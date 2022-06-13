package bms_src;

import bms_interface.IPenalty;

import java.util.Date;

public class Penalty  implements IPenalty, Comparable<Penalty> {


    //datafields
    private final String username;
    private final String plateNumber;
    private Date penalty_date;
    private double debt = 90;
    private String reason = "Traffic rules violation";

    //Constructors
    public Penalty(String username, String plateNumber) {
        this.username = username;
        this.plateNumber = plateNumber;
        penalty_date = new Date();
    }

    public Penalty(String username,String plateNumber,double debt) {
        this.username = username;
        this.plateNumber = plateNumber;
        this.debt = debt;
        penalty_date = new Date();
    }

    public Penalty(String username,String plateNumber,double debt, String reason) {
        this.username = username;
        this.plateNumber = plateNumber;
        this.debt = debt;
        this.reason = reason;
        penalty_date = new Date();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Date getPenalty_date() {
        return penalty_date;
    }

    public void setPenalty_date(Date penalty_date) {
        this.penalty_date = penalty_date;
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
    public String getUsername() {
        return username;
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
                "username='" + username + '\'' +
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
