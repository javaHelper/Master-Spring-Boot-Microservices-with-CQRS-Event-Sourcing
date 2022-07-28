# Master-Spring-Boot-Microservices-with-CQRS-Event-Sourcing

Aggregate is the primary component in the command API, its where commands are handled events are raised, state of aggregate is altered and evets are stored to events store and publish to event bus 

# Setup AxonIQ

```sh
docker run -d \
  --name axonserver \
  -p 8024:8024 \
  -p 8124:8124 \
  axoniq/axonserver
```


![Course+Impl+Architecture drawio](https://user-images.githubusercontent.com/54174687/180636332-4c16da0e-2c71-4868-92e1-c62f1639540f.png)
