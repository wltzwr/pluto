package org.freemason.pluto.common.transmission;

import java.io.Serializable;

/**
 * creat time 2019/8/14
 * pluto框架端点间交互信息的顶级接口
 * @param <B>   消息体类型
 * @param <ID>  id类型
 * @author  wangran0430@gmail.com
 * @since 1.0
 */
public interface Message<B, ID extends Serializable> extends Serializable{

    ID getId();

    byte getType();

    B getBody();
}
