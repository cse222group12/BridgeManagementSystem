package bms_src.menus;

import bms_interface.IVehicle;
import bms_src.*;
//import jdk.swing.interop.SwingInterOpUtils; NOTE: Compiler error

import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class UserVehiclesMenuContent {

    private static final String[] optionHeaders = new String[]{
            "Show all",
            "Add a new vehicle",
            "Remove a vehicle",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            UserVehiclesMenuContent::listVehicles,
            UserVehiclesMenuContent::newVehicle,
            UserVehiclesMenuContent::removeVehicle,

    };

    private static void newVehicle() {
        String plate = null;
        int type = 0;
        IVehicle.Type[] v_type = new IVehicle.Type[5];
        v_type[0] = IVehicle.Type.Automobile;
        v_type[1] = IVehicle.Type.Minibus;
        v_type[2] = IVehicle.Type.Bus;
        v_type[3] = IVehicle.Type.Truck;
        v_type[4] = IVehicle.Type.Motorcycle;

        Scanner sc = new Scanner(System.in);

        User currUser = (User) BMS.currentUser;

        System.out.print("Enter the plate: ");
        plate = sc.next();

        System.out.println("Choose type of the vehicle: ");

        for(int i = 0; i< v_type.length; i++){
            System.out.println("[" + i + "]" + v_type[i]);
        }
        String _type = sc.next();
        type = Integer.parseInt(_type);
        Plate plate1 = new Plate(plate.toUpperCase());
        Vehicle vehicle = new Vehicle(plate1,currUser.getUsername(), v_type[type]);
        currUser.addVehicle(vehicle);
    }

    private static void removeVehicle() {
        String plate = null;
        Scanner sc = new Scanner(System.in);
        User currUser = (User) BMS.currentUser;
        boolean isThereVehicle = currUser.showAllPlates();

        if (isThereVehicle) {
            System.out.println("Enter the plate of the car that'll be removed: ");
            plate = sc.next();
            try {
                currUser.removeVehicle(new Plate(plate));
                System.out.println("Vehicle removed successfully!");
            }catch (Exception NoSuchElementException){
                System.out.println("Plate not found!");
            }
        }

    }

    private static void listVehicles() {
        User currUser = (User) BMS.currentUser;
        currUser.getAllVehicles();
    }

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

}
