package bms_src.menus;

import bms_interface.IVehicle;
import bms_src.Menu;
import bms_src.Pair;

import java.util.HashSet;
import java.util.Set;

public abstract class SuperAdminViewHistoryMenuContent {

    private static Set<IVehicle.Type> vehicleTypes = new HashSet<>();
    
    /*
    TODO:
    Create fields:
    private static Set<City> cities;
    private static Set<Bridge> bridges;
     */

    private static final String[] optionHeaders = new String[]{
            "Son 24 saatin etkinliğini gör",
            "Son 7 günün etkinliğini gör",
            "Son 30 günün etkinliğini gör",
            "Tarih aralığı gir",
            "Araç türü gir",
            "Şehir gir",
            "Köprü gir",
            "Geri dön",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminViewHistoryMenuContent::printLast24h,
            SuperAdminViewHistoryMenuContent::printLast7d,
            SuperAdminViewHistoryMenuContent::printLast30d,
            SuperAdminViewHistoryMenuContent::printSpecified,
            SuperAdminViewHistoryMenuContent::updateValidVehicleTypes,
            SuperAdminViewHistoryMenuContent::updateCities,
            SuperAdminViewHistoryMenuContent::updateBridges,
            Menu::pop,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printLast24h() {
        /*
        TODO:
        Print activity history of last 24 hours.
        According to the specified city/bridge/vehicle type etc.
        Can use printActivity(currentTime - 24 hours).
         */
    }

    private static void printLast7d() {
        /*
        TODO:
        Print activity history of last 7 days.
        According to the specified city/bridge/vehicle type etc.
        Can use printActivity(currentTime - 7 days).
         */
    }

    private static void printLast30d() {
        /*
        TODO:
        Print activity history of last 30 days.
        According to the specified city/bridge/vehicle type etc.
        Can use printActivity(currentTime - 30 days).
         */
    }

    // TODO:
    // private static void printActivity(since) {printActivity(since, currentTime)}

    private static void printActivity(/*start, end*/) {
        /*
        TODO:
        Print activities happened between given times.
        According to the specified city/bridge/vehicle type etc.
         */
    }

    private static void printSpecified() {
        /*
        TODO:
        Get starting and ending dates from user and execute printActivity(start, end).
         */
    }

    private static void updateValidVehicleTypes() {
        /*
        TODO:
        Print list of vehicle types and upon user input add or remove entered vehicle type from vehicleTypes.
         */
    }

    private static void updateCities() {
        /*
        TODO:
        Print list of cities and let the user choose add or remove them from the chosen cities.
         */
    }

    private static void updateBridges() {
        /*
        TODO:
        Print list of bridges that are in cities that user has chosen. Let the user add or delete bridges for filtering.
         */
    }
}
