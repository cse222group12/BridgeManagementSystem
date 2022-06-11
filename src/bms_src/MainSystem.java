package bms_src;

import Jgraph.JGraph;
import com.sun.tools.javac.Main;
import data_structures.Vertex;
import koffman_src.AVLTree;
import koffman_src.HashtableChain;

/**
 * A class that program can run
 * with this class
 */
public class MainSystem {
    //data fields
    //holds every person in the system
    HashtableChain<String,Person> persons;

    JGraph<City,Integer> cities;

    AVLTree<Vehicle> blackListVehicles;

    //
    public MainSystem(){
        persons = new HashtableChain<>();
        cities = new JGraph<>();
    }


    public void addCity(City aCity){
        cities.addNode(aCity);
    }

    /**
     * A method that put the person in the hash table
     * @param person that is want to add
     * @return person
     */
    public Person addPerson(Person person){
        return persons.put(person.getUsername(),person);
    }

    /**
     * A method that put the person in the hash table
     * @param person that is want to remove
     * @return person
     */
    public Person removePerson(Person person){
        return persons.remove(person.getUsername());
    }

    /**
     * A method that add vehicle to blackList
     * @param vehicle which wanted to add blackList
     */
    public void addBlackList(Vehicle vehicle){
        blackListVehicles.add(vehicle);
    }


    /**
     * A method that remove vehicle to blackList
     * @param vehicle which wanted to remove blackList
     */
    public void removeBlackList(Vehicle vehicle){
        blackListVehicles.remove(vehicle);
    }

    /**
     * A method that get person from db
     * @param id person`s id
     * @return Person if exist
     *              else return null
     */
    public Person getPerson(String id){
        return persons.get(id);
    }
}
