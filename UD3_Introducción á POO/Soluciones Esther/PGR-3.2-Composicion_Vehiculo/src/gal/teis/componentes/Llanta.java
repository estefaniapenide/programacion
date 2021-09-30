package gal.teis.componentes;

public class Llanta {
    private float precionMaxima;
    private float diametroDelRin;
    private String marca;

    public Llanta() {
    }

    public Llanta(float precionMaxima, float diametroDelRin, String marca) {
        this.precionMaxima = precionMaxima;
        this.diametroDelRin = diametroDelRin;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecionMaxima() {
        return precionMaxima;
    }

    public void setPrecionMaxima(float precionMaxima) {
        this.precionMaxima = precionMaxima;
    }

    public float getDiametroDelRin() {
        return diametroDelRin;
    }

    public void setDiametroDelRin(float diametroDelRin) {
        this.diametroDelRin = diametroDelRin;
    }
    
    public void rodarIzquierda(){
        System.out.println("Rodando hacia la izquierda");
    }
    
    public void rodarDerecha(){
        System.out.println("Rodando hacia la derecha");
    }
    
}
