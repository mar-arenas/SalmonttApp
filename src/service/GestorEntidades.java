package service;

import model.Registrable;
import model.Empleado;
import model.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase gestora que administra una colección polimórfica de entidades registrables.
 * Permite agregar, gestionar y obtener resúmenes de objetos que implementan Registrable.
 */
public class GestorEntidades {
    // Colección polimórfica de entidades registrables
    private List<Registrable> lista;

    /**
     * Constructor que inicializa la lista de entidades
     */
    public GestorEntidades() {
        this.lista = new ArrayList<>();
    }

    /**
     * Agrega una entidad registrable a la colección
     * @param r Objeto que implementa Registrable
     */
    public void agregar(Registrable r) {
        if (r != null) {
            lista.add(r);
        }
    }

    /**
     * Obtiene una lista de resúmenes de todas las entidades registradas
     * Utiliza instanceof para diferenciar tipos y agregar prefijos
     * @return Lista de strings con los resúmenes
     */
    public List<String> obtenerResúmenes() {
        List<String> resumenes = new ArrayList<>();

        for (Registrable r : lista) {
            String prefijo = "";

            // Uso de instanceof para identificar el tipo específico
            if (r instanceof Empleado) {
                prefijo = "Empleado: ";
            } else if (r instanceof Proveedor) {
                prefijo = "Proveedor: ";
            }

            resumenes.add(prefijo + r.mostrarResumen());
        }

        return resumenes;
    }

    /**
     * Retorna la cantidad de entidades registradas
     * @return Número de entidades en la colección
     */
    public int getCantidad() {
        return lista.size();
    }
}

