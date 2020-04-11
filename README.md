# rockstars-manager

This application is a Rockstars manager

## RESTfull requests

NOTE: No OAuth for the moment to keep it simple
### GET Requests

- Get artist by name
```bash
curl http://localhost:8080/rockstars/artists/200
curl http://localhost:8080/rockstars/artists/filter/name/3%20Doors%20Down
```

- Get song by name

```bash
curl http://localhost:8080/rockstars/songs/1901
curl http://localhost:8080/rockstars/songs/filter/name/666
```

### POST requests

- Post artist
```bash
curl -H "Content-Type: application/json" -X POST --data "{\"Name\": \"Ariana Grande\"}" http://localhost:8080/rockstars/artists
```

- Post song
```bash
curl -H "Content-Type: application/json" -X POST --data "{\"Name\": \"God is a woman\",\"Year\": 2018,\"Artist\": \"Ariana Grande\", \"Shortname\": \"godisawoman\",\"Bpm\": 145,\"Duration\": 197000,\"Genre\": \"Pop\",\"Album\": \"Sweetener\"}" http://localhost:8080/rockstars/artists
```

### PUT requests

- Put artist
```bash
curl -H "Content-Type: application/json" -X PUT --data "{\"Name\": \"Ariana Grande\"}" http://localhost:8080/rockstars/artists/200
```

- Put song
```bash
curl -H "Content-Type: application/json" -X PUT --data "{\"Name\": \"God is a woman\",\"Year\": 2018,\"Artist\": \"Ariana Grande\", \"Shortname\": \"godisawoman\",\"Bpm\": 145,\"Duration\": 197000,\"Genre\": \"Pop\",\"Album\": \"Sweetener\"}" http://localhost:8080/rockstars/songs/1901
```

### DELETE requests

- Delete artist
```bash
curl -X DELETE http://localhost:8080/rockstars/artists/200
```

- Delete
```bash
curl -X DELETE http://localhost:8080/rockstars/songs/1901
```
### OAUTH

```bash
curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&username=jofisaes@gmail.com&password=123&client_id=rockstars-client&client_secret=rockstars&scope=read&redirect_uri=http://localhost:8080/oauth" http://localhost:8080/rockstars/oauth/token
curl -H "Authorization: Bearer TOKEN" http://localhost:8080/rockstars/artists/200
```

## Docker images

This project makes use of the following docker images:

[![dockeri.co](https://dockeri.co/image/jesperancinha/je-all-build-jdk-14)](https://hub.docker.com/r/jesperancinha/je-all-build-jdk-14)

[![dockeri.co](https://dockeri.co/image/_/postgres)](https://hub.docker.com/_/postgres)

## Running everything

Please have docker desktop running. Finally run:

```bash
./build.sh
```

## Refereneces

-   [Cucumber 10 Minute Tutorial](https://cucumber.io/docs/guides/10-minute-tutorial/)
-   [Cucumber Tests in Spring Boot with Dependency Injection](https://thepracticaldeveloper.com/2018/03/31/cucumber-tests-spring-boot-dependency-injection/)
-   [Mock MVC](https://spring.io/guides/gs/testing-web/)
