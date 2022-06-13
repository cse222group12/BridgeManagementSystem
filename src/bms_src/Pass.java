package bms_src;

import bms_interface.IPass;

import java.util.Date;

public class Pass implements IPass {

    private Vehicle vehicle;
    private Date checkInTime, checkOutTime;

    /**
     * Get the vehicle
     *
     * @return
     */
    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Get the vehicle's check in time
     *
     * @return
     */
    @Override
    public Date getCheckInTime() {
        return checkInTime;
    }

    /**
     * Get the vehicle's check out time
     *
     * @return
     */
    @Override
    public Date getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * Set the vehicle
     *
     * @param vehicle
     */
    @Override
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Set the vehicle's check in time
     *
     * @param checkInTime
     */
    @Override
    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * Get the vehicle's check out time
     *
     * @param checkOutTime
     */
    @Override
    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    // TODO:
    // May want a better format.
    @Override
    public String toString() {
        return vehicle + ", " + checkInTime + "-" + checkOutTime;
    }
}
