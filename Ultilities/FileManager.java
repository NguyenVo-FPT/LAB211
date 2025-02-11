package Ultilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author SwordLake
 */
public class FileManager {

    private String fileName;

    public FileManager() {
    }

    //--------------------------------------------------        
    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    

    //--------------------------------------------------   
    public List<String> readDataFromFile() throws IOException {
        List<String> result;
        result = Files.readAllLines(new File(fileName).toPath());
        return result;
    }

    //--------------------------------------------------   
    public void saveDataToFile(String data) throws IOException {
        Files.write(new File(fileName).toPath(), data.getBytes());
    }
}
