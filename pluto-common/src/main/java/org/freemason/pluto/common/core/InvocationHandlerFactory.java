package org.freemason.pluto.common.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
@Component
public class InvocationHandlerFactory {
    @Autowired
    private MessageTransceiver transceiver;

    public InvocationHandler produce(){
        return new ReferencedInvocationHandler(transceiver);
    }

}
