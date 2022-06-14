package bms_src;

import bms_interface.IUser;
import data_structures.KWPriorityQueue;
import data_structures.SkipList;

import java.util.Iterator;
import java.util.Scanner;


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
    public User(String user_name, String password){
        super(user_name,password);
        this.label = "user";
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
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle.getPlate(),vehicle);
    }

    /**
     * A method that prints vehicles plate numbers
     * to terminal
     */
    public boolean showAllPlates(){
        if(vehicles.size() != 0)
            for (Plate vehicle : vehicles) System.out.println("# " + vehicle.getPlate());
        else{
            System.out.println("There is no vehicle here. Let's add some.\n");
            return false;
        }
        return true;
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
    public void removeVehicle(Plate plate) {
        try{
            vehicles.remove(plate);
        }
        catch (Exception NullPointerException){
        }
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

    @Override
    public boolean isThisPlateAvailable(String plate) {
        for (int i = 0; i< vehicles.size();i++ ) {
            if(vehicles.get(new Plate(plate)) == null ) {
                return true;
            }
        }
        return false;
    }

    private boolean isZero(double value, double threshold){
        return value >= -threshold && value <= threshold;
    }

    /**
     * Get the debt
     * @return debt
     */
    public double getDebt()
    {
        return debt;
    }

    /**
     * Set the debt
     * @param newDebt
     */
    public void setDebt(double newDebt)
    {
        debt=newDebt;
    }

    /**
     * Get the vehicles
     * @return vehicles
     */
    public SkipList<Plate,Vehicle> getVehicles()
    {
        return vehicles;
    }

    public void getAllVehicles(){
        if(vehicles.size() != 0){
            for (Plate vehicle : vehicles) System.out.println( vehicles.get(new Plate(vehicle.getPlate())).getPlate() + "  " + vehicles.get(new Plate(vehicle.getPlate())).getVehicleType() );

        }
        else{
            System.out.println("There is no vehicle here. Let's add some.\n");
        }

    }

    public void getAllPenalties(){
        User user = (User)BMS.currentUser;
        if(vehicles.size() != 0){
            for (Plate vehicle : vehicles){
                System.out.println( vehicles.get(new Plate(vehicle.getPlate())).getPlate() + "  " + vehicles.get(new Plate(vehicle.getPlate())).getVehicleType() );
                KWPriorityQueue<Penalty> penalties = vehicles.get(new Plate(vehicle.getPlate())).getPenalties();
                if(penalties.peek() != null){
                    System.out.println("\tDebt: " + penalties.peek().getDebt() + "$\n\tReason: " + penalties.peek().getReason() + "\n\tDate: " + penalties.peek().getPenalty_date());
                    Scanner sc = new Scanner(System.in);
                    String opt = null;
                    System.out.println("Do you want to pay this penalty?(y/n)");
                    opt = sc.next();
                    if(opt.equalsIgnoreCase("Y")){
                        assert penalties.peek() != null;
                        var debt = penalties.peek().getDebt();
                        if(user.balance <= debt){
                            System.out.println("You don't have enough money for pay this. Please add some money to your account.");
                        }
                        else{
                            penalties.poll();
                            user.addToBalance(debt*-1);
                        }
                    }
                }
                else {
                    System.out.println("\tThere is no penalty for this vehicle.\n");
                }
            }
        }
        else{
            System.out.println("There is no vehicle here. Let's add some.\n");
        }

    }


}
