#!/bin/sh

jar_file=$1
service_name=${jar_file%-0.0.1*}
java_ops="-Xms64m -Xmx64m -XX:+PrintCommandLineFlags -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${service_name}.oom"

jar_path=
if [ ! -f "$jar_file" ] ; then
  jar_path=../${service_name}/target/
fi

if [ ! -f "$jar_path$jar_file" ] ; then
  echo "$jar_path$jar_file" Not Exists...
  exit 1
fi

#if [ "$(jps -lv | grep $service_name)" ]; then
#  jps -lv | grep $service_name | awk '{print $1}' | xargs -t kill
#fi

java ${java_ops} -jar "$jar_path$jar_file" $2 > /dev/null 2>&1 &