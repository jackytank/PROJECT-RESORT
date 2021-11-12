/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import ui.NhanVienJDialog;
import helper.ThongBao;
import java.sql.ResultSet;

/**
 *
 * @author tamnt
 */
public class DAO_User {

    public static ResultSet LayTKTheoMaNV(String MaNV) {
        String sql = "SELECT * FROM [dbo].[User] where MaNhanVien =N'" + MaNV + "'";
        return connection.Getdata(sql);
    }

    public static ResultSet LayTatCa() {
        String sql = "SELECT * FROM [dbo].[User]";
        return connection.Getdata(sql);
    }

    public static void Them(User u) {
        String sql = "INSERT INTO [dbo].[User] "
                + "           ([TenUser] "
                + "           ,[MatKhau] "
                + " "
                + "           ,[MaQuyen] "
                + "  "
                + "           ,[MaNhanVien]) "
                + "     VALUES "
                + "           (N'" + u.getTenUser() + "' "
                + "           ,N'" + u.getMK() + "' "
                + "   "
                + "           ,N'" + u.getQuyen() + "' "
                + "   "
                + "           ,N'" + NhanVienJDialog.MaNV + "')";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thêm thành công", "");
        } else {
            ThongBao.thongbao("Thêm  không thành công", "");
        }
    }

    public static void Xoa() {
        String sql = "DELETE FROM [dbo].[User] WHERE MaNhanVien=N'" + NhanVienJDialog.MaNV + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Xóa thành công", "");
        } else {
            ThongBao.thongbao("Xóa không thành công", "");
        }
    }

    public static void Sua(User sua) {
        String sql = "UPDATE [dbo].[User]   SET       [MatKhau] = N'" + sua.getMK() + "',[MaQuyen] = N'" + sua.getQuyen()+ "'         WHERE TenUser=N'" + sua.getTenUser() + "'";
        if (connection.ExecuteTruyVan(sql) > 0) {
            ThongBao.thongbao("Sủa thành công", "");
        } else {
            ThongBao.thongbao("Sửa không thành công", "");
        }
    }

    public static void SuaMK(String MK, String TenUser) {
        String sql = "UPDATE [dbo].[User] SET  "
                + "[MatKhau] =N'" + MK + "' "
                + " "
                + " WHERE TenUser=N'" + TenUser + "'";
        int kq = connection.ExecuteTruyVan(sql);
        if (kq > 0) {
            ThongBao.thongbao("Thành công", "");

        } else {
            ThongBao.thongbao("Thất bại", "");
        }

    }
}
