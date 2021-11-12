/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import javax.swing.JOptionPane;

/**
 *
 * @author tamnt
 */
public class ThongBao {

    public static void thongbao(String noidung, String tieude) {
        JOptionPane.showMessageDialog(new JOptionPane(), noidung, tieude, JOptionPane.INFORMATION_MESSAGE);
    }
}
