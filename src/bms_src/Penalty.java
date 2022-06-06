package bms_src;

import bms_interface.IPenalty;

public class Penalty  implements IPenalty, Comparable<Penalty> {


    //datafields
    private final String driverId;
    private final String plateNumber;
    private double debt = 0;
    private String reason = "Traffic rules violation";

    //Constructors
    public Penalty(String driverId, String plateNumber) {
        this.driverId = driverId;
        this.plateNumber = plateNumber;
    }

    public Penalty(String driverId,String plateNumber,double debt) {
        this.driverId = driverId;
        this.plateNumber = plateNumber;
        this.debt = debt;
    }

    public Penalty(String driverId,String plateNumber,double debt, String reason) {
        this.driverId = driverId;
        this.plateNumber = plateNumber;
        this.debt = debt;
        this.reason = reason;
    }

    /**
     * Get the penalty reason
     *
     * @return reason of the penalty
     */
    @Override
    public String getReason() {
        return reason;
    }

    /**
     * Get the penalty debt
     *
     * @return debt price
     */
    @Override
    public double getDebt() {
        return debt;
    }

    /**
     * Get the guilty driver
     *
     * @return guilty driver
     */
    @Override
    public String getDriverID() {
        return driverId;
    }

    /**
     * Set the reason
     *
     * @param reason reason of penalty
     */
    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Set the penalty debt
     *
     * @param debt debt price
     */
    @Override
    public void setDebt(double debt) {
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "driverId='" + driverId + '\'' +
                ", debt=" + debt +
                ", reason='" + reason + '\'' +
                '}';
    }

    @Override
    public int compareTo(Penalty o) {
        if (o.getDebt()>debt)
            return 1;
        else if (o.getDebt() == debt)
            return 0;

        return -1;
    }
}
