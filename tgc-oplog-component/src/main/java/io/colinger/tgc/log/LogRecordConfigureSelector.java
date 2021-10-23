/**
 * Copyright (c) 2021-2021 All Rights Reserved.
 */

package io.colinger.tgc.log;

import io.colinger.tgc.log.annotation.EnableLogRecord;
import io.colinger.tgc.log.configuration.LogRecordProxyAutoConfiguration;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

import javax.annotation.Nullable;

/**
 * @密级别：classify:p2#-
 * @author: xinying.ge
 * @Date: 2021/10/22 23:32
 * @Description:
 */
public class LogRecordConfigureSelector extends AdviceModeImportSelector<EnableLogRecord> {
    private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME =
            "io.colinger.tgc.log.configuration.LogRecordProxyAutoConfiguration";


    @Override
    @Nullable
    public String[] selectImports(AdviceMode adviceMode) {
        switch (adviceMode) {
            case PROXY:
                return new String[]{LogRecordProxyAutoConfiguration.class.getName()};
            case ASPECTJ:
                return new String[]{ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME};
            default:
                return null;
        }
    }
}
