/*
 * File name  : Main.java
 * Author     : Le Hung Thien
 * ID         : SE61374
 * Class      : SE0865
 * Subject    : Core Java
 * Project    : Workshop 4 (cj_workshop_4)
 * Date       : March 23, 2014
 * Description: There are two prolems in this workshop about Thread in Java:
 *              1. Producer & Consumer problem (Synchronized thread)
 *              2. 7 philosophers (Deadlocks solving in Java)
 */
package cj_workshop_4;

import cj_workshop_4.Probl1.ProducerConsumerManager;
import cj_workshop_4.Probl2.DinnerTable;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thienlh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    String input;

    public static void main(String[] args) {
        // TODO code application logic here
        int userChoice;
        String promt;
        //  Menu
        Menu menu = new Menu(3);
        menu.add("Producer and Consumer.                            *");
        menu.add("7 philosophies having dinner.                     *");
        menu.add("Quit program.                                     *");
        do {
            do {
                clearConsole();
                System.out.println("*******************************************************************");
                System.out.println("*                THIENLHSE61374 - WORKSHOP 4                      *");
                System.out.println("*******************************************************************");
                try {
                    userChoice = menu.getChoice();
                } catch (Exception ex) {
                    System.out.println("\n---------------------------WRONG INPUT!----------------------------\n\t+ Option must be an integer number!\n");
                    userChoice = 4;
                }
                //  
                switch (userChoice) {
                    case 1:
                        ProducerConsumerManager pc;
                        pc = new ProducerConsumerManager();
                        try {
                            pc.openStore();
                        } catch (Exception ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 2:
                        DinnerTable dt = new DinnerTable();
                        try {
                            dt.startDinner();
                        } catch (Exception ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                }
            } while (userChoice > 0 && userChoice < 4);
            System.out.print("-----> Do you want to QUIT? (Y/n): ");
            Scanner sc = new Scanner(System.in);
            promt = sc.nextLine();
        } while (promt.substring(0, 1).equalsIgnoreCase("n"));
        System.out.println("HAVE A NICE DAY. BYE!");
    }
//  Clear console 

    private static void clearConsole() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException exception) {
            //  Handle exception.
            System.out.println("\n\tThere are a problem with clearing console screen!\n");
        }
    }

}
