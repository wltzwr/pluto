package org.freemason.pluto.common.core;

import org.freemason.pluto.common.transmission.*;
import org.freemason.pluto.common.transmission.endpoint.ClientEndpoint;
import org.freemason.pluto.common.transmission.endpoint.NettyServerEndpoint;

public class MessageTransceiver {

    NettyServerEndpoint serverEndpoint = new NettyServerEndpoint(43092,null);

    public static Message<ResponseBody, String> exchange(Message<RequestBody, String> message) throws Exception{
        return null;
    }

}
