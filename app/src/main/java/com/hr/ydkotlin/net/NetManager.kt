package com.hr.ydkotlin.net

import com.google.gson.Gson
import com.hr.ydkotlin.model.HomeItemBean
import com.hr.ydkotlin.util.ThreadUtil
import okhttp3.*
import java.io.IOException

class NetManager private constructor(){

    val client by lazy { OkHttpClient() }

    companion object{
        val manager:NetManager by lazy { NetManager() }
    }

    /**
     * 发送网络请求
     */
    fun <RESPONSE>sendRequest(req:MRequest<RESPONSE>) {
        val request = Request.Builder()
            .url(req.url)
            .get()
            .build();
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnMainThread(object :Runnable{
                    override fun run() {
                        req.handler.onError(e.message)
                    }
                })
            }

            override fun onResponse(call: Call, response: Response) {
                var result = response?.body()?.string()
                val parseResult = req.parseResult(result)
                ThreadUtil.runOnMainThread(object :Runnable {
                    override fun run() {
                        //回调
                        req.handler.onSuccess(parseResult)
                    }
                })
            }
        })
    }
}