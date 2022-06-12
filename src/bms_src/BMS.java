package bms_src;

import Jgraph.JGraph;
import bms_interface.IBMS;
import koffman_src.AVLTree;
import koffman_src.HashtableChain;

import java.util.Stack;

public class BMS extends DataBase implements IBMS {
    HashtableChain<String,Person> persons;

    JGraph<City,Integer> cities;

    AVLTree<Vehicle> blackListVehicles;

    public BMS(){

        Menu.push(Menu.Welcome);
        persons = new HashtableChain<>();
        cities = new JGraph<>();

        SuperAdmin superAdmin = new SuperAdmin("GOD", "123");
        User user1 = new User("bygt","0000");
        TollClerk tollClerk = new TollClerk("gisememur123","4141");
        Officer officer = new Officer("mesutkomiser", "3434");
        persons.put(superAdmin.getUsername(),superAdmin);
        persons.put(user1.getUsername(), user1);
        persons.put(tollClerk.getUsername(),tollClerk);
        System.out.println(Menu.pop());



    }
}
