#!/usr/bin/env bash
set -e
if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    exit -1
fi
if [ -z "$1" ]
  then
    echo "Please provide the image tag"
    exit -1
fi

mvn clean install -DskipTests
tag="$1"
app="m3-cm"
registry=$2
docker build -t ${app}:${tag} .
if [ ! -z "$2" ]
  then
    image_name=${registry}/${app}:${tag}
    docker tag ${app}:${tag} ${image_name}
    docker  push ${image_name}
  else
    echo "Please provide the registry host:ip if you want to push to a docker registry."
fi
