package manager;

import data.DeviceDataIO;
import model.Device;

import java.util.ArrayList;
import java.util.List;

public class DeviceManager implements IManager<Device> {
    private List<Device> devices = new ArrayList<>();

    DeviceDataIO deviceDataIO = new DeviceDataIO();

    public DeviceManager() {
        this.devices = this.deviceDataIO.readData();
    }

    private boolean deviceValidate(Device device){
        int found = findIndexByID(device.getId());
        if(found != -1){
            System.out.println("Device ID existed, new device must have different ID!!!");
            return false;
        }


        return true;
    }

    @Override
    public void add(Device device) {
        if (deviceValidate(device)) {
            this.devices.add(device);
            System.out.println("Updating data to database . . . ");
            deviceDataIO.writeData(this.devices);
        }
    }

    @Override
    public void update(int id, Device device) {

        int index = findIndexByID(id);
        this.devices.set(index, device);
        deviceDataIO.writeData(this.devices);
    }

    @Override
    public void delete(int id) {
        int index = this.findIndexByID(id);
        if(index != -1) {
            this.devices.remove(index);
            deviceDataIO.writeData(this.devices);
        } else {
            System.out.println("Device ID not found. . . . ");
        }
    }

    @Override
    public List<Device> getAll() {
        return this.devices;
    }


    public Device findDeviceByID(int id) {
        for (Device device : this.devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null;

    }

    @Override
    public int findIndexByID(int id) {
        for (Device device : this.devices) {
            if (device.getId() == id) {
                return devices.indexOf(device);
            }
        }
        return -1;
    }

    public void updateDeviceStatus(int id, int statusNum) {
        Device device = findDeviceByID(id);
        if (device != null) {
            device.setStatus(Device.deviceStatus.getDeviceStatus(statusNum));
            deviceDataIO.writeData(this.devices);
        } else {
            System.out.println("Device ID not found. . . . ");
        }
    }

    public void startDevice(int id){
        Device device = findDeviceByID(id);
        if(device != null){
            if (device.getStatus() != Device.deviceStatus.ONLINE){
                System.out.println("Máy không khả dụng, máy phải ở trạng thái online để sử dụng dịch vụ!");
            } else {
                device.setStatus(Device.deviceStatus.OCCUPIED);
                System.out.println("Máy "+device.getName() +" đã sẵn sàng để sử dụng!");
                deviceDataIO.writeData(this.devices);
            }
        } else {
            System.out.println("Device ID not found. . . . ");
        }



    }
}

