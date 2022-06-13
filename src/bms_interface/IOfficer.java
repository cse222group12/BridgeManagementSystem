package bms_interface;

import bms_src.Penalty;
import bms_src.User;

public interface IOfficer {

    /**
     * Send penalty to a user which is actually guilty driver
     * @param user User reference
     */
    void sendPenalty(Penalty penalty);

    /**
     * If somethings goes wrong edit the penalty
     *
     * @param oldPenalty Previous Penalty reference
     * @param newPenalty New Penalty reference
     * 
     */
    void editPenalty(Penalty oldPenalty,Penalty newPenalty);

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
