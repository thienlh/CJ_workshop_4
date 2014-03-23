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
public class Consumer extends Thread {
    Store store = null;
    //  Constructors
    Consumer (Store s)  {
        store = s;
    }
    //  Getting product from the Store
    @Override
    public void run()   {
        while (true) {
            try {
                long x = store.get();
                if (x>0) {
                    System.out.println("\tProduct [" + x + "] has been BOUGHT!\n");
                } else  System.out.println("\tConsumer is waiting for new products!");
            } catch (Exception e) {
                System.out.println("\n\tThere's a problem with getting products!\n");
            }
        }
    }
}
