package bms_src;

import bms_interface.IStaff;

public abstract class Staff extends Person implements IStaff {

    public Staff(String staff_name, String id_number) {
        super(staff_name, id_number);
    }

    /**
     * Get Staff Member's ID
     *
     * @return staff member ID
     */
    @Override
    public int getStaffMemberID() {
        return 0;
    }

    /**
     * Get Staff Member's Branch
     *
     * @return Staff Member's Branch
     */
    @Override
    public String getBranch() {
        return null;
    }

    /**
     * Set Staff Member's ID
     *
     * @param staffMemberID new Staff Member's ID
     */
    @Override
    public void setStaffMemberID(int staffMemberID) {

    }

    /**
     * Set Staff Member's Branch
     *
     * @param branch new Staff Member's Branch
     */
    @Override
    public void setBranch(String branch) {

    }
}
