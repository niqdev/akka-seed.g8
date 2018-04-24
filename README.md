# akka-seed.g8

[![Build Status][travis-image]][travis-url]

[travis-image]: https://travis-ci.org/niqdev/akka-seed.g8.svg?branch=master
[travis-url]: https://travis-ci.org/niqdev/akka-seed.g8

```bash
sbt new niqdev/akka-seed.g8
```

## Development

```bash
# create template
g8 foundweekends/giter8.g8

# test template
g8 file://akka-seed.g8

g8 file://akka-seed.g8 \
  --name=my-akka-project \
  --organization=com.github.niqdev \
  --force
```
