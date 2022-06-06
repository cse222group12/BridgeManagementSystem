package bms_src;

/**
 * An abstract class to classify base user`s class
 */
public abstract class Person {
    //Datafields
    //Person`s name
    private String name;
    //User`s unique id number
    private String id_number;
    //        isIDValid();  //Idinin valid olup olmamasi
    //        check edilecek Userlar hash mapte tutulduktan sonra


    public Person(String name, String id_number) {
        this.name = name;
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }
}
