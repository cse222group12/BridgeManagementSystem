package bms_src.menus;

import bms_src.*;

import java.util.Scanner;

public abstract class AdminTollByVehicleMenuContent {
    private static final String[] optionHeaders = new String[]{
                "Set Bridge Price",
//            "ekstra ozellikler girilebilir",
//            "3",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminTollByVehicleMenuContent::setBridgePrice,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void setBridgePrice() {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());

        System.out.println("Bridges are: ");
        for (Bridge bridge :
                city.getBridges()) {
            System.out.println(bridge);
        }

        System.out.println("Input the Bridge name: ");
        String str= sc.nextLine();              //reads string
        boolean isTrueInput = false;
        for (Bridge bridge :
                city.getBridges()) {
            if(bridge.getName().equals(str)){
                isTrueInput = true;
                System.out.println("Input the new price: ");
                int a= sc.nextInt();
                bridge.setPrice(a);
                System.out.println("Price is updated succesfully! ");
            }
        }
        if (!isTrueInput){
            System.out.println("Wrong city name!");
        }
    }

    private static void setTollVehicle2() {
        /*
        TODO:
            Set tool vehicle 1
         */
    }
    private static void setTollVehicle3() {
        /*
        TODO:
            Set tool vehicle 1
         */
    }
}
