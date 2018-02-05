#!/bin/sh

cd ..
mvn clean package -Dmaven.test.sh
scp eureka/target/eureka-0.0.1-SNAPSHOT.jar \
    root@koyou.top:/usr/local/spring-cloud-explore/