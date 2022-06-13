package bms_src;

import Jgraph.JGraph;
import koffman_src.HashtableChain;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * A class that program can run
 * with this class
 */
public class MainSystem {
    //data fields
    //holds every person in the system
    private static HashtableChain<String,Person> persons = new HashtableChain<>();

    private static JGraph<City, Integer> cities = new JGraph<>();

    // NOTE:
    // Changed AVLTree to TreeSet which implements Red-Black Tree.
    // Reason: TreeSet has iterator.
    //
    // Changed Vehicle to Plate since uniqueness of a vehicle depends on its plate.
    private static TreeSet<Plate> blacklistPlates = new TreeSet<>();

    //
    public MainSystem(){
        persons = new HashtableChain<>();
        cities = new JGraph<>();
    }


    public static void addCity(City aCity){
        cities.addNode(aCity);
    }

    public static Iterator<City> getCityIterator() {
        return cities.getNodes().iterator();
    }

    public static int getNumCity() {
        return cities.size();
    }

    public static City getCity(String cityName) {
        return cities.getNode(new City(cityName));
    }

    /**
     * A method that put the person in the hash table
     * @param person that is want to add
     * @return person
     */
    public static Person addPerson(Person person){
        return persons.put(person.getUsername(),person);
    }

    /**
     * A method that put the person in the hash table
     * @param person that is want to remove
     * @return person
     */
    public static Person removePerson(Person person){
        return persons.remove(person.getUsername());
    }

    /**
     * A method that add vehicle to blackList
     * @param plate which wanted to add blackList
     */
    public static boolean addBlackList(Plate plate){
        return blacklistPlates.add(plate);
    }


    /**
     * A method that remove vehicle to blackList
     * @param plate which wanted to remove blackList
     * @return      true if this set contained the specified element
     */
    public static boolean removeBlackList(Plate plate){
        return blacklistPlates.remove(plate);
    }

    public static Iterator<Plate> blacklistIterator() {
        return blacklistPlates.iterator();
    }

    /**
     * A method that get person from db
     * @param id person`s id
     * @return Person if exist
     *              else return null
     */
    public static Person getPerson(String id){
        return persons.get(id);
    }
}
