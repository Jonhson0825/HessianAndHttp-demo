package com.xinchen.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 * @create 2021-04-26 10:29
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        System.out.println(name);
//        PrintWriter out = null;
//        out = resp.getWriter();
//        out.print("dododododo");
//        out.flush();
//        out.close();
        req.setAttribute("china", "yes");
        req.getRequestDispatcher("/china.jsp").forward(req, resp);

    }
}
