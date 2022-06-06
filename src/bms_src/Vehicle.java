package bms_src;

import bms_interface.IVehicle;
import data_structures.KWPriorityQueue;

public class Vehicle implements IVehicle {

    private Plate plate;
    private String ownerId;
    private Type type;
    private KWPriorityQueue<Penalty> penalties;

    public Vehicle(Plate plate, String ownerId, Type type){
        this.plate = plate;
        this.ownerId = ownerId;
        this.type = type;
        penalties = new KWPriorityQueue<>();
    }
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
    public String getOwnerId() {
        return ownerId;
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

    public void setOwnerId(String ownerId) throws Exception {
        // TODO:
        // Think about the "user not found" exception thing.
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return getPlate().plate;
    }

    /**
     * A method that adds penalty to Vehicle
     * @param p
     */
    public void addPenalty(Penalty p){
        penalties.add(p);
    }


    /**
     * A method that adds penalties to vehicle
     * @param amount debt amount
     */
    public void addPenalty(double amount){
        //penalty eklendiginde kisi uzerine de direktmen
        //eklenmeli
        penalties.add(new Penalty(getOwnerId(),
                getPlate().plate,amount));
    }

    /**
     * A method that adds penalties to vehicle
     * @param amount debt amount
     * @param reason penalty reason
     */
    public void addPenalty(double amount, String reason){
        //penalty eklendiginde kisi uzerine de direktmen
        //eklenmeli
        penalties.add(new Penalty(getOwnerId(),getPlate().plate,amount,reason));
    }



}
