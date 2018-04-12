package com.offline.job.babel.log.common

import com.offline.job.babel.log.{LogParser, ParseParams}
import org.apache.spark.sql.SparkSession
import org.springframework.stereotype.Component

@Component
class UvCount extends LogParser {
    override def run(params: ParseParams, sparkSession: SparkSession): Unit = {
        //业务逻辑.
    }
}