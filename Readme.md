# Rockstars Manager

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/rockstars-manager)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=rockstars-manager%20🤘&color=informational)](https://github.com/jesperancinha/rockstars-manager)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![RSM Build, Test, Coverage and Report](https://github.com/jesperancinha/rockstars-manager/actions/workflows/rockstarts-manager-races.yml/badge.svg)](https://github.com/jesperancinha/rockstars-manager/actions/workflows/rockstarts-manager-races.yml)
[![RSM Build on PR](https://github.com/jesperancinha/rockstars-manager/actions/workflows/rockstarts-manager-pull-request.yml/badge.svg)](https://github.com/jesperancinha/rockstars-manager/actions/workflows/rockstarts-manager-pull-request.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/3bcf372c7e6e42d6827a1393d0517d90)](https://www.codacy.com/gh/jesperancinha/rockstars-manager/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/rockstars-manager&amp;utm_campaign=Badge_Grade)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/3bcf372c7e6e42d6827a1393d0517d90)](https://www.codacy.com/gh/jesperancinha/rockstars-manager/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/rockstars-manager&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/rockstars-manager/badge.svg?branch=main)](https://coveralls.io/github/jesperancinha/rockstars-manager?branch=main)
[![codecov](https://codecov.io/gh/jesperancinha/rockstars-manager/branch/main/graph/badge.svg?token=5JTaC7z68Y)](https://codecov.io/gh/jesperancinha/rockstars-manager)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/rockstars-manager.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/rockstars-manager.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/rockstars-manager.svg)](#)

---

## Introduction

---- Under Construction ----

This application is a Rockstars manager

#### Stable releases

-   [0.0.1](https://github.com/jesperancinha/rockstars-manager/tree/0.0.1) - [4ecb6333713e31c30e195a2c9b5ea033d785f198](https://github.com/jesperancinha/rockstars-manager/tree/0.0.1) - ?
-   [0.0.2](https://github.com/jesperancinha/rockstars-manager/tree/0.0.2) - [73e941a8634e69abaf73a001af970e060192fd03](https://github.com/jesperancinha/rockstars-manager/tree/0.0.2) - JDK 17 / Mockito / Java / JUnit assertion
-   [1.0.0](https://github.com/jesperancinha/rockstars-manager/tree/1.0.0) - [27b82491eecc13b6044ecb6207aeaae23386d3bd](https://github.com/jesperancinha/rockstars-manager/tree/1.0.0) - JDK 19 / Kotlin 1.8.0 / Kotest / Spring Mockk / Spring Boot 3.0.1

## RESTfull requests

### GET Requests

-   Get artist by name
```bash
curl http://localhost:8080/rockstars/artists/200
curl http://localhost:8080/rockstars/artists/filter/name/3%20Doors%20Down
```

-   Get song by name

```bash
curl http://localhost:8080/rockstars/songs/1901
curl http://localhost:8080/rockstars/songs/filter/name/666
```

### POST requests

-   Post artist
```bash
curl -H "Content-Type: application/json" -X POST --data "{\"Name\": \"Ariana Grande\"}" http://localhost:8080/rockstars/artists
```

-   Post song
```bash
curl -H "Content-Type: application/json" -X POST --data "{\"Name\": \"God is a woman\",\"Year\": 2018,\"Artist\": \"Ariana Grande\", \"Shortname\": \"godisawoman\",\"Bpm\": 145,\"Duration\": 197000,\"Genre\": \"Pop\",\"Album\": \"Sweetener\"}" http://localhost:8080/rockstars/artists
```

### PUT requests

-   Put artist
```bash
curl -H "Content-Type: application/json" -X PUT --data "{\"Name\": \"Ariana Grande\"}" http://localhost:8080/rockstars/artists/200
```

-   Put song
```bash
curl -H "Content-Type: application/json" -X PUT --data "{\"Name\": \"God is a woman\",\"Year\": 2018,\"Artist\": \"Ariana Grande\", \"Shortname\": \"godisawoman\",\"Bpm\": 145,\"Duration\": 197000,\"Genre\": \"Pop\",\"Album\": \"Sweetener\"}" http://localhost:8080/rockstars/songs/1901
```

### DELETE requests

-   Delete artist
```bash
curl -X DELETE http://localhost:8080/rockstars/artists/200
```

-   Delete
```bash
curl -X DELETE http://localhost:8080/rockstars/songs/1901
```
### OAUTH

```bash
curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=password&username=jofisaes@gmail.com&password=123&client_id=rockstars-client&client_secret=rockstars&scope=read&redirect_uri=http://localhost:8080/oauth" http://localhost:8080/rockstars/oauth/token
curl -H "Authorization: Bearer TOKEN" http://localhost:8080/rockstars/artists/200
```

## Running everything

Please have docker desktop running. Finally run:

```bash
./build.sh
```

## References

-   [Cucumber 10 Minute Tutorial](https://cucumber.io/docs/guides/10-minute-tutorial/)
-   [Cucumber Tests in Spring Boot with Dependency Injection](https://thepracticaldeveloper.com/2018/03/31/cucumber-tests-spring-boot-dependency-injection/)
-   [Mock MVC](https://spring.io/guides/gs/testing-web/)

## Buy me a coffee

I hope you enjoyed this repository. If you did, you can optionally please buy me a coffee, which supports me in constantly improve and make new free content regularly for everyone. Thank you so much!

[![Buy me a coffee](https://img.buymeacoffee.com/button-api/?text=Buy%20me%20a%20coffee&emoji=&slug=jesperancinha&button_colour=046c46&font_colour=ffffff&font_family=Cookie&outline_colour=ffffff&coffee_colour=FFDD00 "title")](https://www.buymeacoffee.com/jesperancinha)

## About me

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/mastodon-20.png "Mastodon")](https://masto.ai/@jesperancinha)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
| [Sessionize](https://sessionize.com/joao-esperancinha/)
| [Spotify](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm?si=b54b89eae8894960)
| [Medium](https://medium.com/@jofisaes)
| [YouTube](https://www.youtube.com/@joaoesperancinha/featured)
| [Instagram](https://www.instagram.com/joaofisaes/)
| [Buy me a coffee](https://www.buymeacoffee.com/jesperancinha)
| [Credly Badges](https://www.credly.com/users/joao-esperancinha)
| [Google Apps](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
| [Sonatype Search Repos](https://search.maven.org/search?q=org.jesperancinha)
| [Docker Images](https://hub.docker.com/u/jesperancinha)
| [Stack Overflow Profile](https://stackoverflow.com/users/3702839/joao-esperancinha)
| [Reddit](https://www.reddit.com/user/jesperancinha/)
| [Dev.TO](https://dev.to/jofisaes)
| [Hackernoon](https://hackernoon.com/@jesperancinha)
| [Code Project](https://www.codeproject.com/Members/jesperancinha)
| [BitBucket](https://bitbucket.org/jesperancinha)
| [GitLab](https://gitlab.com/jesperancinha)
| [Coursera](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
| [FreeCodeCamp](https://www.freecodecamp.org/jofisaes)
| [HackerRank](https://www.hackerrank.com/jofisaes)
| [LeetCode](https://leetcode.com/jofisaes)
| [Codebyte](https://coderbyte.com/profile/jesperancinha)
| [CodeWars](https://www.codewars.com/users/jesperancinha)
| [Code Pen](https://codepen.io/jesperancinha)
| [Hacker Earth](https://www.hackerearth.com/@jofisaes)
| [Khan Academy](https://www.khanacademy.org/profile/jofisaes)
| [Hacker News](https://news.ycombinator.com/user?id=jesperancinha)
| [InfoQ](https://www.infoq.com/profile/Joao-Esperancinha.2/)
| [LinkedIn](https://www.linkedin.com/in/joaoesperancinha/)
| [Xing](https://www.xing.com/profile/Joao_Esperancinha/cv)
| [Tumblr](https://jofisaes.tumblr.com/)
| [Pinterest](https://nl.pinterest.com/jesperancinha/)
| [Quora](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
| [VMware Spring Professional 2021](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
| [Oracle Certified Professional, Java SE 11 Programmer](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
| [Oracle Certified Professional, JEE7 Developer](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
| [IBM Cybersecurity Analyst Professional](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
| [Certified Advanced JavaScript Developer](https://cancanit.com/certified/1462/)
| [Certified Neo4j Professional](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
| [Deep Learning](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
| [![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=yellow "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)
