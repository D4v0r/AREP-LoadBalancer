#!/bin/bash
docker-compose down 
docker volume prune 
docker system prune -a 

docker-compose up -d
docker container ls
