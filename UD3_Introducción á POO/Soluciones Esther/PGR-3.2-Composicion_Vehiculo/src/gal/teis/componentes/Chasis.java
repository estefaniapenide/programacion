package gal.teis.componentes;

public class Chasis {
    private String rigidez;
    private String tamanio;
    private String materialDeConstruccion;

    public Chasis() {
    }

    public Chasis(String rigidez, String tamanio, String materialDeConstruccion) {
        this.rigidez = rigidez;
        this.tamanio = tamanio;
        this.materialDeConstruccion = materialDeConstruccion;
    }

    public String getMaterialDeConstruccion() {
        return materialDeConstruccion;
    }

    public void setMaterialDeConstruccion(String materialDeConstruccion) {
        this.materialDeConstruccion = materialDeConstruccion;
    }

    public String getRigidez() {
        return rigidez;
    }

    public void setRigidez(String rigidez) {
        this.rigidez = rigidez;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    
    public void absorberImpacto(){
        System.out.println("Has recibido un golpe");
    }
    
    public void sujetarComponentes(){
        System.out.println("Todos los componentes estan sujetos");
    }
    
}
