/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CTDV;
import helper.ThongBao;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_CTDV {

    public static ResultSet LayCTDV(String MaDP) {
        String sql = "SELECT * FROM [dbo].[ChiTietDichVu] where MaDatPhong =" + MaDP + "";
        return connection.Getdata(sql);
    }

    public static void Them(CTDV ctdv) {
        String sql = "INSERT INTO [dbo].[ChiTietDichVu] "
                + "           ([MaDatPhong] "
                + "           ,[MaDichVu] "
                + "           ,[DonGia] "
                + "           ,[SoLuong] "
                + "           ,[ThanhTien]) "
                + "     VALUES "
                + "           (" + ctdv.getMaDP() + " "
                + "           ,N'" + ctdv.getMaDV() + "' "
                + "           ," + ctdv.getDonGia() + " "
                + "           ," + ctdv.getSoLuong() + " "
                + "           ," + ctdv.getThanhTien() + ")";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
//            thongbao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa(String MaCTDV) {
        String sql = "DELETE FROM [dbo].[ChiTietDichVu] WHERE MaCTDV=" + MaCTDV + "";
        connection.ExecuteTruyVan(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = "SELECT * FROM [dbo].[ChiTietDichVu]";
        return connection.Getdata(sql);
    }
}
