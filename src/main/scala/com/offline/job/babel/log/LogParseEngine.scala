package com.offline.job.babel.log

import org.apache.spark.sql.SparkSession
import org.springframework.context.support.ClassPathXmlApplicationContext

import collection.JavaConversions._

object LogParseEngine {

    def main(args: Array[String]): Unit = {
        val outPutPath = args(0)
        val date = args(1)
        val className = args(2)

        Console.println("outPutPath:" + outPutPath)
        Console.println("date:" + date)
        Console.println("className:" + className)

        val params = new ParseParams(outPutPath, date, className)
        val sparkSession = SparkSession
            .builder()
            .appName("LogParseEngine:" + params)
            .getOrCreate()
        val appContext = new ClassPathXmlApplicationContext("applicationContext.xml")

        val logParserFactory = appContext.getBean("logParserFactory").asInstanceOf[LogParserFactory]
        logParserFactory.getLogParsers()
            .filter(e => e.name().equals(className))
            .foreach(i => i.run(params, sparkSession))
    }
}