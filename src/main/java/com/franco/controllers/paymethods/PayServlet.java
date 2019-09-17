package com.franco.controllers.paymethods;

import com.franco.controllers.baseServlet;
import com.franco.controllers.enums.Coins.CoinEnum;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "pay",urlPatterns = "/pay")
public class PayServlet extends baseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        validate(req,resp);
        req.getRequestDispatcher("/pay/payGeneral.jsp").forward(req,resp);
        String payType = req.getParameter("pay");
        double countCoin = Double.parseDouble(req.getParameter("coinNumber"));
        double total = 0;

        CoinEnum coinFilter = CoinEnum.valueOf(String.valueOf(payType.equalsIgnoreCase(String.valueOf(CoinEnum.DIME.getDenomination()))));

//            total += (coinFilter) * (countCoin);
            System.out.println("dime bob: "+ countCoin);





    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        validate(req,resp);
        req.getRequestDispatcher("/pay/payGeneral.jsp").forward(req,resp);



    }
}
