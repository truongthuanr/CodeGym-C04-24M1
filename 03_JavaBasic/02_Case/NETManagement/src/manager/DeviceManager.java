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

    @Override
    public void add(Device device) {
        this.devices.add(device);
        System.out.println("Writing data . . . ");
        deviceDataIO.writeData(this.devices);
    }

    @Override
    public void update(Device device) {

    }

    @Override
    public void delete(Device device) {

    }

    @Override
    public List<Device> getAll() {
        return this.devices;
    }

    @Override
    public int findIndexByID(int id) {
        return 0;

    }
}
