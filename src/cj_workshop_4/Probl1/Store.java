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
public class Store {

    int maxN = 50;  //  Maximum products can be contain in the store
    long[] list;    //  Product list
    int n;  //  Current number of products in the store
    //  Constructors

    Store() {
        n = 0;
        list = new long[maxN];
    }

    //  Checking methods
    public boolean isFull() {
        return n == maxN;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    //  Methods for putting 1 product into the Store
    public synchronized boolean put(long x) {
        if (isFull()) return false;
        list[n++] = x;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("\n\tCannot sleep??\n");
        }
        return true;
    }
    //  Methods for getting 1 prodcut from the Store
    public synchronized long get()  {
        long result = 0;    //  If result equals 0 means product getting failed
        if (!isEmpty())  {
            result = list[0];    //  Get the first product in queue
            for (int i = 0; i < n-1; i++) {
                //  Shift the queue
                list[i] = list[i+1];
            }
            n--;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("\n\tCannot sleep!\n");
        }
        return result;
    }
}
