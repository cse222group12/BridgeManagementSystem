package bms_src.menus;

import bms_src.*;

import java.util.Objects;
import java.util.Scanner;

public abstract class MainMenuContent extends BMS {

    private static final String[] optionHeaders = new String[]{
            "Login",
            "Sign up",
    };

    // TODO: Implement proper functions
    private static final Runnable[] optionRunnables = new Runnable[]{
            MainMenuContent::login,
            MainMenuContent::signUp,
    };

    private static void signUp() {
        String username,password;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new username: ");
        username = sc.next();
        if(persons.get(username) != null){
            System.out.println("This username is alreay taken. Please try again!!");
        }
        else {
            System.out.println("Enter your password: ");
            password = sc.next();
            User newUser = new User(username, password);
            persons.put(username,newUser);
        }
    }

    public static void login(){
        String username = null;
        String password = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        username = sc.next();

        System.out.println("Enter your password: ");
        password = sc.next();

       BMS.currentUser = persons.get(username);

       if(BMS.currentUser == null){
           System.out.println("User not found!");
       }

       else if(Objects.equals(BMS.currentUser.getPassword(), password)){

           String label = BMS.currentUser.getLabel();
           if(Objects.equals(label, "user")){
               Menu.push(Menu.User);
           }

           else if(Objects.equals(label, "super_admin")){
               Menu.push(Menu.SuperAdmin);
           }

           else if (Objects.equals(label, "toll_clerk")){
               Menu.push(Menu.TollClerk);
           }

           else if (Objects.equals(label, "officer")){
               Menu.push(Menu.Officer);
           }
           else if(Objects.equals(label, "normal_admin")){
               Menu.push(Menu.Admin);
           }


       }

       else {
           System.out.println("Password is wrong. Please try again!");
       }

    }

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
