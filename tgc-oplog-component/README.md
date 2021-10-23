### 操作日志组件

使用方法 
1. 增加依赖

```xml

<dependency>
    <groupId>io.colinger.tgc</groupId>
    <artifactId>tc-oplog-component</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>

```
2. 启动日志功能
```java
@EnableLogRecord(tenant = "com.xxx.xxx")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
```
