package bms_src;

import java.util.ArrayList;
import java.util.List;

public class City {
    private ArrayList<Bridge> bridges;
    private Admin admin;
    private String name;

    public City(String name) {
        this.name = name;
        this.bridges = new ArrayList<>();
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City) return name.equals(((City) obj).name);
        return false;
    }

    /**
     * A method that sets admin
     * @param admin Citys admin
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * A method that sets bridges
     * @param bridges is new bridges arrayList
     */
    public void setBridges(ArrayList<Bridge> bridges) {
        this.bridges = bridges;
    }

    /**
     * Gets city admin
     * @return city admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * A method that add bridge to city
     * @param bridge new bridge
     */
    public void addBridge(Bridge bridge){
        bridges.add(bridge);
    }

    /**
     * A method that shows all bridges
     */
    public void showAllBridge(){
        for (Bridge b :
                bridges) {
            System.out.println(b);
        }
    }
}
