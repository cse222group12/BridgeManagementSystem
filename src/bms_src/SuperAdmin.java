package bms_src;

import bms_interface.ISuperAdmin;

public class SuperAdmin extends Staff implements ISuperAdmin {
    public SuperAdmin(String username, String password) {
        super(username, password);
        this.label = "super_admin";
    }

    @Override
    public void addStaffMember(Staff staffMember) {

    }

    @Override
    public Staff removeStaffMember(Staff staffMember) {
        return null;
    }

    @Override
    public Staff updateStaffMember(Staff staffMember, String staffID, String branch) {
        return null;
    }

    @Override
    public int getTollByVehicleType(String vehicleType) {
        return 0;
    }

    @Override
    public void setTollByVehicleType(String vehicleType, int toll) {

    }
}
