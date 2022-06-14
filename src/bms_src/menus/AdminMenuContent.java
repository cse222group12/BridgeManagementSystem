package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;


public abstract class AdminMenuContent {
    private static final String[] optionHeaders = new String[]{
            "View Activity History",
            "View Staff Members",
            "Toll Price "
        };

    private static final Runnable[] optionRunnables = new Runnable[]{
            () -> Menu.push(Menu.AdminViewHistory),
            () -> Menu.push(Menu.AdminViewStaff),
            () -> Menu.push(Menu.AdminTollByVehicle),
    };

    public static final Pair<String, Runnable>[] options =
        Pair.of(optionHeaders, optionRunnables);
}
