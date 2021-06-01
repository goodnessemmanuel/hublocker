package com.oceanngrsmith.ocheejeh.hublocker.configurations;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    @NotNull String url;
}
