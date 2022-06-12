package bms_src.menus;

import bms_src.BMS;
import bms_src.Menu;
import bms_src.Pair;
import bms_src.User;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    }

    private static void showPenalties() {



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

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
