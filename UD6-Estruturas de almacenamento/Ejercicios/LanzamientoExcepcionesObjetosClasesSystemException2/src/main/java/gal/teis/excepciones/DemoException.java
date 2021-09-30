/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.excepciones;

/**
 *
 * @author a20estefaniapc
 */
public class DemoException {

    static void miMetodo(int n) throws Exception {
        try {
            switch (n) {
                case 1:
                    System.out.println("1er caso");
                    break;
                case 2:
                    System.out.println("2º caso");
                    throw new RuntimeException("2!");
                case 3:
                    System.out.println("3er caso");
                    throw new Exception("3!");
            }
        } catch (RuntimeException e) {
            System.out.println("RuntimeException: ");
            System.out.println(e.getMessage());

        } finally {
            System.out.println("try-block ejecutado");
        }
    }

}
