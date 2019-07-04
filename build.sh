#!/usr/bin/env bash
mvn clean || exit 1
mvn -Dmaven.test.skip=true package || exit 1
sudo docker build -t registry.cn-hangzhou.aliyuncs.com/circle-registry/pineapple_admin:0.4.7 .
sudo docker push registry.cn-hangzhou.aliyuncs.com/circle-registry/pineapple_admin:0.4.7
