package org.freemason.pluto.common.model;


import static org.freemason.pluto.common.Constants.PROTOCOL_HEADER_SIGN;

public class ETFOProtocol{
    //开始的头标志 4 byte
    private final int header_sign = PROTOCOL_HEADER_SIGN;
    //content长度 4 byte
    private int contentLength;
    //消息类型  0xAF 表示心跳包    0xBF 表示超时包  0xCF 业务信息包 1 byte
    private byte type;
    //内容
    private byte[] content;

    public ETFOProtocol(byte type, byte[] content) {
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
