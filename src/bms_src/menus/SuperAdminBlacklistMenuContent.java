package bms_src.menus;

import bms_src.*;

import java.util.Iterator;
import java.util.Scanner;

public abstract class SuperAdminBlacklistMenuContent {

    private static final String[] optionHeaders = new String[]{
            "List",
            "Add",
            "Remove",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            SuperAdminBlacklistMenuContent::printList,
            SuperAdminBlacklistMenuContent::add,
            SuperAdminBlacklistMenuContent::remove,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void printList() {
        System.out.println("Current list of blacklisted vehicle plates:");
        Iterator<Plate> plateIterator = MainSystem.blacklistIterator();

        while (plateIterator.hasNext()) {
            Plate plate = plateIterator.next();
            System.out.println(plate);
        }
    }

    private static void add() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a plate:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        // NOTE:
        // You may want to check if given plate is valid for any of every existing plate versions
        // and not only for Turkish.
        if (Plate.Turkey.isValid(userInput)) {
            MainSystem.addBlackList(new Plate.Turkey(userInput));
        }
        else {
            System.out.println("Given plate is not a valid Turkish plate.");
        }
    }

    private static void remove() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a plate:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        if (MainSystem.removeBlackList(new Plate(userInput))) {
            System.out.println("Successfully removed the vehicle with given plate from the blacklist.");
        }
        else {
            System.out.println("No such plate was blacklisted.");
        }
    }
}
