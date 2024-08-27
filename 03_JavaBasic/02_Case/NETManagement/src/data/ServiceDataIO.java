package data;

import model.Device;
import model.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ServiceDataIO {
    File file = new File("services.csv");

    public void writeData(List<Service> services) {
        try {
            // System.out.println("File: " + file.getAbsolutePath());
            String data = "";
            for (Service service: services){
                data += service.toCsvString() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
