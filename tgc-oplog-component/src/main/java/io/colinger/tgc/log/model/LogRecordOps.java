/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.model;

import lombok.Builder;
import lombok.Data;

/**
 *
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/22 23:41
 * @Description:
 */
@Data
@Builder
public class LogRecordOps {
    private String successLogTemplate;
    private String failLogTemplate;
    private String operatorId;
    private String bizKey;
    private String bizNo;
    private String category;
    private String detail;
    private String condition;
}
