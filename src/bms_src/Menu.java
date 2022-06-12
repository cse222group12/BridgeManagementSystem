package bms_src;

import bms_src.menus.*;

import java.util.Scanner;
import java.util.Stack;

public class Menu {
    private final String header;
    private final Pair<String, Runnable>[] options;
    private Integer chosenOption;

    private boolean defaultReturn;
    private String returnOptionHeader;

    private static final Stack<Menu> menus = new Stack<>();

    /**
     * Constructs a menu as in the form of:
     * HEADER
     * OPTION1
     * OPTION2
     * ...
     * Where HEADER is given <code>_header</code> and list of options is given <code>_options</code>.
     * @param _header   Header text of menu.
     * @param _options  Array of option pairs consisting of their headers and functions to execute upon selection.
     */
    public Menu(String _header, Pair<String, Runnable>[] _options){
        header = _header;
        options = _options;
        defaultReturn = false;
    }

    /**
     * Constructs a menu but with an extra option at the end with the number zero before it, that always upon selection
     * returns to the previous menu.
     * @see Menu
     * @param _header               Header text of menu.
     * @param _options              Array of option pairs consisting of their headers and functions to execute upon selection.
     * @param returnOptionHeader    The header of the last extra option that returns to the previous menu.
     */
    public Menu(String _header, Pair<String, Runnable>[] _options, String returnOptionHeader){
        header = _header;
        options = _options;
        defaultReturn = true;
        this.returnOptionHeader = returnOptionHeader;
    }

    /**
     * Displays this menu.
     */
    private void focus() {
        while (!menus.isEmpty() && menus.peek().equals(this)) {
            System.out.println(header);

            int i = defaultReturn ? 1 : 0;

            for (Pair<String, Runnable> option : options) {
                System.out.println(i + ") " + option.getKey());
                i++;
            }

            if (defaultReturn) {
                System.out.println("0) " + returnOptionHeader);
            }

            chosenOption = new Scanner(System.in).nextInt();


            if (defaultReturn) {
                if (chosenOption == 0) {
                    pop();
                    continue;
                }
                chosenOption--;
            }

            if (chosenOption > -1 && chosenOption < options.length) {
                options[chosenOption].getValue().run();
            }
        }
    }

    public Integer getChosenOption(){
        Scanner _option = new Scanner(System.in);
        String _chosenOption = _option.next();
        int a = 0;
        try {
            a = Integer.parseInt(_chosenOption);
        }catch (NumberFormatException e){
            return -2;
        }

        if(a > 0 && a <= options.length){
            return a;
        }
        else if( a == options.length + 1){
            return -1;
        }

        return -2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n");
        for(int i = 0 ; i < this.options.length; i++){
            sb.append(i + 1).append(". ").append(this.options[i].getKey()).append("\n");
        }
        sb.append(options.length + 1).append(". Exit");
        return sb.toString();
    }

    /**
     * Display given menu.
     * @param menu  Menu to be displayed.
     */
    public static void push(Menu menu) {
        menus.push(menu);
        menu.focus();
    }

    /**
     * Close current menu and display the previous one.
     * @return  Index of last chosen option in the closed menu.
     */
    public static int pop() {
        int index = menus.pop().chosenOption;
        if (!menus.isEmpty()) menus.peek().focus();
        return index;
    }

    // TODO: Make a proper main menu.
    public static final Menu Welcome = new Menu("Welcome to HGS", MainMenuContent.options, "Exit");


    public static final Menu SuperAdmin = new Menu("Süper Admin Menüsü", SuperAdminMenuContent.options, "Go back");
    public static final Menu SuperAdminViewHistory = new Menu("Etkinlik Geçmişi Menüsü", SuperAdminViewHistoryMenuContent.options, "Go back");
    public static final Menu SuperAdminViewStaff = new Menu("Çalışan Kayıtları Menüsü", SuperAdminViewStaffMenuContent.options, "Go back");
    public static final Menu SuperAdminBlacklist = new Menu("Blacklist Menüsü", SuperAdminBlacklistMenuContent.options, "Go back");
    public static final Menu SuperAdminWhitelist = new Menu("Whitelist Menüsü",
            SuperAdminWhitelistMenuContent.options, "Go back");



    public static final Menu User = new Menu("User menu:", UserMenuContent.options, "Go back");
    public static final Menu UserVehicles = new Menu("Your vehicles:", UserVehiclesMenuContent.options, "Go back");

    public static final Menu TollClerk = new Menu("Toll Clerk Menu", TollClerkMenuContent.options, "Go back");

    public static final Menu Officer = new Menu("Officer Menu", OfficerMenuContent.options, "Go back");


    //Admin
    public static final Menu Admin = new Menu("Admin Menusu",
            AdminMenuContent.options, "Go back");
    public static final Menu AdminTollByVehicle = new Menu("Bilet Fiyat Menusu",
            AdminTollByVehicleMenuContent.options, "Go back");
    public static final Menu AdminViewHistory = new Menu("Etkinlik Gecmisi",
            AdminViewHistoryMenuContent.options, "Go back");
    public static final Menu AdminViewStaff = new Menu("Calisanlar",
            AdminViewStaffMenuContent.options, "Go back");
}

