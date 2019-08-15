package org.freemason.pluto.common.utils;

import java.util.UUID;

public class IDUtils {
    /**
     *  uuid生成id
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("_","");
    }
}
