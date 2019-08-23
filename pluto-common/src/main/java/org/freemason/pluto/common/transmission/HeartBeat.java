package org.freemason.pluto.common.transmission;

import org.freemason.pluto.common.utils.IPUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.freemason.pluto.common.transmission.message.ETFOProtocol.HEART_BEAT_SIGN;

/**
 * creat time 2019/8/14
 * 心跳包
 * @author  wangran0430@gmail.com
 * @since 1.0
 */
public class HeartBeat extends AbstractMessage<String, String> {
    private transient static final String HEART_BEAT_ID = "ping";
    private transient static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private transient static final String LOCAL_IP = IPUtils.getLocalIP();
    private HeartBeat() {
        super(HEART_BEAT_ID, HEART_BEAT_SIGN);
    }

    private static HeartBeat INSTANCE = new HeartBeat();

    public static HeartBeat getInstance(){
        return INSTANCE.refresh();
    }

    private HeartBeat refresh(){
        this.body = "ping from " + LOCAL_IP + " at " + LocalDateTime.now().format(FORMATTER);
        return this;
    }
}
