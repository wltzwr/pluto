package org.freemason.pluto.common.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Springboot启动类加入该注解
 * 将会自动扫描basePackages包里所有的接口
 * 这些接口类均会被视为需要生成代理对象并调用rpc服务
 * @author wangran0430@gmail.com
 * @since 1.0
 * @see Reference
 * @see ReferenceScannerRegistrar
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ReferenceScannerRegistrar.class)
public @interface ReferenceScan {
    String[] basePackages();
}
