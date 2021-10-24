/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.configuration;

import io.colinger.tgc.log.annotation.EnableLogRecord;
import io.colinger.tgc.log.aop.BeanFactoryLogRecordAdvisor;
import io.colinger.tgc.log.aop.LogRecordInterceptor;
import io.colinger.tgc.log.aop.LogRecordOperationSource;
import io.colinger.tgc.log.service.*;
import io.colinger.tgc.log.service.impl.DefaultFunctionServiceImpl;
import io.colinger.tgc.log.service.impl.DefaultLogRecordServiceImpl;
import io.colinger.tgc.log.service.impl.DefaultOperatorGetServiceImpl;
import io.colinger.tgc.log.service.impl.DefaultParseFunction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.Role;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

/**
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/22 23:33
 * @Description:
 */
@Configuration
@Slf4j
public class LogRecordProxyAutoConfiguration implements ImportAware {

    private AnnotationAttributes enableLogRecord;


    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public LogRecordOperationSource logRecordOperationSource() {
        return new LogRecordOperationSource();
    }

    @Bean
    @ConditionalOnMissingBean(FunctionServiceI.class)
    public FunctionServiceI functionService(ParseFunctionFactory parseFunctionFactory) {
        return new DefaultFunctionServiceImpl(parseFunctionFactory);
    }

    @Bean
    public ParseFunctionFactory parseFunctionFactory(@Autowired List<ParseFunctionI> parseFunctions) {
        return new ParseFunctionFactory(parseFunctions);
    }

    @Bean
    @ConditionalOnMissingBean(ParseFunctionI.class)
    public DefaultParseFunction parseFunction() {
        return new DefaultParseFunction();
    }


    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public BeanFactoryLogRecordAdvisor logRecordAdvisor(FunctionServiceI functionService) {
        BeanFactoryLogRecordAdvisor advisor =
                new BeanFactoryLogRecordAdvisor();
        advisor.setLogRecordOperationSource(logRecordOperationSource());
        advisor.setAdvice(logRecordInterceptor(functionService));
        return advisor;
    }

    @Bean
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public LogRecordInterceptor logRecordInterceptor(FunctionServiceI functionService) {
        LogRecordInterceptor interceptor = new LogRecordInterceptor();
        interceptor.setLogRecordOperationSource(logRecordOperationSource());
        interceptor.setTenant(enableLogRecord.getString("tenant"));
        interceptor.setFunctionService(functionService);
        return interceptor;
    }

    @Bean
    @ConditionalOnMissingBean(OperatorGetServiceI.class)
    @Role(BeanDefinition.ROLE_APPLICATION)
    public OperatorGetServiceI operatorGetService() {
        return new DefaultOperatorGetServiceImpl();
    }

    @Bean
    @ConditionalOnMissingBean(LogRecordServiceI.class)
    @Role(BeanDefinition.ROLE_APPLICATION)
    public LogRecordServiceI recordService() {
        return new DefaultLogRecordServiceImpl();
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {

        this.enableLogRecord = AnnotationAttributes.fromMap(importMetadata.getAnnotationAttributes(EnableLogRecord.class.getName(), false));

        if (this.enableLogRecord == null) {
            log.info("@EnableCaching is not present on importing class");
        }
    }
}
