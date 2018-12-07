package org.freemason.pluto.common.utils;

public class ClassUtils {
    private ClassUtils(){}

    public static Class<?> getClass(String className)  throws ClassNotFoundException {
        if (className == null) {
            throw new NullPointerException("className must not be null.");
        }
        Class clazz;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            switch (className) {
                case "byte":
                    return byte.class;
                case "int":
                    return int.class;
                case "short":
                    return short.class;
                case "long":
                    return long.class;
                case "boolean":
                    return boolean.class;
                case "char":
                    return char.class;
                case "double":
                    return double.class;
                case "float":
                    return float.class;
                default:
                    throw new ClassNotFoundException("can not find class:"+ className +".");
            }
        }
        return clazz;
    }

}
