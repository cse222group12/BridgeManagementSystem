package bms_src;

/**
 * An abstract class to classify base user`s class
 */
public abstract class Person implements Comparable<Person> {

    String label; // is this person a user or toll clerk or officer etc...

    //Datafields
    //Person`s name
    private String username;
    //User`s unique id number
    private String password;
    //        isUsernameValid();  //namein valid olup olmamasi
    //        check edilecek Userlar hash mapte tutulduktan sonra


    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Person(String username){
        this.username = username;
    }

    /**
     * A method that compares persons by name
     * @param o other person
     * @return 0 if equal
     *          1 if this.username>otherone`s
     *          else -1
     */
    public int compareTo(Person o) {
        return this.getUsername().compareTo(o.getUsername());
    }

    public String getLabel() {
        return label;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) return username.equals(((Person) obj).username);
        return false;
    }
}
