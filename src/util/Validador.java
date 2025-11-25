package util;

/**
 * Clase de utilidades para validación de datos.
 * Proporciona métodos estáticos para validar diferentes tipos de información.
 * Aplica el principio de responsabilidad única: solo se encarga de validaciones.
 */
public class Validador {

    /**
     * Valida que una cadena no esté vacía o nula
     * @param valor Cadena a validar
     * @return true si es válida, false en caso contrario
     */
    public static boolean esTextoValido(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    /**
     * Valida el formato básico de un email
     * @param email Email a validar
     * @return true si tiene formato válido, false en caso contrario
     */
    public static boolean esEmailValido(String email) {
        if (!esTextoValido(email)) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }

    /**
     * Valida que un número sea positivo
     * @param numero Número a validar
     * @return true si es positivo, false en caso contrario
     */
    public static boolean esNumeroPositivo(double numero) {
        return numero > 0;
    }

    /**
     * Valida el formato básico de un RUT chileno
     * @param rut RUT a validar
     * @return true si tiene formato válido, false en caso contrario
     */
    public static boolean esRutValido(String rut) {
        if (!esTextoValido(rut)) {
            return false;
        }
        // Validación básica: debe contener puntos, guión y dígito verificador
        return rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]");
    }

    /**
     * Valida el formato básico de un teléfono chileno
     * @param telefono Teléfono a validar
     * @return true si tiene formato válido, false en caso contrario
     */
    public static boolean esTelefonoValido(String telefono) {
        if (!esTextoValido(telefono)) {
            return false;
        }
        // Validación básica: debe comenzar con + o tener al menos 8 dígitos
        return telefono.startsWith("+") || telefono.length() >= 8;
    }

    /**
     * Valida que un salario esté dentro de un rango razonable
     * @param salario Salario a validar
     * @return true si está en rango válido, false en caso contrario
     */
    public static boolean esSalarioValido(double salario) {
        // Salario mínimo en Chile (aproximado) hasta un límite razonable
        return salario >= 400000 && salario <= 50000000;
    }

    /**
     * Intenta parsear un string a double de forma segura
     * @param valor String a convertir
     * @return El valor double o 0.0 si falla
     */
    public static double parseDoubleSeguro(String valor) {
        try {
            return Double.parseDouble(valor.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Intenta parsear un string a int de forma segura
     * @param valor String a convertir
     * @return El valor int o 0 si falla
     */
    public static int parseIntSeguro(String valor) {
        try {
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

