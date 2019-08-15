package org.freemason.pluto.common.transmission;

import org.freemason.pluto.common.utils.IPUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.freemason.pluto.common.transmission.protocol.ETFOProtocol.HEART_BEAT_SIGN;

/**
 * creat time 2019/8/14
 * 心跳包
 * @author  wangran0430@gmail.com
 * @since 1.0
 */
public class HeartBeat extends AbstractMessage<String, String> {
    private transient static final String PING = "ping";
    private transient static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public HeartBeat() {
        super(PING, HEART_BEAT_SIGN);
        init();
    }

    private void init(){
        //  ex : receive ping from 127.0.0.1 at 2019-08-14 10:57:13
        this.body = "receive ping from " + IPUtils.getLocalIP() + " at " + LocalDateTime.now().format(FORMATTER);
    }
}
