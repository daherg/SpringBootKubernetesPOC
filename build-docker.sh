#!/bin/bash

echo ---- BUILD ALL PROJECTS ----
mvn clean package

echo ---- SET DOCKER MACHINE VARIABLES ----
DOCKER_MACHINE_NAME="springPOCMachine"
# export DOCKER_MACHINE_IP=$(docker-machine ip ${DOCKER_MACHINE_NAME})
# export EUREKA_PORT="8761"
# echo " DOCKER_MACHINE_IP: ${DOCKER_MACHINE_IP}"
# echo " EUREKA_PORT: ${EUREKA_PORT}"

echo ---- CREATE DOCKER MACHINE ----
docker-machine create -d virtualbox --virtualbox-cpu-count 2 --virtualbox-memory "4098" ${DOCKER_MACHINE_NAME}

echo ---- STARTING DOCKER MACHINE ----
docker-machine start ${DOCKER_MACHINE_NAME}
docker-machine regenerate-certs ${DOCKER_MACHINE_NAME} --force

echo --- SHOW ALL DOCKER MACHINES  ----
docker-machine ls

eval "$(docker-machine env ${DOCKER_MACHINE_NAME})"

echo --- STOPPING RUNNING CONTAINERS  ----
docker-compose down

echo --- STARTING CONTAINERS  ----
docker-compose build
# docker-compose up -d
echo --- CONTAINERS STARTED  ----