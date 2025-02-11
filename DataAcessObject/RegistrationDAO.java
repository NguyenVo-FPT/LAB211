/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAcessObject;

import Core.Entities.Mountain;
import Core.Entities.Registration;
import Core.Interface.IRegistrationDAO;
import Ultilities.FileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author nguye
 */
public class RegistrationDAO implements IRegistrationDAO {

    private final List<Registration> registrationList = new ArrayList<>();
    private final FileManager fileManager;
    private final MountainDAO mountainDAO = new MountainDAO();

    public RegistrationDAO() throws Exception {
        this.fileManager = new FileManager("registration.dat");
        loadDataFromFile();
    }

    @Override
    public List<Registration> getRegistrationList() throws Exception {
        return registrationList;
    }

    @Override
    public void addRegistration(Registration newRegistration) throws Exception {
        registrationList.add(newRegistration);
        saveRegistrationListToFile();
    }

    @Override
    public void updateRegistrationInfo(Registration registration) throws Exception {
        Registration registrationUpdate = getRegistrationById(registration.getStudentId());
        if (registrationUpdate != null) {
            registrationUpdate.setStudentId(registration.getStudentId());
            registrationUpdate.setName(registration.getName());
            registrationUpdate.setPhone(registration.getPhone());
            registrationUpdate.setMountain(registration.getMountain());
            saveRegistrationListToFile();
        }
    }

    @Override
    public void deleteRegistration(Registration existedRegistration) throws Exception {
        Registration deletedRegistration = getRegistrationById(existedRegistration.getStudentId());
        if (deletedRegistration != null) {
            registrationList.remove(deletedRegistration);
            saveRegistrationListToFile();
            System.out.println("Deleted registraion sucessfully!");
        } else {
            System.out.println("This student has not registered yet.");
        }
    }

    @Override
    public List<Registration> getStudentByName(String name) throws Exception {
        List<Registration> list = new ArrayList<>();
        for (Registration r : registrationList) {
            String[] fullName = r.getName().split(" ");
            if (fullName[fullName.length - 1].equalsIgnoreCase(name)) {
                list.add(r);
            }
        }
        return list;
    }

    @Override
    public List<Registration> getStudentByCampusId(String campusId) throws Exception {
        List<Registration> list = new ArrayList<>();
        for (Registration r : registrationList) {
            if (r.getStudentId().substring(0, 2).equalsIgnoreCase(campusId)) {
                list.add(r);
            }
        }
        return list;
    }

    @Override
    public Registration getRegistrationById(String id) throws Exception {
        Registration registrationNeedFind = null;
        for (Registration registration : registrationList) {
            if (registration.getStudentId().equalsIgnoreCase(id)) {
                registrationNeedFind = registration;
            }
        }
        return registrationNeedFind;
    }

    @Override
    public void saveRegistrationListToFile() throws Exception {
        List<String> stringObjects = registrationList.stream().map(String::valueOf).collect(Collectors.toList());
        String data = String.join("\n", stringObjects);
        fileManager.saveDataToFile(data);
        System.out.println("Registration data has been successfully saved to " + fileManager.getFileName());
    }

    private void loadDataFromFile() throws Exception {
        String id, name, phone, email;
        Mountain mountain;
        List<String> regData = fileManager.readDataFromFile();
        registrationList.clear();
        for (String e : regData) {
            List<String> reg = Arrays.asList(e.split(","));
            id = reg.get(0).trim();
            name = reg.get(1).trim();
            phone = reg.get(2).trim();
            email = reg.get(3).trim();
            mountain = mountainDAO.getMountainByCode(reg.get(4).trim());
            Registration newReg = new Registration(id, name, phone, email, mountain);
            registrationList.add(newReg);
            if (registrationList.isEmpty()) {
                throw new Exception("Employee list is empty.");
            }
        }
    }
}
