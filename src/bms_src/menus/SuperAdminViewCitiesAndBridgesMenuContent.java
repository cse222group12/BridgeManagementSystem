package bms_src.menus;

import bms_src.Bridge;
import bms_src.City;
import bms_src.MainSystem;
import bms_src.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public abstract class SuperAdminViewCitiesAndBridgesMenuContent {
    private static final String[] optionHeader = {
            "List Cities",
            "Add City",
            "Remove City",
            "List Bridges",
            "Add Bridge",
            "Remove Bridge",
    };

    private static final Runnable[] optionRunnables = {
            SuperAdminViewCitiesAndBridgesMenuContent::listCities,
            SuperAdminViewCitiesAndBridgesMenuContent::addCity,
            SuperAdminViewCitiesAndBridgesMenuContent::removeCity,
            () -> listBridges(false),
            SuperAdminViewCitiesAndBridgesMenuContent::addBridge,
            SuperAdminViewCitiesAndBridgesMenuContent::removeBridge,

    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeader, optionRunnables);

    private static void listCities() {
        System.out.println("Cities:");
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        for (int i = 0; cityIterator.hasNext(); i++) {
            City city = cityIterator.next();
            System.out.println(city.getName());
        }
    }

    private static void addCity() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of the city:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (MainSystem.cityExists(userInput)) {
            System.out.println("A city with the entered name already exists.");
            return;
        }

        MainSystem.addCity(new City(userInput));
        System.out.println("Successfully added.");
    }

    private static void removeCity() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of the city:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (!MainSystem.cityExists(userInput)) {
            System.out.println("No such city exists with given name.");
            return;
        }

        MainSystem.removeCity(userInput);
        System.out.println("Successfully removed.");
    }

    private static List<Bridge> listBridges(boolean indexed) {
        ArrayList<Bridge> bridges = new ArrayList<>();
        int i = 0;
        Iterator<City> cityIterator = MainSystem.getCityIterator();
        while (cityIterator.hasNext()) {
            City city = cityIterator.next();
            System.out.println(city.getName());
            for (Bridge bridge : city.getBridges()) {
                if (indexed) System.out.print(i + ") ");
                System.out.println("    " + bridge.getName());
                bridges.add(bridge);
                i++;
            }
        }
        return bridges;
    }

    private static void addBridge() {
        City chosenCity = chooseCity();

        if (chosenCity == null) {
            System.out.println("No such city exists with given name.");
            return;
        }

        System.out.println("Enter the name of the bridge:");
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (chosenCity.containsBridge(userInput)) {
            System.out.println("A bridge with the entered name already exists in this city.");
            return;
        }

        chosenCity.addBridge(new Bridge(userInput));
        System.out.println("Successfully added.");
    }

    private static void removeBridge() {
        City chosenCity = chooseCity();

        if (chosenCity == null) {
            System.out.println("No such city exists with given name.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the index of the bridge you want to remove:");
        List<Bridge> bridgeList = listBridges(true);
        int bridgeIndex = scanner.nextInt();

        Bridge chosenBridge;

        try {
            chosenBridge = bridgeList.get(bridgeIndex);
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        chosenCity.removeBridge(chosenBridge);
        System.out.println("Successfully removed.");
    }

    private static City chooseCity() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of the city:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (!MainSystem.cityExists(userInput)) {
            return null;
        }

        return MainSystem.getCity(userInput);
    }
}
