package data;

import model.Device;
import model.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServiceDataIO {
    File file = new File("database/services.csv");

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
            System.out.println("Exception in ServiceDataIO writeData: ");
            System.out.println("Error " + e.getMessage());
        }
    }


    public List<Service> readData() {
        List<Service> services = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime starttime = LocalDateTime.parse(data[1], formatter);
                LocalDateTime endtime;
                if (!data[2].equals("null")) {
                    endtime = LocalDateTime.parse(data[2], formatter);
                } else {
                    endtime = null;
                }
                Service service = new Service(
                        Integer.parseInt(data[0]),
                        starttime,
                        endtime,
                        Float.parseFloat(data[3]),
                        Float.parseFloat(data[4])
                );

                services.add(service);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Exception in ServiceDataIO.readData: ");
            System.out.println("Error " + e.getMessage());
        }

        return services;
    }
}
