## QuickStart

### What's this ?

Artifact/result of following along [quick start] of spring-cloud-config.

[quick start]: https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_quick_start

### How to re-run

Start spring-cloud-config-server:

```shell
# start from directory contains this file
cd spring-cloud-config-v4.0.1/spring-cloud-config/spring-cloud-config-server/
mvn clean spring-boot:run
```

Access to server:

```shell
curl localhost:8888/foo/develop
```

Start client:

```shell
# start from directory contains this file
cd demo-client
mvn clean spring-boot:run
```

Access to client:

```shell
curl localhost:8080/
# -> Hello World!
curl localhost:8080/foo
# -> from foo development
```

Last response defined at [property-source] defined on GitHub.
The property source is pointed [here][server-config].

[property-source]: https://github.com/spring-cloud-samples/config-repo/foo-development.properties
[server-config]: ./spring-cloud-config-v4.0.1/spring-cloud-config/sprint-cloud-config-server/src/mainresources/configserver.yml
