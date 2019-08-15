package org.freemason.pluto.common.transmission;

import org.springframework.util.Assert;

public class InvocationResponse extends AbstractMessage<ResponseBody, String>{
    //  一次响应必须对应一次请求 所以强制要求id必须一样
    public InvocationResponse(InvocationRequest request, ResponseBody result) {
        super(request.getId(), request.getType());
        Assert.notNull(result, "body must not be null.");
        this.body = result;
    }
}
