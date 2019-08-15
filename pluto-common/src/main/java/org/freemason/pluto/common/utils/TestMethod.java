package org.freemason.pluto.common.utils;

import org.freemason.pluto.common.transmission.InvocationRequest;
import org.freemason.pluto.common.transmission.RequestBody;

public class TestMethod extends InvocationRequest {

    private Integer age;

    private String name;

    public TestMethod(RequestBody body) {
        super(null);
    }

    private void test(){}

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void print(){
        print0();
    }

    private static void print0(){

    }

}
