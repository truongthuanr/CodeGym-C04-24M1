package manager;
import model.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ServiceManager implements IManager<Service>{
    List<Service> services;
    private int transactionid;


    public ServiceManager() {
        services =
    }



    @Override
    public void add(Service service) {

    }
    @Override
    public void update(int id, Service service){

    }

    @Override
    public void delete(int id){

    }
    @Override
    public int findIndexByID(int id){

        return 0;
    }

    public List<Service> getAll(){
        return this.services;
    }

}
