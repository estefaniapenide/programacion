/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.vacunas;

import java.util.Objects;

/**
 *
 * @author Estefania
 */
public class AsignaVacuna implements IGestionVacunasPais {

    private Vacuna laVacuna;
    private String pais;
    private long asignadas;

    public AsignaVacuna(Vacuna laVacuna, String pais) {
        this.laVacuna = laVacuna;
        this.pais = pais;
    }

    public Vacuna getVacuna() {
        return laVacuna;
    }

    public String getPais() {
        return pais;
    }

    public long getAsignadas() {
        return asignadas;
    }

    /**
     * Da valor al atributo asignadas
     *
     * @param numAsignadas número de vacunas que se quieren asignar a un país.
     */
    @Override
    public void asignar(long numAsignadas) {
        this.asignadas = numAsignadas;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Objects.isNull(obj)) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        AsignaVacuna other = (AsignaVacuna) obj;
        if (!laVacuna.getCodigo().equals(other.laVacuna.getCodigo())) {
            return false;
        }
        if (!pais.equals(other.pais)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = 25 * ((laVacuna.getCodigo() == null) ? 0 : laVacuna.getCodigo().hashCode());
        result += (pais == null) ? 0 : pais.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\tCódigo de la vacuna: " + laVacuna.getCodigo() + "\n"
                + "\tPaís:                " + pais + "\n"
                + "\tDosis asigandas:     " + asignadas;
    }

}
