package com.offline.job.babel.log.common

import com.offline.job.babel.log.{LogParser, ParseParams}
import com.offline.job.babel.utils.LogPath
import com.xiaomi.data.commons.spark.HdfsIO._
import com.xiaomi.data.spec.log.miuiads.AdLogV2
import com.xiaomi.miui.ad.babel.log.{LogParser, ParseParams}
import com.xiaomi.miui.ad.babel.utils.LogPath
import org.apache.spark.sql.SparkSession
import org.springframework.stereotype.Component
@Component
class DemoParser  extends LogParser {
    override def run(params: ParseParams, sparkSession: SparkSession): Unit = {
       //业务逻辑.
    }
}

