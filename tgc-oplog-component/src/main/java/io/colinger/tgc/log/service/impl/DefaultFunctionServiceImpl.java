/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service.impl;

import io.colinger.tgc.log.service.FunctionServiceI;
import io.colinger.tgc.log.service.ParseFunctionFactory;
import io.colinger.tgc.log.service.ParseFunctionI;

/**
 * 1.根据传入的函数名称 functionName 找到对应的 ParseFunctionI，
 * 2.把参数传入到 ParseFunctionI 的 apply 方法上最后返回函数的值
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:14
 * @Description:
 */
public class DefaultFunctionServiceImpl implements FunctionServiceI {

    private final ParseFunctionFactory parseFunctionFactory;

    public DefaultFunctionServiceImpl(ParseFunctionFactory parseFunctionFactory) {
        this.parseFunctionFactory = parseFunctionFactory;
    }

    @Override
    public String apply(String functionName, String value) {
        ParseFunctionI function = parseFunctionFactory.getFunction(functionName);
        if (function == null) {
            return value;
        }
        return function.apply(value);
    }

    @Override
    public boolean beforeFunction(String functionName) {
        return parseFunctionFactory.isBeforeFunction(functionName);
    }
}
