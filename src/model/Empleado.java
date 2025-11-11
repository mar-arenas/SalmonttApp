package model;

/**
 * Clase que representa a un empleado de la empresa Salmontt.
 * Extiende la clase Persona agregando atributos específicos del empleado.
 * Aplica el principio de herencia.
 */
public class Empleado extends Persona {
    // Atributos privados específicos del empleado
    private String cargo;
    private String departamento;
    private double salario;
    private String fechaContratacion;

    /**
     * Constructor vacío
     */
    public Empleado() {
    }

    /**
     * Constructor completo con todos los parámetros
     * @param rut RUT del empleado
     * @param nombre Nombre del empleado
     * @param apellido Apellido del empleado
     * @param email Correo electrónico
     * @param telefono Número de teléfono
     * @param direccion Objeto Direccion del empleado
     * @param cargo Cargo del empleado
     * @param departamento Departamento donde trabaja
     * @param salario Salario del empleado
     * @param fechaContratacion Fecha de contratación
     */
    public Empleado(String rut, String nombre, String apellido, String email, String telefono, 
                    Direccion direccion, String cargo, String departamento, double salario, 
                    String fechaContratacion) {
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
    }

    // Métodos getters y setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * Método toString sobrescrito para representar el empleado de forma legible
     * @return String con la representación del empleado
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "RUT='" + getRut() + '\'' +
                ", Nombre='" + getNombre() + " " + getApellido() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Teléfono='" + getTelefono() + '\'' +
                ", Dirección='" + getDireccion() + '\'' +
                ", Cargo='" + cargo + '\'' +
                ", Departamento='" + departamento + '\'' +
                ", Salario=$" + String.format("%,.0f", salario) +
                ", Fecha de Contratación='" + fechaContratacion + '\'' +
                '}';
    }
}
