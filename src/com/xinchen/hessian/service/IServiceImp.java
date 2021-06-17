package com.xinchen.hessian.service;


import com.caucho.hessian.server.HessianServlet;
import com.xinchen.hessian.bean.User;

/**
 * @author
 * @create 2021-04-29 18:10
 */
public class IServiceImp extends HessianServlet implements IService {
    @Override
    public User getUser() {
        User user = new User();
        user.setName("Imp");
        user.setAge(18);
        return user;
    }
}
