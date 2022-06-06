package bms_src;

import bms_interface.ITollClerk;

import java.util.Date;

public class TollClerk extends Staff implements ITollClerk {

    public TollClerk(String staff_name, String id_number) {
        super(staff_name, id_number);
    }

    /**
     * Checks if the passerby passenger from bridge is in the blacklist or there is not enough money on user's account so user can't check in.
     *
     * @param user User reference
     * @return true or false
     */
    @Override
    public boolean validateUser(User user) {
        return false;
    }

    /**
     * User logs in the bridge
     *
     * @param user    User reference
     * @param vehicle User's vehicle
     * @return Check in date
     */
    @Override
    public Date checkIn(User user, Vehicle vehicle) {
        return null;
    }

    /**
     * User logs out from the bridge
     *
     * @param user    User reference
     * @param vehicle User's vehicle
     * @return Check out date
     */
    @Override
    public Date checkOut(User user, Vehicle vehicle) {
        return null;
    }

    /**
     * Adds to history the pass when the vehicle check out
     *
     * @param pass Pass reference includes vehicle, check in time and check out time
     */
    @Override
    public void addToPassSummary(Pass pass) {

    }

    /**
     * Toll clerk's revenue
     *
     * @return revenue of toll clerk
     */
    @Override
    public int revenue() {
        return 0;
    }
}
