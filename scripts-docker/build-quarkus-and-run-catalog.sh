#!/bin/bash

root_folder=$(cd $(dirname $0); cd ..; pwd)

exec 3>&1

function _out() {
  echo "$(date +'%F %H:%M:%S') $@"
}

function setup() {
  echo "Run sh scripts-docker/run-monolith-db2.sh first"
  echo "Run sh scripts-docker/run-database-postgres-catalog.shh first"
  echo "Run sh scripts-docker/run-kafka.sh first"
  echo "Open http://localhost/CustomerOrderServicesWeb"
  
  cd ${root_folder}
  sh scripts-docker/stop-services.sh
  
  cd ${root_folder}/proxy
  docker build -f Dockerfile-all-quarkus -t proxy-nginx .

  cd ${root_folder}/monolith-quarkus-synch
  mvn clean package
  docker build -f src/main/docker/Dockerfile.jvm -t storefront-backend-quarkus .

  cd ${root_folder}/service-catalog-quarkus-synch
  docker build -f Dockerfile -t storefront-catalog .

  cd ${root_folder}/scripts-docker
  docker-compose -f docker-compose-all-quarkus.yml up
}

setup
