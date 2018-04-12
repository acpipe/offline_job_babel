package com.offline.job.babel.log

class ParseParams extends Serializable {
    var year = ""
    var month = ""
    var day = ""
    var outputPath = ""

    def this(className: String, outputPath: String, date: String) {
        this()
        this.outputPath = outputPath
        this.year = date.substring(0, 4)
        this.month = date.substring(4, 6)
        this.day = date.substring(6, 8)
    }

    def getDate: String = {
        year + month + day
    }

    def getDateWithStamp: String = {
        "year=" + year + "/month=" + month + "/day=" + day
    }
}
