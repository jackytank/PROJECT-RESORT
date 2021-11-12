/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_LoaiPhong;
import dao.DAO_Phong;
import entity.Phong;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tamnt
 */
public class BLL_LoaiPhong {

    public static void DoDuLieuBang(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[4];
        ResultSet rs = DAO_LoaiPhong.LayTatCa();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaLoaiPhong");
                obj[1] = rs.getString("TenLoaiPhong");
                obj[2] = rs.getDouble("GiaTheoGio");
                obj[3] = rs.getDouble("GiaTheoNgay");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static boolean KT_Them(Phong LP) {
        String kt2 = "[0-9]{1,99}[.][0-9]{1,99}";
        ResultSet rs = DAO_LoaiPhong.LayTatCa();
        try {
            while (rs.next()) {
                if (rs.getString("MaLoaiPhong").matches(LP.getMaLoaiPhong())) {
                    ThongBao.thongbao("Mã phòng đã có", "");
                    return false;
                }
            }
        } catch (SQLException ex) {

        }

        if (LP.getMaLoaiPhong().trim().equals("") || LP.getTenLoaiPhong().trim().equals("") || LP.getGiaTheoGio().trim().equals("") || LP.getGiaTheoNgay().trim().equals("")) {
            ThongBao.thongbao("Không bỏ trống dữ liệu", "");
            return false;
        }
        if (LP.getGiaTheoGio().equals(kt2) || LP.getGiaTheoNgay().equals(kt2)) {
            ThongBao.thongbao("Nhập số vào giá", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Sua(Phong LP) {
        String kt2 = "[0-9]{1,99}[.][0-9]{1,99}";
        if (LP.getMaLoaiPhong().trim().equals("") || LP.getTenLoaiPhong().trim().equals("") || LP.getGiaTheoGio().trim().equals("") || LP.getGiaTheoNgay().trim().equals("")) {
            ThongBao.thongbao("Không bỏ trống dữ liệu", "");
            return false;
        }
        if (LP.getGiaTheoGio().equals(kt2) || LP.getGiaTheoNgay().equals(kt2)) {
            ThongBao.thongbao("Nhập số vào giá", "");
            return false;
        }
        return true;
    }

    public static boolean KT_Xoa(String MaLP) {
        ResultSet rs = DAO_Phong.LayPhong(0);
        try {
            while (rs.next()) {
                if (rs.getString("MaLoaiPhong").equals(MaLP)) {
                    ThongBao.thongbao("Loại phòng này có phòng đang sử dụng", "");
                    return false;
                }

            }
        } catch (SQLException ex) {

        }
        return true;
    }
}
