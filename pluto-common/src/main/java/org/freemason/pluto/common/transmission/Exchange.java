package org.freemason.pluto.common.transmission;

import java.io.Serializable;

/**
 * pluto框架端点间交互信息的顶级接口
 * @param <ID> 交互消息唯一识别码类型
 * @param <T> 交互消息的载荷类型
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public interface Exchange<ID extends Serializable, T> {

    ID getId();

    byte getType();

    T getPayload();

}
