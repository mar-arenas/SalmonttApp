package ui;

import model.Direccion;
import model.Empleado;
import service.GestorEmpleados;
import java.util.List;

/**
 * Clase principal del sistema de gestión de empleados de Salmontt.
 * Ejecuta el programa y demuestra el uso de colecciones, lectura de archivos y búsquedas.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE EMPLEADOS - SALMONTT ===\n");

        // Crear instancia del gestor de empleados (composición)
        GestorEmpleados gestor = new GestorEmpleados();

        // 1. CARGAR DATOS DESDE ARCHIVO
        System.out.println("--- CARGANDO DATOS DESDE ARCHIVO ---");
        gestor.cargarDesdeArchivo("empleados.txt");

        // 2. AGREGAR EMPLEADOS MANUALMENTE CON VALIDACIÓN
        System.out.println("\n--- AGREGANDO EMPLEADOS MANUALMENTE ---");
        try {
            Direccion dir1 = new Direccion("Avenida Diego Portales", "1500", "Puerto Montt", "Chile");
            Empleado emp1 = new Empleado(
                "77.888.999-0", "Sofía", "Lagos", "sofia.lagos@salmontt.cl", "+56977888999",
                dir1, "Bióloga Marina", "Investigación", 2400000, "15/01/2023"
            );
            gestor.agregarEmpleado(emp1);
        } catch (Exception e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }

        // 3. MOSTRAR TODOS LOS EMPLEADOS
        System.out.println("\n--- LISTADO DE EMPLEADOS ---");
        gestor.mostrarEmpleados();

        // 4. BÚSQUEDA POR DEPARTAMENTO
        System.out.println("\n--- BÚSQUEDA POR DEPARTAMENTO ---");
        String departamento = "Producción";
        System.out.println("Buscando empleados del departamento: " + departamento);
        List<Empleado> empleadosProduccion = gestor.buscarPorDepartamento(departamento);

        if (!empleadosProduccion.isEmpty()) {
            System.out.println("Encontrados " + empleadosProduccion.size() + " empleado(s):");
            for (Empleado emp : empleadosProduccion) {
                System.out.println("  - " + emp.getNombre() + " " + emp.getApellido() +
                                 " (" + emp.getCargo() + ")");
            }
        } else {
            System.out.println("No se encontraron empleados en ese departamento.");
        }

        // 5. FILTRAR POR SALARIO
        System.out.println("\n--- FILTRO POR SALARIO ---");
        double salarioMinimo = 2000000;
        System.out.println("Empleados con salario >= $" + String.format("%,.0f", salarioMinimo) + ":");
        List<Empleado> empleadosAltoSalario = gestor.filtrarPorSalario(salarioMinimo);

        for (Empleado emp : empleadosAltoSalario) {
            System.out.println("  - " + emp.getNombre() + " " + emp.getApellido() +
                             " - $" + String.format("%,.0f", emp.getSalario()));
        }

        // 6. DEMOSTRACIÓN DE GETTERS Y SETTERS
        System.out.println("\n--- MODIFICACIÓN DE DATOS ---");
        if (!empleadosProduccion.isEmpty()) {
            Empleado empleado = empleadosProduccion.get(0);
            System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
            System.out.println("Cargo actual: " + empleado.getCargo());

            // Modificar usando setter
            empleado.setCargo("Jefe de Producción");
            System.out.println("Nuevo cargo: " + empleado.getCargo());
        }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
        System.out.println("Total de empleados gestionados: " + gestor.getCantidadEmpleados());
    }
}

