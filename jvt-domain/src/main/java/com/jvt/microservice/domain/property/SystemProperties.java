package com.jvt.microservice.domain.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*系统参数配置*/
@Component
@ConfigurationProperties(prefix = "system")
public class SystemProperties {
    /*系统根路径*/
    private String basePath;

    public String getBasePath() {
        return this.basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

}
