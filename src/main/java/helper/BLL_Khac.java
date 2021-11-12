/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import entity.Khac;

/**
 *
 * @author tamnt
 */
public class BLL_Khac {

    public static boolean KT_Sua(Khac a) {
        if (a.getMoc2() >= a.getMoc1()) {
            ThongBao.thongbao("Checkin 2 phải lớn hơn checkin 1", "");
            return false;
        }
        if (a.getMoc4() >= a.getMoc3()) {
            ThongBao.thongbao("Checkout 2 phải lớn hơn checkout 1", "");
            return false;
        }
        return true;
    }
}
