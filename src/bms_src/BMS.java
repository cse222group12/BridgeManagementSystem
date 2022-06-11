package bms_src;

import bms_interface.IBMS;

public class BMS extends DataBase implements IBMS {
    public BMS(){
        Menu.push(Menu.Welcome);
    }
}
