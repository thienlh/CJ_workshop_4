/*
 * File name: Main.java
 * Author   : Le Hung Thien
 * ID       : SE61374
 * Class    : SE0865
 * Subject  : Core Java
 * Project  : Workshop 4 (cj_workshop_4)
 * Date     : March 23, 2014
 */

package cj_workshop_4.Probl1;

/**
 *
 * @author thienlh
 */
public class Producer extends Thread {
    Store store = null;
    long index = 1; //  Index of the product that will be made
    //  Constructors
    Producer (Store s)  {
        store = s;
    }
    //  Putting new product to the queue
    @Override
    public void run()   {
        while (true) {
            try {
                boolean result = store.put(index);
                if (result == true) System.out.println("\tThe product [" + index++ + "] has been MADE!");
                else    System.out.println("The store is full!");
            } catch (Exception e) {
                System.out.println("\n\tThere's a problem with putting new product!\n");
            }
        }
    }
}
