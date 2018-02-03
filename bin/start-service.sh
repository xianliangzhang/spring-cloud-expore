#!/bin/sh

jar_file=$1
service_name=${jar_file%-0.0.1*}
java_ops="-Xms128m -Xmx128m -XX:+PrintCommandLineFlags -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${service_name}.oom"

jar_path=
if [ ! -f "$jar_file" ] ; then
  jar_path=../${service_name}/target/
fi

if [ ! -f "$jar_path$jar_file" ] ; then
  echo "$jar_path$jar_file" Not Exists...
  exit 1
fi

jps -l | grep ${service_name} | awk '{print $1}' | xargs kill
java ${java_ops} -jar "$jar_path$jar_file" > /dev/null 2>&1 &