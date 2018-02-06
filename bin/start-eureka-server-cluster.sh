#!/bin/sh

java -Xms64m -Xmx64m -jar eureka/target/eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1
java -Xms64m -Xmx64m -jar eureka/target/eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2
java -Xms64m -Xmx64m -jar eureka/target/eureka-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer3