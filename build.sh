#!/bin/bash

echo "=============Building Producer============="
cd ./producer
./mvnw clean install
cd ..
echo "=============Building Consumer============="
cd ./consumer
./mvnw clean install
cd ..
