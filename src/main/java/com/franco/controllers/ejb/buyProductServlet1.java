package com.franco.controllers.ejb;

import com.franco.Beans.SaleDao;
import com.franco.controllers.baseServlet;
import com.franco.controllers.enums.Coins;
import com.franco.controllers.enums.Item;
import com.franco.models.SaleProduct;
import com.franco.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;

//@Stateful
@WebServlet(name = "buyProduct",urlPatterns = "/buyProduct")
public class buyProductServlet1 extends baseServlet {
//    @EJB
//    buyProductI buyProductI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        validate(req,resp);
        req.getRequestDispatcher("/views/products/buyProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        validate(req,resp);
        String productName = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Item.ItemsEnum product = Item.ItemsEnum.valueOf(productName);
        double total = product.getPrice() * quantity;
        double price = product.getPrice();

        int dollar = Integer.parseInt(req.getParameter("dollar"));
        int nickel = Integer.parseInt(req.getParameter("nickel"));
        int dime = Integer.parseInt(req.getParameter("dime"));
        int penny = Integer.parseInt(req.getParameter("penny"));
        int quarter = Integer.parseInt(req.getParameter("quarter"));

        double totalamount = ((dollar * Coins.CoinEnum.DOLLAR.getDenomination()) + (nickel * Coins.CoinEnum.NICKLE.getDenomination()) + (dime * Coins.CoinEnum.DIME.getDenomination()) + (penny * Coins.CoinEnum.PENNY.getDenomination()) + (quarter * Coins.CoinEnum.QUARTER.getDenomination()));

        if (totalamount > total) {
            double balance = totalamount - total;
            SaleDao saleDao = new SaleDao();

            System.out.println(productName + " " + quantity + "  " + total);
            PrintWriter pr = new PrintWriter(System.out);
            pr.write("Total is: " + total);
            User user = new User();

            String customerName = user.getUsername() ;

            java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            try {

                saleDao.create(new SaleProduct(productName, quantity, price, total, date, customerName));
                resp.sendRedirect("all-sales");
            } catch (SQLException e) {
                throw new ServletException("Error creating sale", e);
            }
            if (balance > 0){
                req.setAttribute("message", "Your balance is: : "+balance);
                System.out.println("Your balance is: "+ balance);
            }
            else  if (balance == 0){
                req.setAttribute("message", "Your balance is: "+balance);
                System.out.println("your balance is: "+ balance);
            }


        }else {
            double remaining;
            remaining = total - totalamount;
            req.setAttribute("message", "Error making transaction....you provided less cash remaing: "+remaining);
            System.out.println("Error making transaction....");
            req.getRequestDispatcher("error.jsp").forward(req,resp);


        }


    }
}

