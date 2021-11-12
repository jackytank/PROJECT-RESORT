/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_ThuePhong;
import dao.DAO_User;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tamnt
 */
public class BLL_User {

    public static boolean KT_Them(User u, String NhapLai) {
        ResultSet rs = DAO_User.LayTatCa();
        try {
            while (rs.next()) {
                if (rs.getString("TenUser").equals(u.getTenUser())) {
                    ThongBao.thongbao("Tên user đã được sử dụng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Loi");
        }
        if (u.getTenUser().length() < 5) {
            ThongBao.thongbao("Tên tài khoản lớn hơn 5 ký tự", "");
            return false;
        }
        if (u.getMK().length() < 5) {
            ThongBao.thongbao("Mật khẩu lớn hơn 5 ký tự", "");
            return false;
        }
        if (!u.getMK().matches(NhapLai)) {
            ThongBao.thongbao("Nhập lại mật khẩu sai", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Sua(User sua, String nhaplai) {
        if (sua.getMK().trim().equals("")) {
            ThongBao.thongbao("Nhập mật khẩu", "");
            return false;
        }
        if (!sua.getMK().equals(nhaplai)) {
            ThongBao.thongbao("Nhập lại mật khẩu sai", "");
            return false;
        }

        return true;
    }

    public static boolean KT_Xoa(String MaNV) {
        String tenUser = null;
        ResultSet rs = DAO_User.LayTKTheoMaNV(MaNV);
        try {
            if (rs.next()) {
                tenUser = rs.getString("TenUser");//lấy tên user từ mã nhân viên
            }
        } catch (SQLException ex) {

        }
        ResultSet rs2 = DAO_ThuePhong.LayTatCa();
        try {
            while (rs2.next()) {//kiểm tra tài khoản đã thực hiện đặt phòng 
                if (rs2.getString("TenUser").equals(tenUser)) {
                    ThongBao.thongbao("Tài khoản này đang có trong đặt phòng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }
        if (tenUser.equals(BLL_DangNhap.TenUser)) {
            ThongBao.thongbao("Tài khoản này đang nhập phần mềm", "");
            return false;
        }
        return true;
    }
}
