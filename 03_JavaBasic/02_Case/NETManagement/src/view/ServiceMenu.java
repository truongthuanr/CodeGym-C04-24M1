package view;

import input.Input;

public class ServiceMenu extends DeviceMenu{

    public void showServiceMenu(){

        int choice;
        do {
            System.out.println("==============================");
            System.out.println("========== Dịch vụ ===========");
            System.out.println("1. Bắt đầu sử dụng máy.");
            System.out.println("2. Dừng sử dụng máy - Thanh toán.");
            System.out.println("0. Thoát.");

            System.out.print("Nhập lựa chọn: ");
            choice  =  Input.InputNumber();

            switch (choice){
                case 1:
                    startService();
                case 2:
                    stopService();
            }

        }while (choice !=0 );

    }

    private void startService(){
        // Show available devices
        showAvailableDevice();
        // start device
        System.out.print("Nhập ID máy bắt đầu sử dụng: ");
        int id = Input.InputNumber();
        deviceManager.startDevice(id);
    }

    private void stopService(){
        // show online device

        // stop device

    }
}
