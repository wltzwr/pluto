package org.freemason.pluto.common.transmission;

import org.springframework.util.Assert;

public class InvocationResponse extends AbstractMessage<ResponseBody, String>{
    //  一次响应必须对应一次请求 所以强制要求id必须一样
    public InvocationResponse(InvocationRequest request, ResponseBody result) {
        this(request.getId(), request.getType(), result);
    }

    public InvocationResponse(String id, byte type, ResponseBody result) {
        super(id, type);
        Assert.notNull(result, "body must not be null.");
        this.body = result;
    }


}
