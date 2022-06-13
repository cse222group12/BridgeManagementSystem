package bms_src;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;
import data_structures.SkipList;

public class Bridge {
    private String name;
    private BinarySearchTree<Staff> workers;
    private SkipList<Plate,Pass> passHistory;


    public Bridge(String bridge_name){
        name = bridge_name;
        workers = new BinarySearchTree<>();
        passHistory = new SkipList<>();
    }

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
        return workers.remove((Staff) new Person(username));
    }

    /**
     * A method that get worker from
     * Workers datastructures which is tree
     * @param username staff`s username
     * @return a Staff
     */
    public Staff getAWorker(String username){
        return workers.find((Staff) new Person(username));
    }

    /**
     * A method that shows all workers
     * in the bridge
     * @return nothing
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

    public BinaryTree<Staff> getWorkers() {
        return workers;
    }

    public void setWorkers(BinarySearchTree<Staff> workers) {
        this.workers = workers;
    }

    public SkipList<Plate, Pass> getPassHistory() {
        return passHistory;
    }

    public void setPassHistory(SkipList<Plate, Pass> passHistory) {
        this.passHistory = passHistory;
    }


}
