package com.github.pepedd.autoconfiguration;

import com.github.pepedd.autoconfiguration.core.HealwrapProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author pepedd864
 * @since 2023/10/27
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(HealwrapProperties.class)
// 条件装配，当配置文件中healwrap.enabled=true时，才会装配HealwrapAutoConfiguration
@ConditionalOnProperty(prefix = "healwrap", name = "enabled", havingValue = "true", matchIfMissing = true)
public class HealwrapAutoConfiguration {
}
