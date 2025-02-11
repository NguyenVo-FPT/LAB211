/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Entities;

import Ultilities.Acceptable;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author nguye
 */
public class Registration implements Serializable {

    private String studentId;
    private String name;
    private String phone;
    private String email;
    private Mountain mountain;
    private double tutionFee;

    public Registration() {
    }

    public Registration(String studentId, String name, String phone, String email, Mountain mountain) {
        this.studentId = studentId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountain = mountain;
        this.tutionFee = 6000000.0;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) throws Exception {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws Exception {

        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {


        this.email = email;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) throws Exception {

        this.mountain = mountain;
    }

    public double getTutionFee() {
        if (Acceptable.checkDiscountPhoneNumbers(phone)) {
            return tutionFee - tutionFee * 0.35;
        }

        return tutionFee;
    }

    public void displayInfo() {
        String prefix = "";
        if (mountain.getCode().length() < 2) {
            prefix = "MT0";
        } else {
            prefix = "MT";
        }
        DecimalFormat df = new DecimalFormat("#,###");
        String formattedFee = df.format(getTutionFee());

        System.out.printf("%-12s | %-20s | %-12s | %-8s | %-12s%n",
                studentId, name, phone, prefix + mountain.getCode(), formattedFee);
    }
    
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", studentId, name, phone, email, mountain.getCode());
    }

}
