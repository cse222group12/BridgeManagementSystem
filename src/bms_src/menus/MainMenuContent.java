package bms_src.menus;

import bms_src.Pair;

public abstract class MainMenuContent {

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
        System.out.println("Signed up");
    }

    public static void login(){
        System.out.println("Logged up");


    }

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
