package bms_src;

import bms_interface.IOfficer;

public class Officer extends Staff implements IOfficer {

    private int speedLimit=90;

    
    public Officer(String username, String password) {
        super(username, password);
        this.label = "officer";
    }


    /**
     * Send penalty to a user which is actually guilty driver
     *
     * @param penalty Penalty that is going to user
     */
    @Override
    public void sendPenalty(Penalty penalty) {
        
        try{

        User user = (User) BMS.getPerson(penalty.getUsername());
        Vehicle vehicle=(user.getVehicles()).get(new Plate(penalty.getPlateNumber()));

        vehicle.addPenalty(penalty);

        user.setDebt(user.getDebt() + penalty.getDebt());

        }catch(Exception exception)
        {

        }

    }


    /**
     * If somethings goes wrong edit the penalty
     *
     * @param oldPenalty Previous Penalty reference
     * @param newPenalty New Penalty reference
     * 
     */
    @Override
    public void editPenalty(Penalty oldPenalty,Penalty newPenalty) {
        
        try{

        User user = (User) BMS.getPerson(oldPenalty.getUsername());

        Vehicle vehicle=(user.getVehicles()).get(new Plate(oldPenalty.getPlateNumber()));

        vehicle.getPenalties().remove(oldPenalty);

        user.setDebt(user.getDebt() - oldPenalty.getDebt());

        sendPenalty(newPenalty);

        }catch(Exception exception)
        {


        }

    }


    /**
     * Get the current speed limit
     *
     * @return speed limit
     */
    @Override
    public int getSpeedLimit() {
        return speedLimit;
    }


    /**
     * Set the speed limit according to the conditions of the day and traffic rules
     *
     * @param speedLimit new speed limit
     */
    @Override
    public void setSpeedLimit(int speedLimit) {
        if(speedLimit>0)
        this.speedLimit = speedLimit;
    }
}
