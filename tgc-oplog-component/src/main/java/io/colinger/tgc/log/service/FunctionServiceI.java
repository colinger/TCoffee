/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service;

import io.colinger.tgc.log.service.impl.DefaultFunctionServiceImpl;

/**
 * 用户根据需求自行实现
 * 默认实现 {@link DefaultFunctionServiceImpl}
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:07
 * @Description:
 */
public interface FunctionServiceI {
    /**
     * 值，函数
     * @param functionName
     * @param value
     * @return
     */
    String apply(String functionName, String value);

    /**
     * 扩展
     * @param functionName
     * @return
     */
    boolean beforeFunction(String functionName);
}
