#!/usr/bin/env bash 

DATASET=imdb_ijs

MYSQL_IMAGE=mysql:5
CTU_USER=guest
CTU_PASS=ctu-relational
CTU_HOST=relational.fel.cvut.cz
CTU_PORT=3306

MYSQLDUMP_CONNECTION=()
MYSQLDUMP_CONNECTION+=(-u${CTU_USER})
MYSQLDUMP_CONNECTION+=(-p${CTU_PASS})
MYSQLDUMP_CONNECTION+=(-h ${CTU_HOST})
MYSQLDUMP_CONNECTION+=(-P ${CTU_PORT})

#DUMPFILE=$(echo ${DATASET}-$(date +%Y%m%d_%H%M%S).dump)
DUMPFILE=$(echo ${DATASET}.dump)
if [ -f ${DUMPFILE} ]
then
  echo "Existing ${DUMPFILE} is deleted"
  rm ${DUMPFILE}
fi
touch ${DUMPFILE}

MYSQLDUMP_OPTIONS=()
MYSQLDUMP_OPTIONS+=(--skip-add-locks)
MYSQLDUMP_OPTIONS+=(--skip-lock-tables)
MYSQLDUMP_OPTIONS+=(--result-file="/${DUMPFILE}")



docker run \
  -v $(pwd)/${DUMPFILE}:/${DUMPFILE}:rw \
  ${MYSQL_IMAGE} \
  /usr/bin/mysqldump \
  "${MYSQLDUMP_CONNECTION[@]}" \
  ${DATASET} \
  "${MYSQLDUMP_OPTIONS[@]}"

if [ $? -eq 0 ]
then
  echo "Dataset ${DATASET} was successfully dumped into ${DUMPFILE}"
else
  rm ${DUMPFILE}
  echo "Dataset ${DATASET} dump filed! ${DUMPFILE} is deleted"
fi
