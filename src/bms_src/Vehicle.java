package bms_src;

import bms_interface.IVehicle;

public class Vehicle implements IVehicle {

    /**
     * Gets the vehicle type of vehicle
     *
     * @return
     */
    @Override
    public String getVehicleType() {
        return null;
    }

    /**
     * Gets the plate of vehicle
     *
     * @return
     */
    @Override
    public String getPlate() {
        return null;
    }

    /**
     * Gets the toll of vehicle(by vehicle type)
     *
     * @return toll(passing price)
     */
    @Override
    public int getToll() {
        return 0;
    }

    /**
     * Gets the owner of the user
     *
     * @return owner
     */
    @Override
    public User getOwner() {
        return null;
    }

    /**
     * Sets the vehicle type of vehicle
     *
     * @param vehicleType
     */
    @Override
    public void setVehicleType(String vehicleType) {

    }

    /**
     * Sets the plate of the vehicle
     *
     * @param plate
     */
    @Override
    public void setPlate(String plate) {

    }

    /**
     * Vehicle toll(passing price?)
     *
     * @param toll
     */
    @Override
    public void setToll(int toll) {

    }

    /**
     * Sets the owner of the user.
     *
     * @param user owner
     * @throws Exception if the user not found
     */
    @Override
    public void setOwner(User user) throws Exception {

    }
}
