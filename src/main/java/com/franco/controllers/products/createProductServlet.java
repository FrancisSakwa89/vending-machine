package com.franco.controllers.products;

import com.franco.Beans.ProductDao;
import com.franco.controllers.baseServlet;
import com.franco.models.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "add-Product", urlPatterns = "/add-Product")
public class createProductServlet extends baseServlet {
    @Inject
    ProductDao productDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/products/addProduct.jsp").forward(req,resp);
    }
    //        throw new RuntimeException("test exception");




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        validate(req,resp);
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(name,price);
        try {
           if (productDao.create(product)){
            System.out.println("Added okay");}else {
               System.out.println("Failed");
           }
        } catch (SQLException e) {
            System.out.println("Error creating product");
            e.printStackTrace();
        }
        resp.sendRedirect("home.jsp");
        }



    }


