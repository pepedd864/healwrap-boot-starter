package com.github.pepedd.autoconfiguration.core.config;

import com.github.pepedd.autoconfiguration.core.HealwrapProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author pepedd864
 * @since 2023/10/27
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class ServerConfig {
  @Autowired
  private HealwrapProperties healwrapProperties;
  /**
   * Server配置
   */
  @Bean
  public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
    log.info("初始化Server...");
    HealwrapProperties.Server serverProperties = healwrapProperties.getServer();
    return (WebServerFactoryCustomizer<ConfigurableWebServerFactory>) factory -> {
      factory.setPort(serverProperties.getPort());
    };
  }
}
