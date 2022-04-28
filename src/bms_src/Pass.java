package bms_src;

import bms_interface.IPass;

import java.util.Date;

public class Pass implements IPass {
    /**
     * Get the vehicle
     *
     * @return
     */
    @Override
    public Vehicle getVehicle() {
        return null;
    }

    /**
     * Get the vehicle's check in time
     *
     * @return
     */
    @Override
    public Date getCheckInTime() {
        return null;
    }

    /**
     * Get the vehicle's check out time
     *
     * @return
     */
    @Override
    public Date getCheckOutTime() {
        return null;
    }

    /**
     * Set the vehicle
     *
     * @param vehicle
     */
    @Override
    public void setVehicle(Vehicle vehicle) {

    }

    /**
     * Set the vehicle's check in time
     *
     * @param checkInTime
     */
    @Override
    public void setCheckInTime(Date checkInTime) {

    }

    /**
     * Get the vehicle's check out time
     *
     * @param checkOutTime
     */
    @Override
    public void setCheckOutTime(Date checkOutTime) {

    }
}
