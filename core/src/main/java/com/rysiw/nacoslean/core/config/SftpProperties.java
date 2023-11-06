package com.rysiw.nacoslean.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Rysiw
 * @date 2022/7/21 16:14
 */
@Configuration
//@ConfigurationProperties(prefix = "sftp")
public class SftpProperties {

    @Value("${sftp.host}")
    public String host;

    @Value("${sftp.username}")
    public String username;

    @Value("${sftp.password}")
    public String password;
}
