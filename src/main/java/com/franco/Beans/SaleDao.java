package com.franco.Beans;

import com.franco.db.DBConnWithResources;
import com.franco.db.DBConnection;
import com.franco.models.SaleProduct;

import javax.inject.Inject;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class SaleDao implements DaoI<SaleProduct> {
    @Inject
    DBConnWithResources dbConnWithResources;
    public boolean create(SaleProduct sale) throws SQLException {
        String sql = "INSERT INTO reports(productName, quantity,price,total,date, customerName) VALUES(?,?,?,?,?,?)";
        Connection conn = DBConnection.getDbCon().conn;
        PreparedStatement prp = conn.prepareStatement(sql);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(sale.getDate());
        prp.setString(1, sale.getProductName());
        prp.setInt(2, sale.getQuantity());
        prp.setDouble(3, sale.getPrice());
        prp.setDouble(4, sale.getTotal());
        prp.setDate(5, Date.valueOf(dateString));
        prp.setString(6, sale.getCustomerName());


        return prp.executeUpdate() > 0;

    }

    @Override
    public SaleProduct read(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean update(SaleProduct saleProduct) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(SaleProduct saleProduct) throws SQLException {
        return false;
    }


    public ArrayList<SaleProduct> readAll() throws SQLException {
        String sql = "SELECT * FROM reports";
        ResultSet rs =DBConnection.getDbCon().executeQuery(sql);
        ArrayList<SaleProduct> sales = new ArrayList<>();
        while(rs.next()){
            SaleProduct sale = new SaleProduct();
            sale.setProductName(rs.getString("productName"));
            sale.setDate(rs.getDate("date"));
            sale.setPrice(rs.getInt("price"));
            sale.setQuantity(rs.getInt("quantity"));
            sale.setTotal(rs.getInt("total"));
            sale.setCustomerName(rs.getString("customerName"));
            sales.add(sale);

        }

        return sales;

    }



}
