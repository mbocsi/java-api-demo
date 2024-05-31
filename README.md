# Test springAPI

A RESTful API made using Oracle JDK 22 and Springboot. This is a test API for getting experience and experimentation with different backend frameworks.

## Running the server for dev

`./mvnw spring-boot:run`

## Building a jar file

`./mvnw install`
installs into `target/`

## Building docker image

`docker build --platform linux/amd64 -t mbocsi/springapi .` or whatever platform you want to deploy to
mbocsi/springapi is just the name of the image.

## Running the docker container

`docker run -p 8080:8080 mbocsi/springapi`

## Pushing the image

`docker push mbocsi/springapi`
Pushes the image with the 'latest' tag.

## Pulling the image

Make sure you are logged in either using user/pass or auth keys.
`docker pull mbocsi/springapi`
