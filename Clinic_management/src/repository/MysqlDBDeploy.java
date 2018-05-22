package repository;

import util.Helper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ledin
 */
public class MysqlDBDeploy implements IDB {

    private Connection conn = null;

    @Override
    public boolean openConnection() {
        try {
            if (this.conn == null) {
                Properties props = new Properties();
                // đọc thông tin database trong file và kết nối
                props.load(new FileInputStream("data/database/jdbc.properties"));
                Class.forName(props.getProperty("driver"));
                this.conn = DriverManager.getConnection(
                        props.getProperty("url"),
                        props.getProperty("username"),
                        props.getProperty("password"));
                return true;
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MysqlDBDeploy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            Helper.dlgNotice("Lỗi kết nối", "Không thể kết nối tới cơ sở dữ liệu!");
        }
        return false;
    }

    // Tự động set Type cho các object dữ liệu
    // Phục vụ cho prepared statement
    private void autoSetTypeObjectsArgs(PreparedStatement pstmt, List<Object> args) throws SQLException {
        Date valueNullDate = new Date(0);
        short valueNullShort = -1;
        int valueNullInteger = -1;
        long valueNullLong = -1;
        double valueNullDouble = -1.0D;
        float valueNullFloat = -1.0F;

        int i = 1;

        for (Object arg : args) {
            // với dạng số, coi -1 là null, 0 vẫn là 0
            if (arg instanceof Date) {
                // coi Date(0) == null date
                if (arg.equals(valueNullDate)) {
                    pstmt.setNull(i++, Types.TIME);
                } else {
                    pstmt.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
                }
            } else if (arg instanceof Short) {
                if (arg.equals(valueNullShort)) {
                    pstmt.setNull(i++, Types.SMALLINT);
                } else {
                    pstmt.setInt(i++, (Short) arg);
                }
            } else if (arg instanceof Integer) {
                if (arg.equals(valueNullInteger)) {
                    pstmt.setNull(i++, Types.INTEGER);
                } else {
                    pstmt.setInt(i++, (Integer) arg);
                }
            } else if (arg instanceof Long) {
                if (arg.equals(valueNullLong)) {
                    pstmt.setNull(i++, Types.BIGINT);
                } else {
                    pstmt.setLong(i++, (Long) arg);
                }
            } else if (arg instanceof Double) {
                if (arg.equals(valueNullDouble)) {
                    pstmt.setNull(i++, Types.DOUBLE);
                } else {
                    pstmt.setDouble(i++, (Double) arg);
                }
            } else if (arg instanceof Float) {
                if (arg.equals(valueNullFloat)) {
                    pstmt.setNull(i++, Types.FLOAT);
                } else {
                    pstmt.setFloat(i++, (Float) arg);
                }
            } else {
                if (arg == null) {
                    pstmt.setNull(i++, Types.VARCHAR);
                } else {
                    pstmt.setString(i++, (String) arg);
                }
            }
        }
    }

    // dùng cho các câu query lấy dữ liệu
    // trả dữ liệu về dưới dạng ResultSet là tập dữ liệu cần query
    @Override
    public ResultSet execQuery(String sql) {
        PreparedStatement pstmt;
        ResultSet res = null;
        try {
            if (conn == null) {
                throw new SQLException("Không kết nối được với cơ sở dữ liệu!");
            }
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println(sql);    // print sql query để debug
            e.printStackTrace(System.out);
        }
        return res;
    }

    // dùng cho các lệnh INSERT, DELETE, UPDATE
    // trả về trạng thái true khi ok hoặc false khi error
    @Override
    public boolean execUpdate(String sql, List<Object> args) {
        PreparedStatement pstmt = null;
        try {
            if (conn == null) {
                throw new SQLException("Không kết nối được với cơ sở dữ liệu!");
            }
            pstmt = conn.prepareStatement(sql);
            autoSetTypeObjectsArgs(pstmt, args);
            int affectedRows = pstmt.executeUpdate();   // return 0 hoặc số rows updated!
            if (affectedRows != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(sql);    // print sql query để debug
            e.printStackTrace(System.out);
        }
        return false;
    }

    // được gọi ngay trước khi đối tượng MysqlDBDeploy bị hủy bởi Garbage Collector
    @Override
    protected void finalize() throws Throwable {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            super.finalize();
        }
    }

    // close resultSet
    public void close(ResultSet rst) throws Exception {
        try {
            try (Statement stmt = rst.getStatement()) {
                rst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    // close statement
    public void close(Statement stmt) throws Exception {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    // close connect
    public void close() {
        try {
            if (!conn.getAutoCommit()) {
                return;
            }
            if (conn != null) {
                conn.close();
            }
            conn = null;
        } catch (SQLException ex) {
            Logger.getLogger(MysqlDBDeploy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
