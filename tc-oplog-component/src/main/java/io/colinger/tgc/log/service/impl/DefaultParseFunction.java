/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service.impl;

import io.colinger.tgc.log.service.ParseFunctionI;

/**
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:14
 * @Description:
 */
public class DefaultParseFunction implements ParseFunctionI {

    @Override
    public boolean executeBefore() {
        return true;
    }

    @Override
    public String functionName() {
        return null;
    }

    @Override
    public String apply(String value) {
        return null;
    }
}
