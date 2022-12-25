# UAV trajectory calculation

# Technologies
* Java 17
* Maven
* Spring Boot 2.7.5
* Docker
* MongoDB 5.0.14
# Quick start
1) Clone this repository
2) Set up necessary fields in ```application.properties```
```
spring.datasource.mongodb.database=DB_NAME
```
3) Start maven compiling code and packaging it to jar - run **mvn clean package**
4) Run project
___
Besides, You can **pull image from Docker Hub** and start it with command. <br>
```docker pull octopy/uav-trajectory-calculation``` -> ```docker-compose up```
