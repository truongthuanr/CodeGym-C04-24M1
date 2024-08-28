package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class ServiceConfigIO {

    public HashMap<String, Float> servicePrice;
    public ServiceConfigIO() {
        this.servicePrice = new HashMap<String, Float>();

        File file = new File("database/service_config.csv");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                this.servicePrice.put(data[0], Float.parseFloat(data[1]));
            }
            br.close();
        } catch (Exception e){
            System.out.println("Exception in ServiceConfigIO:");
            System.out.println(e.getMessage());
        }
    }
}
