package com.franco.controllers.accounts;


import com.franco.Beans.UserBean;
import com.franco.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "login",urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/includes/login.jsp").include(req,resp);
//        req.getRequestDispatcher("/includes/footer.html").include(req,resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        UserBean userBean = new UserBean();
            try {
                User user = userBean.readByName(name);
                if (user.getPassword().equalsIgnoreCase(password)) {
                    auth(req);
                    HttpSession s = req.getSession();
                    s.setAttribute("username", user);
//                    s.setMaxInactiveInterval(5 * 60);
                    resp.sendRedirect("login");


                } else {
                    PrintWriter out = new PrintWriter(System.out);
                    out.write("User credential incorrect...");
                    System.out.println("user not exist..");
                    req.setAttribute("message", "User password or username is incorrect !!!!");
//                    req.getRequestDispatcher("/includes/login.jsp").forward(req, resp);
                    resp.sendRedirect("login");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }



    }



    public boolean isLoggedIn(HttpServletRequest req){
        HttpSession s = req.getSession();
        return (boolean)s.getAttribute("loggedIn");


    }

    public void auth(HttpServletRequest req){
        HttpSession s = req.getSession();
        s.setAttribute("loggedIn", true);

    }



}
