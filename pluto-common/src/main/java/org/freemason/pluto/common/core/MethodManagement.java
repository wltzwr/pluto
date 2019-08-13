package org.freemason.pluto.common.core;

import org.freemason.pluto.common.model.InvokeRequest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class MethodManagement {
    //  支持RPC调用的方法和对应的预生成调用请求映射
    //  InvokeRequest涉及到反射考虑到性能所以在初始化时直接静态化
    private static final Map<Method, InvokeRequest> RPC_ENABLE_METHOD_REQUEST_MAP = new ConcurrentHashMap<>();

    private static final Set<Method> EXCLUDE_METHODS = new CopyOnWriteArraySet<>(Arrays.asList(Object.class.getDeclaredMethods()));

    public static void registerMethod(Method method){
        RPC_ENABLE_METHOD_REQUEST_MAP.put(method, null);
    }

}
