package com.xinchen.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @create 2021-04-26 10:29
 */
public class MyPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        ServletInputStream servletInputStream = req.getInputStream();

        StringBuilder content = new StringBuilder();
        byte[] b = new byte[1024];
        int lens;
        while ((lens = servletInputStream.read(b)) > 0) {
            content.append(new String(b, 0, lens));
        }

        String strContent = content.toString(); // 请求体内容
        System.out.println(strContent);

        req.getRequestDispatcher("/china.jsp").forward(req, resp);

    }
}
