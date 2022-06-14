package testers;
import bms_interface.*;
import bms_src.BMS;
import bms_src.Stopwatch;

import java.util.Arrays;
import java.util.Date;


public class Test {
    public static void main(String[] args) {
        Stopwatch.printDirectly(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) sum += i;
        }, 1000, "sum of first 100 numbers");
//        BMS bms = new BMS();
//        Date date = new Date(2032, 12,3,5,7);
//        System.out.println(date);

    }

}
