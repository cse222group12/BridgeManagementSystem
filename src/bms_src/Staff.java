package bms_src;

import bms_interface.IStaff;

import java.util.Scanner;

public abstract class Staff extends Person implements IStaff {

    public Staff(String staff_name, String id_number) {
        super(staff_name, id_number);
    }

    public Staff() {
        super();
    }

    public void fillInfo(){
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        System.out.println("Input username: ");
        String str= sc.next();   //reads string before the space
        this.setUsername(str);
        System.out.println("Input password: ");
        str=sc.next();
        this.setPassword(str);
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

    @Override
    public String toString() {
        return super.toString() + " | " + getClass().getSimpleName();
    }

    public enum Type {
        TollClerk(bms_src.TollClerk.class),
        Officer(bms_src.Officer.class),
        Admin(bms_src.Admin.class),
        SuperAdmin(bms_src.SuperAdmin.class);

        private final Class<? extends Staff> staffClass;

        Type(Class<? extends Staff> staffClass) {
            this.staffClass = staffClass;
        }

        public Class<? extends Staff> getStaffClass() {
            return staffClass;
        }
    }
}
