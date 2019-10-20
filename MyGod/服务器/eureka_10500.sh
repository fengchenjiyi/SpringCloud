#!/bin/sh
cd /usr/mygod/microservice_jar
nohup java -jar -Xms128m -Xmx256m /usr/mygod/microservice_jar/eureka_10500.jar >/usr/mygod/sh/out/eureka_10500.txt 2>&1 &
echo "$!" > /var/run/eureka_10500.pid
echo "eureka_10500.jar-------start-------succeed"


