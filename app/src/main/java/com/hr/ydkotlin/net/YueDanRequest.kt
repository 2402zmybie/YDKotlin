package com.hr.ydkotlin.net

import com.hr.ydkotlin.model.HomeItemBean

class YueDanRequest(url: String, handler: ResponseHandler<HomeItemBean>) : MRequest<HomeItemBean>(url, handler) {
}