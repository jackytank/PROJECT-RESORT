/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanLuong;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_NhanLuong {

    public static void Them(NhanLuong nl) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[ChiTietLuong] "
                + "           ([MaChiTietLuong] "
                + "           ,[MaNhanVien] "
                + "           ,[SoNgayNghi] "
                + "           ,[SoNgayLam] "
                + "           ,[NgayNhanLuong] "
                + "           ,[TongNhan]) "
                + "     VALUES "
                + "           (N'" + nl.getMaChiTietLuong() + "' "
                + "           ,N'" + nl.getMaNhanVien() + "' "
                + "           ," + nl.getSoNgayNghi() + " "
                + "           ," + nl.getSoNgayLam() + " "
                + "           ,'" + nl.getNgayNhanLuong() + "' "
                + "           ," + nl.getTongNhan() + ")";
        connection.ExecuteTruyVan(sql);
    }

    public static void CapNhatNgayLam(NhanLuong nl, String ngayhientai) {
        String sql = " set dateformat dmy "
                + "UPDATE [dbo].[NhanVien] "
                + "SET [NgayBatDauLam] ='" + ngayhientai + "' "
                + "where MaNhanVien=N'" + nl.getMaNhanVien() + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static ResultSet Lay() {
        String sql = "SELECT * FROM [dbo].[ChiTietLuong]";
        return connection.Getdata(sql);
    }
}
