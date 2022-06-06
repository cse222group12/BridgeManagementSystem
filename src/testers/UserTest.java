package testers;

import bms_interface.IVehicle;
import bms_src.Plate;
import bms_src.User;
import bms_src.Vehicle;

import javax.sound.sampled.AudioFileFormat;

/**
 *  A method that test Users class Functions
 */
public class UserTest {
    public static void main(String[] args) throws Exception {
        //Create user
        User a_user = new User("AhmetCakar",
                "9213214214");

        //Create Vehicles to use user`s functions
        Vehicle v1 = new Vehicle(new Plate("41dy69"),a_user.getId_number(), IVehicle.Type.Automobile);
        Vehicle v2 = new Vehicle(new Plate("34op333"),a_user.getId_number(), IVehicle.Type.Automobile);
        Vehicle v3 = new Vehicle(new Plate("zzzzzzzzzzzzz"),a_user.getId_number(), IVehicle.Type.Automobile);
        Vehicle v4 = new Vehicle(new Plate("31di31"),a_user.getId_number(), IVehicle.Type.Truck);
        Vehicle v5 = new Vehicle(new Plate("32mi51"),a_user.getId_number(), IVehicle.Type.Automobile);

        a_user.addVehicle(v1);
        a_user.addVehicle(v2);
        a_user.addVehicle(v3);
        a_user.addVehicle(v4);
        a_user.addVehicle(v5);
        System.out.println("After Added Plates");
        a_user.showAllPlates();

        /**
         * Removes  platenumber: zzzzzzzzzzzzz and plate v1
         */
        a_user.removeVehicle(v1);
        a_user.removeVehicle(new Plate("zzzzzzzzzzzzz"));

        System.out.println("After removed plates:");
        a_user.showAllPlates();

    }
}
