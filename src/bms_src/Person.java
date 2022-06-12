package bms_src;

/**
 * An abstract class to classify base user`s class
 */
public abstract class Person {

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
}
