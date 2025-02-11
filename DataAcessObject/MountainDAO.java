/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Core.Entities.Mountain;
import Core.Interface.IMountainDAO;
import Ultilities.FileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nguye
 */
public class MountainDAO implements IMountainDAO {

    private List<Mountain> list = new ArrayList<>();
    private FileManager fileManager;

    public MountainDAO() throws Exception {
        this.fileManager = new FileManager("MountainList.csv");
        readDataFromFile();
    }

    
    
    @Override
    public List<Mountain> getMountains() throws Exception{
        return list;
    }

    @Override
    public void readDataFromFile() throws Exception{
        String code, name, province, des =  null;
        List<String> mountains = fileManager.readDataFromFile();
        list.clear();
        for (String m : mountains) {
            List<String> l = Arrays.asList(m.split(","));
            code = l.get(0).trim();
            name = l.get(1).trim();
            province = l.get(2).trim();
            if (!l.get(3).isEmpty()) {
                des = l.get(3).trim();
            }

            Mountain mountain = new Mountain(code, name, province, des);
            list.add(mountain);
            if (list.isEmpty()) {
                throw new Exception("Employee list is empty.");
            }
        }
    }

@Override
    public Mountain getMountainByCode(String code) {
        Mountain mountain = null;
        for(Mountain m : list) {
            if (m.getCode().equalsIgnoreCase(code)){
                mountain = m;
            }
        }
        return mountain;
    }

}
