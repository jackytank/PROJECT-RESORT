/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import entity.CTDV;

/**
 *
 * @author tamnt
 */
public class BLL_CTDV {

    public static boolean KT_Them(CTDV ctdv) {
        if (ctdv.getMaDV().trim().equals("")) {
            ThongBao.thongbao("Chưa chọn dịch vụ", "");
            return false;
        }
        return true;
    }
}
