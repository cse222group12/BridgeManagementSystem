package bms_src;

import bms_interface.IUser;

import java.util.ArrayList;
import java.util.Date;

public class User implements IUser {

    private String name;
    private ArrayList<Vehicle> vehicles; // Data structure type is subject to change

    /**
     * Get the name of the user.
     *
     * @return Name of the user.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set name of the user.
     *
     * @param name New name of this user.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * add vehicle to account
     *
     * @param vehicle
     * @throws Exception
     */
    @Override
    public void addVehicle(Vehicle vehicle) throws Exception {
        vehicles.add(vehicle);
    }

    /**
     * remove vehicle from account
     *
     * @param vehicle vehicle reference
     * @return removed vehicle
     * @throws Exception throws exception if the remove operation successfully or not
     */
    @Override
    public Vehicle removeVehicle(Vehicle vehicle) throws Exception {
        return null;
    }

    /**
     * update the one of the user's vehicle
     *
     * @param vehicle     Vehicle reference
     * @param plate       plate of vehicle
     * @param vehicleType type of vehicle
     * @return old valu of vehicle
     * @throws Exception throws exception if the update operation successful or not
     */
    @Override
    public Vehicle updateVehicle(Vehicle vehicle, String plate, String vehicleType) throws Exception {
        return null;
    }

    /**
     * Paying operation for penalty. The balance of the user must be checked.
     *
     * @param penalty penalty reference
     * @return paying operation successful or not
     */
    @Override
    public boolean payPenalty(Penalty penalty) {
        return false;
    }

    /**
     * Show user's account balance
     *
     * @return balance
     */
    @Override
    public int showBalance() {
        return 0;
    }

    /**
     * Money adding operation to user's balance
     *
     * @param money the amount of money
     * @return old balance of account
     */
    @Override
    public int addToBalance(int money) {
        return 0;
    }
}
