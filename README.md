# POC Logging Client

A Service to receive messages and log them.

#### Technologies
- Gradle
- JDK 1.8
- Spring Boot
- Spring-Web


### Installation
#### Requirements
- JDK 1.8

Executing the command below, it'll install all the project dependencies and build the package.

```
    ./gradlew build or gradlew.bat build
```

### Running

```
    java -jar build/libs/poc-logging-client-1.0-SNAPSHOT.jar
```

### Documentation

```
    http://localhost:9080/health
```


### Testing 
To test the logging, we just need to send a POST like the example below:

`Endpoint: http://localhost:9080/api/v1/processData`

```
{
	"device": "Scale",
	"organization": "Hospital XPTO",
	"name": "Quartzolit"
}
```

