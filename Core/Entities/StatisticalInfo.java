/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Entities;

import java.io.Serializable;
import java.text.DecimalFormat;

public class StatisticalInfo implements Serializable{
    private String mountainCode;
    private int numOfStudent;
    private double totalCost;

    public StatisticalInfo(String mountainCode, int numOfStudent, double totalCost) {
        this.mountainCode = mountainCode;
        this.numOfStudent = numOfStudent;
        this.totalCost = totalCost;
    }

    public int getNumOfStudent() {
        return numOfStudent;
    }

    public void setNumOfStudent(int numOfStudent) {
        this.numOfStudent = numOfStudent;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    @Override
    public String toString() {
        String prefix = "";
        if (mountainCode.length() < 2) {
            prefix = "MT0";
        }
        else prefix = "MT";
        DecimalFormat df = new DecimalFormat("#,###");
        String formattedFee = df.format(getTotalCost());
        return String.format("%-12s | %-23s | %-18s", prefix + mountainCode, numOfStudent, formattedFee);
    }
}
