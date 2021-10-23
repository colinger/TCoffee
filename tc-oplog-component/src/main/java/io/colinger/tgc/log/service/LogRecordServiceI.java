/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service;

import io.colinger.tgc.log.model.LogRecord;
import io.colinger.tgc.log.service.impl.DefaultLogRecordServiceImpl;

/**
 * 日志记录的接口
 * 业务根据需求自行实现：把日志保存在任何存储介质上
 * 默认实现 {@link DefaultLogRecordServiceImpl}
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:05
 * @Description:
 */
public interface LogRecordServiceI {

    /**
     * 保存log
     *
     * @param logRecord 日志实体
     */
    void record(LogRecord logRecord);
}
