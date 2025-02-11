/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultilities;

/**
 *
 * @author nguye
 */
public interface Acceptable {
    public final String STUDENT_ID_VALID = "^[CcDdHhSsQq][Ee]\\d{6}$";
    public final String NAME_VALID = "^[A-Za-z]{2,20}$";
    public final String VNPT_PHONE_NUMBER = "^(081|082|083|084|085|088|091|094)\\d{7}$";
    public final String VIETTEL_PHONE_NUMBER = "^(086|096|097|098|039|038|037|036|035|034|033|032)\\d{7}$";
    public final String PHONE_VALID = "^(081|082|083|084|085|088|091|094|086|096|097|098|039|038|037|036|035|034|033|032|070|079|077|076|078|089|090|093|092|052|056|058|099|059|087)\\d{7}$"; 
    public final String EMAIL_VALID= "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$";
    public final String MOUNTAIN_CODE_VALID = "^(1[0-3]|[1-9])$";
    public final String CHOICE_VALID = "^[Yy]|[Nn]$";
    
    public static boolean checkStringWithFormat(String data, String pattern) {
        return data.matches(pattern); 
    }
    
    public static boolean checkDiscountPhoneNumbers(String phone) {
        return (phone.matches(VIETTEL_PHONE_NUMBER) || phone.matches(VNPT_PHONE_NUMBER));
    }
}
