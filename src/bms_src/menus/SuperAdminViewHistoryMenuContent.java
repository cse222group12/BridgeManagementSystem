package bms_src.menus;

import bms_interface.IVehicle;
import bms_src.*;
import data_structures.SkipList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class SuperAdminViewHistoryMenuContent {

    private static final Set<IVehicle.Type> vehicleTypes = new HashSet<>();
    private static final Set<City> cities = new HashSet<>();
    private static final Set<Bridge> bridges = new HashSet<>();

    private static final String[] optionHeaders = new String[]{
            "Search vehicle history",
            "View activity of last 24 hours",
            "View activity of last 7 days",
            "View activity of last 30 days",
            "Enter date interval",
            "Enter vehicle type",
            "Enter city",
            "Enter bridge",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminViewHistoryMenuContent::searchVehicle,
            SuperAdminViewHistoryMenuContent::printLast24h,
            SuperAdminViewHistoryMenuContent::printLast7d,
            SuperAdminViewHistoryMenuContent::printLast30d,
            SuperAdminViewHistoryMenuContent::printSpecified,
            SuperAdminViewHistoryMenuContent::updateValidVehicleTypes,
            SuperAdminViewHistoryMenuContent::updateCities,
            SuperAdminViewHistoryMenuContent::updateBridges,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void searchVehicle() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the plate of the vehicle:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        String finalUserInput = userInput;
        printActivity(new Date(Integer.MIN_VALUE), pass -> pass.getVehicle().getPlate().getPlate().equals(finalUserInput));
    }

    private static void printLast24h() {
        // Quite possibly can be better.
        printActivity((Date.from(Instant.now().minus(1, ChronoUnit.DAYS))));
    }

    private static void printLast7d() {
        printActivity((Date.from(Instant.now().minus(7, ChronoUnit.DAYS))));
    }

    private static void printLast30d() {
        printActivity((Date.from(Instant.now().minus(30, ChronoUnit.DAYS))));
    }

    private static void printActivity(Date since) {
        printActivity(since, (pass) -> true);
    }

    private static void printActivity(Date since, Function<Pass, Boolean> passCondition) {
        printActivity(since, new Date(), passCondition);
    }


    private static void printActivity(Date start, Date end) {
        printActivity(start, end, (pass) -> true);
    }

    // Theta(n) where n is the total number of activity
    private static void printActivity(Date start, Date end, Function<Pass, Boolean> passCondition) {
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            if (cities.isEmpty() || cities.contains(city)) {
                for (Bridge bridge : city.getBridges()) {
                    if (bridges.isEmpty() || bridges.contains(bridge)) {
                        // TODO:
                        // THIS IS DISGUSTING AND HORRENDOUS, CURRENT SKIPLIST CAN'T BE ITERATED WITH VALUES!!!!
                        // FIX IT!!!!
                        SkipList<Date, Pass> passHistory = bridge.getPassHistory();

                        for (Date passDate : passHistory) {
                            Pass pass = passHistory.get(passDate);

                            if (pass == null || !passCondition.apply(pass)) continue;

                            Vehicle vehicle = pass.getVehicle();
                            IVehicle.Type vehicleType = vehicle.getVehicleType();

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

        // Theta(n) where n is number of vehicle types
        for (IVehicle.Type type : IVehicle.Type.values()) {
            System.out.print(vehicleTypes.contains(type) ? "+" : "-");
            String typeName = type.toString();
            System.out.println(typeName);
            typeNames.put(typeName, type);
        }

        // All constant time below here
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

    private static void updateCities() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        Map<String, City> cityMap = new HashMap<>();

        System.out.println("Current cities: (+: Included, -: Excluded)");

        // Theta(n) where n is number of cities
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            System.out.print(cities.contains(city) ? "+" : "-");
            String cityName = city.getName();
            System.out.println(cityName);
            cityMap.put(cityName, city);
        }

        // Constant time below this point
        System.out.println("Enter a city name to change its state:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (cityMap.containsKey(userInput)) {
            City city = cityMap.get(userInput);

            if (cities.contains(city)) {
                cities.remove(city);
                System.out.println("Successfully removed from the selected cities.");
            }
            else {
                cities.add(city);
                System.out.println("Successfully added to the selected cities.");
            }
        }
        else {
            System.out.println("No such city exists.");
        }
    }

    private static void updateBridges() {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Bridge> bridgeMap = new HashMap<>();

        System.out.println("Current bridges in chosen cities: (+: Included, -: Excluded)");

        // Theta(n) where n is the total number of every bridge
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();

            if (cities.isEmpty() || cities.contains(city)) {
                int bridgeIndex = 0;
                for (Bridge bridge : city.getBridges()) {
                    bridgeMap.put(bridgeIndex, bridge);
                    System.out.print(bridgeIndex + ") " + (bridges.contains(bridge) ? "+" : "-"));
                    System.out.println(bridge.getName());
                    bridgeIndex++;
                }
            }
        }

        // Constant time below this point
        System.out.println("Enter the index of the bridge to change its state:");
        userInput = scanner.nextInt();

        Bridge chosenBridge = bridgeMap.get(userInput);

        if (chosenBridge == null) {
            System.out.println("No such bridge exists in currently chosen cities.");
        }
        else {
            if (bridges.contains(chosenBridge)) {
                bridges.remove(chosenBridge);
                System.out.println("Successfully removed from the selected bridges.");
            }
            else {
                bridges.add(chosenBridge);
                System.out.println("Successfully added to the selected bridges.");
            }
        }
    }
}
