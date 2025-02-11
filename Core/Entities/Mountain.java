/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Entities;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Mountain implements Serializable{
    private String code;
    private String mountain;
    private String province;
    private String description;

    public Mountain(String code, String mountain, String province) {
        this.code = code;
        this.mountain = mountain;
        this.province = province;
    }

    public Mountain(String code, String mountain, String province, String description) {
        this.code = code;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getMountain() {
        return mountain;
    }
    
    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return String.format(code + mountain + province + description);
    }
}
