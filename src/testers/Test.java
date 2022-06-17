package testers;
import bms_interface.*;
import bms_src.BMS;
<<<<<<< Updated upstream
import bms_src.Stopwatch;
=======
import bms_src.Officer;
import bms_src.Staff;
import bms_src.TollClerk;
>>>>>>> Stashed changes

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        BMS bms = new BMS();
//        Date date = new Date(2032, 12,3,5,7);
//        System.out.println(date);

    }

    public static void addStaff(){
        System.out.println("Input the keyletter for staff" +
                "\n(for tollclerk :t, officer: o)\nInput: ");
        Scanner sc= new Scanner(System.in);  //System.in is a standard input stream
        String str= sc.next();   //reads string before the space

        char ch = str.charAt(0);
        Staff newStaff = null;

        if (ch=='t' || ch=='T'){
            newStaff = new TollClerk();
            newStaff.fillInfo();
        }
        else if (ch=='o' || ch=='O'){
            newStaff = new Officer();
            newStaff.fillInfo();
        }

        if (newStaff == null){
            System.out.println("Sory Dude Wrong Input!");
        }

        else{
            System.out.println(newStaff +" added succesfully!");
        }
    }

}
