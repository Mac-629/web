package com.zz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            request.setCharacterEncoding("utf-8");

            String name = request.getParameter("name");
            String password = request.getParameter("password");

            System.out.println("name:" + name);
            System.out.println("password:" + password);
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("这是Get");
    }
}
