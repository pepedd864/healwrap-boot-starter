package com.github.pepedd.autoconfiguration.core.config;

import com.github.pepedd.autoconfiguration.core.HealwrapProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * TODO
 *
 * @author pepedd864
 * @since 2023/10/27
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
public class DataSourceConfig {
  @Autowired
  private HealwrapProperties healwrapProperties;

  /**
   * 通过Bean注入的方式配置数据源
   */
  @Bean
  public DataSource dataSource() {
    log.info("初始化数据库...");
    HealwrapProperties.DataSource dbProperties = healwrapProperties.getDataSource();
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(dbProperties.getDriverClassName());
    String url = dbProperties.getUrl();
    if (url == null || url.isEmpty()) {
      url = String.format("jdbc:mysql://%s:%d/%s", dbProperties.getHost(),
          dbProperties.getPort(), dbProperties.getDatabase());
    }
    dataSource.setUrl(healwrapProperties.getDataSource().getUrl());
    dataSource.setUsername(dbProperties.getUsername());
    dataSource.setPassword(dbProperties.getPassword());
    return dataSource;
  }
}
