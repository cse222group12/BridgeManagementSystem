package bms_src.menus;

import bms_src.Pair;

public abstract class AdminViewHistoryMenuContent {

    private static final String[] optionHeaders = new String[]{
            "Son 24 saatin etkinligini gor",
            "Son 7 gunun etkinligini gor",
            "Son 30 gunun etkinligini gor",
            "Tarih aralıgı gir",
            "Arac turu gir",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminViewHistoryMenuContent::printLast24h,
            AdminViewHistoryMenuContent::printLast7d,
            AdminViewHistoryMenuContent::printLast30d,
            AdminViewHistoryMenuContent::printSpecified,
            AdminViewHistoryMenuContent::updateValidVehicleTypes,
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
        Print list of vehicle types and upon user input add or remove entered vehicle type from
        vehicleTypes.
         */
    }
}
