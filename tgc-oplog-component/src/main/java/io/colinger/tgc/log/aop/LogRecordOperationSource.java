/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.aop;

import io.colinger.tgc.log.annotation.LogRecord;
import io.colinger.tgc.log.model.LogRecordOps;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 解析LogRecord
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/22 23:38
 * @Description:
 */
public class LogRecordOperationSource {
    /**
     *
     * @param method
     * @param targetClass
     * @return
     */
    public Collection<LogRecordOps> computeLogRecordOperations(Method method, Class<?> targetClass) {
        // Don't allow no-public methods as required.
        if (!Modifier.isPublic(method.getModifiers())) {
            return null;
        }

        // The method may be on an interface, but we need attributes from the target class.
        // If the target class is null, the method will be unchanged.
        Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
        // If we are dealing with method with generic parameters, find the original method.
        specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

        // First try is the method in the target class.
        return parseLogRecordAnnotations(specificMethod);
    }

    /**
     *
     * @param ae
     * @return
     */
    private Collection<LogRecordOps> parseLogRecordAnnotations(AnnotatedElement ae) {
        Collection<LogRecord> logRecordAnnotationAnnotations = AnnotatedElementUtils.getAllMergedAnnotations(ae, LogRecord.class);
        Collection<LogRecordOps> ret = null;
        if (!logRecordAnnotationAnnotations.isEmpty()) {
            ret = lazyInit(ret);
            for (LogRecord recordAnnotation : logRecordAnnotationAnnotations) {
                ret.add(parseLogRecordAnnotation(ae, recordAnnotation));
            }
        }
        return ret;
    }

    /**
     *
     * @param ae
     * @param recordAnnotation
     * @return
     */
    private LogRecordOps parseLogRecordAnnotation(AnnotatedElement ae, LogRecord recordAnnotation) {
        LogRecordOps recordOps = LogRecordOps.builder()
                .successLogTemplate(recordAnnotation.success())
                .failLogTemplate(recordAnnotation.fail())
                .bizKey(recordAnnotation.prefix().concat("_").concat(recordAnnotation.bizNo()))
                .bizNo(recordAnnotation.bizNo())
                .operatorId(recordAnnotation.operator())
                .category(StringUtils.isEmpty(recordAnnotation.category()) ? recordAnnotation.prefix() : recordAnnotation.category())
                .detail(recordAnnotation.detail())
                .condition(recordAnnotation.condition())
                .build();
        validateLogRecordOperation(ae, recordOps);
        return recordOps;
    }


    /**
     *
     * @param ae
     * @param recordOps
     */
    private void validateLogRecordOperation(AnnotatedElement ae, LogRecordOps recordOps) {
        if (!StringUtils.hasText(recordOps.getSuccessLogTemplate()) && !StringUtils.hasText(recordOps.getFailLogTemplate())) {
            throw new IllegalStateException("Invalid logRecord annotation configuration on '" +
                    ae.toString() + "'. 'one of successTemplate and failLogTemplate' attribute must be set.");
        }
    }

    /**
     *
     * @param ops
     * @return
     */
    private Collection<LogRecordOps> lazyInit(Collection<LogRecordOps> ops) {
        return (ops != null ? ops : new ArrayList<>(1));
    }
}
