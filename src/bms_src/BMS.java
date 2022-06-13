package bms_src;

import Jgraph.JGraph;
import bms_interface.IBMS;
import bms_interface.IVehicle;
import data_structures.BinarySearchTree;
import koffman_src.AVLTree;
import koffman_src.HashtableChain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Stack;

public class BMS extends DataBase implements IBMS {
    public static Person currentUser;
    protected static HashtableChain<String,Person> persons; //TODO it could be private, protected for testing

    JGraph<City,Integer> cities;

    AVLTree<Vehicle> blackListVehicles;



    public BMS(){
        persons = new HashtableChain<>();
        cities = new JGraph<>();
        currentUser = null;

        SuperAdmin superAdmin = new SuperAdmin("GOD", "123");
        User user1 = new User("bygt","0000");
        user1.addToBalance(112.12);

        TollClerk tollClerk = new TollClerk("gisememur123","4141");
        Officer officer = new Officer("mesutkomiser", "3434");
        Admin admin = new Admin("bursa","12344");
        persons.put(superAdmin.getUsername(),superAdmin);
        persons.put(user1.getUsername(), user1);
        persons.put(tollClerk.getUsername(),tollClerk);
        persons.put(officer.getUsername(),officer);
        persons.put(admin.getUsername(),admin);

        //-----------------------------SuperAdmin Tests
        MainSystem.addBlackList(new Plate.Turkey("54ERE123"));

        City istanbul = new City("Istanbul");
        Bridge fsmBridge = new Bridge("Fatih Sultan Mehmet Bridge");

        Pass[] passes = new Pass[20];
        Arrays.setAll(passes, (i) -> new Pass());

        IVehicle.Type[] vehicleTypes = IVehicle.Type.values();
        int i = 0;
        for (Pass pass : passes) {
            pass.setVehicle(new Vehicle(new Plate("GP" + i), "", vehicleTypes[(int) (i % vehicleTypes.length)]));
            pass.setCheckInTime(Date.from(Instant.now().minus(2L * i + 1, ChronoUnit.HALF_DAYS)));
            pass.setCheckOutTime(Date.from(Instant.now().minus(i, ChronoUnit.DAYS)));
            fsmBridge.getPassHistory().add(ComparableDate.from(pass.getCheckInTime()), pass);
            i += i + 1;
        }

        istanbul.getBridges().add(fsmBridge);
        MainSystem.addCity(istanbul);

        BinarySearchTree<Staff> staff = fsmBridge.getWorkers();

        for (i = 0; i < 20; i++) {
            switch (i % 3) {
                case 0 -> staff.add(new TollClerk("TC" + 3 * i, Integer.toString(3 * i)));
                case 1 -> staff.add(new Officer("OF" + (3 * i + 1), Integer.toString(3 * i + 1)));
                case 2 -> staff.add(new Admin("AD" + (3 * i + 2), Integer.toString(3 * i + 2)));
            }
        }

        //-----------------------------SuperAdmin Tests

        Menu.push(Menu.Welcome);

    }
}
