package com.github.pepedd.autoconfiguration.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取配置类
 *
 * @author pepedd864
 * @since 2023/10/27
 */
@Data
@ConfigurationProperties(prefix = "healwrap")
public class HealwrapProperties {
  /**
   * 开启Healwrap
   */
  private boolean enabled;
  /**
   * 数据库配置
   */
  private DataSource dataSource = new DataSource();
  /**
   * 服务配置
   */
  private Server server = new Server();

  /**
   * Redis配置
   */
  private Redis redis = new Redis();

  @Data
  public static class DataSource {
    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String database = "test";
    private String host = "localhost";
    private int port = 3306;
    private String username = "root";
    private String password = "123456";
  }

  @Data
  public static class Server {
    private int port = 8080;
  }

  @Data
  public static class Redis {
    private String host = "localhost";
    private int port = 6379;
    private String password = "";
    private int database = 0;
  }
}
