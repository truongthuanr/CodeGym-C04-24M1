package view;

import input.Input;


public class MainMenu {
    public void showMainMenu(){
        int choice;
        do {
            System.out.println("========== Main Menu ==========");
            System.out.println("1. Quản lý máy.");
            DeviceMenu deviceMenu = new DeviceMenu();

            choice = Input.InputNumber();
            switch(choice){
                case 1:
                    System.out.println("Debug: Menu quản lý máy ");
                    deviceMenu.showDeviceMenu();
                    break;
                case 2:

                    break;

            }

        } while (choice != 0);

    }

}
