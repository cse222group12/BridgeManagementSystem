package bms_src;

import bms_interface.IPenalty;

public class Penalty implements IPenalty {
    /**
     * Get the penalty reason
     *
     * @return reason of the penalty
     */
    @Override
    public String getReason() {
        return null;
    }

    /**
     * Get the penalty debt
     *
     * @return debt price
     */
    @Override
    public int getDebt() {
        return 0;
    }

    /**
     * Get the guilty driver
     *
     * @return guilty driver
     */
    @Override
    public User getDriver() {
        return null;
    }

    /**
     * Set the reason
     *
     * @param reason reason of penalty
     */
    @Override
    public void setReason(String reason) {

    }

    /**
     * Set the penalty debt
     *
     * @param debt debt price
     */
    @Override
    public void setDebt(int debt) {

    }

    /**
     * Set the guilty driver
     *
     * @param driver guilty driver
     */
    @Override
    public void setDriver(User driver) {

    }
}
