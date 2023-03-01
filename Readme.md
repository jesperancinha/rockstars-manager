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

<div align="center">

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-100/JEOrgLogo-27.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![](https://img.shields.io/badge/youtube-%230077B5.svg?style=for-the-badge&logo=youtube&color=FF0000)](https://www.youtube.com/@joaoesperancinha)
[![](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@jofisaes)
[![](https://img.shields.io/badge/Buy%20Me%20A%20Coffee-%230077B5.svg?style=for-the-badge&logo=buymeacoffee&color=yellow)](https://www.buymeacoffee.com/jesperancinha)
[![](https://img.shields.io/badge/Twitter-%230077B5.svg?style=for-the-badge&logo=twitter&color=white)](https://twitter.com/joaofse)
[![](https://img.shields.io/badge/Mastodon-%230077B5.svg?style=for-the-badge&logo=mastodon&color=afd7f7)](https://masto.ai/@jesperancinha)
[![](https://img.shields.io/badge/Sessionize-%230077B5.svg?style=for-the-badge&logo=sessionize&color=cffff6)](https://sessionize.com/joao-esperancinha)
[![](https://img.shields.io/badge/Instagram-%230077B5.svg?style=for-the-badge&logo=instagram&color=purple)](https://www.instagram.com/joaofisaes)
[![](https://img.shields.io/badge/Tumblr-%230077B5.svg?style=for-the-badge&logo=tumblr&color=192841)](https://jofisaes.tumblr.com)
[![](https://img.shields.io/badge/Spotify-1ED760?style=for-the-badge&logo=spotify&logoColor=white)](https://open.spotify.com/user/jlnozkcomrxgsaip7yvffpqqm)
[![](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/joaoesperancinha/)
[![](https://img.shields.io/badge/Xing-%230077B5.svg?style=for-the-badge&logo=xing&color=064e40)](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![](https://img.shields.io/badge/YCombinator-%230077B5.svg?style=for-the-badge&logo=ycombinator&color=d0d9cd)](https://news.ycombinator.com/user?id=jesperancinha)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
[![](https://img.shields.io/badge/bitbucket-%230077B5.svg?style=for-the-badge&logo=bitbucket&color=blue)](https://bitbucket.org/jesperancinha)
[![](https://img.shields.io/badge/gitlab-%230077B5.svg?style=for-the-badge&logo=gitlab&color=orange)](https://gitlab.com/jesperancinha)
[![](https://img.shields.io/badge/Stack%20Overflow-%230077B5.svg?style=for-the-badge&logo=stackoverflow&color=5A5A5A)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![](https://img.shields.io/badge/Credly-%230077B5.svg?style=for-the-badge&logo=credly&color=064e40)](https://www.credly.com/users/joao-esperancinha)
[![](https://img.shields.io/badge/Coursera-%230077B5.svg?style=for-the-badge&logo=coursera&color=000080)](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![](https://img.shields.io/badge/Docker-%230077B5.svg?style=for-the-badge&logo=docker&color=cyan)](https://hub.docker.com/u/jesperancinha)
[![](https://img.shields.io/badge/Reddit-%230077B5.svg?style=for-the-badge&logo=reddit&color=black)](https://www.reddit.com/user/jesperancinha/)
[![](https://img.shields.io/badge/Hackernoon-%230077B5.svg?style=for-the-badge&logo=hackernoon&color=0a5d00)](https://hackernoon.com/@jesperancinha)
[![](https://img.shields.io/badge/Code%20Project-%230077B5.svg?style=for-the-badge&logo=codeproject&color=063b00)](https://www.codeproject.com/Members/jesperancinha)
[![](https://img.shields.io/badge/Free%20Code%20Camp-%230077B5.svg?style=for-the-badge&logo=freecodecamp&color=0a5d00)](https://www.freecodecamp.org/jofisaes)
[![](https://img.shields.io/badge/Hackerrank-%230077B5.svg?style=for-the-badge&logo=hackerrank&color=1e2f97)](https://www.hackerrank.com/jofisaes)
[![](https://img.shields.io/badge/LeetCode-%230077B5.svg?style=for-the-badge&logo=leetcode&color=002647)](https://leetcode.com/jofisaes)
[![](https://img.shields.io/badge/Codewars-%230077B5.svg?style=for-the-badge&logo=codewars&color=722F37)](https://www.codewars.com/users/jesperancinha)
[![](https://img.shields.io/badge/CodePen-%230077B5.svg?style=for-the-badge&logo=codepen&color=black)](https://codepen.io/jesperancinha)
[![](https://img.shields.io/badge/HackerEarth-%230077B5.svg?style=for-the-badge&logo=hackerearth&color=00035b)](https://www.hackerearth.com/@jofisaes)
[![](https://img.shields.io/badge/Khan%20Academy-%230077B5.svg?style=for-the-badge&logo=khanacademy&color=00035b)](https://www.khanacademy.org/profile/jofisaes)
[![](https://img.shields.io/badge/Pinterest-%230077B5.svg?style=for-the-badge&logo=pinterest&color=FF0000)](https://nl.pinterest.com/jesperancinha)
[![](https://img.shields.io/badge/Quora-%230077B5.svg?style=for-the-badge&logo=quora&color=FF0000)](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
[![](https://img.shields.io/badge/Google%20Play-%230077B5.svg?style=for-the-badge&logo=googleplay&color=purple)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
| [Sonatype Search Repos](https://search.maven.org/search?q=org.jesperancinha)
| [Dev.TO](https://dev.to/jofisaes)
| [Codebyte](https://coderbyte.com/profile/jesperancinha)
| [InfoQ](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![](https://img.shields.io/badge/OCP%20Java%2011-%230077B5.svg?style=for-the-badge&logo=oracle&color=064e40)](https://www.credly.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280)
[![](https://img.shields.io/badge/OCP%20JEE%207-%230077B5.svg?style=for-the-badge&logo=oracle&color=064e40)](https://www.credly.com/badges/27a14e06-f591-4105-91ca-8c3215ef39a2)
[![](https://img.shields.io/badge/VMWare%20Spring%20Professional%202021-%230077B5.svg?style=for-the-badge&logo=spring&color=064e40)](https://www.credly.com/badges/762fa7a4-9cf4-417d-bd29-7e072d74cdb7)
[![](https://img.shields.io/badge/IBM%20Cybersecurity%20Analyst%20Professional-%230077B5.svg?style=for-the-badge&logo=ibm&color=064e40)](https://www.credly.com/badges/ad1f4abe-3dfa-4a8c-b3c7-bae4669ad8ce)
[![](https://img.shields.io/badge/Deep%20Learning-%230077B5.svg?style=for-the-badge&logo=ibm&color=064e40)](https://www.credly.com/badges/8d27e38c-869d-4815-8df3-13762c642d64)
[![](https://img.shields.io/badge/Certified%20Neo4j%20Professional-%230077B5.svg?style=for-the-badge&logo=neo4j&color=064e40)](https://graphacademy.neo4j.com/certificates/c279afd7c3988bd727f8b3acb44b87f7504f940aac952495ff827dbfcac024fb.pdf)
[![](https://img.shields.io/badge/Certified%20Advanced%20JavaScript%20Developer-%230077B5.svg?style=for-the-badge&logo=javascript&color=064e40)](https://cancanit.com/certified/1462/)
[![](https://img.shields.io/badge/Kong%20Champions-%230077B5.svg?style=for-the-badge&logo=kong&color=064e40)](https://konghq.com/kong-champions)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=JEsperancinhaOrg&color=064e40&style=for-the-badge "jesperancinha.org dependencies")](https://github.com/JEsperancinhaOrg)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=064e40&style=for-the-badge "All badges")](https://joaofilipesabinoesperancinha.nl/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=orange&style=for-the-badge "Project statuses")](https://github.com/jesperancinha/project-signer/blob/master/project-signer-quality/Build.md)

</div>
