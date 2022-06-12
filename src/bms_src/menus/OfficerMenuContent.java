package bms_src.menus;

import bms_src.Menu;
import bms_src.Pair;

public class OfficerMenuContent
{ 

    private static final String[] optionHeaders = new String[] {
        "Ceza Yaz",
        "Ceza Düzenle",
        "Hız Sınırını Düzenle",
        "Güncel Hız Sınırını Göster",
        "Geri dön",
    };

    private static final Runnable[] optionRunnables = new Runnable[] {
        OfficerMenuContent::sendPenalty,
        OfficerMenuContent::editPenalty,
        OfficerMenuContent::editSpeedLimit,
        OfficerMenuContent::checkSpeedLimit,
        Menu::pop,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);


    private static void sendPenalty() {
        /*
            TODO: 
            Wait for officer to enter penalty info and send the penalty.
        */
    }

    private static void editPenalty() {
        /*
            TODO:
            Wait for officer to enter the previous and new penalty info and edit the penalty.
        */
    }

    private static void editSpeedLimit() {
        /*
            TODO:
            Wait for officer to enter the new speed limit and change the current speed limit.
        */
    }

    private static void checkSpeedLimit() {
        /*
            TODO:
            Print the current speed limit.
        */
    }

}

