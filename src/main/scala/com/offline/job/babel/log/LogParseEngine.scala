package com.offline.job.babel.log

import org.apache.spark.sql.SparkSession
import org.springframework.context.support.ClassPathXmlApplicationContext

import collection.JavaConversions._

object LogParseEngine {

    def main(args: Array[String]): Unit = {
        val Array(className, outputPath, date) = args
        val params = new ParseParams(className, outputPath, date)
        val sparkSession = SparkSession
            .builder()
            .appName("LogParseEngine" + params)
            .getOrCreate()
        val appContext = new ClassPathXmlApplicationContext("applicationContext.xml")

        val logParserFactory = appContext.getBean("logParserFactory").asInstanceOf[LogParserFactory]
        logParserFactory.getLogParsers()
            .filter(e => e.name().equals(className))
            .foreach(i => i.run(params, sparkSession))
    }
}