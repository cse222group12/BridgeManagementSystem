package bms_interface;

public interface IStaff {

    /**
     * Get Staff Member's ID
     * @return staff member ID
     */
    int getStaffMemberID();

    /**
     * Get Staff Member's Branch
     * @return Staff Member's Branch
     */
    String getBranch();

    /**
     * Set Staff Member's ID
     * @param staffMemberID new Staff Member's ID
     */
    void setStaffMemberID(int staffMemberID);

    /**
     * Set Staff Member's Branch
     * @param branch new Staff Member's Branch
     */
    void setBranch(String branch);
}
