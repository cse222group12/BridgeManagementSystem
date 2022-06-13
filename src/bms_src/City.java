package bms_src;

import java.util.ArrayList;

public class City {
    private String city_name;
    ArrayList<Bridge> bridges;
    Admin admin;

    /**
     * Constructor that gets
     * @param city_name only city name
     */
    public City(String city_name){
        this.city_name = city_name;
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
