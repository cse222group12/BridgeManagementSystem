package bms_src.menus;

import bms_src.*;

import java.util.*;
import java.util.function.Function;

public class AdminViewStaffMenuContent {

    private static final Set<Class<? extends Staff>> staffTypes = new HashSet<>();


    private static final String[] optionHeaders = new String[]{
            "List",
            "Search",
            "Choose Bridge",
            "Choose Staff Type",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminViewStaffMenuContent::printStaffList,
            AdminViewStaffMenuContent::printSearchList,
            AdminViewStaffMenuContent::ShowBridges,
            AdminViewStaffMenuContent::updateStaffTypes,

    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);



    private static void printStaffList() {
        printStaffListOnCondition(staff -> true);
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

    private static void ShowBridges() {
        int i = 0;
        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());

        for (Bridge bridge:
                city.getBridges()) {
            System.out.println(i+"- "+bridge);
            i++;
        }

    }

    private static void printStaffListOnCondition(Function<Staff, Boolean> condition) {
        System.out.println("List of valid staff members:");
        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());
        for (Bridge bridge : city.getBridges()) {
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
