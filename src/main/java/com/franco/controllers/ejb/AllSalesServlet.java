package com.franco.controllers.ejb;

import com.franco.Beans.SaleDao;
import com.franco.controllers.baseServlet;
import com.franco.models.SaleProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-sales",urlPatterns = "/all-sales")
public class AllSalesServlet extends baseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<SaleProduct> sales = new SaleDao().readAll();
            req.setAttribute("sales",sales);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("/views/sale/allSales.jsp").include(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }

