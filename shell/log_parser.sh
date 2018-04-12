#!/bin/bash
source ~/.bashrc

if [ $# -lt 2 ]; then
    echo "sh log_parser.sh <date> <className>"
    exit 1
fi

# xxx部分需要自己指定.

queue=xxx
cluster=xxx

date=${1}

className=${2}
output_path=xxx

jarPath="offline-job-babel-1.0-SNAPSHOT.jar"
if [ ! -f "offline-job-babel-1.0-SNAPSHOT.jar" ]; then
    jarPath="../target/offline-job-babel-1.0-SNAPSHOT.jar"
else
    echo "-----offline-job-babel-1.0-SNAPSHOT.jar exist!-----"
fi

echo "-------------------job info-----------------------"
echo "You are running jar at path:" ${jarPath}
echo "job work for date:" ${date}
echo "className:" ${className}
echo "-------------------job start!-----------------------"

hadoop fs -rm -r -skipTrash ${output_path}

spark-submit --cluster ${cluster} \
    --master yarn \
    --deploy-mode cluster \
    --queue ${queue} \
    --driver-memory 6g \
    --executor-memory 6g \
    --executor-cores 1  \
    --conf spark.yarn.job.owners=huming1 \
    --conf spark.default.parallelism=800 \
    --conf spark.yarn.executor.memoryOverhead=4096 \
    --conf spark.sql.shuffle.partitions=2000 \
    --conf spark.dynamicAllocation.enabled=true \
    --conf spark.shuffle.service.enabled=true \
    --conf spark.dynamicAllocation.maxExecutors=700 \
    --conf spark.dynamicAllocation.executorIdleTimeout=600s \
    --conf spark.hadoop.parquet.enable.summary-metadata=true \
    --conf spark.speculation=true \
    --conf spark.speculation.multiplier=2 \
    --conf spark.speculation.quantile=0.5 \
    --conf  spark.scheduler.executorTaskBlacklistTime=300000 \
    --conf spark.shuffle.compress=false \
    --conf spark.shuffle.spill.compress=false  \
    --class com.offline.job.babel.log.LogParseEngine \
    ${jarPath} ${output_path} $*

echo "hadoop fs -cat" ${output_path}"/*" "| less"