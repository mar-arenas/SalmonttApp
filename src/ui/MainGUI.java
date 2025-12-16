package ui;

import model.Direccion;
import model.Empleado;
import model.Proveedor;
import service.GestorEntidades;
import util.Validador;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Interfaz gráfica para el sistema de gestión de entidades de Salmontt.
 * Utiliza JOptionPane para ingresar y visualizar datos de empleados y proveedores.
 */
public class MainGUI {

    private static GestorEntidades gestor = new GestorEntidades();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            String[] opciones = {"Agregar Empleado", "Agregar Proveedor", "Mostrar registros", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "Sistema de Gestión de Entidades - Salmontt\n\nSeleccione una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            switch (seleccion) {
                case 0:
                    agregarEmpleado();
                    break;
                case 1:
                    agregarProveedor();
                    break;
                case 2:
                    mostrarRegistros();
                    break;
                case 3:
                case JOptionPane.CLOSED_OPTION:
                    continuar = false;
                    JOptionPane.showMessageDialog(null,
                        "Total de entidades gestionadas: " + gestor.getCantidad() + "\n¡Hasta pronto!",
                        "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
    }

    /**
     * Solicita datos para crear un nuevo empleado
     */
    private static void agregarEmpleado() {
        try {
            // Solicitar y validar RUT
            String rut = solicitarCampoValidado("Ingrese RUT (formato: 12.345.678-9):",
                Validador::esRutValido, "RUT inválido. Debe tener formato 12.345.678-9");
            if (rut == null) return;

            // Solicitar y validar nombre
            String nombre = solicitarCampoValidado("Ingrese nombre:",
                Validador::esTextoValido, "Nombre no puede estar vacío");
            if (nombre == null) return;

            // Solicitar y validar apellido
            String apellido = solicitarCampoValidado("Ingrese apellido:",
                Validador::esTextoValido, "Apellido no puede estar vacío");
            if (apellido == null) return;

            // Solicitar y validar email
            String email = solicitarCampoValidado("Ingrese email:",
                Validador::esEmailValido, "Email inválido. Debe contener @ y .");
            if (email == null) return;

            // Solicitar y validar teléfono
            String telefono = solicitarCampoValidado("Ingrese teléfono:",
                Validador::esTelefonoValido, "Teléfono inválido");
            if (telefono == null) return;

            // Solicitar datos de dirección
            String calle = solicitarCampoValidado("Ingrese calle:",
                Validador::esTextoValido, "Calle no puede estar vacía");
            if (calle == null) return;

            String numero = solicitarCampoValidado("Ingrese número:",
                Validador::esTextoValido, "Número no puede estar vacío");
            if (numero == null) return;

            String ciudad = solicitarCampoValidado("Ingrese ciudad:",
                Validador::esTextoValido, "Ciudad no puede estar vacía");
            if (ciudad == null) return;

            String pais = solicitarCampoValidado("Ingrese país:",
                Validador::esTextoValido, "País no puede estar vacío");
            if (pais == null) return;

            // Solicitar y validar cargo
            String cargo = solicitarCampoValidado("Ingrese cargo:",
                Validador::esTextoValido, "Cargo no puede estar vacío");
            if (cargo == null) return;

            // Solicitar y validar departamento
            String departamento = solicitarCampoValidado("Ingrese departamento:",
                Validador::esTextoValido, "Departamento no puede estar vacío");
            if (departamento == null) return;

            // Solicitar y validar salario
            double salario = solicitarSalario();
            if (salario == -1) return;

            // Solicitar fecha de contratación
            String fechaContratacion = solicitarCampoValidado("Ingrese fecha de contratación (DD/MM/AAAA):",
                Validador::esTextoValido, "Fecha no puede estar vacía");
            if (fechaContratacion == null) return;

            // Crear objetos
            Direccion direccion = new Direccion(calle, numero, ciudad, pais);
            Empleado empleado = new Empleado(rut, nombre, apellido, email, telefono,
                                            direccion, cargo, departamento, salario, fechaContratacion);

            // Agregar al gestor
            gestor.agregar(empleado);

            JOptionPane.showMessageDialog(null,
                "Empleado agregado exitosamente:\n" + empleado.mostrarResumen(),
                "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al crear empleado: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Solicita datos para crear un nuevo proveedor
     */
    private static void agregarProveedor() {
        try {
            // Solicitar y validar RUT
            String rut = solicitarCampoValidado("Ingrese RUT del contacto (formato: 12.345.678-9):",
                Validador::esRutValido, "RUT inválido. Debe tener formato 12.345.678-9");
            if (rut == null) return;

            // Solicitar y validar nombre del contacto
            String nombre = solicitarCampoValidado("Ingrese nombre del contacto:",
                Validador::esTextoValido, "Nombre no puede estar vacío");
            if (nombre == null) return;

            // Solicitar y validar apellido del contacto
            String apellido = solicitarCampoValidado("Ingrese apellido del contacto:",
                Validador::esTextoValido, "Apellido no puede estar vacío");
            if (apellido == null) return;

            // Solicitar y validar email
            String email = solicitarCampoValidado("Ingrese email:",
                Validador::esEmailValido, "Email inválido. Debe contener @ y .");
            if (email == null) return;

            // Solicitar y validar teléfono
            String telefono = solicitarCampoValidado("Ingrese teléfono:",
                Validador::esTelefonoValido, "Teléfono inválido");
            if (telefono == null) return;

            // Solicitar datos de dirección
            String calle = solicitarCampoValidado("Ingrese calle:",
                Validador::esTextoValido, "Calle no puede estar vacía");
            if (calle == null) return;

            String numero = solicitarCampoValidado("Ingrese número:",
                Validador::esTextoValido, "Número no puede estar vacío");
            if (numero == null) return;

            String ciudad = solicitarCampoValidado("Ingrese ciudad:",
                Validador::esTextoValido, "Ciudad no puede estar vacía");
            if (ciudad == null) return;

            String pais = solicitarCampoValidado("Ingrese país:",
                Validador::esTextoValido, "País no puede estar vacío");
            if (pais == null) return;

            // Solicitar y validar empresa
            String empresa = solicitarCampoValidado("Ingrese nombre de la empresa:",
                Validador::esTextoValido, "Empresa no puede estar vacía");
            if (empresa == null) return;

            // Solicitar y validar rubro
            String rubro = solicitarCampoValidado("Ingrese rubro:",
                Validador::esTextoValido, "Rubro no puede estar vacío");
            if (rubro == null) return;

            // Crear objetos
            Direccion direccion = new Direccion(calle, numero, ciudad, pais);
            Proveedor proveedor = new Proveedor(rut, nombre, apellido, email, telefono,
                                               direccion, empresa, rubro);

            // Agregar al gestor
            gestor.agregar(proveedor);

            JOptionPane.showMessageDialog(null,
                "Proveedor agregado exitosamente:\n" + proveedor.mostrarResumen(),
                "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al crear proveedor: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra todos los registros almacenados
     */
    private static void mostrarRegistros() {
        List<String> resumenes = gestor.obtenerResúmenes();

        if (resumenes.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                "No hay registros para mostrar.",
                "Registros", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("REGISTROS DEL SISTEMA\n");
            mensaje.append("Total: ").append(gestor.getCantidad()).append("\n\n");

            for (String resumen : resumenes) {
                mensaje.append(resumen).append("\n\n");
            }

            JOptionPane.showMessageDialog(null,
                mensaje.toString(),
                "Registros", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Solicita un campo con validación y reintentos
     * @param mensaje Mensaje a mostrar
     * @param validador Función de validación
     * @param mensajeError Mensaje de error si la validación falla
     * @return El valor válido o null si el usuario cancela
     */
    private static String solicitarCampoValidado(String mensaje, ValidadorFunc validador, String mensajeError) {
        while (true) {
            String valor = JOptionPane.showInputDialog(null, mensaje, "Ingreso de datos", JOptionPane.QUESTION_MESSAGE);

            // Usuario canceló
            if (valor == null) {
                return null;
            }

            // Validar
            if (validador.validar(valor)) {
                return valor;
            } else {
                int opcion = JOptionPane.showConfirmDialog(null,
                    mensajeError + "\n¿Desea intentar nuevamente?",
                    "Error de validación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);

                if (opcion != JOptionPane.YES_OPTION) {
                    return null;
                }
            }
        }
    }

    /**
     * Solicita y valida un salario
     * @return El salario válido o -1 si el usuario cancela
     */
    private static double solicitarSalario() {
        while (true) {
            String valorStr = JOptionPane.showInputDialog(null,
                "Ingrese salario (entre $400.000 y $10.000.000):",
                "Ingreso de datos",
                JOptionPane.QUESTION_MESSAGE);

            // Usuario canceló
            if (valorStr == null) {
                return -1;
            }

            // Intentar parsear
            double salario = Validador.parseDoubleSeguro(valorStr);

            // Validar
            if (Validador.esSalarioValido(salario)) {
                return salario;
            } else {
                int opcion = JOptionPane.showConfirmDialog(null,
                    "Salario inválido. Debe estar entre $400.000 y $10.000.000\n¿Desea intentar nuevamente?",
                    "Error de validación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.ERROR_MESSAGE);

                if (opcion != JOptionPane.YES_OPTION) {
                    return -1;
                }
            }
        }
    }

    /**
     * Interfaz funcional para validadores
     */
    @FunctionalInterface
    interface ValidadorFunc {
        boolean validar(String valor);
    }
}

