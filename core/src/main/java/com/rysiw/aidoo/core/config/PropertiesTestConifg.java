package com.rysiw.aidoo.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Rysiw
 * @date 2022/7/11 10:00
 */
//@Configuration
//@PropertySource("classpath:netsignagent.properties")
public class PropertiesTestConifg {

    @Value("${ttttt}")
    public String ttttt;

    @Value("${worker.log.file.path}")
    public String tete;
}
