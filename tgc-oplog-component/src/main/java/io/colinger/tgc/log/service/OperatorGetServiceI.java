/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service;

import io.colinger.tgc.log.model.Operator;
import io.colinger.tgc.log.service.impl.DefaultOperatorGetServiceImpl;

/**
 * 用户根据需求自行实现
 * 默认实现 {@link DefaultOperatorGetServiceImpl}
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:05
 * @Description:
 */
public interface OperatorGetServiceI {

    /**
     * 可以在里面外部的获取当前登陆的用户，比如UserContext.getCurrentUser()
     *
     * @return 转换成Operator返回
     */
    Operator getUser();
}
