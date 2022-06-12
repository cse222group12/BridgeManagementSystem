package bms_src.menus;

import bms_src.Pair;

public class AdminViewStaffMenuContent {

    /*
    TODO:
    private static final Set<City> cities;
    private static final Set<Bridge> bridges;
    private static final Set<Staff.Type> staffTypes;
     */

    private static final String[] optionHeaders = new String[]{
            "Listele",
            "İsim ara",
            "Calisan sinifi sec",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminViewStaffMenuContent::printStaffList,
            AdminViewStaffMenuContent::printSearchList,
            AdminViewStaffMenuContent::updateStaffTypes,
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


    private static void updateStaffTypes() {
        /*
        TODO:
        Print list of staff types and let user add or remove them.
         */
    }
}
