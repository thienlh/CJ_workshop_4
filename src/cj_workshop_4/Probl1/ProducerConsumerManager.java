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
public class ProducerConsumerManager {
    Store store;
    Producer pro;
    Consumer con;

    //  Constructor
    public ProducerConsumerManager() {
        //  Allocate resourse
        store = new Store();
        pro = new Producer(store);
        con = new Consumer(store);
        //  Start threads in constructor is very dangerous
        pro.start();
        con.start();
    }
    
}
