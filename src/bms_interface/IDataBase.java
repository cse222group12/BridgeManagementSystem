package bms_interface;

import bms_src.*;

import java.util.ArrayList;

public interface IDataBase {

    /**
     * Shows all the penalties with details.
     * @return list of penalties
     */
    ArrayList<Penalty> showPenalties();

    /**
     * Shows all pass summary
     * @return list of passings
     */
    ArrayList<Pass> showPassSummary();

    /**
     * Shows the blacklisted users
     * @return list of users on the blacklist
     */
    ArrayList<User> showBlacklist();

    /**
     * Shows all the users with details.
     * @return List of users
     */
    ArrayList<User> showUsers();

    /**
     * Shows all the vehicles with details.
     * @return List of vehicles
     */
    ArrayList<Vehicle> showAllVehicles();

    /**
     * Shows all the staff members with details.
     * @return List of staff members
     */
    ArrayList<Staff> showStaff();

    /**
     * Shows revenue of the StaffMember. If the Staff Member is Admin, so shows the total revenue of bridge.
     * @param staffMember staff member reference
     * @return revenue
     */
    int showRevenue(Staff staffMember);

    /**
     * Checks is there any user with this username because usernames must be unique.
     * @param userName username of user
     * @return true or false
     */
    boolean userNameValidate(String userName);
}
