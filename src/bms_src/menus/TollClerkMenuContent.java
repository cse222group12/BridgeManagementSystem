package bms_src.menus;

import java.util.Scanner;

import bms_src.BMS;
import bms_src.MainSystem;
import bms_src.Menu;
import bms_src.Pair;
import bms_src.Person;
import bms_src.Plate;
import bms_src.TollClerk;
import bms_src.User;


public class TollClerkMenuContent {
    private static final String[] optionHeaders = new String[] {
        "Kullancıyı kontrol et",
        "Check in",
        "Check out",
        "Toplam Geliri Göster",
        "Geri dön",
    };

    private static final Runnable[] optionRunnables = new Runnable[] {
        TollClerkMenuContent::checkUser,
        TollClerkMenuContent::checkIn,
        TollClerkMenuContent::checkOut,
        TollClerkMenuContent::showRevenue,
        Menu::pop,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);


    private static void checkUser() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the username of the user:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        
        Person userCandidate = MainSystem.getPerson(userInput);

        if (!(userCandidate instanceof bms_src.User)) {
            System.out.println("No user exists with given username.");
        }   
        else
        {
            System.out.println("User found.");
        }



    }

    private static void checkIn() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        TollClerk currentTollClerk = (TollClerk) BMS.currentUser;

        System.out.println("Enter the username of the user:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        
        Person userCandidate = MainSystem.getPerson(userInput);

        if (!(userCandidate instanceof bms_src.User)) {
            System.out.println("No user exists with given username.");
        }   
        
        System.out.println("Enter the vehicle's license plate number:");
        for(var item : ((User)(userCandidate)).getVehicles())
        {
            System.out.println(item.getPlate());
        }

        String plateInput = "\n";

        while (plateInput.equals("\n")) {
            plateInput = scanner.nextLine();
        }

        if(((User)(userCandidate)).isThisPlateAvailable(plateInput))
        {
            System.out.println("Check in successful.");
            currentTollClerk.checkIn((User)(userCandidate),((User)(userCandidate)).getVehicles().get(new Plate(plateInput)));
        }
        else
        {
            System.out.println("Vehicle not found.");
        }


    }

    private static void checkOut() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        TollClerk currentTollClerk = (TollClerk) BMS.currentUser;

        System.out.println("Enter the username of the user:");
        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        
        Person userCandidate = MainSystem.getPerson(userInput);

        if (userCandidate == null || userCandidate instanceof bms_src.User == false) {
            System.out.println("No user exists with given username.");
        }   
        
        System.out.println("Enter the vehicle's license plate number:");
        for(var item : ((User)(userCandidate)).getVehicles())
        {
            System.out.println(item.getPlate());
        }

        String plateInput = "\n";

        while (plateInput.equals("\n")) {
            plateInput = scanner.nextLine();
        }

        if(((User)(userCandidate)).isThisPlateAvailable(plateInput))
        {
            System.out.println("Check out successful.");
            currentTollClerk.checkIn((User)(userCandidate),((User)(userCandidate)).getVehicles().get(new Plate(plateInput)));
        }
        else
        {
            System.out.println("Vehicle not found.");
        }

    }

    private static void showRevenue() {
        /*
            Prints the total revenue of the toll clerk.
        */
        TollClerk currentTollClerk = (TollClerk) BMS.currentUser;
        System.out.println("Total revenue: " + currentTollClerk.revenue());
    }

}
