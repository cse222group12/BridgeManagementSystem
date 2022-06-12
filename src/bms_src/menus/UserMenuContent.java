package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class UserMenuContent {
    private static final String[] optionHeaders = new String[]{
            "My Balance",
            "My Vehicles",
            "My Penalties",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            UserMenuContent::showBalance,
            () -> Menu.push(Menu.SuperAdminBlacklist), //TODO!!
            UserMenuContent::showPenalties,
    };

    private static void showPenalties() {
    }

    private static void showBalance() {

    }

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
