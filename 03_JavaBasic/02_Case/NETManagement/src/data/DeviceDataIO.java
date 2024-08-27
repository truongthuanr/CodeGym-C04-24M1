package data;

import model.Device;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class DeviceDataIO {
    private File file = new File("database/Devices.csv");

    public void writeData(List<Device> devices) {
        try {
            // System.out.println("File: " + file.getAbsolutePath());
            String data = "";
            for (Device device: devices){
                data += device.toCsvString() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

    public List<Device> readData() {
        List<Device> devices = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Device device = new Device(Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                );

                devices.add(device);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }


        return devices;
    }


}
