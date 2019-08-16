package org.freemason.pluto.common.core;

import org.freemason.pluto.common.transmission.InvocationResponse;
import org.freemason.pluto.common.transmission.Message;
import org.freemason.pluto.common.transmission.RequestBody;
import org.freemason.pluto.common.transmission.ResponseBody;
import org.freemason.pluto.common.transmission.endpoint.NettyServerEndpoint;
import org.springframework.stereotype.Component;

@Component
public class MessageTransceiver {

    NettyServerEndpoint serverEndpoint = new NettyServerEndpoint(43092,null);

    public Message<ResponseBody, String> exchange(Message<RequestBody, String> message) throws Exception{
        return new InvocationResponse(message.getId(), message.getType(), new ResponseBody("test", true));
    }

}
