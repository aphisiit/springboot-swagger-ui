# Demo spring-boot and swaager for simple api.
Run Project

    mvn clean compile -Dmaven.test.skip=true spring-boot:run

Build Project

    mvn clean compile -Dmaven.test.skip=true package

You can build a tagged docker image using the Maven command line like this
    
    mvn install dockerfile:build -Dmaven.test.skip=true

Run docker images

    docker run -p 8090:8090 --name SpringBootSwagger -d spt/swagger-back
