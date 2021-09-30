package gal.teis.composicon_vehiculo;

import gal.teis.automovil.Vehiculo;
import gal.teis.componentes.Chasis;
import gal.teis.componentes.Llanta;
import gal.teis.componentes.Motor;

public class TestVehiculo {
    
    public static void main(String[] args) {
        
        Vehiculo auto1=new Vehiculo();
        auto1.setPrecio(45524.67f);
        auto1.setColor("morado");
        auto1.setFabricante("LOTUS");
        auto1.setNeumatico(new Llanta(35.6f, 16.5f, "MICHELIN"));
        auto1.setArmazon(new Chasis("Alta Rigidez", "Mediano", "Aluminio"));
        auto1.setMaquina(new Motor("BMW", 6, 760.5f));
        
        System.out.println("Vehiculo 1");
        System.out.println("Precio: " +auto1.getPrecio());
        System.out.println("Fabricante: " +auto1.getFabricante());
        System.out.println("Color: " +auto1.getColor());
        System.out.println("Caracteristicas del chasis:");
        System.out.println("Rigidez: " +auto1.getArmazon().getRigidez());
        System.out.println("Tamaño: " +auto1.getArmazon().getTamanio());
        System.out.println("Material: " +auto1.getArmazon().getMaterialDeConstruccion());
        System.out.println("Caracteristicas del motor:");
        System.out.println("Marca del motor: " +auto1.getMaquina().getMarca());
        System.out.println("Cilindros: " +auto1.getMaquina().getNumeroDeCilindros());
        System.out.println("Fuerza: " +auto1.getMaquina().getFuerza());
        System.out.println("Caracteristicas de la llanta:");
        System.out.println("Marca de la llanta: " +auto1.getNeumatico().getMarca());
        System.out.println("Diametro del rin: " +auto1.getNeumatico().getDiametroDelRin());
        System.out.println("Precion maxima: " +auto1.getNeumatico().getPrecionMaxima());
    }
    
}
