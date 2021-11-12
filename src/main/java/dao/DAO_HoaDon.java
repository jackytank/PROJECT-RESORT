/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.HoaDon;

/**
 *
 * @author tamnt
 */
public class DAO_HoaDon {

    public static void ThemHD(HoaDon HD) {
        String sql = "set dateformat dmy "
                + "INSERT INTO [dbo].[HoaDon] "
                + "           ([MaDatPhong] "
                + "           ,[TenUser] "
                + "           ,[TenKhachHang] "
                + "           ,[MaPhong] "
                + "           ,[SoNgayThue] "
                + "           ,[SoGioThue] "
                + "           ,[TienPhong] "
                + "           ,[PhuThuCheckin] "
                + "           ,[PhuThuCheckout] "
                + "           ,[TienDichVu] "
                + "           ,[ThanhTien] "
                + "           ,[NgayThanhToan]) "
                + "     VALUES "
                + "           (" + HD.getMaDP() + " "
                + "           ,N'" + HD.getTenUser() + "' "
                + "           ,N'" + HD.getTenKH() + "' "
                + "           ,N'" + HD.getMaPhong() + "' "
                + "           ," + HD.getSoNgayThue() + " "
                + "           ," + HD.getSoGioThue() + " "
                + "           ," + HD.getTienPhong() + " "
                + "           ," + HD.getPhuThuCheckin() + " "
                + "           ," + HD.getPhuThuCheckout() + " "
                + "           ," + HD.getTienDV() + " "
                + "           ," + HD.getThanhTien() + " "
                + "           ,'" + HD.getNgayThanhToan() + "')";
        connection.ExecuteTruyVan(sql);
    }
}
