/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net.request

import okhttp3.Response

/**
 * @author: HerbLee
 * @Date: Created on 2019/5/12 2:43 PM
 * @des:
 */
class GetDataByNet {

    protected var baseConfig1:HRequest? = null
    protected lateinit var _onSuccess:(response:Response?)->Unit
    protected lateinit var _onError:(error:String?)->Unit

    inline fun config(config: HRequest.()-> Unit){
        var hd = HRequest()
        hd.config()
        baseConfig1 = hd
    }
    fun initData(){
        Kokhttp.instant.initData(baseConfig1!!,_onSuccess,_onError)
    }


    inline fun onSuccess(noinline onSuccess:(response:Response?)->Unit){
        _onSuccess = onSuccess

    }

    inline fun onError(noinline onError:(error:String?)->Unit){
        _onError = onError

    }




}