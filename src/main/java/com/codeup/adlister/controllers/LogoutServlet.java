package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
        response.sendRedirect("/login");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hash);

        String username = null;
        if (DaoFactory.getUsersDao().findByUsername(username) != null) {
            try {
                response.sendRedirect(request.getContextPath() + "/register?error=username");
                return;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("Received form data:");
    }


}
