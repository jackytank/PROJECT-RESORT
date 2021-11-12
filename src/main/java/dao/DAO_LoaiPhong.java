/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Phong;
import helper.ChuyenDoi;
import helper.ThongBao;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_LoaiPhong {

    public static ResultSet LayLoaiTheoMa(String MaLoai) {
        String sql = "SELECT * FROM [dbo].[LoaiPhong] where MaLoaiPhong =N'" + MaLoai + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = "SELECT * FROM [dbo].[LoaiPhong]";
        return connection.Getdata(sql);
    }

    public static void Them(Phong LP) {
        String sql = "INSERT INTO [dbo].[LoaiPhong] "
                + "           ([MaLoaiPhong] "
                + "           ,[TenLoaiPhong] "
                + "           ,[GiaTheoGio] "
                + "           ,[GiaTheoNgay]) "
                + "     VALUES "
                + "           (N'" + LP.getMaLoaiPhong() + "' "
                + "           ,N'" + LP.getTenLoaiPhong() + "' "
                + "           ,N'" + ChuyenDoi.ChuyenSangSo(LP.getGiaTheoGio()) + "' "
                + "           ,N'" + ChuyenDoi.ChuyenSangSo(LP.getGiaTheoNgay()) + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa(String MaLoaiPhong) {
        String sql = "DELETE FROM [dbo].[LoaiPhong] WHERE MaLoaiPhong=N'" + MaLoaiPhong + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(Phong LP) {
        String sql = "UPDATE [dbo].[LoaiPhong] "
                + "   SET [MaLoaiPhong] = N'" + LP.getMaLoaiPhong() + "' "
                + "      ,[TenLoaiPhong] = N'" + LP.getTenLoaiPhong() + "' "
                + "      ,[GiaTheoGio] = " + ChuyenDoi.ChuyenSangSo(LP.getGiaTheoGio()) + " "
                + "      ,[GiaTheoNgay] = " + ChuyenDoi.ChuyenSangSo(LP.getGiaTheoNgay()) + " "
                + " WHERE MaLoaiPhong =N'" + LP.getMaLoaiPhong() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Sửa thành công", "");
        } else {
            ThongBao.thongbao("Sửa  không thành công", "");
        }
    }
}
