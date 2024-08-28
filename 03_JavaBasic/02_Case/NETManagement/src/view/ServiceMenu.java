package view;

import input.Input;
import manager.ServiceManager;
import model.Device;
import model.Service;


import javax.lang.model.type.NullType;
import java.time.LocalDateTime;

public class ServiceMenu extends DeviceMenu{

    ServiceManager serviceManager = new ServiceManager();

    public void showServiceMenu(){

        int choice;
        do {
            System.out.println("==============================");
            System.out.println("========== Dịch vụ ===========");
            System.out.println("1. Bắt đầu sử dụng máy.");
            System.out.println("2. Đồ ăn - Thức uống.");
            System.out.println("3. Dừng sử dụng máy - Thanh toán.");
            System.out.println("0. Thoát.");

            System.out.print("Nhập lựa chọn: ");
            choice  =  Input.InputNumber();

            switch (choice){
                case 1:
                    startService();
                    break;
                case 2:
                    System.out.println("Function comming soon . . .!");
                    break;
                case 3:
                    stopService();
                    break;
            }

        }while (choice !=0 );

    }

    private void startService(){
        // Show available devices
        showAvailableDevice();
        // start device
        System.out.print("Nhập ID máy bắt đầu sử dụng dịch vụ (0 để thoát): ");
        int id = Input.InputNumber();
        if (id != 0) {
            if (deviceManager.findIndexByID(id)!=-1) {
                deviceManager.startDevice(id);
                float unitprice = deviceManager.getUnitPrice(id);
                Service service = new Service(id, LocalDateTime.now(), null, unitprice, -1);
                serviceManager.add(service);
            } else {
                System.out.println("ID không hợp lệ!");
            }
        }
    }

    private void stopService(){
        // show using device
        int n = showDeviceWithStatus(Device.deviceStatus.OCCUPIED);

        if (n != 0) {
            System.out.print("Nhập ID máy dừng sử dụng dịch vụ: ");
            int id = Input.InputNumber();
            // stop device
            deviceManager.stopDevice(id);
            serviceManager.stopService(id);
        }


    }
}
