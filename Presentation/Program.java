/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BusinessObject.RegistrationManager;
import Core.Interface.IMountainDAO;
import Core.Interface.IRegistrationDAO;
import DataAcessObject.MountainDAO;
import DataAcessObject.RegistrationDAO;

/**
 *
 * @author nguye
 */
public class Program {

    public static void main(String[] args) throws Exception {

        IRegistrationDAO registrationDAO = new RegistrationDAO();
        IMountainDAO mountainDAO = new MountainDAO();
        RegistrationManager registrationManager = new RegistrationManager(registrationDAO, mountainDAO);
        String choice;
        try {
            do {
                Menu.printMenu();
                choice = Menu.getUserChoice();
                switch (choice) {
                    case "1": {
                        registrationManager.addNewRegistration();
                        Menu.pause();
                        break;
                    }
                    case "2": {
                        registrationManager.updateRegistration();
                        Menu.pause();
                        break;
                    }
                    case "3": {
                        registrationManager.displayRegistrationList();
                        Menu.pause();
                        break;
                    }
                    case "4": {
                        registrationManager.deleteStudentById();
                        Menu.pause();
                        break;
                    }
                    case "5": {
                        registrationManager.searchStudentsByName();
                        Menu.pause();
                        break;
                    }
                    case "6": {
                        registrationManager.filterDataByCampus();
                        Menu.pause();
                        break;
                    }
                    case "7": {
                        registrationManager.displayStatistics();
                        Menu.pause();
                        break;
                    }
                    case "8": {
                        registrationManager.saveRegistrationsToFile();
                        Menu.pause();
                        break;
                    }
                    case "9": {
                        Menu.exitProgram();
                        break;
                    }
                    default: {
                        System.out.println("This function is not available.");
                        break;
                    }
                }
            } while (true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
