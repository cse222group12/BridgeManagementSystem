package bms_src;

import Jgraph.JGraph;
import bms_interface.IBMS;
import koffman_src.AVLTree;
import koffman_src.HashtableChain;

import java.util.Stack;
import java.util.function.Function;

public class BMS extends DataBase implements IBMS {
    HashtableChain<String,Person> persons;

    JGraph<City,Integer> cities;

    AVLTree<Vehicle> blackListVehicles;

    public BMS(){
        persons = new HashtableChain<>();
        cities = new JGraph<>();

        SuperAdmin superAdmin = new SuperAdmin("GOD", "0000");




        String userLabel = null;
        Stack<Menu> demo = new Stack<>();
        demo.push(null);
        while(!demo.isEmpty()){
            System.out.println(demo.peek());
            int opt = demo.peek().getChosenOption();
            if(opt == -1) demo.pop();
            else if (opt < 0 )
                System.out.println("Invalid argument!");
            else {
                System.out.println(opt); //take the opt and choose the operation
            }
        }
    }
}
