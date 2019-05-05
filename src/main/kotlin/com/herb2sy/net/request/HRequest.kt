/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net.request


/**
 * @author: HerbLee
 * @Date: Created on 2019/5/5 10:43 PM
 * @des:
 */
class HRequest {

    protected val _params: MutableMap<String, String> = mutableMapOf() // used for a POST or PUT request.
    protected val _fileParams: MutableMap<String, String> = mutableMapOf() // used for a POST or PUT request.
    protected val _headers: MutableMap<String, String> = mutableMapOf()
    private var jsonParams:String? = null
    var method:Int = HttpConfig.Method.GET
    var url:String? = null



    /**
     * 头文件
     */
    inline fun header(headers: RequestPairs.()-> Unit){
        val hd = RequestPairs()
        hd.headers()
        _headers.putAll(hd.pairs)
    }

    /**
     * params
     */
    inline fun params(params: RequestPairs.()-> Unit){
        val hd = RequestPairs()
        hd.params()
        _params.putAll(hd.pairs)
    }

}

class RequestPairs {
    var pairs: MutableMap<String, String> = HashMap()
    operator fun String.minus(value: String) {
        pairs.put(this, value)
    }
}

