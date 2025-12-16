package model;

/**
 * Clase que representa a un proveedor de la empresa Salmontt.
 * Extiende la clase Persona agregando atributos específicos del proveedor.
 * Implementa la interfaz Registrable.
 */
public class Proveedor extends Persona implements Registrable {
    // Atributos privados específicos del proveedor
    private String empresa;
    private String rubro;

    /**
     * Constructor vacío
     */
    public Proveedor() {
    }

    /**
     * Constructor completo con todos los parámetros
     * @param rut RUT del proveedor
     * @param nombre Nombre del contacto
     * @param apellido Apellido del contacto
     * @param email Correo electrónico
     * @param telefono Número de teléfono
     * @param direccion Objeto Direccion del proveedor
     * @param empresa Nombre de la empresa proveedora
     * @param rubro Rubro o sector del proveedor
     */
    public Proveedor(String rut, String nombre, String apellido, String email, String telefono,
                    Direccion direccion, String empresa, String rubro) {
        super(rut, nombre, apellido, email, telefono, direccion);
        this.empresa = empresa;
        this.rubro = rubro;
    }

    // Métodos getters y setters
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    /**
     * Método toString sobrescrito para representar el proveedor de forma legible
     * @return String con la representación del proveedor
     */
    @Override
    public String toString() {
        return "Proveedor{" +
                "Empresa='" + empresa + '\'' +
                ", RUT='" + getRut() + '\'' +
                ", Contacto='" + getNombre() + " " + getApellido() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Teléfono='" + getTelefono() + '\'' +
                ", Dirección='" + getDireccion() + '\'' +
                ", Rubro='" + rubro + '\'' +
                '}';
    }

    /**
     * Implementación del método de la interfaz Registrable
     * @return Resumen conciso del proveedor
     */
    @Override
    public String mostrarResumen() {
        return "Empresa: " + empresa +
               " | Contacto: " + getNombre() + " " + getApellido() +
               " | Email: " + getEmail() +
               " | Teléfono: " + getTelefono() +
               " | Rubro: " + rubro;
    }
}

