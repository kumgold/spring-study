package com.hello.demo.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("전체 파라미터 조회");
        request.getParameterNames().asIterator()
                .forEachRemaining(name -> System.out.println(name + " = " + request.getParameter(name)));
        System.out.println();

        System.out.println("단일 파라미터 조회");
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        String age = request.getParameter("age");
        System.out.println("age = " + age);

        System.out.println("이름이 같은 파라미터 조회");
        String[] names = request.getParameterValues("name");

        for (String n: names) {
            System.out.println("n = " + n);
        }

        response.getWriter().write("ok");
    }
}
