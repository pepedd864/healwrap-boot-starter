package com.github.pepedd.autoconfiguration.annotation;

import com.github.pepedd.autoconfiguration.HealwrapAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 注解开启Healwrap
 *
 * @author pepedd864
 * @since 2023/10/27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HealwrapAutoConfiguration.class)
public @interface EnableHealwrap {
}
