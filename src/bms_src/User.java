package bms_src;

import bms_interface.IUser;
import data_structures.SkipList;

import java.util.Iterator;


public class User extends Person implements IUser {

    //DataFields
    //SkipList structure uses to sore user`s vehicle`s
    //Key value is Plate which is unique for vehicles
    private SkipList<Plate,Vehicle> vehicles; // Data structure type is subject to change
    //User`s balance (burda 2 tane para hesabi var)
    //biri kendisinin hesabindaki para balance digeri
    //borclarinin tamamini gosteren debt
    //Kullanici borcunu odemek icin ilkin kendi hesabina
    //para yatirir sonrasinda borcunu odemek icin kendisi manuel
    //sistemeden borcunu oder
    double balance = 0;

    double debt = 0;

    //Constructors
    public User(String user_name, String id_number){
        super(user_name,id_number);
//        isIDValid();  //Idinin valid olup olmamasi
//        check edilecek Userlar hash mapte tutulduktan sonra
        vehicles = new SkipList<>();
        balance = 0;
    }

    /**
     * add vehicle to account
     *
     * @param vehicle
     * @throws Exception
     */
    @Override
    public void addVehicle(Vehicle vehicle) throws Exception {
        vehicles.add(vehicle.getPlate(),vehicle);
    }

    /**
     * A method that prints vehicles plate numbers
     * to terminal
     */
    public void showAllPlates(){

        for (Plate vehicle : vehicles) System.out.println(vehicle.getPlate());
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
        vehicles.remove(vehicle.getPlate());
        return vehicle;
    }

    /**
     * remove vehicle from account by plate
     *
     * @param plate vehicle reference
     * @return removed vehicle
     * @throws Exception throws exception if the remove operation successfully or not
     */
    public void removeVehicle(Plate plate) throws Exception {
        vehicles.remove(plate);
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
    public double showBalance() {
        return balance;
    }


    /**
     * Money adding operation to user's balance
     *
     * @param money the amount of money
     * @return old balance of account
     */
    @Override
    public double addToBalance(double money) {
        double b_balance = balance;
        balance+=money;
        return b_balance;
    }

    @Override
    public boolean isThereAnyDebt() {
        return isZero(balance, 0.001);
    }

    private boolean isZero(double value, double threshold){
        return value >= -threshold && value <= threshold;
    }


}
