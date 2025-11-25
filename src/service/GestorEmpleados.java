package service;

import model.Empleado;
import model.Direccion;
import util.Validador;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase gestora que administra la colección de empleados.
 * Permite cargar datos desde archivos, agregar, buscar y mostrar empleados.
 */
public class GestorEmpleados {
    // Colección de empleados usando ArrayList
    private List<Empleado> listaEmpleados;

    /**
     * Constructor que inicializa la lista de empleados
     */
    public GestorEmpleados() {
        this.listaEmpleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado a la colección con validación
     */
    public void agregarEmpleado(Empleado empleado) {
        if (empleado != null) {
            // Validar datos del empleado usando la clase Validador
            boolean esValido = true;

            if (!Validador.esRutValido(empleado.getRut())) {
                System.out.println("Advertencia: RUT con formato inválido");
                esValido = false;
            }

            if (!Validador.esEmailValido(empleado.getEmail())) {
                System.out.println("Advertencia: Email con formato inválido");
                esValido = false;
            }

            if (!Validador.esSalarioValido(empleado.getSalario())) {
                System.out.println("Advertencia: Salario fuera del rango válido");
                esValido = false;
            }

            if (esValido) {
                listaEmpleados.add(empleado);
                System.out.println("Empleado agregado: " + empleado.getNombre() + " " + empleado.getApellido());
            } else {
                System.out.println("Empleado NO agregado debido a datos inválidos");
            }
        }
    }

    /**
     * Muestra todos los empleados por consola
     */
    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        System.out.println("Total de empleados: " + listaEmpleados.size());
        System.out.println();

        for (Empleado emp : listaEmpleados) {
            System.out.println(emp);
            System.out.println();
        }
    }

    /**
     * Busca empleados por departamento (búsqueda simple)
     */
    public List<Empleado> buscarPorDepartamento(String departamento) {
        List<Empleado> resultado = new ArrayList<>();

        for (Empleado emp : listaEmpleados) {
            if (emp.getDepartamento() != null &&
                emp.getDepartamento().equalsIgnoreCase(departamento)) {
                resultado.add(emp);
            }
        }

        return resultado;
    }

    /**
     * Filtra empleados por salario mínimo
     */
    public List<Empleado> filtrarPorSalario(double salarioMinimo) {
        List<Empleado> resultado = new ArrayList<>();

        for (Empleado emp : listaEmpleados) {
            if (emp.getSalario() >= salarioMinimo) {
                resultado.add(emp);
            }
        }

        return resultado;
    }

    /**
     * Carga empleados desde un archivo de texto
     * Formato: rut;nombre;apellido;email;telefono;calle;numero;ciudad;pais;cargo;departamento;salario;fechaContratacion
     */
    public void cargarDesdeArchivo(String rutaArchivo) {
        System.out.println("Cargando datos desde: " + rutaArchivo);

        int cargados = 0;
        int errores = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                // Saltar la primera línea si es encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    if (linea.toLowerCase().contains("rut")) {
                        continue;
                    }
                }

                try {
                    // Separar los datos usando punto y coma
                    String[] datos = linea.split(";");

                    if (datos.length < 13) {
                        throw new Exception("Formato incorrecto");
                    }

                    // Extraer datos
                    String rut = datos[0].trim();
                    String nombre = datos[1].trim();
                    String apellido = datos[2].trim();
                    String email = datos[3].trim();
                    String telefono = datos[4].trim();
                    String salarioStr = datos[11].trim();

                    // VALIDACIONES USANDO LA CLASE VALIDADOR
                    // Validar RUT con expresión regular
                    if (!Validador.esRutValido(rut)) {
                        throw new Exception("RUT inválido: " + rut);
                    }

                    // Validar email
                    if (!Validador.esEmailValido(email)) {
                        throw new Exception("Email inválido: " + email);
                    }

                    // Validar teléfono
                    if (!Validador.esTelefonoValido(telefono)) {
                        throw new Exception("Teléfono inválido: " + telefono);
                    }

                    // Parsear salario de forma segura
                    double salario = Validador.parseDoubleSeguro(salarioStr);

                    // Validar salario
                    if (!Validador.esSalarioValido(salario)) {
                        throw new Exception("Salario fuera de rango válido: $" + salario);
                    }

                    // Validar campos obligatorios
                    if (!Validador.esTextoValido(nombre) || !Validador.esTextoValido(apellido)) {
                        throw new Exception("Nombre o apellido vacío");
                    }

                    // Crear objetos después de validar
                    Direccion direccion = new Direccion(
                        datos[5].trim(), datos[6].trim(),
                        datos[7].trim(), datos[8].trim()
                    );

                    Empleado empleado = new Empleado(
                        rut, nombre, apellido, email, telefono, direccion,
                        datos[9].trim(), datos[10].trim(),
                        salario, datos[12].trim()
                    );

                    listaEmpleados.add(empleado);
                    cargados++;

                } catch (Exception e) {
                    errores++;
                    System.out.println("Error al procesar línea: " + e.getMessage());
                }
            }

            System.out.println("Empleados cargados exitosamente: " + cargados);
            if (errores > 0) {
                System.out.println("Líneas con errores: " + errores);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Retorna la cantidad de empleados
     */
    public int getCantidadEmpleados() {
        return listaEmpleados.size();
    }
}

