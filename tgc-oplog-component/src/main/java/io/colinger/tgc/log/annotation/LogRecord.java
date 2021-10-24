/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.annotation;

import java.lang.annotation.*;

/**
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/22 23:29
 * @Description:
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogRecord {
    /**
     * 正常执行的模板
     *
     * @return
     */
    String success();

    /**
     * 出错的模板
     *
     * @return
     */
    String fail() default "";

    /**
     * 操作人
     *
     * @return
     */
    String operator() default "";

    /**
     * 前缀
     *
     * @return
     */
    String prefix();

    /**
     * 业务编号
     *
     * @return
     */
    String bizNo();

    /**
     * 条件：是否记录日志
     *
     * @return
     */
    String condition() default "";
}
