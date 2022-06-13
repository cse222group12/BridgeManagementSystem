package bms_src.menus;

import bms_interface.IVehicle;
import bms_src.*;
import data_structures.BinaryTree;
import data_structures.SkipList;

import java.util.*;
import java.util.function.Function;

public abstract class SuperAdminViewStaffMenuContent {

    private static final Set<City> cities = new HashSet<>();
    private static final Set<Bridge> bridges = new HashSet<>();
    private static final Set<Class<? extends Staff>> staffTypes = new HashSet<>();

    private static final String[] optionHeaders = new String[]{
            "List",
            "Search",
            "Choose City",
            "Choose Bridge",
            "Choose Staff Type",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminViewStaffMenuContent::printStaffList,
            SuperAdminViewStaffMenuContent::printSearchList,
            SuperAdminViewStaffMenuContent::updateCities,
            SuperAdminViewStaffMenuContent::updateBridges,
            SuperAdminViewStaffMenuContent::updateStaffTypes,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printStaffList() {
        printStaffListOnCondition(staff -> true);
    }

    private static void printStaffListOnCondition(Function<Staff, Boolean> condition) {
        System.out.println("List of valid staff members:");
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            if (cities.isEmpty() || cities.contains(city)) {
                for (Bridge bridge : city.getBridges()) {
                    if (bridges.isEmpty() || bridges.contains(bridge)) {
                        bridge.getWorkers().inOrderTraverse((staff, integer) -> {
                            if (staff == null);
                            else if (staffTypes.isEmpty() || staffTypes.contains(staff.getClass())) {
                                if (condition.apply(staff)) {
                                    System.out.println(staff);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private static void printSearchList() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        String finalUserInput = userInput;
        printStaffListOnCondition(staff -> staff.getUsername().contains(finalUserInput));
    }


    private static void updateCities() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        Map<String, City> cityMap = new HashMap<>();

        System.out.println("Current cities: (+: Included, -: Excluded)");

        Iterator<City> cityIterator = MainSystem.getCityIterator();

        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            System.out.print(cities.contains(city) ? "+" : "-");
            String cityName = city.getName();
            System.out.println(cityName);
            cityMap.put(cityName, city);
        }

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

    private static void updateStaffTypes() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        Map<String, Staff.Type> typeNames = new HashMap<>();

        System.out.println("Current vehicle types: (+: Included, -: Excluded)");

        for (Staff.Type type : Staff.Type.values()) {
            System.out.print(staffTypes.contains(type.getStaffClass()) ? "+" : "-");
            String typeName = type.toString();
            System.out.println(typeName);
            typeNames.put(typeName, type);
        }

        System.out.println("Enter a vehicle type to change its state:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (typeNames.containsKey(userInput)) {
            Staff.Type type = typeNames.get(userInput);
            Class<? extends Staff> staffClass = type.getStaffClass();

            if (staffTypes.contains(staffClass)) {
                staffTypes.remove(staffClass);
                System.out.println("Successfully removed from the selected vehicle types.");
            }
            else {
                staffTypes.add(staffClass);
                System.out.println("Successfully added to the selected vehicle types.");
            }
        }
        else {
            System.out.println("No such vehicle type exists.");
        }
    }
}
