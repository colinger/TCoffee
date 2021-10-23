/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.service.impl;

import io.colinger.tgc.log.model.LogRecord;
import io.colinger.tgc.log.service.LogRecordServiceI;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/23 01:14
 * @Description:
 */
@Slf4j
public class DefaultLogRecordServiceImpl implements LogRecordServiceI {

    @Override
    public void record(LogRecord logRecord) {
        log.info("【logRecord】log={}", logRecord);
    }
}
