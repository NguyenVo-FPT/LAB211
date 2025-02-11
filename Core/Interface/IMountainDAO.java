/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Interface;

import Core.Entities.Mountain;
import java.util.List;


/**
 *
 * @author nguye
 */
public interface IMountainDAO {
    public List<Mountain> getMountains() throws Exception;
    public void readDataFromFile() throws Exception;
    public Mountain getMountainByCode(String code);
}
