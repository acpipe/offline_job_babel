package com.offline.job.babel.utils

import com.offline.job.babel.log.ParseParams

object LogPath {
    //用户信息路径.
    def getUserInfoPath(params: ParseParams): String = {
        "..." + params.getDate
    }
    //用户行为路径.
    def getUserActionPath(params: ParseParams): String = {
        "..." + params.getDateWithStamp
    }

}
