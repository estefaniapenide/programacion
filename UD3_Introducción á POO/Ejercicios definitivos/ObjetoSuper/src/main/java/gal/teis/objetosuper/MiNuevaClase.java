/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.objetosuper;

/**
 *
 * @author a20estefaniapc
 */
public class MiNuevaClase extends MiClase {

    public void sumaAi(int j) {
        i = i + (j / 2);
        super.sumaAi(j);
    }
    
}
