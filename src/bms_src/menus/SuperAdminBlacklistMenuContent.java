package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class SuperAdminBlacklistMenuContent {

    private static final String[] optionHeaders = new String[]{
            "Listele",
            "Ekle",
            "Çıkar",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminBlacklistMenuContent::printList,
            SuperAdminBlacklistMenuContent::add,
            SuperAdminBlacklistMenuContent::remove,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printList() {
        /*
        TODO:
        Prints list of users in the blacklist.
         */
    }

    private static void add() {
        /*
        TODO:
        Wait for user to enter and add the entered user to blacklist.
         */
    }

    private static void remove() {
        /*
        TODO:
        Wait for user to enter and remove the entered user from blacklist.
         */
    }
}
