package view;

import input.Input;


public class MainMenu {
    public void showMainMenu(){
        int choice;
        do {
            System.out.println();
            System.out.println("===============================");
            System.out.println("========== Main Menu ==========");
            System.out.println("1. Quản lý máy.");
            System.out.println("2. Dịch vụ.");
            System.out.println("3. Doanh Thu.");

            System.out.println("0. Thoát");

            DeviceMenu deviceMenu = new DeviceMenu();
            ServiceMenu serviceMenu = new ServiceMenu();

            System.out.print("Nhập lựa chọn: ");
            choice = Input.InputNumber();
            System.out.println();

            switch(choice){
                case 1:
                    //System.out.println("Debug: Menu quản lý máy ");
                    deviceMenu.showDeviceMenu();
                    break;
                case 2:
                    serviceMenu.showServiceMenu();
                    break;

            }

        } while (choice != 0);

    }

}
