package model;

/**
 * Interfaz que define el contrato de comportamiento común
 * para todas las entidades registrables del sistema.
 */
public interface Registrable {
    /**
     * Devuelve un resumen conciso de la entidad
     * @return String con el resumen de la entidad
     */
    String mostrarResumen();
}

