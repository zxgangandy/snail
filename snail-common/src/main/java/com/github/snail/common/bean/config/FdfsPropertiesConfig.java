

package com.github.snail.common.bean.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnProperty(prefix = "fdfs", name = "file-host")
@ConfigurationProperties(prefix = "fdfs")
public class FdfsPropertiesConfig {
    private String fileHost;

    public String getFileHost() {
        return fileHost;
    }

    public void setFileHost(String fileHost) {
        this.fileHost = fileHost;
    }
}
