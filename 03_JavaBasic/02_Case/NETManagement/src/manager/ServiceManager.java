package manager;
import model.Service;
import data.ServiceDataIO;
import data.ServiceConfigIO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ServiceManager implements IManager<Service>{
    List<Service> services;
    private int transactionid;
    ServiceDataIO serviceDataIO = new ServiceDataIO();
    ServiceConfigIO serviceConfigIO = new ServiceConfigIO();



    public ServiceManager() {
        this.services = serviceDataIO.readData();
    }



    @Override
    public void add(Service service) {
        services.add(service);
        System.out.println("Service added");
        serviceDataIO.writeData(services);
    }
    @Override
    public void update(int id, Service service){

    }

    @Override
    public void delete(int id){
        int index = this.findIndexByID(id);
        if(index != -1) {
            this.services.remove(index);
            serviceDataIO.writeData(this.services);
        } else {
            System.out.println("From Service Manager: (Delete) ID not found. . . . ");
        }
    }

    @Override
    public int findIndexByID(int id){
        for (Service service : this.services) {
            if (service.getDeviceid()==id)
                return (this.services.indexOf(service));
        }
        return -1;
    }

    public List<Service> getAll(){
        return this.services;
    }

    public void stopService(int id){
        this.services = serviceDataIO.readData();
        try {
            int index = findIndexByID(id);
            Service service = services.get(index);
            service.setEndtime(LocalDateTime.now());
            service.calTotalPrice();
            deleteByIndex(index);
            serviceDataIO.writeData(this.services);
        }catch (Exception e) {
            System.out.println("Error while stopService: " + e.getMessage());
        }
    }

    private void deleteByIndex(int index) {
        this.services.remove(index);
    }
}
