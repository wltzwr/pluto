package org.freemason.pluto.common.registry;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisExporter implements Exporter{

    private JedisPool pool = new JedisPool("localhost",6379);

    @Override
    public void export() {
        try(Jedis jedis =pool.getResource()) {
            System.out.println(jedis.ping());
        }
    }

    public static void main(String[] args) {

        RedisExporter e = new RedisExporter();
        e.export();
    }
}
