/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_DangNhap;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tamnt
 */
public class BLL_DangNhap {

    public static String TenUser, MatKhau, quyen;

    public static boolean KT_DangNhap(String TK, String MK) {
        if (TK.trim().equals("") || MK.trim().equals("")) {
            ThongBao.thongbao("Không bỏ trống dữ liệu", "Thông báo");
            return false;
        }
        ResultSet rs = DAO_DangNhap.LayTaiKhoanTheoMa(TK);
        try {
            if (rs.next()) {
                if (rs.getString("TenUser").matches(TK)) {
                    if (rs.getString("MatKhau").matches(MK)) {
                        System.out.println("Đăng nhập thành công");
                        TenUser = rs.getString("TenUser");
                        quyen = rs.getString("MaQuyen");
                        MatKhau = rs.getString("MatKhau");
                        return true;
                    }
                    ThongBao.thongbao("Tài khoản hoặc mật khẩu sai", "Thông báo");
                    return false;

                }
                ThongBao.thongbao("Tài khoản hoặc mật khẩu sai", "Thông báo");
                return false;

            }
        } catch (SQLException ex) {

        }
        ThongBao.thongbao("Tài khoản hoặc mật khẩu sai", "Thông báo");
        return false;
    }

    public static boolean KT_DoiMK(String mkcu, String mkmoi, String nhaplai) {
        if (!mkcu.equals(MatKhau)) {
            ThongBao.thongbao("Mật khẩu cũ sai", "");
            return false;
        }
        if (mkmoi.length() < 5) {
            ThongBao.thongbao("mật khẩu dài hơn 5 ký tự", "");
            return false;
        }
        if (!mkmoi.equals(nhaplai)) {
            ThongBao.thongbao("Nhập lại mật khẩu", "");
            return false;
        }
        return true;
    }
}
