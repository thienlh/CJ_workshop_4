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
public class Philosopher extends Thread {

    Chopstick leftChopstick, rightChopstick;
    int pos;    //  Position of the philosopher in the table

    //  Constructor
    public Philosopher(int p, Chopstick left, Chopstick right) {
        pos = p;
        leftChopstick = left;
        rightChopstick = right;
    }

    //  Eating
    public void eat() {
        leftChopstick.pick();
        rightChopstick.pick();
        System.out.println("\tPhiloshopher [" + pos + "] is eating!");
    }

    //  Thinking (Stop eating, they are philosopher, you know...)
    public void think() {
        leftChopstick.lower();
        rightChopstick.lower();
        System.out.println("\tPhiloshopher [" + pos + "] is thinking!");
    }

    //
    @Override
    public void run() {
        while (true) {
            eat();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("There are a problem while eating!");
            }
            think();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("There are a problem while thinking!");
            }
        }
    }
}
