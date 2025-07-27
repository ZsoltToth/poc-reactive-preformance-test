# Getting Started

## Infrastructure

The database can be configured with the scripts in the `infrastructure` directory.

- `docker-mysqldump-ctu.sh` dump the imdb-ijs database from [CTU Relational Dataset Repository](https://relational.fel.cvut.cz/dataset/IMDb). It takes time.
- `start-mysql.sh` start MySQL server in Docker container
- `import-dump.sh` load the dumped database, Time Consuming.
- `connect-mysql-docker.sh` CLI connection to the MySQL server running in Docker 

You should dump the database once, after checking out the repository. 

Docker removes the container when it stops. 
So you have to import the database after the server is started. 

## Endpoint

There is a single `GET /v{1,2,3}/movies/{id}` endpoint for fetching single `MovieResponse` objects.

- `v1` is a blocking Spring MVC implementation.
- `v2` is a Reactive implementation with annotation based Controller configuration. 
- `v3` is a Reactive implementation with Router Functions

## Examples

```bash
curl -X GET localhost:8080/v1/movies/381743 | jq
```

```json
{
  "id": "381743",
  "title": "\"Best of the West\"",
  "rank": 0.0,
  "genres": [],
  "actors": [
    "Tom Ewell",
    "Leonard Frey",
    "Joel Higgins",
    "Christopher (I) Lloyd",
    "Macon McCalman",
    "Meeno Peluce",
    "Tracey Walter",
    "Valri Bromfield",
    "Carlene Watkins"
  ],
  "directors": [
    "James (II) Burrows",
    "Jeff Chambers",
    "Stan Daniels",
    "Michael Lessac",
    "Will (I) Mackenzie",
    "Doug (I) Rogers",
    "Howard Storm",
    "Tom Trbovich",
    "Ed. Weinberger"
  ]
}
```
