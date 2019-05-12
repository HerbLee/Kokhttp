/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net

import com.herb2sy.net.api.ApiUitls
import com.herb2sy.net.request.GetDataByNet


/**
 * @author: HerbLee
 * @Date: Created on 2019/5/5 10:20 PM
 * @des:
 */


class Http {
    companion object {
        fun request(block: GetDataByNet.()->Unit){
            val flag = GetDataByNet()
            flag.block()
            flag.initData()
        }
    }


}




fun main(args: Array<String>){
    System.out.println("开始")

//    ApiUitls.getWeather("辛集"){
//        System.out.print("${it?.data?.city}的温度是：${it?.data?.wendu}")
//    }


    ApiUitls.getIpAddress("180.159.159.73"){
        System.out.print(it)
    }
}