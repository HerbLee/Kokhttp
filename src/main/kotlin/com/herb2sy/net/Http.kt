/**
 * Author Herb
 * Copyright (C) 2017-2019 All Rights Reserved
 */
package com.herb2sy.net

import com.herb2sy.net.request.HRequest
import com.herb2sy.net.request.HttpConfig

/**
 * @author: HerbLee
 * @Date: Created on 2019/5/5 10:20 PM
 * @des:
 */


class Http {
    companion object {
        fun get(block: HRequest.() -> Unit) {

            var flg = HRequest()
            flg.block()

        }
    }


}




fun main(args: Array<String>){
    Http.get {

        url = ""
        method = HttpConfig.Method.GET

        header {
            "wo"-"ni"
            "ta"-"hao"
        }
    }
}