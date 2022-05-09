package bms_src;

import bms_interface.IVehicle;

public class Vehicle implements IVehicle {

    private Plate plate;
    private User owner;
    private Type type;

    /**
     * Gets the vehicle type of vehicle.
     *
     * @return  <code>Type</code> of this vehicle.
     */
    @Override
    public Type getVehicleType() {
        return type;
    }

    /**
     * Gets the plate of vehicle.
     *
     * @return <code>Plate</code> of this vehicle.
     */
    @Override
    public Plate getPlate() {
        return plate;
    }

    /**
     * Gets the toll of vehicle(by vehicle type)
     *
     * @return toll(passing price)
     */
    @Override
    public float getToll() {
        return type.toll;
    }

    /**
     * Gets the owner of this vehicle.
     *
     * @return Owner of this vehicle.
     */
    @Override
    public User getOwner() {
        return owner;
    }

    /**
     * Sets the vehicle type.
     * @param type  New <code>Type</code> of this vehicle.
     */
    @Override
    public void setVehicleType(Type type) {
        this.type = type;
    }

    /**
     * Sets the plate of the vehicle.
     *
     * @param plate New <code>Plate</code> of this vehicle.
     */
    @Override
    public void setPlate(Plate plate) {
        this.plate = plate;
    }

    /**
     * Vehicle toll(passing price?)
     *
     * @param toll
     */
    @Override
    @Deprecated
    public void setToll(float toll) {
        // TODO:
        // Tolls are special to different types of vehicles.
        // This function shouldn't exist. Delete it.
    }

    /**
     * Sets the owner of this vehicle.
     *
     * @param owner New owner of this vehicle.
     * @throws Exception If user is not found.
     */
    @Override
    public void setOwner(User owner) throws Exception {
        // TODO:
        // Think about the "user not found" exception thing.
        this.owner = owner;
    }
}
