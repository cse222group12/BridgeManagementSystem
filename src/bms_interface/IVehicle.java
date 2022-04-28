package bms_interface;

import bms_src.User;

public interface IVehicle {
    /**
     * Gets the vehicle type of vehicle
     * @return
     */
    String getVehicleType();

    /**
     * Gets the plate of vehicle
     * @return
     */
    String getPlate();

    /**
     * Gets the toll of vehicle(by vehicle type)
     * @return toll(passing price)
     */
    int getToll();

    /**
     * Gets the owner of the user
     * @return owner
     */
    User getOwner();


    /**
     * Sets the vehicle type of vehicle
     * @param vehicleType
     */
    void setVehicleType(String vehicleType);

    /**
     * Sets the plate of the vehicle
     * @param plate
     */
    void setPlate(String plate);

    /**
     * Vehicle toll(passing price?)
     * @param toll
     */
    void setToll(int toll);

    /**
     * Sets the owner of the user.
     * @param user owner
     * @throws Exception if the user not found
     */
    void setOwner(User user) throws Exception;




}
