package gal.teis.componentes;

public class Motor {
    private String marca;
    private int numeroDeCilindros;
    private float fuerza;

    public Motor() {
    }

    public Motor(String marca, int numeroDeCilindros, float fuerza) {
        this.marca = marca;
        this.numeroDeCilindros = numeroDeCilindros;
        this.fuerza = fuerza;
    }

    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumeroDeCilindros() {
        return numeroDeCilindros;
    }

    public void setNumeroDeCilindros(int numeroDeCilindros) {
        this.numeroDeCilindros = numeroDeCilindros;
    }
    
    public void consumirGasolina(){
        System.out.println("La gasolina consumida es constante");
    }
    
    public void obtenerOxigeno(){
        System.out.println("El oxigeno que se obtine es suficiente");
    }
    
}
