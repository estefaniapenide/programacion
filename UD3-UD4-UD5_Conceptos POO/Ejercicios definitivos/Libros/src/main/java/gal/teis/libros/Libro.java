/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.libros;

/**
 *
 * @author Estefania
 */
public class Libro {

    //Propiedades
    private String titulo;
    private String autor;

    private int totalPaginas;
    private int paginaActual;
    
    public Libro(){
    }

    public Libro(String titulo, String autor, int totalPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.totalPaginas=totalPaginas;
    }
    
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    //Setter y getter
    public String getTitulo() {
        return titulo;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public String getAutor() {
        return autor;
    }

    /*No hay get para páginaActual, esta propiedad se maneja mediante un 
        método específico: avanzarPagina() y avanzarCapitulo()*/
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Métodos
    public void avanzarPagina() {
        paginaActual++;
    }

    public void avanzarCapitulo() {
        paginaActual += 20;
    }
}
