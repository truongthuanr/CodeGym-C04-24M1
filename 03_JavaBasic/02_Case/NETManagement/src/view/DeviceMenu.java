package view;

import input.Input;
import manager.DeviceManager;
import model.Device;
import model.Device.deviceType;
import model.Device.deviceStatus;
import java.util.List;

import java.util.logging.Level;

public class DeviceMenu {

    DeviceManager deviceManager = new DeviceManager();

    public void showDeviceMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("======================================");
            System.out.println("========== Menu Quản lý máy ==========");
            System.out.println("1. Hiển thị tất cả máy.");
            System.out.println("2. Thêm máy mới.");
            System.out.println("3. Xóa máy hiện có.");
            System.out.println("4. Chỉnh sửa thông tin máy.");
            System.out.println("5. Chỉnh sửa trạng thái máy.");
            System.out.println("0. Thoát.");

            System.out.print("Nhập lựa chọn: ");
            choice = Input.InputNumber();
//            System.out.println();
            switch (choice) {
                case 1:
                    showAllDevice();
                    break;
                case 2:
                    addDevice();
                    break;
                case 3:
                    removeDevice();
                case 4:
                    updateDevice();
                case 5:
                    updateDeviceStatusMenu();

            }

        } while(choice !=0);

    }

    private void showAllDevice() {
        List<Device> devices = this.deviceManager.getAll();
        for (Device device : devices) {
            System.out.println(device);
        }
    }


    protected void showAvailableDevice(){
        System.out.println("Available devices:");
        List<Device> devices = this.deviceManager.getAll();
        for (Device device : devices) {
            if (device.getStatus() == Device.deviceStatus.ONLINE){
                System.out.println(device.toString());
            }
        }

    }

    private void addDevice() {
        System.out.println("========== Add Device ==========");

        System.out.print("Nhập ID: ");
        int id = Input.InputNumber();
        System.out.println();


        System.out.print("Nhập tên Máy:");
        String name = Input.InputString();
        System.out.println();

        System.out.print("Nhập kiểu máy (");
        for (deviceType dt: deviceType.values()){
            System.out.print(dt.value +"." + dt + " ");
        }
        System.out.print("): ");
        int deviceTypeNum = Input.InputNumber();
        System.out.println();

//        Device device = new Device("May 1", Device.deviceType.STANDARD);
        Device device = new Device(id,name,deviceType.getDeviceType(deviceTypeNum));
        deviceManager.add(device);

    }

    private void removeDevice() {
        int choice;
        do {
            System.out.println();
            System.out.println("===================================");
            System.out.println("========== Remove Device ==========");
            System.out.println("1. Hiển thị danh sách các máy.");
            System.out.println("2. Xóa máy theo id máy.");
            System.out.println("3. Xóa máy theo tên máy.");
            System.out.println("0. Thoát.");


            System.out.print("Nhập lựa chọn: ");
            choice = Input.InputNumber();
//            System.out.println();

            switch (choice) {
                case 1:
                    showAllDevice();
                    break;
                case 2:
                    System.out.print("Nhập id máy muốn xóa: ");
                    int id = Input.InputNumber();
                    System.out.println();
                    deviceManager.delete(id);
                    break;
                case 3:
                    System.out.println("This funtion is comming soon!!!");
                    break;
            }
        } while (choice !=0);

    }
    private void updateDevice() {
        System.out.println("===================================");
        System.out.println("========== Update Device ==========");
        System.out.print("Nhập id máy cần chỉnh sửa (nhập 0 để thoát): ");
        int id = Input.InputNumber();
        if (id == 0) {
            return;
        }

//        int index = deviceManager.findIndexByID(id);
        Device device = deviceManager.findDeviceByID(id);
        if (device != null) {
            System.out.println("Thực hiện chỉnh sửa thông tin cho máy: ");
            System.out.println(device.toString());
            // Update device
            System.out.print("Nhập tên mới cho máy: ");
            String name = Input.InputString();
            System.out.print("Nhập Loại máy (");
            for (deviceType dt: deviceType.values()){
                System.out.print(dt.value +"." + dt + " ");
            }
            System.out.print("): ");
            int deviceTypeNum = Input.InputNumber();

            Device newDevice = new Device(id,name,deviceType.getDeviceType(deviceTypeNum));

            deviceManager.update(id, newDevice);
        } else {
            System.out.println("Device Not Found . . .");


        }


    }

    private void updateDeviceStatusMenu() {
        System.out.println("===============================================");
        System.out.println("========== Update Device Status Menu ==========");
        int choice;
        do {
            System.out.println("1. Xem danh sách máy");
            System.out.println("2. Chỉnh sửa trạng thái máy.");
            choice = Input.InputNumber();

            switch (choice) {
                case 1:
                    showAllDevice();
                    break;
                case 2:
                    System.out.print("Nhập id máy: ");
                    int id = Input.InputNumber();
                    System.out.println();
                    System.out.print("Nhập trạng thái máy ");
                    for (deviceStatus dt: deviceStatus.values()){
                        System.out.print(dt.value +"." + dt + " ");
                    }
                    System.out.print("): ");
                    int deviceStatusNum = Input.InputNumber();
                    deviceManager.updateDeviceStatus(id, deviceStatusNum);
                    break;
            }


        } while (choice != 0);





    }

//    protected void updateDeviceStatus(int id, int statusNum) {
//        Device device = deviceManager.findDeviceByID(id);
//        device.setStatus(deviceStatus.getDeviceStatus(statusNum));
//    }


}
