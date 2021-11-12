/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Luong;
import helper.ChuyenDoi;
import helper.ThongBao;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_Luong {

    public static ResultSet LayLuong() {
        String sql = "SELECT * FROM [dbo].[Luong]";
        return connection.Getdata(sql);
    }

    public static ResultSet LayLuongTheoMa(String maluong) {
        String sql = "SELECT  * FROM [dbo].[Luong] where MaLuong=N'" + maluong + "'";
        return connection.Getdata(sql);
    }

    public static void Them(Luong L) {
        String sql = "INSERT INTO [dbo].[Luong] "
                + "           ([MaLuong] "
                + "           ,[LuongTheoGio] "
                + "           ,[SoGioLam] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + L.getMaluong() + "' "
                + "           ," + ChuyenDoi.ChuyenSangSo(L.getLuonggio()) + " "
                + "           ," + L.getSogiolam() + " "
                + "           ,N'" + L.getGhichu() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Sua(Luong L) {
        String sql = "UPDATE [dbo].[Luong] "
                + "   SET [MaLuong] = N'" + L.getMaluong() + "' "
                + "      ,[LuongTheoGio] = " + ChuyenDoi.ChuyenSangSo(L.getLuonggio()) + " "
                + "      ,[SoGioLam] = " + L.getSogiolam() + " "
                + "      ,[GhiChu] = N'" + L.getGhichu() + "' "
                + " WHERE MaLuong=N'" + L.getMaluong() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Sửa thành công", "");
        } else {
            ThongBao.thongbao("Sửa không thành công", "");
        }
    }

    public static void Xoa(String maluong) {
        String sql = "DELETE FROM [dbo].[Luong] WHERE MaLuong=N'" + maluong + "'";
        connection.ExecuteTruyVan(sql);
    }
}
