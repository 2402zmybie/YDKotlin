package com.hr.ydkotlin.net

import com.google.gson.Gson
import com.hr.ydkotlin.model.HomeItemBean
import java.lang.reflect.ParameterizedType

/**
 * 所有请求的基类
 */
open class MRequest<RESPONSE>(val url:String, val handler:ResponseHandler<RESPONSE>){
    /**
     * 得到泛型 通过json解析数据
     */
    fun parseResult(result: String?): RESPONSE {
        var gson = Gson()
        //获取泛型类型
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        var bean = gson.fromJson<RESPONSE>(result, type)
        return bean;
    }

    /**
     * 发送网络请求
     */
    fun excute() {
        NetManager.manager.sendRequest(this)
    }



}