/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_DangNhap {

    public static ResultSet LayTaiKhoanTheoMa(String TK) {
        String sql = "SELECT * FROM [dbo].[User] where TenUser =N'" + TK + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTaiKhoan() {

        String sql = "SELECT * FROM [dbo].[User]";
        return connection.Getdata(sql);
    }
}
