package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public abstract class UserVehiclesMenuContent {

    private static final String[] optionHeaders = new String[]{
            "Show all",
            "New vehicle",
            "Remove a vehicle",
            "Update a vehicle",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            UserVehiclesMenuContent::listVehicles,
            UserVehiclesMenuContent::newVehicle,
            UserVehiclesMenuContent::removeVehicle,
            UserVehiclesMenuContent::updateVehicle,

    };

    private static void newVehicle() {
        /*TODO
            takes the input from user for the new car, car added to user's vehicles list
         */
    }

    private static void updateVehicle() {
        /*TODO
            user choose the car from the list, and update it
         */
    }

    private static void removeVehicle() {
        /*TODO
            user choose the car from the list and remove it
         */
    }

    private static void listVehicles() {
        /*TODO
            list of user's vehicles
         */
    }

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

}
