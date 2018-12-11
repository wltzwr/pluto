package org.freemason.pluto.pluto.common.endpoint;

import io.netty.channel.Channel;

/**
 * Netty端点顶级接口
 * @author wangran
 * @since 1.0
 */
public interface Endpoint{

    Channel channel();

    void close();
}
