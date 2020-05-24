#!/bin/sh

# Author : Orlando Loza
# Script follows here:


echo "--- deploying cubing-mysql-db to dockerhub ---"

echo "--- loging in to docker hub ---"

cat ~/my_password.txt | docker login --username orlandoloza --password-stdin

echo "building image..."
docker image build -t cubos-mysql .
docker tag cubos-mysql orlandoloza/cubos-mysql
echo "pushing image to dockerhub..."
docker push orlandoloza/cubos-mysql

echo "--- image deployed to dockerhub ---"