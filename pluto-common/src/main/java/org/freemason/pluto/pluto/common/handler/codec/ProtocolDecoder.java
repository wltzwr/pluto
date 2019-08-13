package org.freemason.pluto.pluto.common.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.freemason.pluto.pluto.common.model.InvokeRequest;
import org.freemason.pluto.pluto.common.utils.SerializationUtils;

import java.util.List;

import static org.freemason.pluto.pluto.common.model.ETFOProtocol.MAX_CONTENT_LENGTH;
import static org.freemason.pluto.pluto.common.model.ETFOProtocol.PROTOCOL_HEADER_SIGN;


/**
 * 协议解码器
 * 读取byteBuf 并反序列化为InvokeRequest对象
 * @author wangran
 * @since 1.0
 */
public class ProtocolDecoder extends ByteToMessageDecoder {

    //头大小 int(HEADER_SIGN) + int(length) + byte(type) = 4 + 4 +1 = 9
    private static final int HEADER_SIZE = 9;

    private int beginIndex(ByteBuf in){
        int beginIndex;
        for (;;){
            //避免NPE  并确定可读字节数大于 HEADER_SIZE
            if (in == null || in.readableBytes() <= HEADER_SIZE) {
                return -1;
            }
            //读之前标记读索引位置   并读取一个int（读索引+4）
            in.markReaderIndex();
            int sign = in.readInt();

            if (sign == PROTOCOL_HEADER_SIGN){
                //如果读到的int为头标志(8341)，那么返回读取之后的读索引位置
                beginIndex = in.readerIndex();
                break;
            }else {
                //reset读索引到读取int之前的标记位置  之后读取一个byte  继续
                in.resetReaderIndex();
                in.readByte();
            }
        }
        return beginIndex;
    }


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out){
        //确定一个合法的读索引位置
        int beginIdx = beginIndex(in);
        //读取不到头标记
        if (beginIdx < 0){
            return;
        }

        //之前过程保证了读取到了合法的头标记 并确定了合法的读索引

        int contentLength = in.readInt();
        if (contentLength > MAX_CONTENT_LENGTH){
            in.resetReaderIndex();
            return;
        }

        byte type = in.readByte();
        if (in.readableBytes() < contentLength) {
            in.resetReaderIndex();
            return;
        }

        byte[] content = new byte[contentLength];
        in.readBytes(content);
        out.add(SerializationUtils.deserialize(content, InvokeRequest.class));
    }
}
