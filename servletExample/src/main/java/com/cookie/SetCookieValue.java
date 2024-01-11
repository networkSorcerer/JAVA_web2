package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setCookieValue")
public class SetCookieValue extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String now = dateFormat.format(d); // 현재 시간을 문자열로 저장

        Cookie cl = new Cookie("connectTime", URLEncoder.encode(now, "utf-8"));
        cl.setMaxAge(24 * 60 * 60);
        response.addCookie(cl);

        Cookie c2 = new Cookie("cookieString", URLEncoder.encode("JSP프로그래밍입니다", "utf-8"));

        c2.setMaxAge(-1);
        response.addCookie(c2);

        Cookie c3 = new Cookie("cookieName", "Youngsu");
        c3.setMaxAge(24 * 60 * 60);
        response.addCookie(c3);

        out.println("<!DOCTYPE html><html>");
        out.println("<head><meta charset='UTF-8' />");
        out.println("<title>Cookie 예제</title>");
        out.println("<link rel = 'icon' href = 'data:,'></head>");
        out.println("<body>");
        out.println("<div>현재 시간 : " + now + " </div>");
        out.println("<div>문자열을 Cookie에 저장 합니다</div>");
        out.println("</body></html>");
        out.close();
    }
}
