package org.freemason.pluto.pluto.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Constants {


    public static void main(String[] args) {
        Service s = (Service)Proxy.newProxyInstance(Constants.class.getClassLoader(),new Class[]{Service.class}, new ServiceProxyHandler());



        s.say("name");
        s.hello();

        s.execute(0);
    }





    public interface Service{

        void say(String name);

        void hello();

        int execute(int a);

    }

    public static class ServiceProxyHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

}
