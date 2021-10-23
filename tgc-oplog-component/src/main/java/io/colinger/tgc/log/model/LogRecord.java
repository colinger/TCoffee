/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 *
 *
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/22 23:39
 * @Description:
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogRecord {
    private Integer id;
    private String tenant;

    @NotBlank(message = "bizKey required")
    @Length(max = 200, message = "appKey max length is 200")
    private String bizKey;

    @NotBlank(message = "bizNo required")
    @Length(max = 200, message = "bizNo max length is 200")
    private String bizNo;

    @NotBlank(message = "operator required")
    @Length(max = 63, message = "operator max length 63")
    private String operator;

    @NotBlank(message = "opAction required")
    @Length(max = 511, message = "operator max length 511")
    private String action;

    private String category;
    private Date createTime;
    private String detail;
}