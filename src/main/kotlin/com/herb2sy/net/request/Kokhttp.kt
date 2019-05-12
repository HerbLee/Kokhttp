/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net.request

import okhttp3.*
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

/**
 * @author: HerbLee
 * @Date: Created on 2019/5/6 10:58 PM
 * @des:
 */
class Kokhttp {

    var client:OkHttpClient
    val UTF_8 = "UTF-8"


    init {
         val builder = OkHttpClient.Builder()
         client = builder.build()
    }

    companion object{
        val instant:Kokhttp by lazy { Kokhttp() }
    }

    private fun mapToQueryString(map: Map<String, String>): String{

        val string = StringBuilder()

        try {
            for ((key, value) in map) {
                string.append(key)
                string.append("=")
                string.append(URLEncoder.encode(value, UTF_8))
                string.append("&")
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        return string.toString()
    }

    fun initData(bean:HRequest,onSuccess:(response: Response)->Unit,onError:(str:String?)->Unit){

        when(bean.method){
            //开始初始化各种
            HttpConfig.Method.GET ->get(bean,onSuccess,onError)
            HttpConfig.Method.POST -> post(bean,onSuccess,onError)
        }

    }

    fun get(bean: HRequest,onSuccess:(response: Response)->Unit,onError:(str:String?)->Unit){

        var param:String = ""

        if (bean._params.isNotEmpty()){
            param = mapToQueryString(bean._params)
        }
        if (bean.paramsMap != null){
            if (bean.paramsMap?.isNotEmpty()!!){
                param += mapToQueryString(bean.paramsMap!!)
            }
        }

        val builder = Request.Builder()

        for (ss in bean._headers.keys) {
            builder.addHeader(ss, URLEncoder.encode(bean._headers[ss], UTF_8))
        }
        if (bean.headerMap != null){
            for (ss in bean.headerMap?.keys!!){
                builder.addHeader(ss, URLEncoder.encode(bean._headers[ss], UTF_8))
            }
        }
        var url = bean.url
        if (param != ""){
            url = "$url?$param"
        }

        val request = builder.url(url).build()
        get(request,onSuccess,onError)

    }
    fun get(request: Request,onSuccess:(response: Response)->Unit,onError:(str:String?)->Unit){
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                onError(e.message)

            }

            override fun onResponse(call: Call, response: Response) {
                onSuccess(response)
            }

        })

    }




    private fun post(bean: HRequest,onSuccess:(response: Response)->Unit,onError:(str:String?)->Unit){
        //暂时分为json 和 表单
        when(bean.type){
            HttpConfig.Type.DEF -> postByFrom(bean)
            HttpConfig.Type.JSON -> postByJson(bean)
        }
    }

    private fun postByFrom(bean: HRequest){



    }
    private fun postByJson(bean: HRequest){

    }


    fun showDetail(){

        System.out.println("显示详情")
    }
    fun showMain(){
        System.out.println("显示主要的")
    }

}