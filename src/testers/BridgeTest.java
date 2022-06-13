package testers;

import bms_interface.IVehicle;
import bms_src.*;

public class BridgeTest {
    public static void main(String args[]){
        int test = 2;
        //Create bridge
        Bridge bridge = new Bridge("FSM");
        //Create staff
        Staff a = new Officer("ofc1", "321");
        Officer b = new Officer("ofc2", "321");
        Staff c = new Admin("ofc3", "321");
        Staff d = new Officer("ofc4", "321");
        Staff e = new Officer("ofc5", "321");
        //add to worker ds
        bridge.addWorker(a);
        bridge.addWorker(b);
        bridge.addWorker(c);
        bridge.addWorker(d);
        bridge.addWorker(e);
        //create vehicles
        Vehicle v1 = new Vehicle(new Plate("44tk445"),a.getUsername(), IVehicle.Type.Truck);
        Vehicle v2 = new Vehicle(new Plate("44tk446"),a.getUsername(), IVehicle.Type.Automobile);
        Vehicle v3 = new Vehicle(new Plate("44tk447"),a.getUsername(), IVehicle.Type.Motorcycle);
        Vehicle v4 = new Vehicle(new Plate("44tk448"),a.getUsername(), IVehicle.Type.Bus);
        Vehicle v5 = new Vehicle(new Plate("44tk449"),a.getUsername(), IVehicle.Type.Minibus);

        //Create Passes
        Pass p1 = new Pass(v1);
        Pass p2 = new Pass(v2);
        Pass p3 = new Pass(v3);
        Pass p4 = new Pass(v4);
        Pass p5 = new Pass(v5);
        //add passes
        bridge.addPass(p1);
        bridge.addPass(p2);
        bridge.addPass(p3);
        bridge.addPass(p4);
        bridge.addPass(p5);
        //get passes and set checkOut date
        bridge.getPass(p1.getCheckInTime()).setCheckOut();
        bridge.getPass(p2.getCheckInTime()).setCheckOut();
        bridge.getPass(p3.getCheckInTime()).setCheckOut();
        bridge.getPass(p4.getCheckInTime()).setCheckOut();
        bridge.getPass(p5.getCheckInTime()).setCheckOut();





            if (test == 1) {

                //check get methods
                bridge.getAWorker(a);
                bridge.getAWorker("ofc1");

                //check all showAllWorkers method
                System.out.println(bridge.showAllWorkers());
            }

            else if (test==2){
                System.out.println("ssssssssssss");

                bridge.printAllPassHistory();

                System.out.println("size: " + bridge.getPassTime());
            }



    }
}
