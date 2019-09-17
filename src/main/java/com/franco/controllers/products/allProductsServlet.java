package com.franco.controllers.products;

import com.franco.Beans.ProductDao;
import com.franco.controllers.baseServlet;
import com.franco.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-products", urlPatterns = "/all-products")
public class allProductsServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        validate(req,resp);
        try {
            ArrayList<Product> products = new ProductDao().readAll();
            req.setAttribute("products",products);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("/views/products/allProducts.jsp").include(req,resp);
//            req.getRequestDispatcher("/includes/footer.html").include(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
