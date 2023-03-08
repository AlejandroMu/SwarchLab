#!/bin/bash
hosts=$(seq 1 22)
if [ $1 = "ping" ]; then
    for i in $hosts; do
        ping -c 3 xgrid$i
    done
    exit 0
fi
if [ $1 = "build" ]; then
    echo "send files"
     for i in $hosts; do
        sshpass -p swarch scp  -o "StrictHostKeyChecking no" ../helloworld.zip swarch@xgrid$i:helloworld.zip
        sshpass -p swarch scp deploy.sh swarch@xgrid$i:delpoy.sh
        ssh swarch@xgrid$i rm -rf helloworld/
        ssh swarch@xgrid$i unzip helloworld.zip
    done
    echo "files sended"
fi
if [ $2 = "client" ]; then
    echo "run clients"
    for i in $hosts; do
        sshpass -p swarch ssh swarch@xgrid$i ./delpoy.sh build $2 $3
    done
else
    echo "run server"
    sshpass -p swarch ssh swarch@x$3 ./delpoy.sh build $2 $3
fi
