package testers;

import bms_interface.IVehicle;
import bms_src.Plate;
import bms_src.User;
import bms_src.Vehicle;

public class VehicleTest {
    public static void main(String[] args){
        User user = new User("Marshall M", "123213123");
        Vehicle v = new Vehicle(new Plate("34kv434"),user.getId_number(), IVehicle.Type.Truck);
        v.addPenalty(100);
        v.addPenalty(123);
        v.addPenalty(100,
                "asiri hiz");

        v.getPenalties();
        System.out.println(v.getOwnerId());

    }
}
