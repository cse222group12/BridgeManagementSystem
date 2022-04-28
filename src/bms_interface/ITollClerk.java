package bms_interface;

import bms_src.Pass;
import bms_src.User;
import bms_src.Vehicle;

import java.util.Date;

public interface ITollClerk {

    /**
     * Checks if the passerby passenger from bridge is in the blacklist or there is not enough money on user's account so user can't check in.
     * @param user User reference
     * @return true or false
     */
    boolean validateUser(User user);

    /**
     * User logs in the bridge
     * @param user User reference
     * @param vehicle User's vehicle
     * @return Check in date
     */
    Date checkIn(User user, Vehicle vehicle);

    /**
     * User logs out from the bridge
     * @param user User reference
     * @param vehicle User's vehicle
     * @return Check out date
     */
    Date checkOut(User user, Vehicle vehicle);

    /**
     * Adds to history the pass when the vehicle check out
     * @param pass Pass reference includes vehicle, check in time and check out time
     */
    void addToPassSummary(Pass pass);

    /**
     * Toll clerk's revenue
     * @return revenue of toll clerk
     */
    int revenue();

}
