package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class SuperAdminMenuContent {
    private static final String[] optionHeaders = new String[]{
            "View Activity History",
            "View Staff Members",
            "View Blacklist",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            () -> Menu.push(Menu.SuperAdminViewHistory),
            () -> Menu.push(Menu.SuperAdminViewStaff),
            () -> Menu.push(Menu.SuperAdminBlacklist),
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
