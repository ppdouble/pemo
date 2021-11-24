@[toc]
### 下载示例项目
根据[官网 quickstart](https://spring.io/quickstart)提示生成示例项目
![在这里插入图片描述](https://img-blog.csdnimg.cn/d7a50ddcd24f4ebe9e2f62b84607015c.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAcHBkb3VibGU=,size_20,color_FFFFFF,t_70,g_se,x_16#pic_center)
这里使用的是 **spring boot 2.6.0**

### 在IDEA中打开官网生成的项目
找到 `src/main/java/com/pxample/pemo/PemoApplication.java` 查看

```java
package com.pxample.pemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PemoApplication.class, args);
	}

}
```

### 修改代码
修改 `src/main/java/com/pxample/pemo/PemoApplication.java`  文件
```java
package com.pxample.pemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(PemoApplication.class, args);
	}

	@GetMapping("")
	public String pemodefault(@RequestParam(value = "customdefaultstr", defaultValue = "PefaultPage") String customdefaultstr) {
		return String.format("This is %s~", customdefaultstr);
	}

	@GetMapping("/pemohello")
	public String pemohello(@RequestParam(value = "name", defaultValue = "PemoWorld") String name) {
		return String.format("Hello %s~", name);
	}

}

```
### 改变服务器默认端口号
在 ` src/main/resources/`创建三个文件 
`application-dev.properties`
```text
server.port=8090
```
`application-staging.properties`
```text
server.port=8091
```
`application-production.properties`
```text
server.port=8092
```

### 添加404错误文件 404.html
路径为 : `src/main/resources/public/error/404.html`
```html
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron alert-danger">
        <h1>Oops!</h1>
        <h2>404 Not Found</h2>
    </div>
</div>
</body>

</html>
```
**目录结构**
```text
src
├── main
│   ├── java
│   │   └── com
│   │       └── pxample
│   │           └── pemo
│   │               └── PemoApplication.java
│   └── resources
│       ├── application-dev.properties
│       ├── application-production.properties
│       ├── application.properties
│       ├── application-staging.properties
│       ├── public
│       │   └── error
│       │       └── 404.html
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── pxample
                └── pemo
                    └── PemoApplicationTests.java
```
### 启动
使用其中配置的一个端口号进行启动
运行 `./mvnw spring-boot:run -Dspring-boot.run.profiles=production`

```bash
[user@localhost pemo]$ ./mvnw spring-boot:run -Dspring-boot.run.profiles=production
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.pxample:pemo >--------------------------
[INFO] Building pemo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.6.0:run (default-cli) > test-compile @ pemo >>>
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:resources (default-resources) @ pemo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 4 resources
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ pemo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /home/ideajavaprj/pemo/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:3.2.0:testResources (default-testResources) @ pemo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] skip non existing resourceDirectory /home/ideajavaprj/pemo/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ pemo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /home/ideajavaprj/pemo/target/test-classes
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.6.0:run (default-cli) < test-compile @ pemo <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.6.0:run (default-cli) @ pemo ---
[INFO] Attaching agents: []

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.0)

2021-11-24 11:04:35.245  INFO 10449 --- [           main] com.pxample.pemo.PemoApplication         : Starting PemoApplication using Java 1.8.0_212 on localhost.localdomain with PID 10449 (/home/ideajavaprj/pemo/target/classes started by codc in /home/ideajavaprj/pemo)
2021-11-24 11:04:35.247  INFO 10449 --- [           main] com.pxample.pemo.PemoApplication         : The following profiles are active: production
2021-11-24 11:04:36.148  INFO 10449 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8092 (http)
2021-11-24 11:04:36.161  INFO 10449 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-11-24 11:04:36.161  INFO 10449 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.55]
2021-11-24 11:04:36.206  INFO 10449 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-11-24 11:04:36.206  INFO 10449 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 898 ms
2021-11-24 11:04:36.517  INFO 10449 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8092 (http) with context path ''
2021-11-24 11:04:36.526  INFO 10449 --- [           main] com.pxample.pemo.PemoApplication         : Started PemoApplication in 1.697 seconds (JVM running for 2.048)
```
### 访问
`http://localhost:8092/`
页面返回显示为 `This is PefaultPage~`

`http://localhost:8092/?customdefaultstr=abc`
页面返回显示为 `This is abc~`

`http://localhost:8092/pemohello`
页面返回显示为 `Hello PemoWorld~`

`http://localhost:8092/pemohello?name=Nick`
页面返回显示为 `Hello Nick~`


[1] [how-to-change-default-port-in-spring-boot javatodev](https://javatodev.com/how-to-change-default-port-in-spring-boot/#:~:text=%20How%20To%20Change%20Default%20Port%20in%20Spring,using%20a%20command%20line%20argument%20as...%20More%20)
[2] [https://spring.io/quickstart](https://spring.io/quickstart)
