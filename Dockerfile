FROM jesperancinha/je-all-runtime-jdk-11

WORKDIR /root

COPY target/rockstars-manager*.jar rockstars.jar

ENTRYPOINT ["java", "-jar", "rockstars.jar"]