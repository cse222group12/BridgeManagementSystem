package bms_src;

import data_structures.BinarySearchTree;
import data_structures.SkipList;

import java.util.Date;
import java.util.Iterator;

public class Bridge {
    private String name;
//<<<<<<< Updated upstream
//=======
    private BinarySearchTree<Staff> workers;
    private SkipList<Date,Pass> passHistory;
//>>>>>>> Stashed changes

    // NOTE:
    // Changed binary tree to bst
//    private BinarySearchTree<Staff> workers;

    // TODO:
    // CONSIDER A BETTER DATA STRUCTURE!!!!
    // OR A BETTER IMPLEMENTED SKIPLIST!!!!
    //
    // ---maybe fixed by making key value Pass and making pass comparable
    // ---and not using value class at all
    // ---consider it

    // @see SuperAdminViewHistoryMenuContent::printActivity
//    private SkipList<Date, Pass> passHistory;

    public Bridge(String name) {
        this.name = name;
        this.passHistory = new SkipList<>();
        this.workers = new BinarySearchTree<>();
    }

    //passHistory SkipList

    /**
     * Add pass by Pass classes object
     * @param pass object to add skiplist
     */
    public void addPass(Pass pass){
        passHistory.add(pass.getCheckInTime(), pass);
    }

    public void addPass(Vehicle v){
//<<<<<<< Updated upstream
        Pass pass = new Pass(v);
        passHistory.add(pass.getCheckInTime(), pass);
//=======
        Pass p = new Pass(v);
        passHistory.add(p.getCheckInTime(), p);
//>>>>>>> Stashed changes
    }

    public int getPassTime(){
        return passHistory.size();
    }

    /**
     * A method that get a pass
     * from passHistory
     * @param date is checkin time
     * @return pass given date
     */

    public Pass getPass(Date date){
        return passHistory.get(date);
    }





    public void printAllPassHistory(){
        for (Date date : passHistory) {
            System.out.println(date);
        }
    }



    //Workers
    /**
     * Add new staff to workers tree
     * @param newStaff
     */
    public void addWorker(Staff newStaff){
        workers.add(newStaff);
    }

    /**
     * A method that remove a vvorker from workers datastructure tree
     * @param aStaff
     */
    public void removeAWorker(Staff aStaff){
        workers.remove(aStaff);
    }

    /**
     * A method that remove a vvorker from
     * workers datastructure tree
     * @param username represents the workers name
     */
    public boolean removeAWorker(String username){
        return workers.remove(new TollClerk(username, ""));    // Type of staff doesnt matter
    }

    /**
     * A method that get worker from
     * Workers datastructures which is tree
     * @param username staff`s username
     * @return a Staff
     */
    public Staff getAWorker(String username){
        return workers.find(new TollClerk(username, ""));    // Type of staff doesnt matter
    }

    /**
     * A method that get worker from
     * Workers datastructures which is tree
     * @param user is represent worker
     * @return a Staff
     */
    public Staff getAWorker(Staff user){
        return workers.find( user);
    }

    /**
     * A method that shows all workers
     * in the bridge
     * @return names & labels of the workers
     */
    public String showAllWorkers(){
        return workers.toString();
    }

    //Getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public data_structures.BinarySearchTree<Staff> getWorkers() {
        return workers;
    }

    public void setWorkers(data_structures.BinarySearchTree<Staff> workers) {
        this.workers = workers;
    }

    public SkipList<Date, Pass> getPassHistory() {
        return passHistory;
    }

    public void setPassHistory(SkipList<Date, Pass> passHistory) {
        this.passHistory = passHistory;
    }
}
