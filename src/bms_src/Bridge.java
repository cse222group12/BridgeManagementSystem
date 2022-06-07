package bms_src;

import data_structures.BinaryTree;
import data_structures.SkipList;

public class Bridge {
    private String name;
    private BinaryTree<Staff> workers;
    private SkipList<Plate,Pass> passHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinaryTree<Staff> getWorkers() {
        return workers;
    }

    public void setWorkers(BinaryTree<Staff> workers) {
        this.workers = workers;
    }

    public SkipList<Plate, Pass> getPassHistory() {
        return passHistory;
    }

    public void setPassHistory(SkipList<Plate, Pass> passHistory) {
        this.passHistory = passHistory;
    }
}
