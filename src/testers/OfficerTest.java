package testers;

import bms_interface.IVehicle;
import bms_src.BMS;
import bms_src.Officer;
import bms_src.Penalty;
import bms_src.Plate;
import bms_src.User;
import bms_src.Vehicle;

public class OfficerTest {
    
    public static void main(String[] args) throws Exception {
        //Create user
        User user = new User("AhmetCakar",
                "9213214214");

        BMS.addPerson(user);

        //Create Vehicles to use user`s functions
        Vehicle v1 = new Vehicle(new Plate("41dy69"),user.getUsername(), IVehicle.Type.Automobile);
        Vehicle v2 = new Vehicle(new Plate("34op333"),user.getUsername(), IVehicle.Type.Automobile);
        Vehicle v3 = new Vehicle(new Plate("zzzzzzzzzzzzz"),user.getUsername(), IVehicle.Type.Automobile);
        Vehicle v4 = new Vehicle(new Plate("31di31"),user.getUsername(), IVehicle.Type.Truck);
        Vehicle v5 = new Vehicle(new Plate("32mi51"),user.getUsername(), IVehicle.Type.Automobile);

        user.addVehicle(v1);
        user.addVehicle(v2);
        user.addVehicle(v3);
        user.addVehicle(v4);
        user.addVehicle(v5);
        System.out.println("After Added Plates");
        user.showAllPlates();

        Officer officer = new Officer("Rıza Baba", "5445");

        Penalty p0 = new Penalty("invaliduser", "32mi51", 120);
        Penalty p1 = new Penalty(user.getUsername(), "32mi51", 120);
        Penalty p2 = new Penalty(user.getUsername(), "32mi51", 70);
        Penalty p3 = new Penalty(user.getUsername(), "41dy69", 85);
        Penalty p4 = new Penalty(user.getUsername(), "invalidplate",90);
        Penalty p5 = new Penalty(user.getUsername(), "32mi51", 150,"speeding violation");

        officer.sendPenalty(p0);
        officer.sendPenalty(p1);
        officer.sendPenalty(p2);
        officer.sendPenalty(p3);
        officer.sendPenalty(p4);
        officer.sendPenalty(p5);

        System.out.println("\nPenalties of " + v1.getPlate());
        v1.printPenalties();

        System.out.println("\nPenalties of " + v5.getPlate());
        v5.printPenalties();

        System.out.println("\nTotal debt of " + user.getUsername() + " : " + user.getDebt());

        Penalty p6 = new Penalty(user.getUsername(), "32mi51", 50);

        officer.editPenalty(p5, p6);
        officer.editPenalty(p4, p0);

        System.out.println("\nAfter editing a penalty of " + v5.getPlate());
        v5.printPenalties();

        System.out.println("\nTotal debt of " + user.getUsername() + " : " + user.getDebt());

        System.out.println("Current speed limit : " + officer.getSpeedLimit());

        officer.setSpeedLimit(120);
        officer.setSpeedLimit(-90);

        System.out.println("After editing the speed limit : " + officer.getSpeedLimit());

    }


}
