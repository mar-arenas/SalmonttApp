package app;

import model.Direccion;
import model.Persona;
import model.Empleado;

/**
 * Clase principal para ejecutar y probar el sistema de gestión de personas de Salmontt.
 * Crea instancias de las clases del modelo y muestra su información por consola.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE PERSONAS - SALMONTT ===\n");

        // Crear direcciones
        Direccion direccion1 = new Direccion("Avenida Providencia", "1234", "Santiago", "Chile");
        Direccion direccion2 = new Direccion("Calle Los Robles", "567", "Puerto Montt", "Chile");
        Direccion direccion3 = new Direccion("Paseo Bulnes", "890", "Santiago", "Chile");

        // Crear una persona
        System.out.println("--- PERSONA ---");
        Persona persona1 = new Persona(
                "12.345.678-9",
                "María",
                "González",
                "maria.gonzalez@email.com",
                "+56912345678",
                direccion1
        );
        System.out.println(persona1);
        System.out.println();

        // Crear empleados
        System.out.println("--- EMPLEADO 1 ---");
        Empleado empleado1 = new Empleado(
                "23.456.789-0",
                "Juan",
                "Pérez",
                "juan.perez@salmontt.cl",
                "+56923456789",
                direccion2,
                "Ingeniero en Acuicultura",
                "Producción",
                1500000,
                "01/03/2023"
        );
        System.out.println(empleado1);
        System.out.println();

        System.out.println("--- EMPLEADO 2 ---");
        Empleado empleado2 = new Empleado(
                "34.567.890-1",
                "Ana",
                "Silva",
                "ana.silva@salmontt.cl",
                "+56934567890",
                direccion3,
                "Gerente de Recursos Humanos",
                "Administración",
                2500000,
                "15/01/2022"
        );
        System.out.println(empleado2);
        System.out.println();

        // Demostración de uso de getters y setters
        System.out.println("--- MODIFICACIÓN DE DATOS ---");
        System.out.println("Cargo anterior de empleado1: " + empleado1.getCargo());
        empleado1.setCargo("Jefe de Producción");
        System.out.println("Nuevo cargo de empleado1: " + empleado1.getCargo());
        System.out.println();

        // Mostrar empleado actualizado
        System.out.println("--- EMPLEADO 1 ACTUALIZADO ---");
        System.out.println(empleado1);
        System.out.println();

        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}
