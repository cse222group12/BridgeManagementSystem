package bms_interface;

import bms_src.Vehicle;

import java.util.Date;

public interface IPass {

    /**
     * Get the vehicle
     * @return
     */
    Vehicle getVehicle();

    /**
     * Get the vehicle's check in time
     * @return
     */
    Date getCheckInTime();

    /**
     * Get the vehicle's check out time
     * @return
     */
    Date getCheckOutTime();

    /**
     * Set the vehicle
     * @param vehicle
     */
    void setVehicle(Vehicle vehicle);

    /**
     * Set the vehicle's check in time
     * @param checkInTime
     */
    void setCheckInTime(Date checkInTime);

    /**
     * Get the vehicle's check out time
     * @param checkOutTime
     */
    void setCheckOutTime(Date checkOutTime);


}
