package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class SuperAdminWhitelistMenuContent {

    private static final String[] optionHeaders = new String[]{
            "Listele",
            "Ekle",
            "Çıkar",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminWhitelistMenuContent::printList,
            SuperAdminWhitelistMenuContent::add,
            SuperAdminWhitelistMenuContent::remove,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printList() {
        /*
        TODO:
        Prints list of users in the whitelist.
         */
    }

    private static void add() {
        /*
        TODO:
        Wait for user to enter and add the entered user to whitelist.
         */
    }

    private static void remove() {
        /*
        TODO:
        Wait for user to enter and remove the entered user from whitelist.
         */
    }
}
