package bms_interface;

import bms_src.Penalty;
import bms_src.Vehicle;

public interface IUser {

    /**
     * add vehicle to account
     * @param vehicle
     * @throws Exception
     */
    void addVehicle(Vehicle vehicle) throws Exception;

    /**
     * remove vehicle from account
     * @param vehicle vehicle reference
     * @return removed vehicle
     * @throws Exception throws exception if the remove operation successfully or not
     */
    Vehicle removeVehicle(Vehicle vehicle) throws Exception;

    /**
     * update the one of the user's vehicle
     * @param vehicle Vehicle reference
     * @param plate plate of vehicle
     * @param vehicleType type of vehicle
     * @return old valu of vehicle
     * @throws Exception throws exception if the update operation successful or not
     */
    Vehicle updateVehicle(Vehicle vehicle, String plate, String vehicleType ) throws Exception; //In my opinion(berkay), user shouldn't be able to update it as they want. This method should send request to admin and officer at the same time and one of both can approve the request.

    /**
     * Paying operation for penalty. The balance of the user must be checked.
     * @param penalty penalty reference
     * @return paying operation successful or not
     */
    boolean payPenalty(Penalty penalty);

    /**
     * Show user's account balance
     * @return balance
     */
    double showBalance();

    /**
     * Money adding operation to user's balance
     * @param money the amount of money
     * @return old balance of account
     */
    double addToBalance(double money);

    /**
     * A method that checks if there is debt or not
     * @return true if there is any debt
     *         false if not
     */
    boolean isThereAnyDebt();

    boolean isThisPlateAvailable(String plate);


}
