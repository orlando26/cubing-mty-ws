#!/bin/sh

# Author : Orlando Loza
# Script follows here:


echo "--- deploying cubing-mty-ws to dockerhub ---"

echo "building project with maven..."
mvn package

echo "building image..."
sudo docker image build -t cubing-mty-ws .
sudo docker tag cubing-mty-ws orlandoloza/cubing-mty-ws
echo "pushing image to dockerhub..."
sudo docker push orlandoloza/cubing-mty-ws

echo "--- image deployed to dockerhub ---"