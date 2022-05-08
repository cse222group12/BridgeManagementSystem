package bms_src;

import bms_interface.IUser;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class User implements IUser, Comparable<User> {

    //data fields

    //user`s user name to login
    private String user_name;
    //user`s password to login
    private String password;
    //name of the user
    private String name;
    //user`s identity number
    private String identity_number;
    //user's balance
    private double balance;
    //user's penalty
    private double penalty;
    //user's vehicle stored in the LinkedList
    private LinkedList<Vehicle> vehicles;


    public User(){
        user_name = "";
        password = "";
        name = "";
        identity_number = "";
        balance = 0;
        penalty = 0;
        vehicles = new LinkedList<>();
    }

    public User(String identity){
        this();
        this.identity_number = identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(identity_number, user.identity_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity_number);
    }

    /**
     * Get the username
     *
     * @return username of user
     */
    @Override
    public String getUserName() {
        return user_name;
    }

    /**
     * set the username it should be check is it unique or not
     *
     * @param userName
     */
    @Override
    public void setUserName(String userName) {
        user_name = userName;
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
        vehicles.remove(vehicle);
        return vehicle;
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

    @Override
    /**
     * A method that return compare identies and
     * @return 1 if this identity is bigger
     *          0 if identity is equal
     *          else -1
     */
    public int compareTo(User o) {
        return identity_number.compareTo(o.identity_number);
    }
}
