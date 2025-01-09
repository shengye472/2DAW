#!/usr/bin/env bash

pwd

source $1

rm -rf Facturas

git clone git@github.com:shengye472/Facturas.git

cd Facturas

git switch developWin

mvn clean install

scp ./target/*.jar ${USER_NAME_DEPLOY_SERVER}@${IP_DEPLOY_SERVER}:/home/${USER_NAME_DEPLOY_SERVER}/sheng

ssh ${USER_NAME_DEPLOY_SERVER}@${IP_DEPLOY_SERVER} sheng/jdk-21.0.5+11/bin/java -jar sheng/*.jar --server.port=${APP_PORT}
