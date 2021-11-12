/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.ThongBao;
import entity.KhachHang;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_KhachHang {

    public static ResultSet LayKH() {
        String sql = "SELECT * FROM [dbo].[KhachHang]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayKHMa(String MaKH) {
        String sql = "SELECT * FROM [dbo].[KhachHang] where MaKhachHang =N'" + MaKH + "'";
        return connection.Getdata(sql);
    }

    public static void Them(KhachHang KH) {
        String sql = "INSERT INTO [dbo].[KhachHang] "
                + "           ([MaKhachHang] "
                + "           ,[MaLoaiKH] "
                + "           ,[TenKhachHang] "
                + "           ,[Tuoi] "
                + "           ,[GioiTinh] "
                + "           ,[SoDienThoai] "
                + "           ,[SoCMND]) "
                + "     VALUES "
                + "           (N'" + KH.getMaKH() + "' "
                + "           ,N'" + KH.getMaLoaiKH() + "' "
                + "           ,N'" + KH.getTenKH() + "' "
                + "           ," + KH.getTuoi() + " "
                + "           ,'" + KH.isGioiTinh() + "' "
                + "           ,N'" + KH.getSDT() + "' "
                + "           ,N'" + KH.getCMND() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa(String MaKH) {
        String sql = "DELETE FROM [dbo].[KhachHang] WHERE MaKhachHang=N'" + MaKH + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(KhachHang KH) {
        String sql = "UPDATE [dbo].[KhachHang] "
                + "   SET [MaKhachHang] = N'" + KH.getMaKH() + "' "
                + "      ,[MaLoaiKH] =" + KH.getMaLoaiKH() + " "
                + "      ,[TenKhachHang] =N'" + KH.getTenKH() + "' "
                + "      ,[Tuoi] = " + KH.getTuoi() + " "
                + "      ,[GioiTinh] = '" + KH.isGioiTinh() + "' "
                + "      ,[SoDienThoai] = '" + KH.getSDT() + "' "
                + "      ,[SoCMND] = '" + KH.getCMND() + "' "
                + " WHERE MaKhachHang=N'" + KH.getMaKH() + "'";
        if (connection.ExecuteTruyVan(sql) > 0) {
            ThongBao.thongbao("Sửa thành công", "");
        } else {
            ThongBao.thongbao("Sửa không thành công", "");
        }
    }

    public static ResultSet TimKiem(String tukhoa) {
        String sql = "select *from KhachHang where TenKhachHang like N'%" + tukhoa + "%' or SoDienThoai like N'%" + tukhoa + "%' or SoCMND like N'%" + tukhoa + "%'";
        return connection.Getdata(sql);
    }
}
