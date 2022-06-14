package bms_src;

import bms_interface.IVehicle;
import data_structures.KWPriorityQueue;

import java.util.Iterator;

public class Vehicle implements IVehicle, Comparable<Vehicle> {

    private Plate plate;
    private String username;
    private Type type;
    private KWPriorityQueue<Penalty> penalties;

    public Vehicle(Plate plate, String username, Type type){
        this.plate = plate;
        this.username = username;
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
    public String getUsername() {
        return username;
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

    public void setUsername(String username) throws Exception {
        // TODO:
        // Think about the "user not found" exception thing.
        this.username = username;
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
        penalties.add(new Penalty(getUsername(),
                getPlate().plate,amount));
    }


    /**
     * A method that prints penalties of vehicle
     */
    public void printPenalties(){
        Iterator<Penalty> iterator=  penalties.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    /**
     * Get the penalties
     * @return penalties
     */
    public KWPriorityQueue<Penalty> getPenalties(){
        return penalties;
    }


    /**
     * A method that adds penalties to vehicle
     * @param amount debt amount
     * @param reason penalty reason
     */
    public void addPenalty(double amount, String reason){
        //penalty eklendiginde kisi uzerine de direktmen
        //eklenmeli
        penalties.add(new Penalty(getUsername(),getPlate().plate,amount,reason));
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.getPlate().plate.compareTo(o.getPlate().plate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) return plate.equals(((Vehicle) obj).plate);
        return false;
    }
}
