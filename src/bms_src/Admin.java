package bms_src;

import bms_interface.IAdmin;

public class Admin extends Staff implements IAdmin  {

    public Admin(String username, String password) {
        super(username, password);
        this.label = "normal_admin";
    }

    /**
     * Add a new member to staff
     *
     * @param staffMember staff member reference
     */
    @Override
    public void addStaffMember(Staff staffMember) {

    }

    /**
     * Remove a member from staff
     *
     * @param staffMember staff member reference
     * @return removed staff member
     */
    @Override
    public Staff removeStaffMember(Staff staffMember) {
        return null;
    }

    /**
     * Update a member from staff
     *
     * @param staffMember staff member reference to change
     * @param staffID     ID of staff member
     * @param branch      branch of staff member
     * @return old value of the staff member
     */
    @Override
    public Staff updateStaffMember(Staff staffMember, String staffID, String branch) {
        return null;
    }

    /**
     * Every vehicle type has different toll(pass price?). Get the toll by vehicle type
     *
     * @param vehicleType type of vehicle
     * @return toll
     */
    @Override
    public int getTollByVehicleType(String vehicleType) {
        return 0;
    }

    /**
     * Every vehicle type has different toll(pass price?). Set the toll by vehicle type
     *
     * @param vehicleType type of vehicle
     * @param toll        toll
     */
    @Override
    public void setTollByVehicleType(String vehicleType, int toll) {

    }
}
