package bms_src.menus;

import bms_interface.IVehicle;
import bms_src.*;
import data_structures.SkipList;
import testers.CityTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;


public abstract class AdminViewHistoryMenuContent {
    /**
     * This classes fucntions copied from
     * SuperAdminViewHistoryMenuContent class
     */
    private static Admin admin = (Admin) BMS.currentUser;

    private static final Set<Bridge> bridges = new HashSet<>();
    private static final Set<IVehicle.Type> vehicleTypes = new HashSet<>();


    private static final String[] optionHeaders = new String[]{
            "View Pass History",
            "View total revenue",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminViewHistoryMenuContent::passHistory,
            AdminViewHistoryMenuContent::viewRevenue,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printLast24h() {
        // Quite possibly can be better.
        printActivity((Date.from(Instant.now().minus(1, ChronoUnit.DAYS))));
    }

    private static void passHistory() {
        admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());
        for (Bridge bridge : city.getBridges()) {
            System.out.println(bridge);
            System.out.println("Total revenue: " + bridge.getPassHistory());
        }
    }

    private static void printLast7d() {
        printActivity((Date.from(Instant.now().minus(7, ChronoUnit.DAYS))));
    }

    private static void viewRevenue() {
        admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());
        for (Bridge bridge : city.getBridges()) {
            System.out.print(bridge.getName()+ " bridge -> " );
            System.out.println(bridge.getRevenue()+ " $");
        }
    }

    private static void printActivity(Date since) {
        printActivity(since,new Date());
    }


    private static void printActivity(Date start, Date end) {
        admin = (Admin) BMS.currentUser;

        City city = BMS.getCity(admin.getCity_name());
        for (Bridge bridge : city.getBridges()) {
            if (bridges.isEmpty() || bridges.contains(bridge)) {
                // TODO:
                // THIS IS DISGUSTING AND HORRENDOUS, CURRENT SKIPLIST CAN'T BE ITERATED WITH VALUES!!!!
                // FIX IT!!!!
                SkipList<Date, Pass> passHistory = bridge.getPassHistory();

                if (bridge.getPassTime() < 0) {
                    for (Date passDate : passHistory) {
                        Pass pass = passHistory.get(passDate);

                        if (pass == null) continue;

                        IVehicle.Type vehicleType = pass.getVehicle().getVehicleType();

                        if (vehicleTypes.isEmpty() || vehicleTypes.contains(vehicleType)) {
                            if (start.compareTo(passDate) < 0 && end.compareTo(passDate) > 0) {
                                System.out.println(pass);
                            }
                        }
                    }
                }
            }
        }
    }


    private static void printSpecified() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        Date firstDate, lastDate;

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Enter first date: (as dd-MM-yyyy)");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        try {
            firstDate = (dateFormatter.parse(userInput));
        } catch (ParseException e) {
            System.out.println("Input was in an invalid format.");
            return;
        }

        userInput = "\n";
        System.out.println("Enter last date: (as dd-MM-yyyy)");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        try {
            lastDate = (dateFormatter.parse(userInput));
        } catch (ParseException e) {
            System.out.println("Input was in an invalid format.");
            return;
        }

        printActivity(firstDate, lastDate);
    }
    private static void updateValidVehicleTypes() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        Map<String, IVehicle.Type> typeNames = new HashMap<>();

        System.out.println("Current vehicle types: (+: Included, -: Excluded)");

        for (IVehicle.Type type : IVehicle.Type.values()) {
            System.out.print(vehicleTypes.contains(type) ? "+" : "-");
            String typeName = type.toString();
            System.out.println(typeName);
            typeNames.put(typeName, type);
        }

        System.out.println("Enter a vehicle type to change its state:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (typeNames.containsKey(userInput)) {
            IVehicle.Type type = typeNames.get(userInput);

            if (vehicleTypes.contains(type)) {
                vehicleTypes.remove(type);
                System.out.println("Successfully removed from the selected vehicle types.");
            }
            else {
                vehicleTypes.add(type);
                System.out.println("Successfully added to the selected vehicle types.");
            }
        }
        else {
            System.out.println("No such vehicle type exists.");
        }
    }
}
