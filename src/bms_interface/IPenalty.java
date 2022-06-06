package bms_interface;

import bms_src.User;

public interface IPenalty {

    /**
     * Get the penalty reason
     * @return reason of the penalty
     */
    String getReason();

    /**
     * Get the penalty debt
     * @return debt price
     */
    double getDebt();

    /**
     * Get the guilty driver
     * @return guilty driver
     */
    String getDriverID();

    /**
     * Set the reason
     * @param reason reason of penalty
     */
    void setReason(String reason);

    /**
     * Set the penalty debt
     * @param debt debt price
     */
    void setDebt(double debt);

}
