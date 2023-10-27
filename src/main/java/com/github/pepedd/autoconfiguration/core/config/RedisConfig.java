package com.github.pepedd.autoconfiguration.core.config;

import com.github.pepedd.autoconfiguration.core.HealwrapProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * TODO
 *
 * @author pepedd864
 * @since 2023/10/27
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RedisTemplate.class)
public class RedisConfig {

  @Autowired
  private HealwrapProperties healwrapProperties;

  /**
   * Redis配置
   */
  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
    log.info("初始化Redis...");
    HealwrapProperties.Redis redisProperties = healwrapProperties.getRedis();

    RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
    redisConfig.setDatabase(redisProperties.getDatabase());
    redisConfig.setPassword(redisProperties.getPassword());

    return new LettuceConnectionFactory(redisConfig);
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);
    template.setKeySerializer(new StringRedisSerializer());
    // 设置其他的序列化器和配置
    // ...
    return template;
  }
}
