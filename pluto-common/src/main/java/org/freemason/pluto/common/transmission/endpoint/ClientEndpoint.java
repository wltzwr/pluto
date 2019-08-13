package org.freemason.pluto.common.transmission.endpoint;

import io.netty.channel.ChannelFuture;

/**
 * Netty客户端接口
 * @author wangran
 * @since 1.0
 */
public interface ClientEndpoint extends Endpoint {
    ChannelFuture send(Object msg);
}
