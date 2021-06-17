package com.xinchen.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.xinchen.hessian.basic.Basic;

import java.net.MalformedURLException;

public class HSTest {
    public static void main(String[] args) throws MalformedURLException {
//        String url = "http://localhost:8080/HessianServer/api/service";
        String url = "http://localhost:8080/hessian_test_war_exploded/hessian";

        HessianProxyFactory factory = new HessianProxyFactory();
        Basic api = (Basic) factory.create(Basic.class, url);
        System.out.println(api.sayHello("fangfang"));


    }
}
