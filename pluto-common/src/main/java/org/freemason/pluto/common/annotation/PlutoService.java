package org.freemason.pluto.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 提供rpc服务的bean需要加该注解
 * 已经被spring视为一个component
 * 被注解类不需要添加@Component
 * @author wangran0430@gmail.com
 * @since 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PlutoService {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";

    String version() default "1.0.0";

    String auth();
}
