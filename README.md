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