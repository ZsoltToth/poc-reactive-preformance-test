#!/usr/bin/env bash

DOCKER_IMAGE=mysql:5
DOCKER_ARGS=()
DOCKER_ARGS+=(--name mysql)
DOCKER_ARGS+=(--rm)
DOCKER_ARGS+=(--publish 3306:3306)
#DOCKER_ARGS=+(-d)

MYSQL_ENV=()
MYSQL_ENV+=(-e MYSQL_ROOT_PASSWORD=secret)
MYSQL_ENV+=(-e MYSQL_DATABASE=imdb)

docker run \
 "${DOCKER_ARGS[@]}" \
 "${MYSQL_ENV[@]}" \
 ${DOCKER_IMAGE}
