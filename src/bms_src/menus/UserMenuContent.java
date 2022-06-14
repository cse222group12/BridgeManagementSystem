package bms_src.menus;

import bms_interface.IVehicle;
import bms_src.*;
import bms_src.Menu;
import data_structures.SkipList;
import java.util.*;

public abstract class UserMenuContent {

    private static final String[] optionHeaders = new String[]{
            "My Balance",
            "My Vehicles",
            "My Penalties",
            "My Pass History",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            UserMenuContent::showBalance,
            () -> Menu.push(Menu.UserVehicles), //TODO!!
            UserMenuContent::showPenalties,
            UserMenuContent::showPassHistory,
    };

    private static void showPassHistory() {
        printActivity();
    }

    private static void showPenalties() {
        User currUser = (User) BMS.currentUser;
        currUser.getAllPenalties();
    }

    private static void showBalance() {
        User currUser = (User) BMS.currentUser;
        System.out.println("Your balance: " + currUser.showBalance() + "$");
        System.out.print("Do you want to add some money?(y/n) ");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        double newBalance = 0;
        if(option.equalsIgnoreCase("Y")){
            System.out.print("How many dollars do you want to add? ");
            try {
                newBalance = sc.nextDouble();
            }
            catch (Exception InputMismatchException){
                System.out.println("Input should be like this. (4,3)");
            }
            currUser.addToBalance(newBalance);
        }

    }

    private static void printActivity() {
        User currUser = (User) BMS.currentUser;
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            for (Bridge bridge : city.getBridges()) {
                SkipList<Date, Pass> passHistory = bridge.getPassHistory();
                for (Date passDate : passHistory) {
                    Pass pass = passHistory.get(passDate);
                    if (pass == null) continue;
                    if(currUser.getVehicles().contains(pass.getVehicle().getPlate())){
                        System.out.println(pass);
                    }
                }

            }

        }
    }

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
