package bms_src;

import bms_src.menus.*;

import java.util.Scanner;
import java.util.Stack;

public class Menu {
    private final String header;
    private final Pair<String, Runnable>[] options;
    private Integer chosenOption;

    private static final Stack<Menu> menus = new Stack<>();

    public Menu(String _header, Pair<String, Runnable>[] _options){
        header = _header;
        options = _options;
    }

    public void focus() {
        // On execution of this function print this menu and wait for a user input.
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
            sb.append(i + 1).append(". ").append(this.options[i]).append("\n");
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
        menus.peek().focus();
        return index;
    }

    public static final Menu SuperAdminMenu = new Menu("Süper Admin Menüsü", SuperAdminMenuContent.options);
    public static final Menu SuperAdminViewHistory = new Menu("Etkinlik Geçmişi Menüsü", SuperAdminViewHistoryMenuContent.options);
    public static final Menu SuperAdminViewStaff = new Menu("Çalışan Kayıtları Menüsü", SuperAdminViewStaffMenuContent.options);
    public static final Menu SuperAdminBlacklist = new Menu("Blacklist Menüsü", SuperAdminBlacklistMenuContent.options);
    public static final Menu SuperAdminWhitelist = new Menu("Whitelist Menüsü", SuperAdminWhitelistMenuContent.options);
}
