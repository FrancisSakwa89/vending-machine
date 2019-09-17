package com.franco.db;


import java.sql.*;
import java.util.Scanner;

public final class DBConnection {

    public Connection conn;
    private Statement statement;
    public static DBConnection db;
    public static  PreparedStatement prp = null;


    public DBConnection() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "vend";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Francis_2019";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
//            conn.setAutoCommit(false);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized DBConnection getDbCon() {
        if ( db == null ) {
            db = new DBConnection();
        }
        return db;

    }



    public int insert() throws SQLException {
        statement = db.conn.createStatement();

        return prp.executeUpdate();
    }


    private void  createConnection(){}

    public ResultSet executeQuery(String sql) throws SQLException {
        statement = db.conn.createStatement();
        //String resul = "SELECT * FROM product WHERE id ="+;
        //statement.execute(sql);
        return  statement.executeQuery(sql);

    }

    public void commit(){
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void rollBack(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
