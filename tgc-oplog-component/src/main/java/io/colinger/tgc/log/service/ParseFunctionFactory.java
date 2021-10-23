/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将所有的ParseFunctionI注入到函数工厂中
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:14
 * @Description:
 */
public class ParseFunctionFactory {

    private Map<String, ParseFunctionI> allFunctionMap;

    public ParseFunctionFactory(List<ParseFunctionI> parseFunctions) {
        if (CollectionUtils.isEmpty(parseFunctions)) {
            return;
        }
        allFunctionMap = new HashMap<>();
        for (ParseFunctionI parseFunction : parseFunctions) {
            if (StringUtils.isEmpty(parseFunction.functionName())) {
                continue;
            }
            allFunctionMap.put(parseFunction.functionName(), parseFunction);
        }
    }

    public ParseFunctionI getFunction(String functionName) {
        return allFunctionMap.get(functionName);
    }

    public boolean isBeforeFunction(String functionName) {
        return allFunctionMap.get(functionName) != null && allFunctionMap.get(functionName).executeBefore();
    }
}
