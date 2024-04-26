Open a terminal window and run `./gradlew bootRun`

Open a second terminal window and execute the following:

```
$ curl localhost:8080/metrics | grep ^http_server_requests
$ curl localhost:8080/jersey/test
$ curl localhost:8080/jersey/test
$ curl localhost:8080/metrics | grep ^http_server_requests
```
Now only the /metrics endpoint is reported

