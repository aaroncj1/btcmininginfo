FROM gradle:7.6-jdk11

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY gradlew gradlew
COPY .gradle .gradle

# Copy the pom.xml file
COPY build.gradle .

COPY src src

RUN gradle clean build

COPY build/libs/btcmininginfo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
