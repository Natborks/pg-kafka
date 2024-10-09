This project has three containers.
Producer container
Consumer container
Demo Container
The producer container, has some code, which polls a service . E.g.,
It copies to its own PG container (replacing Kafka), a payload of the messages it collects.

The consumer container, has some  code, which polls the PG container that replaces Kafka. And according to some configuration, sends data via 
Server Sent Events (http push) to another service (Demon) it, at endpoints a preconfigured endpoint.

To run: docker-compose up