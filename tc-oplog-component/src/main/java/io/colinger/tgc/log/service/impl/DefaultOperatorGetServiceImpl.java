/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service.impl;

import io.colinger.tgc.log.model.Operator;
import io.colinger.tgc.log.service.OperatorGetServiceI;

/**
 * 默认实现，
 * 需要由用户根据业务场景自行实现
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:14
 * @Description:
 */
public class DefaultOperatorGetServiceImpl implements OperatorGetServiceI {

    @Override
    public Operator getUser() {
        Operator operator = new Operator();
        operator.setOperatorId("---");
        return operator;
    }
}
