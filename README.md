## spring-boot-web-blank

#### 已集成组件
- springframework-4.1.6.RELEASE
- freemarker-2.3.22
- druid-1.0.14
- mybatis-3.3.0
- activemq-5.7.0
- quartz-2.2.1
- slf4j-1.7.12
- logback-1.1.3
- guava-18.0
- apache-commons-xxx

#### 注意事项
- 目录结构可参考 `./tree.txt`。聪明的你一定知道什么样的文件应该放在什么目录。
- 不推荐使用[JSP](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations), freemarker取而代之。

#### 怎么运行这东西?

~~~
cd /path/to/spring-boot-web-blank
mvn spring-boot:run
~~~

或

~~~
cd /path/to/spring-boot-web-blank
mvn clean package
java -jar target/spring-boot-web-blank-1.0.0.jar --spring.profiles.active=prod
~~~

访问`http://localhost:8080/`即可看到效果