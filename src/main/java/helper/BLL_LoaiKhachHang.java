/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_KhachHang;
import dao.DAO_LoaiKhachHang;
import entity.LoaiKhachHang;
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
public class BLL_LoaiKhachHang {

    public static void DoDuLieuBang(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO_LoaiKhachHang.LayLoaiKH();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaLoaiKH");
                obj[1] = rs.getString("TenLoaiKH");
                obj[2] = rs.getInt("TienGiam");
                obj[3] = rs.getString("MoTa");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static boolean KT_Them(LoaiKhachHang Loai) {
        System.out.println(Loai.getTienGiam());
        ResultSet rs = DAO_LoaiKhachHang.LayLoaiKH();
        try {
            while (rs.next()) {
                if (rs.getString("MaLoaiKH").matches(Loai.getMaLoaiKH())) {
                    ThongBao.thongbao("Mã loại đã dùng", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Loai.getMaLoaiKH().trim().equals("") || Loai.getTenLoaiKH().trim().equals("")) {
            ThongBao.thongbao("Không để trống thông tin", "");
            return false;
        }
        if (Loai.getTienGiam() > 100) {
            ThongBao.thongbao("Tiền giảm sai", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Sua(LoaiKhachHang Loai) {
        if (Loai.getMaLoaiKH().trim().equals("") || Loai.getTenLoaiKH().trim().equals("")) {
            ThongBao.thongbao("Không để trống thông tin", "");
            return false;
        }
        if (Loai.getTienGiam() > 100) {
            ThongBao.thongbao("Tiền giảm sai", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Xoa(String MaLoaiKH) {
        ResultSet rs = DAO_KhachHang.LayKH();
        try {
            while (rs.next()) {
                if (rs.getString("MaLoaiKH").matches(MaLoaiKH)) {
                    ThongBao.thongbao("Có khách hàng đang có mã loại này", "");
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_LoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
