package org.freemason.pluto.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.freemason.pluto.common.core.InvocationMappingHandlerMapping;
import org.freemason.pluto.common.transmission.HeartBeat;
import org.freemason.pluto.common.transmission.InvocationRequest;
import org.freemason.pluto.common.transmission.Message;
import org.freemason.pluto.common.transmission.RequestBody;
import org.freemason.pluto.common.utils.SerializationUtils;

public class Constants {

    public static void main(String[] args) throws NoSuchMethodException, InterruptedException {
        /*Message<RequestBody, String> request
                = new InvocationRequest(InvocationMappingHandlerMapping.class.getMethod("getHandlerMethod", RequestBody.class)
                ,new Object[]{new RequestBody(Constants.class.getMethod("hashCode"))});

        byte[] rrr = SerializationUtils.serialize(request);

        request = SerializationUtils.deserialize(rrr, Message.class);*/

        for (;;){
            Thread.sleep(2000);

            System.out.println(JSON.toJSONString(HeartBeat.getInstance()));
        }


    }
}
