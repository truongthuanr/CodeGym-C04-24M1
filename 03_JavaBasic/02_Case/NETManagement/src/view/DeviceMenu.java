package view;

import input.Input;
import manager.DeviceManager;
import model.Device;
import model.Device.deviceType;
import java.util.List;

import java.util.logging.Level;

public class DeviceMenu {

    DeviceManager deviceManager = new DeviceManager();

    public void showDeviceMenu() {
        int choice;
        do {
            System.out.println("========== Menu Quản lý máy ==========");
            System.out.println("1. Hiển thị tất cả máy.");
            System.out.println("2. Thêm máy mới.");
            System.out.println("3. Xóa máy hiện có.");
            System.out.println("0. Thoát.");
            choice = Input.InputNumber();
            switch (choice) {
                case 1:
                    showAllDevice();


                    break;
                case 2:
                    addDevice();
                    break;

            }

        } while(choice !=0);

    }
    private void showAllDevice() {
        List<Device> devices = this.deviceManager.getAll();
        for (Device device : devices) {
            System.out.println(device);
        }
    }

    private void addDevice() {
        System.out.println("========== Add Device ==========");
        System.out.println("Nhập tên Máy:");
        String name = Input.InputString();
        System.out.print("Nhập kiểu máy: ");
        for (deviceType dt: deviceType.values()){
            System.out.print(dt.value +". " + dt + " | ");
        }
        System.out.println();
        int deviceTypeNum = Input.InputNumber();

//        Device device = new Device("May 1", Device.deviceType.STANDARD);
        Device device = new Device(name,deviceType.getDeviceType(deviceTypeNum));
        deviceManager.add(device);

    }
}
