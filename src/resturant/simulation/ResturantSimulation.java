/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturant.simulation;

import java.util.*;

/**
 *
 * @author amral
 */
public class ResturantSimulation extends Thread{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
     int nuberOfTables,
            numberOfCustomers;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter number of Tables: ");
        nuberOfTables= userInput.nextInt();

        System.out.println("Enter number of Customers: ");
        numberOfCustomers=userInput.nextInt();

        Semaphore_A availableTables=new Semaphore_A(nuberOfTables);

        for(int i=1;i<=numberOfCustomers;i++){

            Customer newCustomer=new Customer("c"+String.valueOf(i) ,availableTables) ; 
            sleep(newCustomer.getRandomNumber());
            newCustomer.start();
        }
    }
    
}
