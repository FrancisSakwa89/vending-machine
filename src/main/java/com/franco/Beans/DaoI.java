package com.franco.Beans;

import java.sql.SQLException;

public interface DaoI<T>{
    boolean create(T t) throws SQLException;
    T read(int id) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}
