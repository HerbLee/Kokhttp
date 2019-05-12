/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net.data

/**
 * @author: HerbLee
 * @Date: Created on 2019/5/12 5:07 PM
 * @des:
 */
data class IpData(
    val resultcode:String?,
    val reason:String?,
    val error_code:String?,
    val result:InData?

)

//"Country":"中国",
//"Province":"上海",
//"City":"上海市",
//"Isp":"电信"

data class InData(
    val Country:String?,
    val Province:String?,
    val City:String?,
    val Isp:String?
)