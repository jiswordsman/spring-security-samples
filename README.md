# Spring Security入门学习

## Quick Start

1. 修改src/main/resources/application.properties中的数据源配置，改为自己要连接的数据库的地址、用户名、密码。
2. 在数据库中分别执行src/main/resources/doc/sql/下的"建表语句.sql"和"数据语句.sql"。
3. 在项目根目录下执行`mvn clean package -Dmaven.test.skip=true`.
4. 执行`java -jar target/spring-security-samples.jar`启动项目
5. 启动完成后，访问 http://localhost:8080/。默认有两个用户：admin和user，密码都是password。
