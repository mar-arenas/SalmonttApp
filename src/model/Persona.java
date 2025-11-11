package model;

/**
 * Clase base que representa a una persona.
 * Contiene información básica como RUT, nombre, email, teléfono y dirección.
 * Aplica el principio de composición con la clase Direccion.
 */
public class Persona {
    // Atributos privados (encapsulamiento)
    private String rut;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Direccion direccion; // Composición: una persona tiene una dirección

    /**
     * Constructor vacío
     */
    public Persona() {
    }

    /**
     * Constructor con todos los parámetros incluyendo dirección
     * @param rut RUT de la persona
     * @param nombre Nombre de la persona
     * @param apellido Apellido de la persona
     * @param email Correo electrónico
     * @param telefono Número de teléfono
     * @param direccion Objeto Direccion de la persona
     */
    public Persona(String rut, String nombre, String apellido, String email, String telefono, Direccion direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Métodos getters y setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Método toString para representar la persona de forma legible
     * @return String con la representación de la persona
     */
    @Override
    public String toString() {
        return "Persona{" +
                "RUT='" + rut + '\'' +
                ", Nombre='" + nombre + " " + apellido + '\'' +
                ", Email='" + email + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Dirección=" + direccion.toString() +
                '}';
    }
}
