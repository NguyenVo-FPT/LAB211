/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessObject;

import Core.Entities.Mountain;
import Core.Entities.Registration;
import Ultilities.Acceptable;
import Core.Interface.IMountainDAO;
import Core.Interface.IRegistrationDAO;
import DataAcessObject.Statistics;
import Ultilities.DataInput;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author nguye
 */
public class RegistrationManager implements Acceptable{

    private IRegistrationDAO registrationDAO;

    private IMountainDAO mountainDAO;
    private Statistics statistics = new Statistics();

    public RegistrationManager(IRegistrationDAO registrationDAO, IMountainDAO mountainDAO) {
        this.registrationDAO = registrationDAO;
        this.mountainDAO = mountainDAO;
    }

    public void printList(List<Registration> list) {
        System.out.println("------------------------------------------------------------------------- ");
        System.out.printf("%-12s | %-20s | %-12s | %-8s | %-12s%n", "Student ID", "Name", "Phone", "Moutain", "Fee");
        System.out.println("------------------------------------------------------------------------- ");
        for(Registration r : list) {
            r.displayInfo();
        }
        System.out.println("------------------------------------------------------------------------- ");
    }

    private Registration inputRegistration() throws Exception {
        String studentId = DataInput.getString("Enter Sttudent ID: ", STUDENT_ID_VALID);
        if (registrationDAO.getRegistrationById(studentId) != null) {
            return null;
        }
        String name = DataInput.getString("Enter Name: ", NAME_VALID);
        String phone = DataInput.getString("Enter Phone: ", PHONE_VALID);
        String email = DataInput.getString("Enter Email: ", EMAIL_VALID);
        String mountainCode = DataInput.getString("Enter Moutain Code:", MOUNTAIN_CODE_VALID);
        Mountain mountain = mountainDAO.getMountainByCode(mountainCode);
        return new Registration(studentId, name, phone, email, mountain);
    }

    public void setNewRegistrationInfo(Registration registration) throws Exception {
        String name = DataInput.getStringWithEnter("Enter new name: ", NAME_VALID);
        if (!name.isEmpty()) {
            registration.setName(name);
        }

        String phone = DataInput.getStringWithEnter("Enter new phone numbers: ", PHONE_VALID);
        if (!phone.isEmpty()) {
            registration.setPhone(phone);
        }

        String email = DataInput.getStringWithEnter("Enter new email: ", EMAIL_VALID);
        if (!email.isEmpty()) {
            registration.setEmail(email);
        }

        String mountainCode = DataInput.getStringWithEnter("Enter new moutain code: ", MOUNTAIN_CODE_VALID);
        if (!mountainCode.equals("")) {
            registration.setMountain(mountainDAO.getMountainByCode(mountainCode));
        }
    }

    public void addNewRegistration() throws Exception {
        try {
            Registration registration = inputRegistration();
            if (registration == null) {
                System.out.println("This student has already registered!");
                return;
            }
            registrationDAO.addRegistration(registration);
            System.out.println("Register Successfully!");
        } catch (Exception e) {
            System.out.println(">>Error:" + e.getMessage());
        }
    }

    public void updateRegistration() throws Exception {
        String studentId = DataInput.getString("Enter Student ID: ", STUDENT_ID_VALID);
        Registration registration = registrationDAO.getRegistrationById(studentId);
        if (registration == null) {
            System.out.println("This student has not registered yet.");
            return;
        }
        setNewRegistrationInfo(registration);
        System.out.println("The registration info has updated successfully.");
        registrationDAO.updateRegistrationInfo(registration);
    }

    public void displayRegistrationList() throws Exception {
        List<Registration> registrations = registrationDAO.getRegistrationList();
        if (registrations.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }
        printList(registrations);
    }

    public void deleteStudentById() throws Exception {
        String studentId = DataInput.getString("Enter Student ID: ", STUDENT_ID_VALID);
        if (registrationDAO.getRegistrationById(studentId) != null) {
            Registration r = registrationDAO.getRegistrationById(studentId);
            DecimalFormat df = new DecimalFormat("#,###");
            String formattedFee = df.format(r.getTutionFee());
            System.out.println("Student Details:");
            System.out.println("--------------------------------------------------");
            System.out.printf("Student ID: %-10s%n", r.getStudentId());
            System.out.printf("Name      : %-10s%n", r.getName());
            System.out.printf("Phone     : %-10s%n", r.getPhone());
            System.out.printf("Mountain  : %-10s%n", r.getMountain().getCode());
            System.out.printf("Fee       : %-10s%n", formattedFee);
            System.out.println("--------------------------------------------------");
            String choice = DataInput.getString("Are you sure you want to delete this registration? (Y/N): ", Acceptable.CHOICE_VALID);
            if (choice.equalsIgnoreCase("Y")) {
                registrationDAO.deleteRegistration(registrationDAO.getRegistrationById(studentId));
            }
        } else {
            System.out.println("This student has not registered yet.");
        }
    }

    public void searchStudentsByName() throws Exception {
        String name = DataInput.getString("Enter Name: ", NAME_VALID);
        if (registrationDAO.getStudentByName(name).isEmpty()) {
            System.out.println("No one matches the search criteria!");
            return;
        }

        printList(registrationDAO.getStudentByName(name));
    }

    public void filterDataByCampus() throws Exception {
        String campusId = DataInput.getString("Input: ");
        if (registrationDAO.getStudentByCampusId(campusId).isEmpty()) {
            System.out.println("No students have registered under this campus.");
            return;
        }

        String campus = "";
        switch (campusId) {
            case "CE": {
                campus = "Can Tho Campus (CE)";
                break;
            }
            case "HE": {
                campus = "Ha Noi Campus (HE)";
                break;
            }
            case "DE": {
                campus = "Da Nang Campus (DE)";
                break;
            }
            case "SE": {
                campus = "Ho Chi Minh Campus (SE)";
                break;
            }
            case "QE": {
                campus = "Quy Nhon Campus (QE)";
                break;
            }
        }
        System.out.println("Registered Students Under " + campus);
        printList(registrationDAO.getStudentByCampusId(campusId));
    }

    public void displayStatistics() throws Exception {
        Statistics stats = new Statistics(registrationDAO.getRegistrationList());
        stats.show();
    }

    public void saveRegistrationsToFile() throws IOException, Exception {
        registrationDAO.saveRegistrationListToFile();;
    }
}
