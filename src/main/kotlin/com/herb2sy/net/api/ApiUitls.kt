/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net.api

import com.google.gson.Gson
import com.herb2sy.net.Http
import com.herb2sy.net.data.IpData
import com.herb2sy.net.data.Weather

/**
 * @author: HerbLee
 * @Date: Created on 2019/5/12 3:21 PM
 * @des:
 */
object ApiUitls {

    /**
     * 获取温度
     * @param city 要查询天气到城市
     */
    fun getWeather(city:String,onSuccess1:(success: Weather?)->Unit){
        val url1 = "https://www.apiopen.top/weatherApi"
        Http.request {
            config {
                url=url1
                params {
                    "city"-city
                }
                onSuccess {
                    val res = it?.body()?.string()
                    val res1 = Gson().fromJson<Weather>(res.toString(),Weather::class.java)
                    onSuccess1(res1)
                }
                onError {
                    System.out.println(it)
                }

            }
        }
    }

    fun getIpAddress(ip:String,onSuccess1:(success: IpData?)->Unit){
//        val url1 = "http://ip.taobao.com/service/getIpInfo.php?ip=180.159.159.73"
        val url1 = "http://apis.juhe.cn/ip/ipNew"

        Http.request {
            config {
                url=url1
                params {
                    "ip"-ip
                    "key"-"c6e129ae1d95a19780213eb6b9abc37b"
                }
                onSuccess {
                    val res = it?.body()?.string()
                    val res1 = Gson().fromJson<IpData>(res.toString(),IpData::class.java)
                    onSuccess1(res1)

                }
                onError {
                    System.out.println(it)
                }
            }
        }
    }





}