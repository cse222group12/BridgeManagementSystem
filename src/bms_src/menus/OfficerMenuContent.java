package bms_src.menus;

import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import bms_src.BMS;
import bms_src.Officer;
import bms_src.Pair;
import bms_src.Penalty;
import bms_src.Person;
import bms_src.Plate;
import bms_src.User;

public abstract class OfficerMenuContent
{ 

    private static final String[] optionHeaders = new String[] {
        "Send Penalty",
        "Edit Penalty",
        "Edit the Current Speed Limit",
        "Display the Current Speed Limit",
    };

    private static final Runnable[] optionRunnables = new Runnable[] {
        OfficerMenuContent::sendPenalty,
        OfficerMenuContent::editPenalty,
        OfficerMenuContent::editSpeedLimit,
        OfficerMenuContent::checkSpeedLimit,
    };

    public static final Pair<String, Runnable>[] options = Pair.of(optionHeaders, optionRunnables);


    private static void sendPenalty() {
        
        Officer currOfficer = (Officer) BMS.currentUser;
       
        Penalty penalty = getData();

        currOfficer.sendPenalty(penalty);

    }


    private static Penalty getData()
    {

        Scanner sc = new Scanner(System.in);  
        System.out.print("\nEnter the user name : ");
        String username = sc.next();
        Person person = BMS.getPerson(username);

        if(person==null  || !(person instanceof User))  System.out.println("Invalid user!\n");

        else
        {

            User user = (User) person;
            System.out.print("Enter the plate : ");
            String plateNum = sc.next();

            Plate plate = new Plate(plateNum);

            if(user.getVehicles().get(plate)==null) System.out.println("Invalid plate!\n");

            else
            {

                Penalty penalty = new Penalty(username,plateNum);

                System.out.print("Enter the debt (Enter default for default debt) : ");
                String str = sc.next();
                double debt=0;

                try
                {
       
                if(str.equals("default")) throw new Exception();

                debt = Double.parseDouble(str);
    
                if(debt<0) throw new Exception();

                penalty.setDebt(debt);

                }catch(Exception Exception)
                {
    
                    System.out.println("Debt set as default.");

                }


                System.out.print("Enter the reason (Enter default for default reason) : ");
                String reason = sc.next();

                if(reason.equals("default")) System.out.println("Reason set as default.\n");

                else penalty.setReason(reason);

                Date date = new Date();
                penalty.setPenalty_date(date);

                return penalty;
            }

        }

        return null;

    }


    private static void editPenalty() {

        Officer currOfficer = (Officer) BMS.currentUser;
        
        Scanner sc = new Scanner(System.in);  
        System.out.print("\nEnter the user name : ");
        String username = sc.next();
        
        Person person = BMS.getPerson(username);
        
        if(person==null || !(person instanceof User))  System.out.println("Invalid user!\n");

        else
        {

            User user = (User) person;
            System.out.print("Enter the plate : ");
            String plateNum = sc.next();

            Plate plate = new Plate(plateNum);

        if(user.getVehicles().get(plate)==null) System.out.println("Invalid plate!\n");

        else 
        {
            System.out.println("\nPenalties of " + user.getVehicles().get(new Plate(plateNum)).getPlate());
            user.getVehicles().get(new Plate(plateNum)).printPenalties();

            System.out.print("\nEnter the penalty number that is going to be edited : ");
            String str = sc.next();

            int penaltyNum=0;
            boolean isValid=true; 
      
           try
           {
             
              penaltyNum = Integer.parseInt(str);
          
              if((user.getVehicles().get(new Plate(plateNum))).getPenalties().size()<penaltyNum || penaltyNum<=0) 
                throw new Exception();

           }catch(Exception Exception)
           {
          
              isValid = false;
              System.out.println("Invalid penalty number!\n");
      
           }
            
            if(isValid)
            {
            
                Penalty oldPenalty=null;

                Iterator<Penalty> iter= (user.getVehicles().get(new Plate(plateNum))).getPenalties().iterator();
           
                for(int i=penaltyNum;iter.hasNext() && i>0;i--)
                  oldPenalty=iter.next();

                System.out.println("\nEnter the new penalty details.");

                Penalty newPenalty=getData();

                if(oldPenalty!=null && newPenalty!=null)
                {

                currOfficer.editPenalty(oldPenalty,newPenalty);
                System.out.println("\nPenalty is edited!\n");
                
                }

            }

            }

        }

    }


    private static void editSpeedLimit() {
       
      Officer currOfficer = (Officer) BMS.currentUser;

      Scanner sc = new Scanner(System.in);  
      System.out.print("Enter the new speed limit : ");
      String str = sc.next();
      int newSL=0;
      boolean isValid=true; 

    try
    {
       
        newSL = Integer.parseInt(str);
    
    }catch(Exception nullPException)
    {
    
        isValid = false;

    }
    
    if(!isValid || newSL<=0) System.out.println("Invalid speed limit!\n");
    
    else 
    {
      
        currOfficer.setSpeedLimit(newSL); 
        System.out.println("Speed limit is edited!\n");

    }

    }


    private static void checkSpeedLimit() {
       
        Officer currOfficer = (Officer) BMS.currentUser;

        System.out.println("Current speed limit : " + currOfficer.getSpeedLimit() + "\n");
    
    }

}

