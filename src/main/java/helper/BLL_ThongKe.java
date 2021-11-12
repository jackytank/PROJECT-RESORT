/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import dao.DAO_NhanVien;
import dao.DAO_ThongKe;
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
public class BLL_ThongKe {
    public static void DoBang(JTable tbl, String date1, String date2) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[6];
        ResultSet rs = DAO_ThongKe.LayTheoKhoangTG(date1, date2);
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaHoaDon");
                obj[1] = ChuyenDoi.DinhDangSo((rs.getDouble("TienPhong")));
                obj[2] = ChuyenDoi.DinhDangSo(rs.getDouble("TienDichVu"));
                obj[3] = ChuyenDoi.DinhDangSo(rs.getDouble("ThanhTien"));
                obj[4] = ChuyenDoi.DinhDangSo(rs.getDouble("phuthu"));
                obj[5] = rs.getString("NgayThanhToan");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ bảng");
        }
    }

    public static void DoBangTatCa(JTable tbl) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[6];
        ResultSet rs = DAO_ThongKe.LayTatCa();
        try {
            while (rs.next()) {
                obj[0] = rs.getString("MaHoaDon");
                obj[1] = ChuyenDoi.DinhDangSo((rs.getDouble("TienPhong")));
                obj[2] = ChuyenDoi.DinhDangSo(rs.getDouble("TienDichVu"));
                obj[3] = ChuyenDoi.DinhDangSo(rs.getDouble("ThanhTien"));
                obj[4] = ChuyenDoi.DinhDangSo(rs.getDouble("phuthu"));
                obj[5] = rs.getString("NgayThanhToan");
                tblModel.addRow(obj);
            }
        } catch (SQLException ex) {
            System.out.println("lỗi đổ bảng");
        }

    }
//thống kê lương

    public static void DoBangLuong(JTable tbl,ResultSet rs) {
        DefaultTableModel tblModel = (DefaultTableModel) tbl.getModel();
        tblModel.setRowCount(0);
        Object obj[] = new Object[5];
//        ResultSet rs = DAO.DAO_ThongKe.LayTatCaLuong();
        try {
            while (rs.next()) {
                String MaNhanVien = rs.getString("MaNhanVien");
                ResultSet rsNV = DAO_NhanVien.LayNVTheoMa(MaNhanVien);
                if (rsNV.next()) {
                    obj[0] = rsNV.getString("TenNhanVien");
                }
                obj[1] = rs.getInt("SoNgayNghi");
                obj[2] = rs.getInt("SoNgayLam");
                obj[3] = ChuyenDoi.GetDate2(rs.getDate("NgayNhanLuong"));
                obj[4] = ChuyenDoi.DinhDangSo(rs.getDouble("TongNhan"));
                tblModel.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BLL_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
