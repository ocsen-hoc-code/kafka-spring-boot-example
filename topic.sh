#!/bin/bash

echo "==================Topic Register================="
docker exec -it kafka-spring-boot-example_kafka_1 bash -c "/opt/bitnami/kafka/bin/kafka-topics.sh --create --zookeeper 172.80.0.2:2181 --topic kafka-message --partitions 1 --replication-factor 1"
