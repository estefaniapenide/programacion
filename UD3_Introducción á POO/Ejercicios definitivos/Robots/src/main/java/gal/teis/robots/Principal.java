/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.robots;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Robot robot1 = new Robot("AAA", 1, "Vigo");
        Robot robot2 = new Robot("AAA", 1, "Pontevedra");

        Robot robot3 = new Robot("AAA", 1, "Vigo");
        Robot robot4 = new Robot("BBB", 1, "Vigo");
        
        Robot robot5 = new Robot("AAA", 1, "Vigo");
        Robot robot6 = new Robot("AAA", 2, "Vigo");

        if (robot1.equals(robot2)) {
            System.out.println("robot1 y robot2 son iguales");
        } else {
            System.out.println("robot1 y robot2  NO son iguales");
        }
        
        if (robot3.equals(robot4)) {
            System.out.println("robot3 y robot4 son iguales");
        } else {
            System.out.println("robot3 y robot4  NO son iguales");
        }
        
        if (robot5.equals(robot6)) {
            System.out.println("robot5 y robot6 son iguales");
        } else {
            System.out.println("robot5 y robot6  NO son iguales");
        }
    }

}
