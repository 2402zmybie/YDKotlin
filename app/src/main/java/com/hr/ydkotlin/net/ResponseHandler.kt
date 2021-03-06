package com.hr.ydkotlin.net

/*
请求回调
 */
interface ResponseHandler<RESPONSE> {
    fun onError(msg: String?)
    fun onSuccess(response:RESPONSE)
}