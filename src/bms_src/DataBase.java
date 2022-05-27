package bms_src;

import bms_interface.IDataBase;

import java.util.ArrayList;

public class DataBase implements IDataBase {





    /**
     * Shows all the penalties with details.
     *
     * @return list of penalties
     */
    @Override
    public ArrayList<Penalty> showPenalties() {
        return null;
    }

    /**
     * Shows all pass summary
     *
     * @return list of passings
     */
    @Override
    public ArrayList<Pass> showPassSummary() {
        return null;
    }

    /**
     * Shows the blacklisted users
     *
     * @return list of users on the blacklist
     */
    @Override
    public ArrayList<User> showBlacklist() {
        return null;
    }

    /**
     * Shows all the users with details.
     *
     * @return List of users
     */
    @Override
    public ArrayList<User> showUsers() {
        return null;
    }

    /**
     * Shows all the vehicles with details.
     *
     * @return List of vehicles
     */
    @Override
    public ArrayList<Vehicle> showAllVehicles() {
        return null;
    }

    /**
     * Shows all the staff members with details.
     *
     * @return List of staff members
     */
    @Override
    public ArrayList<Staff> showStaff() {
        return null;
    }

    /**
     * Shows revenue of the StaffMember. If the Staff Member is Admin, so shows the total revenue of bridge.
     *
     * @param staffMember staff member reference
     * @return revenue
     */
    @Override
    public int showRevenue(Staff staffMember) {
        return 0;
    }

    /**
     * Checks is there any user with this username because usernames must be unique.
     *
     * @param userName username of user
     * @return true or false
     */
    @Override
    public boolean userNameValidate(String userName) {
        return false;
    }
}
