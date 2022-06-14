package bms_src;

import Jgraph.JGraph;
import bms_interface.IBMS;
import bms_interface.IVehicle;
import data_structures.BinarySearchTree;
import koffman_src.AVLTree;
import koffman_src.HashtableChain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BMS extends DataBase implements IBMS {
    public static Person currentUser;
    protected static HashtableChain<String,Person> persons=new HashtableChain<>();; //TODO it could be private, protected for testing

    protected static JGraph<City,Integer> cities;

    AVLTree<Vehicle> blackListVehicles;
    private static TreeSet<Plate> blacklistPlates = new TreeSet<>();



    public BMS(){
        persons = new HashtableChain<>();
        cities = new JGraph<>();
        currentUser = null;

        SuperAdmin superAdmin = new SuperAdmin("presidentobama", "991");
        User user1 = new User("dumbuser","0000");
        user1.addToBalance(112.12);

        TollClerk tollClerk = new TollClerk("tcmahmut","4141");
        Officer officer = new Officer("jakeperalta", "3434");
        Admin admin = new Admin("a","a");

        user1.addVehicle(new Vehicle(new Plate("16BYGT34"), "dumbuser", IVehicle.Type.Automobile));
        user1.addVehicle(new Vehicle(new Plate("16BYGT35"), "dumbuser", IVehicle.Type.Truck));
        user1.addVehicle(new Vehicle(new Plate("16BYGT33"), "dumbuser", IVehicle.Type.Bus));





        persons.put(superAdmin.getUsername(),superAdmin);
        persons.put(user1.getUsername(), user1);
        persons.put(tollClerk.getUsername(),tollClerk);
        persons.put(officer.getUsername(),officer);
        persons.put(admin.getUsername(),admin);
        officer.sendPenalty(new Penalty("dumbuser", "16BYGT34"));
        officer.sendPenalty(new Penalty("dumbuser", "16BYGT33"));
        officer.sendPenalty(new Penalty("dumbuser", "16BYGT35"));

        //
        City Istanbul = new City("Istanbul");
        Bridge fsm = new Bridge("FSM", 1000);
        Bridge yss = new Bridge("YSS", 3000);
        Istanbul.addBridge(fsm);
        Istanbul.addBridge(yss);
        admin.setCity_name("Istanbul");
        Istanbul.setAdmin(admin);
        cities.addNode(Istanbul);
        //


        //-----------------------------SuperAdmin Tests
        MainSystem.addBlackList(new Plate.Turkey("54ERE123"));

        MainSystem.addPerson(new User("Kelek", "1453"));

        City istanbul = new City("Istanbul");
        Bridge fsmBridge = new Bridge("Fatih Sultan Mehmet Bridge");

        IVehicle.Type[] vehicleTypes = IVehicle.Type.values();
        Pass[] passes = new Pass[20];
        Arrays.setAll(passes, (i) -> new Pass(new Vehicle(new Plate("GP" + i), "", vehicleTypes[i % vehicleTypes.length])));

        int i = 0;
        for (Pass pass : passes) {
            pass.setCheckInTime(Date.from(Instant.now().minus(2L * i + 1, ChronoUnit.HALF_DAYS)));
            pass.setCheckOutTime(Date.from(Instant.now().minus(i, ChronoUnit.DAYS)));
            fsmBridge.addPass(pass);
            i += i + 1;
        }

        istanbul.addBridge(fsmBridge);
        MainSystem.addCity(istanbul);

        for (i = 0; i < 20; i++) {
            switch (i % 3) {
                case 0 -> fsmBridge.addWorker(new TollClerk("TC" + 3 * i, Integer.toString(3 * i)));
                case 1 -> fsmBridge.addWorker(new Officer("OF" + (3 * i + 1), Integer.toString(3 * i + 1)));
                case 2 -> fsmBridge.addWorker(new Admin("AD" + (3 * i + 2), Integer.toString(3 * i + 2)));
            }
        }
        //-----------------------------SuperAdmin Tests

        cities.addNode(new City("Istanbul"));
        Menu.push(Menu.Welcome);

    }


    public static void addCity(City aCity){
        cities.addNode(aCity);
    }

    public static Iterator<City> getCityIterator() {
        return cities.getNodes().iterator();
    }

    public static int getNumCity() {
        return cities.size();
    }

    public static City getCity(String cityName) {
        return cities.getNode(new City(cityName));
    }

    /**
     * A method that put the person in the hash table
     * @param person that is want to add
     * @return person
     */
    public static Person addPerson(Person person){
        return persons.put(person.getUsername(),person);
    }

    /**
     * A method that put the person in the hash table
     * @param person that is want to remove
     * @return person
     */
    public static Person removePerson(Person person){
        return persons.remove(person.getUsername());
    }

    /**
     * A method that add vehicle to blackList
     * @param plate which wanted to add blackList
     */
    public static boolean addBlackList(Plate plate){
        return blacklistPlates.add(plate);
    }


    /**
     * A method that remove vehicle to blackList
     * @param plate which wanted to remove blackList
     * @return      true if this set contained the specified element
     */
    public static boolean removeBlackList(Plate plate){
        return blacklistPlates.remove(plate);
    }

    public static Iterator<Plate> blacklistIterator() {
        return blacklistPlates.iterator();
    }

    /**
     * A method that get person from db
     * @param id person`s id
     * @return Person if exist
     *              else return null
     */
    public static Person getPerson(String id){
        return persons.get(id);
    }

}
