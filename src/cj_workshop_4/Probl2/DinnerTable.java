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
public class DinnerTable {

    //  We have 7 philosophers and 7 chopsticks here ;-)
    Chopstick[] chops = new Chopstick[7];
    Philosopher[] phils = new Philosopher[7];
    //  Start dinner

    public void startDinner() throws Exception {
        int i;
        //  Generate new chopstick
        for (i = 0; i < 7; i++) {
            chops[i] = new Chopstick();
        }
        //  Invite new philosopher
        for (i = 0; i < 7; i++) {
            phils[i] = new Philosopher(i, chops[i], chops[(i+1) % 7]);
        }
        //  Let start the party!
        for (i = 0; i < 7; i++) {
            phils[i].start();
        }
    }
}
