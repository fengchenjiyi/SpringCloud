#======script start ============

echo "-----sleep 5------start eureka_10500"
sleep 5
nohup /usr/mygod/sh/eureka_10500.sh >/usr/mygod/sh/out/28_microservice_start.txt 2>&1 &
echo "eureka_10500.sh----run-------start"

echo "all---sh----run-------succeed"
#======script end =============