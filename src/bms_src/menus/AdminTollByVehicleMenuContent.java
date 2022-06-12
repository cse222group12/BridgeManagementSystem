package bms_src.menus;

import bms_src.Pair;

public abstract class AdminTollByVehicleMenuContent {
    private static final String[] optionHeaders = new String[]{
            "AracTur1 icin bilet fiyati ayarla",
            "AracTur2 icin bilet fiyati ayarla",
            "AracTur3 icin bilet fiyati ayarla",
//            "ekstra ozellikler girilebilir",
//            "3",
    };

    private static final Runnable[] optionRunnables = new Runnable[]{
            AdminTollByVehicleMenuContent::setTollVehicle1,
            AdminTollByVehicleMenuContent::setTollVehicle2,
            AdminTollByVehicleMenuContent::setTollVehicle3
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);

    private static void setTollVehicle1() {
        /*
        TODO:
            Set tool vehicle 1
         */
    }

    private static void setTollVehicle2() {
        /*
        TODO:
            Set tool vehicle 1
         */
    }
    private static void setTollVehicle3() {
        /*
        TODO:
            Set tool vehicle 1
         */
    }
}
