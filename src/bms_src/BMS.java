package bms_src;

import bms_interface.IBMS;

import java.util.Stack;
import java.util.function.Function;

public class BMS extends DataBase implements IBMS {
    public BMS(){


        Stack<Menu> demo = new Stack<>();


        demo.push(new Menu("Welcome to the Bridge Management System v1.2.2", new String[]{"Login", "Sign in"}));
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
