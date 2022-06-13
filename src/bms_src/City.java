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
}
