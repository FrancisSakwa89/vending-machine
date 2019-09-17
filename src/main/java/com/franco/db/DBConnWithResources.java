package com.franco.db;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnWithResources {
        @Resource(lookup = "java:/MySqlDS")
        public DataSource dsc;
        public Statement statement;
        public static DBConnection db;

    //        @Produces
        public Connection getConnection() throws SQLException {
            System.out.println("connecting....");
            return dsc.getConnection();

        }

    public ResultSet executeQuery(String sql) throws SQLException {
        statement = db.conn.createStatement();
        //String resul = "SELECT * FROM product WHERE id ="+;
        //statement.execute(sql);
        return  statement.executeQuery(sql);

    }
    }


