package org.freemason.pluto.common.annotation;

import java.lang.annotation.*;

/**
 * 需要生成代理对象并调用rpc服务
 * 手动指定那些接口需要调用rpc服务
 * 和{@link ReferenceScan}的关系类似于Mybatis的 @MapperScan 和 @Mapper的关系
 * @author wangran0430@gmail.com
 * @since 1.0
 * @see ReferenceScan
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Reference {
}
