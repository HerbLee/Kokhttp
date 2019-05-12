/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net.data

/**
 * @author: HerbLee
 * @Date: Created on 2019/5/12 3:35 PM
 * @des:
 */

data class Weather(val code:Int?=200,
                   val msg:String?="成功",
                   val data:ResData?
                   )

data class ResData(
    val yesterday:MiniData?,//昨天天气
    val city:String?,//城市
    val aqi:String?,//不知道
    val ganmao:String?,//感冒
    val wendu:String?,//温度
    val forecast:List<MiniData>//接下来几天温度
)


data class MiniData(
    val date:String?, //时间
    val high:String?,//最高气温
    val fx:String?,//风向
    val low:String?,//最低气温
    val fl:String?,//风力
    val type:String?//天晴情况
)