package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;


public class TollClerkMenuContent {
    private static final String[] optionHeaders = new String[] {
        "Kullancıyı kontrol et",
        "Check in",
        "Check out",
        "Toplam Geliri Göster",
        "Geri dön",
    };

    private static final Runnable[] optionRunnables = new Runnable[] {
        TollClerkMenuContent::checkUser,
        TollClerkMenuContent::checkIn,
        TollClerkMenuContent::checkOut,
        TollClerkMenuContent::showRevenue,
        Menu::pop,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);


    private static void checkUser() {
        /*
            TODO: 
            Wait for user to enter and check the entered user.
        */
    }

    private static void checkIn() {
        /*
            TODO:
            Wait for user to enter and check in the entered user.
        */
    }

    private static void checkOut() {
        /*
            TODO:
            Wait for user to enter and check out the entered user.
        */
    }

    private static void showRevenue() {
        /*
            TODO:
            Prints the total revenue of the toll clerk.
        */
    }

}
