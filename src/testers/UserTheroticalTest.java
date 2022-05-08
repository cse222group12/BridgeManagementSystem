package testers;
import bms_interface.*;
import bms_src.*;

import java.util.ArrayList;

public class UserTheroticalTest {
    public static void main(String[] args) {

        //DataBase for users
        DataBase db10 = fillDataBase(10);
        DataBase db100 = fillDataBase(100);
        DataBase db1000 = fillDataBase(1000);
        DataBase db10000 = fillDataBase(10000);
        DataBase db100000 = fillDataBase(100000);


        //find Test
        System.out.println("Find Test We`re expected increasing time logarithmically");
        long start = System.nanoTime();
        db10.findUser("9");
        long find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 10 element: " + find_elapsedTime);

        start = System.nanoTime();
        db100.findUser("99");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 100 element: " + find_elapsedTime);

        start = System.nanoTime();
        db1000.findUser("999");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 1000 element: " + find_elapsedTime);

        start = System.nanoTime();
        db10000.findUser("9999");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 10000 element: " + find_elapsedTime);

        start = System.nanoTime();
        db100000.findUser("99999");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 100000 element: " + find_elapsedTime);

        System.out.println();

        //Remove Test
        System.out.println("Remove Test We`re expected " +
                "increasing time logarithmically");
         start = System.nanoTime();
        db10.findUser("9");
         find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 10 element: " + find_elapsedTime);

        start = System.nanoTime();
        db100.findUser("99");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 100 element: " + find_elapsedTime);

        start = System.nanoTime();
        db1000.findUser("999");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 1000 element: " + find_elapsedTime);

        start = System.nanoTime();
        db10000.findUser("9999");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 10000 element: " + find_elapsedTime);

        start = System.nanoTime();
        db100000.findUser("99999");
        find_elapsedTime = System.nanoTime() - start;
        System.out.println("for 100000 element: " + find_elapsedTime);

        System.out.println();

    }



    public static User generateUser(String id){
        return new User(id);
    }

    public static DataBase fillDataBase(int count){
        DataBase db = new DataBase();
        for (int i = 0; i < count; i++) {
            db.addUser(new User(Integer.toString(i)));
        }
        return db;
    }

    public static ArrayList<User> fillUsers(int count){
        ArrayList<User> usersArray = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            usersArray.add(new User(Integer.toString(i)));
        }
        return usersArray;
    }

}
