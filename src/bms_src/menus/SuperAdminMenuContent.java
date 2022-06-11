package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class SuperAdminMenuContent {
    private static final String[] optionHeaders = new String[]{
            "Etkinlik geçmişini gör",
            "Çalışanları gör",
            "Whitelisti aç",
            "Blacklisti aç",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            () -> Menu.push(Menu.SuperAdminViewHistory),
            () -> Menu.push(Menu.SuperAdminViewStaff),
            () -> Menu.push(Menu.SuperAdminWhitelist),
            () -> Menu.push(Menu.SuperAdminBlacklist),
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
