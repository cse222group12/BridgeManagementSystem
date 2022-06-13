package bms_src;

import data_structures.BinaryTree;
import data_structures.SkipList;
import koffman_src.BinarySearchTree;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Bridge {
    private String name;

    // NOTE:
    // Changed binary tree to bst
    private data_structures.BinarySearchTree<Staff> workers;

    // TODO:
    // CONSIDER A BETTER DATA STRUCTURE!!!!
    // OR A BETTER IMPLEMENTATION SKIPLIST!!!!
    //
    // ---maybe fixed by making key value Pass and making pass comparable
    // ---and not using value class at all
    // ---consider it

    // @see SuperAdminViewHistoryMenuContent::printActivity
    private SkipList<ComparableDate, Pass> passHistory;

    public Bridge(String name) {
        this.name = name;
        this.passHistory = new SkipList<>();
        this.workers = new data_structures.BinarySearchTree<>();
    }

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

    public SkipList<ComparableDate, Pass> getPassHistory() {
        return passHistory;
    }

    public void setPassHistory(SkipList<ComparableDate, Pass> passHistory) {
        this.passHistory = passHistory;
    }
}
