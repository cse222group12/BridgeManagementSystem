package bms_src;

import data_structures.BinarySearchTree;
import data_structures.BinaryTree;
import data_structures.SkipList;

import java.util.Iterator;

public class Bridge {
    private String name;
    private BinarySearchTree<Staff> workers;
    private SkipList<Plate,Pass> passHistory;


    public Bridge(String bridge_name){
        name = bridge_name;
        workers = new BinarySearchTree<>();
        passHistory = new SkipList<>();
    }

    //passHistory SkipList

    /**
     * Add pass by Pass classes object
     * @param pass object to add skiplist
     */
    public void addPass(Pass pass){
        passHistory.add(pass.getVehicle().getPlate(), pass);
    }

    public void addPass(Vehicle v){
        passHistory.add(v.getPlate(), new Pass(v));
    }

    public void printAllPassHistory(){
        Iterator iter = passHistory.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
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
