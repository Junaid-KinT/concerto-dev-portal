package com.concerto.devportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("file:${configPath}/configuration/projectConfig.properties"),
        @PropertySource("file:${configPath}/configuration/dbconfig.properties")
})
public class ProjectConfig {
}
