package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class SuperAdminViewStaffMenuContent {

    /*
    TODO:
    private static final Set<City> cities;
    private static final Set<Bridge> bridges;
    private static final Set<Staff.Type> staffTypes;
     */

    private static final String[] optionHeaders = new String[]{
            "Listele",
            "İsim ara",
            "Şehir seç",
            "Köprü seç",
            "Çalışan türü seç",
            "Geri dön",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminViewStaffMenuContent::printStaffList,
            SuperAdminViewStaffMenuContent::printSearchList,
            SuperAdminViewStaffMenuContent::updateCities,
            SuperAdminViewStaffMenuContent::updateBridges,
            SuperAdminViewStaffMenuContent::updateStaffTypes,
            Menu::pop,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printStaffList() {
        /*
        TODO:
        Prints list of staff according to specified cities, bridges, and staff types.
         */
    }

    private static void printSearchList() {
        /*
        TODO:
        Let user enter a name and print the matching results.
         */
    }

    private static void updateCities() {
        /*
        TODO:
        Print list of cities and let user
        add or remove the city they entered.
         */
    }

    private static void updateBridges() {
        /*
        TODO:
        Print list of bridges in chosen cities and let user add or remove them.
         */
    }

    private static void updateStaffTypes() {
        /*
        TODO:
        Print list of staff types and let user add or remove them.
         */
    }
}
