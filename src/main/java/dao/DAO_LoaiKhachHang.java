/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.LoaiKhachHang;
import helper.ThongBao;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_LoaiKhachHang {

    public static ResultSet LayLoaiKH() {
        String sql = "SELECT * FROM [dbo].[LoaiKhachHang]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTHeoMa(String MaLoai) {
        String sql = "SELECT * FROM [dbo].[LoaiKhachHang] where MaLoaiKH=N'" + MaLoai + "'";
        return connection.Getdata(sql);
    }

    public static void Them(LoaiKhachHang Loai) {
        String sql = "INSERT INTO [dbo].[LoaiKhachHang] "
                + "           ([MaLoaiKH] "
                + "           ,[TenLoaiKH] "
                + "           ,[TienGiam] "
                + "           ,[MoTa]) "
                + "     VALUES "
                + "           (N'" + Loai.getMaLoaiKH() + "' "
                + "           ,N'" + Loai.getTenLoaiKH() + "' "
                + "           ," + Loai.getTienGiam() + " "
                + "           ,N'" + Loai.getMoTa() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Sua(LoaiKhachHang Loai) {
        String sql = "UPDATE [dbo].[LoaiKhachHang] "
                + "   SET [MaLoaiKH] = N'" + Loai.getMaLoaiKH() + "' "
                + "      ,[TenLoaiKH] = N'" + Loai.getTenLoaiKH() + "' "
                + "      ,[TienGiam] = " + Loai.getTienGiam() + " "
                + "      ,[MoTa] = N'" + Loai.getMoTa() + "' "
                + " WHERE MaLoaiKH=N'" + Loai.getMaLoaiKH() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Sửa thành công", "");
        } else {
            ThongBao.thongbao("Sửa  không thành công", "");
        }
    }

    public static void Xoa(String MaLoaiKH) {
        String sql = "DELETE FROM [dbo].[LoaiKhachHang] WHERE MaLoaiKH =N'" + MaLoaiKH + "'";
        connection.ExecuteTruyVan(sql);
    }
}
