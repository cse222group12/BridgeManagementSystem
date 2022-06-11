package bms_src;

import bms_interface.IOfficer;

public class Officer extends Staff implements IOfficer {

    public Officer(String username, String password) {
        super(username, password);
    }

    /**
     * Send penalty to a user which is actually guilty driver
     *
     * @param user    User reference
     * @param penalty Penalty that is going to user
     */
    @Override
    public void sendPenalty(User user, Penalty penalty) {

    }

    /**
     * If somethings goes wrong edit the penalty
     *
     * @param penalty Penalty reference
     */
    @Override
    public void editPenalty(Penalty penalty) {

    }

    /**
     * Get the current speed limit
     *
     * @return speed limit
     */
    @Override
    public int getSpeedLimit() {
        return 0;
    }

    /**
     * Set the speed limit according to the conditions of the day and traffic rules
     *
     * @param speedLimit new speed limit
     */
    @Override
    public void setSpeedLimit(int speedLimit) {

    }
}
