package com.offline.job.babel.log

import org.apache.spark.sql.SparkSession

trait LogParser extends Serializable {
    def name(): String =  {
        this.getClass.getSimpleName
    }
    def run(params: ParseParams, sparkSession: SparkSession)
}
