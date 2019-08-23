package org.freemason.pluto.common.transmission.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.freemason.pluto.common.transmission.Message;
import org.freemason.pluto.common.utils.SerializationUtils;

import static org.freemason.pluto.common.transmission.message.ETFOProtocol.PROTOCOL_HEADER_SIGN;


/**
 * Message编码器
 * 将invokeProcedure对象序列化之后按照Message协议写入
 * @author wangran
 * @since 1.0
 */
public class ProtocolEncoder extends MessageToByteEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        //序列化invokeResponse
        byte[] content = SerializationUtils.serialize(message);
        //写消息头标识
        out.writeInt(PROTOCOL_HEADER_SIGN);
        //写消息类型
        out.writeByte(message.getType());
        //写消息内容长度
        out.writeInt(content.length);
        //写消息内容
        out.writeBytes(content);
    }
}