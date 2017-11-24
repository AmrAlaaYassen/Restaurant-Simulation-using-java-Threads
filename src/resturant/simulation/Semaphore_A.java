package resturant.simulation;

public class Semaphore_A {

    int value = 0 ;
    int tableptr = 0 ,size  ;

public javax.swing.JTextArea out;
     Semaphore_A() { value = 0 ; }
     Semaphore_A(int initial) { 
        value = initial ;
        size=initial;
    }

   

    public synchronized void P(Customer cust) {
        value-- ;
        if (value < 0){

            
            out.append ("Customer: "+cust.customerName+" arrived and  waiting") ; 
            System.out.println("Customer: "+cust.customerName+" arrived and  waiting");
            out.append("\n") ;
            try { wait() ; } catch( InterruptedException e ) { }
        }else {
            out.append ("Customer: "+cust.customerName+" arrived ") ;
            out.append("\n") ; 
            System.out.println("Customer: "+cust.customerName+" arrived ");
        }

        cust.setTableNumber(tableptr+1);
        tableptr = (tableptr+1)%size ;
    }

    public synchronized void V() {
        value++ ; if (value <= 0) notify() ;
    }

}