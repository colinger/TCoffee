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

3. 实现日志接口

```java
import io.colinger.tgc.log.service.LogRecordServiceI;

public class XXXLogService implements LogRecordServiceI {
    @Override
    public void record(LogRecord logRecord) {
        //日志落地方法
    }
}
```

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XXXConfiguration {
    @Bean
    public LogRecordServiceI myLogRecordService() {
        return new XXXLogService();
    }
}
```
4. 其他接口，按需自行实现
* FunctionServiceI
* OperatorGetServiceI
* ParseFunctionI
