package bms_src;

import Jgraph.JGraph;
import bms_interface.IBMS;
import koffman_src.AVLTree;
import koffman_src.HashtableChain;

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
        Menu.push(Menu.Welcome);

    }
}
