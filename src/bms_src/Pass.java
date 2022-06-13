package bms_src;

import bms_interface.IPass;

import java.util.Date;

public class Pass implements IPass {
    private Date checkIn;
    private Date checkOut;
    private Vehicle vehicle;

    public Pass(Vehicle vehicle){
        checkIn = new Date();
        this.vehicle = vehicle;
    }

    public void setCheckOut(){
        checkOut = new Date();
    }
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
        return checkIn;
    }

    /**
     * Get the vehicle's check out time
     *
     * @return
     */
    @Override
    public Date getCheckOutTime() {
        return checkOut;
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
        checkIn = checkInTime;
    }

    /**
     * Get the vehicle's check out time
     *
     * @param checkOutTime
     */
    @Override
    public void setCheckOutTime(Date checkOutTime) {
        checkOut = checkOutTime;
    }
}
