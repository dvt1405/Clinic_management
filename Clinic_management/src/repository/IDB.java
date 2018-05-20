package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface IDB {
    public boolean openConnection();
    public Connection getConn();
    public ResultSet execQuery(String sql);
    public boolean execUpdate(String sql, List<Object> args);
    public void close();
}
