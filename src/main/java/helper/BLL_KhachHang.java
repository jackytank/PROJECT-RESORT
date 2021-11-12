/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_KhachHang;
import dao.DAO_ThuePhong;
import entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tamnt
 */
public class BLL_KhachHang {

    public static boolean KT_Them(KhachHang KH) {
        ResultSet rs = DAO_KhachHang.LayKH();
        try {
            while (rs.next()) {
                if (rs.getString("MaKhachHang").matches(KH.getMaKH())) {
                    ThongBao.thongbao("Mã khách hàng đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (KH.getMaKH().trim().equals("") || KH.getTenKH().trim().equals("") || KH.getTuoi().trim().equals("") || KH.getCMND().trim().equals("")) {
            ThongBao.thongbao("Không để trống thông tin", "thông báo");
            return false;
        }
        if (KH.getCMND().length() != 10) {
            ThongBao.thongbao("Nhập lại số CMND", "");
            return false;
        }
        return true;
    }

    public static void dodulieu(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[2];
        ResultSet rs = DAO_KhachHang.LayKH();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaKhachHang");
                obj[1] = rs.getString("TenKhachHang");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");
        }
    }

    public static void TimKiem(JTable tbl, String tukhoa) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[2];
        ResultSet rs = DAO_KhachHang.TimKiem(tukhoa);
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaKhachHang");
                obj[1] = rs.getString("TenKhachHang");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ table");
        }
    }

    public static boolean KT_Xoa(String MaKH) {
        ResultSet rs = DAO_ThuePhong.LayTatCa();
        try {
            while (rs.next()) {
                if (rs.getString("MaKhachHang").matches(MaKH)) {
                    ThongBao.thongbao("Khách hàng đã hoặc đang thuê phòng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean KT_Sua(KhachHang KH) {
        if (KH.getMaKH().trim().equals("") || KH.getTenKH().trim().equals("") || KH.getTuoi().trim().equals("") || KH.getCMND().trim().equals("")) {
            ThongBao.thongbao("Không để trống thông tin", "thông báo");
            return false;
        }
        return true;
    }
}
