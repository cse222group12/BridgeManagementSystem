package testers;

import bms_src.Admin;
import bms_src.Bridge;
import bms_src.Officer;
import bms_src.Staff;

public class BridgeTest {
    public static void main(String args[]){
        //Create bridge
        Bridge bridge = new Bridge("FSM");
        //Create staff
        Staff a = new Officer("ofc1","321");
        Officer b = new Officer("ofc2","321");
        Staff c = new Admin("ofc3","321");
        Staff d = new Officer("ofc4","321");
        Staff e = new Officer("ofc5","321");
        //add to worker ds
        bridge.addWorker(a);
        bridge.addWorker(b);
        bridge.addWorker(c);
        bridge.addWorker(d);
        bridge.addWorker(e);
        //check get methods
        bridge.getAWorker(a);
        bridge.getAWorker("ofc1");

        //check all showAllWorkers method
        System.out.println(bridge.showAllWorkers());



    }
}
