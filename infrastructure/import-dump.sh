#!/usr/bin/env bash

docker exec -i mysql sh -c 'exec /bin/mysql -uroot -psecret --database=imdb' <  imdb_ijs.dump
