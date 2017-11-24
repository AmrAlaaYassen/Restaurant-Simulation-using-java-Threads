package resturant.simulation;

import java.util.Random;

public class Customer extends Thread {
Semaphore_A availableTables;
public javax.swing.JTextArea out;
    public String  customerName;
   int tableNumber;

     Customer(String name) {
         this.customerName = name ; 
    }
    
      Customer(String _customerName,Semaphore_A _availableTables , javax.swing.JTextArea ou){
        this.customerName=_customerName;
        this.availableTables=_availableTables;
        this.out = ou ; 

    }
     
     public void setSema (Semaphore_A obj) {
         this.availableTables = obj ; 
     }
    
    public void arrived () {
       
        this.out.append("Table "+tableNumber+" : Customer: "+customerName+ " Arrived");
         System.out.println("Table "+tableNumber+" : Customer : "+customerName+ " is arrive");
        out.append("\n") ;
        try {
            this.sleep(getRandomNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sitDown () {
         out.append("\n") ;
        this.out.append("Table "+tableNumber+" : Customer: "+customerName+ " sitDown");
         System.out.println("Table "+tableNumber+" : Customer : "+customerName+ " is sitting down");
        out.append("\n") ;
        try {
            this.sleep(getRandomNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void orderFood () {
             out.append("\n") ;
        this.out.append("Table "+tableNumber+" : Customer: "+customerName+ " ordering Food");
         System.out.println("Table "+tableNumber+" : Customer : "+customerName+ " is ordering food");
        out.append("\n") ;
        try {
            this.sleep(getRandomNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void isEating () {
             out.append("\n") ;
        this.out.append("Table "+tableNumber+" : Customer: "+customerName+ " is Eating");
         System.out.println("Table "+tableNumber+" : Customer : "+customerName+ " is eating");
        out.append("\n") ;
        try {
            this.sleep(getRandomNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void leavee () {
             out.append("\n") ;
             System.out.println("Table "+tableNumber+" : Customer : "+customerName+ " is leaving");
        this.out.append("Table "+tableNumber+" : Customer : "+customerName+ " is leaving");
        out.append("\n") ;
        try {
            this.sleep(getRandomNumber());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public int getRandomNumber () {
        int maximum = 10000 , minimum = 2000 ;
        return ( minimum + (int)(Math.random() * maximum)) ;
    }
    public void run() {



        //Critical section entry
        availableTables.P(this);

        //Critical section body

        this.sitDown();
        this.orderFood();
        this.isEating();

        try {
            Random rand = new Random();

            int  customerTimeOnTable = rand.nextInt(5000) + 500;
            Thread.sleep(customerTimeOnTable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        availableTables.V();

        this.leavee();
    }

    public void setTableNumber(int pnum) {
        this.tableNumber = pnum ;
    }

    

}
