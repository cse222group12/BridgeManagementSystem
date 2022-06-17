package bms_src.menus;

import bms_src.*;

import java.util.*;
import java.util.function.Function;

public class AdminViewStaffMenuContent {

    private static final Set<Class<? extends Staff>> staffTypes = new HashSet<>();


    private static final String[] optionHeaders = new String[]{
            "List",
            "Search",
            "Update Staff",
            "Add Staff",
            "Remove Staff",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminViewStaffMenuContent::printStaffList,
            AdminViewStaffMenuContent::printSearchList,
            AdminViewStaffMenuContent::updateStaff,
            AdminViewStaffMenuContent::addStaff,
            AdminViewStaffMenuContent::removeStaff,

    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);




    private static void printStaffList() {
        printStaffListOnCondition(staff -> true);
    }

    private static void printSearchList() {
        String userInput = "\n";
        Scanner scanner = new Scanner(System.in);

        while (userInput.equals("\n")) {
            userInput = scanner.nextLine();
        }

        String finalUserInput = userInput;
        printStaffListOnCondition(staff -> staff.getUsername().contains(finalUserInput));

    }

    private static Staff getStaff(){
        printStaffList();
        System.out.println("Input the username of staff: ");
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        String str= sc.next();

        return (Staff) BMS.getPerson(str);
    }

    private static void updateStaff() {
        int i = 0;
        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());
        Staff staff = getStaff();
        if (staff == null)
            System.out.println("Wrong Input please try again!");
        else{
            staff.fillInfo();
            System.out.println("Staff info Updated!");
        }

    }

    private static void removeStaff() {
        int i = 0;
        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());
        Staff staff = getStaff();
        Bridge bridge =selectBridge();
        if (staff == null)
            System.out.println("Wrong Input please try again!");
        else{
            BMS.removePerson(staff);
            bridge.removeAWorker(staff);
            System.out.println("Staff info Updated!");
        }

    }

    private static void printStaffListOnCondition(Function<Staff, Boolean> condition) {
        System.out.println("List of valid staff members:");
        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());
        for (Bridge bridge : city.getBridges()) {
                bridge.getWorkers().inOrderTraverse((staff, integer) -> {
                    if (staff == null);
                        else if (staffTypes.isEmpty() || staffTypes.contains(staff.getClass())) {
                            if (condition.apply(staff)) {
                                System.out.println(staff);
                            }
                        }
                });
        }
    }

    private static Bridge selectBridge(){
        Admin admin = (Admin) BMS.currentUser;
        City city = BMS.getCity(admin.getCity_name());

        for (Bridge bridge :
                city.getBridges()) {
            System.out.println("Bridge :" + bridge.getName());
        }

        System.out.println("Input the Bridge name: ");
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        String str= sc.next();   //reads string before the space

        for (Bridge bridge :
                city.getBridges()) {
            if (bridge.getName().equals(str))
                return bridge;
        }

        return null;

    }

    private static void addStaff() {
        Bridge bridge = selectBridge();
        if (bridge == null){
            System.out.println("Wrong input! Try Again");
            return;
        }

        System.out.println("Input the keyletter for staff" +
                "\n(for tollclerk :t, officer: o)\nInput: ");
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        String str= sc.next();   //reads string before the space

        char ch = str.charAt(0);
        Staff newStaff = null;

        if (ch=='t' || ch=='T'){
            newStaff = new TollClerk();
            newStaff.fillInfo();
        }
        else if (ch=='o' || ch=='O'){
            newStaff = new Officer();
            newStaff.fillInfo();
        }

        if (newStaff == null){
            System.out.println("Sory Dude Wrong Input!");
        }

        else{
            BMS.addPerson(newStaff);
            bridge.addWorker(newStaff);
            System.out.println(newStaff +" added succesfully!");
        }

    }
}
