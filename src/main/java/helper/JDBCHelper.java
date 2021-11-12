/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.*;

/**
 *
 * @author balis
 */
public class JDBCHelper {

    // Can doi mat khau SQLServer sang 1221 va ten DB la QuanLyKhachSan
    public static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSan";
    public static String USERNAME = "sa";
    public static String PASSWORD = "1221";
    public static Connection conn = null;

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("connect successfully(kết nối thành công)");
        } catch (ClassNotFoundException ex) {
            System.out.println("lỗi thiếu thư viện");
        } catch (SQLException ex) {
            System.out.println("lỗi kết nối csdl");
        }
    }

    public static PreparedStatement preparedStatement(String SQL, Object... args) throws SQLException {
        PreparedStatement stmt = null;
        if (SQL.trim().startsWith("{")) {
            stmt = conn.prepareCall(SQL); //proc
        } else {
            stmt = conn.prepareStatement(SQL);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    public static ResultSet executeQuery(String SQL, Object... args) {
        try {
            PreparedStatement stmt = preparedStatement(SQL, args);
            try {
                return stmt.executeQuery();
            } finally {
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void executeUpdate(String SQL, Object... args) {
        try {
            PreparedStatement stmt = preparedStatement(SQL, args);
            try {
                stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
