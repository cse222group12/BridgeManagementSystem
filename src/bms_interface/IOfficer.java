package bms_interface;

import bms_src.Penalty;
import bms_src.User;

public interface IOfficer {

    /**
     * Send penalty to a user which is actually guilty driver
     * @param user User reference
     * @param penalty Penalty that is going to user
     */
    void sendPenalty(User user, Penalty penalty);

    /**
     * If somethings goes wrong edit the penalty
     * @param penalty Penalty reference
     */
    void editPenalty(Penalty penalty);

    /**
     * Get the current speed limit
     * @return speed limit
     */
    int getSpeedLimit();

    /**
     * Set the speed limit according to the conditions of the day and traffic rules
     * @param speedLimit new speed limit
     */
    void setSpeedLimit(int speedLimit);

}
