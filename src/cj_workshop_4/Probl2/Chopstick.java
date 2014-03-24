/*
 * File name  : Main.java
 * Author     : Le Hung Thien
 * ID         : SE61374
 * Class      : SE0865
 * Subject    : Core Java
 * Project    : Workshop 4 (cj_workshop_4)
 * Date       : March 23, 2014
 * Description: Part of 7 philosophers having dinner problem
 */
package cj_workshop_4.Probl2;

/**
 *
 * @author thienlh
 */
public class Chopstick {

    boolean ready;
//  Constructor

    public Chopstick() {
        this.ready = true;
    }
//  Pick one chopstick
    public synchronized void pick()  {
        while (!ready) {
            try {
                System.out.println("\tPhilosopher is waiting for another chopstick!");
                wait();
            } catch (Exception e) {
                System.out.println("\n\tThere are a problem with picking a chopstick!\n");
            }
            ready = false;
        }
    }
//  Lower the chopstick
    public synchronized void lower() {
        ready = true;
        notify();
    }
}
