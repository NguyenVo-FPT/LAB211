/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.Interface;

import java.util.List;
import Core.Entities.Registration;

/**
 *
 * @author nguye
 */
public interface IRegistrationDAO {
    public List<Registration> getRegistrationList() throws Exception;
    public Registration getRegistrationById(String id) throws Exception;
    void saveRegistrationListToFile() throws Exception ;
    public void addRegistration(Registration newRegistration) throws Exception;
    public void updateRegistrationInfo(Registration existedRegistration) throws Exception;
    public void deleteRegistration(Registration existedRegistration) throws Exception;
    public List<Registration> getStudentByName(String name) throws Exception;
    public List<Registration> getStudentByCampusId(String campusId) throws Exception;
}
