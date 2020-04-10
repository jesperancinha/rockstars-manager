# rockstars-manager

This application is a rockstars manager

## RESTfull requests

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
curl -H "Content-Type: application/json" -X PUT --data "{\"Name\": \"Ariana Grande\"}" http://localhost:8080/rockstars/artists/save/200
```

- Put song
```bash
curl -H "Content-Type: application/json" -X PUT --data "{\"Name\": \"God is a woman\",\"Year\": 2018,\"Artist\": \"Ariana Grande\", \"Shortname\": \"godisawoman\",\"Bpm\": 145,\"Duration\": 197000,\"Genre\": \"Pop\",\"Album\": \"Sweetener\"}" http://localhost:8080/rockstars/songs/save/1901
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

## Refereneces

-   [Cucumber 10 Minute Tutorial](https://cucumber.io/docs/guides/10-minute-tutorial/)