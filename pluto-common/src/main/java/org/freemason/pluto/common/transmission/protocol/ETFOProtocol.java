package org.freemason.pluto.common.transmission.protocol;


import java.util.*;

/**
 * 交互协议的模型
 */
public class ETFOProtocol {

    /*  头标识    类型    内容长度    内容
        int      byte    int        byte[]
        4byte    1byte   4byte      数组长度
        8341     0xA/0xB  <1024
        ┌----┐    ┌-┐    ┌----┐    ┌--------
        │    │    │ │    │    │    │        .....
        └----┘    └-┘    └----┘    └--------
    */


    public static final String DEFAULT_VERSION = "1.0.0";

    public static final int PROTOCOL_HEADER_SIGN = 8341;

    public static final int CONTENT_MAX_LENGTH = 1 << 10;

    public static final byte BIZ_SIGN = 0xA;

    public static final byte HEART_BEAT_SIGN = 0xB;

    public static final byte PING_SIGN = 0xC;

    public static Set<Byte> TYPES;
    static {
        TYPES = new LinkedHashSet<>(3);
        TYPES.add(BIZ_SIGN);
        TYPES.add(HEART_BEAT_SIGN);
        TYPES.add(PING_SIGN);
        TYPES = Collections.unmodifiableSet(TYPES);
    }

    //开始的头标志 4 byte
    private final int header_sign = PROTOCOL_HEADER_SIGN;
    //content长度 4 byte
    private int contentLength;
    //消息类型  0xB 表示心跳包 0xA 业务信息包 1 byte
    private byte type;
    //内容
    private byte[] content;

    private ETFOProtocol(byte type, byte[] content) {
        this.type = type;
        this.contentLength = content.length;
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    public int getSign() {
        return header_sign;
    }

    public byte getType() {
        return type;
    }

    public int getContentLength() {
        return contentLength;
    }


    public static void main(String[] args) {
        System.out.println(HEART_BEAT_SIGN);
    }
}
