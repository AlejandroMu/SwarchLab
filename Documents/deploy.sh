#!/bin/bash


if [ $1 = "build" ]; then
    cd helloworld
    chmod +777 gradlew
    if [ $2 = "client" ]; then
        line="Service.Proxy = SimplePrinter: default -h $3 -p 1234"
        echo $line > client/src/main/resources/client.cfg
    elif [ $2 = "server" ];then
        line="Service.Endpoints = default -h $3 -p 1234"
        echo $line > server/src/main/resources/server.cfg
    fi
    ./gradlew ":$2:build"
    cd ..
fi
cd helloworld
if [ $2 = "client" ]; then
    java -jar client/build/libs/client.jar
elif [ $2 = "server" ]; then
    java -jar server/build/libs/server.jar
fi
