/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.ChuyenDoi;
import helper.ThongBao;
import entity.DichVu;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_CungCapDichVu {

    public static ResultSet LayDV() {
        String sql = "SELECT * FROM [dbo].[DichVu]";
        return connection.Getdata(sql);
    }

    public static void Them(DichVu dv) {
        String sql = "INSERT INTO [dbo].[DichVu] "
                + "           ([MaDichVu] "
                + "           ,[TenDichVu] "
                + "           ,[DonVi] "
                + "           ,[DonGia] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (N'" + dv.getMaDV() + "' "
                + "           ,N'" + dv.getTenDV() + "' "
                + "           ,N'" + dv.getDonVi() + "' "
                + "           ," + ChuyenDoi.ChuyenSangSo(dv.getDonGia()) + " "
                + "           ,N'" + dv.getGhiChu() + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static ResultSet LayDVTheoMa(String MaDV) {
        String sql = "SELECT * FROM [dbo].[DichVu] where MaDichVu=N'" + MaDV + "'";
        return connection.Getdata(sql);
    }

    public static void Xoa(String MaDV) {
        String sql = "DELETE FROM [dbo].[DichVu] WHERE MaDichVu=N'" + MaDV + "'";
        connection.ExecuteTruyVan(sql);
    }

    public static void Sua(DichVu dv) {
        String sql = "UPDATE [dbo].[DichVu] "
                + "   SET [MaDichVu] = N'" + dv.getMaDV() + "' "
                + "      ,[TenDichVu] = N'" + dv.getTenDV() + "' "
                + "      ,[DonVi] = N'" + dv.getDonVi() + "' "
                + "      ,[DonGia] = " + ChuyenDoi.ChuyenSangSo(dv.getDonGia()) + " "
                + "      ,[GhiChu] = N'" + dv.getGhiChu() + "' "
                + " WHERE MaDichVu =N'" + dv.getMaDV() + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("SỬa thành công", "");
        } else {
            ThongBao.thongbao("Sửa  không thành công", "");
        }
    }

    public static ResultSet TimKiem(String tukhoa) {
        String sql = "SELECT * FROM [dbo].[DichVu] where TenDichVu like N'%" + tukhoa + "%'";
        return connection.Getdata(sql);
    }
}
