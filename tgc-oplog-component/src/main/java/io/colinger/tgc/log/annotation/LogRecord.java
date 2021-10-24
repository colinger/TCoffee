/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.annotation;

import java.lang.annotation.*;

/**
 *
 *
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

    String success();

    String fail() default "";

    String operator() default "";

    String prefix();

    String bizNo();

    String category() default "";

    String detail() default "";

    String condition() default "";
}
