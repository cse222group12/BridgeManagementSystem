package testers;

import bms_src.MainSystem;
import bms_src.Person;
import bms_src.User;

public class MainSystemTester {
    public static void main(String args[]){
        MainSystem ms = new MainSystem();

        ms.addPerson(new User("ahmet cakar", "921421123"));
        Person ruhi_mucerret = new User("Ruhi Mucerret", "123098123");
        ms.addPerson(ruhi_mucerret);
        if (!ruhi_mucerret.equals(ms.getPerson(ruhi_mucerret.getUsername()))){
            System.out.println("error");
        }

    }
}
