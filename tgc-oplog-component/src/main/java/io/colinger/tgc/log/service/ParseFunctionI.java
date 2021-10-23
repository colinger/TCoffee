/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service;

import io.colinger.tgc.log.service.impl.DefaultParseFunction;

/**
 * 用户根据需求自行实现
 * 默认实现 {@link DefaultParseFunction}
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:08
 * @Description:
 */
public interface ParseFunctionI {
    /**
     * 是否在业务代码执行前解析
     *
     * @return
     */
    default boolean executeBefore() {
        return false;
    }

    /**
     * 函数名
     *
     * @return
     */
    String functionName();

    /**
     * 应用
     *
     * @param value
     * @return
     */
    String apply(String value);
}
