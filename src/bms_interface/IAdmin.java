package bms_interface;

import bms_src.Staff;

public interface IAdmin {

    /**
     * Add a new member to staff
     * @param staffMember staff member reference
     */
    void addStaffMember(Staff staffMember);

    /**
     * Remove a member from staff
     * @param staffMember staff member reference
     * @return removed staff member
     */
    Staff removeStaffMember(Staff staffMember);

    /**
     * Update a member from staff
     * @param staffMember staff member reference to change
     * @param staffID ID of staff member
     * @param branch branch of staff member
     * @return old value of the staff member
     */
    Staff updateStaffMember(Staff staffMember, String staffID, String branch);

    /**
     * Every vehicle type has different toll(pass price?). Get the toll by vehicle type
     * @param vehicleType type of vehicle
     * @return toll
     */
    int getTollByVehicleType(String vehicleType);

    /**
     * Every vehicle type has different toll(pass price?). Set the toll by vehicle type
     * @param vehicleType type of vehicle
     * @param toll toll
     */
    void setTollByVehicleType(String vehicleType, int toll);


}
