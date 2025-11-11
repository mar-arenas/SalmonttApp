package model;

/**
 * Clase que representa una dirección física.
 * Contiene información sobre calle, número, ciudad y país.
 */
public class Direccion {
    // Atributos privados (encapsulamiento)
    private String calle;
    private String numero;
    private String ciudad;
    private String pais;

    /**
     * Constructor vacío
     */
    public Direccion() {
    }

    /**
     * Constructor con todos los parámetros
     * @param calle Nombre de la calle
     * @param numero Número de la dirección
     * @param ciudad Ciudad
     * @param pais País
     */
    public Direccion(String calle, String numero, String ciudad, String pais) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    // Métodos getters y setters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Método toString para representar la dirección de forma legible
     * @return String con la representación de la dirección
     */
    @Override
    public String toString() {
        return calle + " " + numero + ", " + ciudad + ", " + pais;
    }
}
