package com.franco.Beans;

import com.franco.db.DBConnWithResources;
import com.franco.db.DBConnection;
import com.franco.models.Product;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao implements DaoI<Product>{
    @Inject
    DBConnWithResources dbConnWithResources;
    @Override
    public boolean create(Product product) throws SQLException {
        String sql = "INSERT INTO product(name) VALUES(?)";
        Connection conn = dbConnWithResources.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,product.getName());
//        ps.setDouble(2,product.getPrice());

        return ps.executeUpdate() > 0;

    }
    @Override
    public Product read(int id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id=" + id;
        ResultSet rs = DBConnection.getDbCon().executeQuery(sql);
        Product product = new Product();
        if (rs.next()) {
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
        }

        return product;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        String sql = "UPDATE product SET name=?,description=? WHERE id=" + product.getId();
        Connection conn = DBConnection.getDbCon().conn;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());

        return ps.executeUpdate() > 0;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        String sql = "DELETE FROM product WHERE id=" + product.getId();
        Connection conn = DBConnection.getDbCon().conn;

        PreparedStatement prp = conn.prepareStatement(sql);

        return prp.executeUpdate() > 0;
    }

    public ArrayList<Product> readAll() throws SQLException {
        String sql = "SELECT * FROM product";
        ResultSet rs = DBConnection.getDbCon().executeQuery(sql);
        ArrayList<Product> products = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product();

            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            products.add(product);
        }
        return products;
    }

}

