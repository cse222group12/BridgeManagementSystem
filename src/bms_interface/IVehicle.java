package bms_interface;

import bms_src.Plate;
import bms_src.User;

public interface IVehicle {
    /**
     * Gets the vehicle type.
     * @return <code>Type</code> of this vehicle.
     */
    Type getVehicleType();

    /**
     * Gets the plate of vehicle.
     *
     * @return <code>Plate</code> of this vehicle.
     */
    Plate getPlate();

    // TODO:
    // Doesn't really make sense since toll is dependent on the type and can be retrieved from there.
    /**
     * Gets the toll of vehicle(by vehicle type)
     * @return toll(passing price)
     */
    @Deprecated
    float getToll();

    /**
     * Gets the owner of this vehicle.
     *
     * @return Owner of this vehicle.
     */
    User getOwner();

    /**
     * Sets the vehicle type.
     * @param type  New <code>Type</code> of this vehicle.
     */
    void setVehicleType(Type type);

    /**
     * Sets the plate of the vehicle.
     *
     * @param plate New <code>Plate</code> of this vehicle.
     */
    void setPlate(Plate plate);

    // TODO:
    // Toll is special to vehicle type, you shouldn't be able to change it.
    /**
     * Vehicle toll(passing price?)
     * @param toll
     */
    @Deprecated
    void setToll(float toll);

    /**
     * Sets the owner of this vehicle.
     *
     * @param owner New owner of this vehicle.
     * @throws Exception If user is not found.
     */
    void setOwner(User owner) throws Exception;

    /**
     * Types of vehicles.
     */
    enum Type {
        // TODO:
        // Set tolls to logical values.
        Automobile(0),
        Minibus(0),
        Bus(0),
        Truck(0),
        Motorcycle(0);

        public final float toll;

        Type(float toll) {
            this.toll = toll;
        }
    }
}
