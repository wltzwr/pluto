package org.freemason.pluto.common.model;



/**
 * 交互协议的模型
 */
public class ETFOProtocol{

    public static final String DEFAULT_VERSION = "1.0.0";

    public static final int PROTOCOL_HEADER_SIGN = 8341;

    public static final int MAX_CONTENT_LENGTH = 1024;

    public static final byte HEART_BEAT = 82;

    public static final byte INVOKE = 8;


    //开始的头标志 4 byte
    private final int header_sign = PROTOCOL_HEADER_SIGN;
    //content长度 4 byte
    private int contentLength;
    //消息类型  0xAF 表示心跳包    0xBF 表示超时包  0xCF 业务信息包 1 byte
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

}
