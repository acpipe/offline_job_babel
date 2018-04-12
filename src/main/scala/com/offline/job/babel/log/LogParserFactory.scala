package com.offline.job.babel.log

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LogParserFactory {
    private var logParsers: java.util.List[LogParser] = _

    @Autowired
    def this(list: java.util.List[LogParser]) {
        this()
        logParsers = list
    }

    def getLogParsers(): java.util.List[LogParser] = {
        logParsers
    }
}
