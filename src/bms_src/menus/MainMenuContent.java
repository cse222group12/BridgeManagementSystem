package bms_src.menus;

import bms_src.Pair;

public abstract class MainMenuContent {

    private static final String[] optionHeaders = new String[]{
            "Giriş yap",
            "Kayıt ol",
    };

    // TODO: Implement proper functions
    private static final Runnable[] optionRunnables = new Runnable[]{
            () -> {},
            () -> {},
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);
}
