# $name;format="normalize"$

```
sbt app/run
sbt "cli/run -p MyName --game Rock -a 2"

sbt test
```

## Docker

```
# generate Dockerfile in target/docker/
sbt docker:stage

# build image
sbt docker:publishLocal

# start temporary container
docker run \
  --rm \
  -e HTTP_PORT="8080" \
  -p 80:8080 \
  --name $name;format="normalize"$ \
  $name;format="normalize"$:0.1.0-SNAPSHOT

# request status (with HTTPie)
http :80/status

# access container
docker exec -it $name;format="normalize"$ bash

# access container as root
docker exec -it --user root $name;format="normalize"$ bash
```
