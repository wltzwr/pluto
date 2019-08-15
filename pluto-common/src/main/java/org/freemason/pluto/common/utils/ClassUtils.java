package org.freemason.pluto.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassUtils {
    private static Set<Method> OBJECT_METHOD_SET = new LinkedHashSet<>(Arrays.asList(Object.class.getMethods()));
    /**
     * 获取类中 public 的实例方法
     * @param clazz 用解释吗？
     * @return  实例方法set
     */
    public static Set<Method> getPublicInstanceMethod(Class<?> clazz){
        if (clazz == null)
            throw new NullPointerException("class must not be null.");
        Set<Method> methodSet = new LinkedHashSet<>(Arrays.asList(clazz.getMethods()));
        return methodSet.parallelStream()
                .filter(method -> !OBJECT_METHOD_SET.contains(method) && !Modifier.isStatic(method.getModifiers()))
                .collect(Collectors.toSet());
    }
}
