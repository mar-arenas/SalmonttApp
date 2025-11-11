# Sistema de Gestión de Personas - Salmontt

## Descripción del Proyecto

Este proyecto implementa un sistema básico de gestión de personas para la empresa Salmontt, desarrollado en Java aplicando los principios de Programación Orientada a Objetos (POO). El sistema permite representar personas y empleados con sus datos personales y direcciones, aplicando conceptos fundamentales como encapsulamiento, herencia y composición.

## Contexto

Salmontt es una empresa dedicada a la acuicultura y comercialización de salmón. Actualmente, no cuenta con un sistema estructurado para organizar la información de las personas vinculadas a la empresa. Este proyecto constituye la primera fase de digitalización de sus sistemas internos, proporcionando una base técnica sólida para futuras funcionalidades.

## Estructura del Proyecto

```
POO-exp1/
├── src/
│   ├── model/              # Paquete con las clases del dominio
│   │   ├── Direccion.java  # Clase que representa una dirección
│   │   ├── Persona.java    # Clase base que representa una persona
│   │   └── Empleado.java   # Clase que hereda de Persona (empleado)
│   └── app/                # Paquete con la aplicación principal
│       └── Main.java       # Clase principal para ejecutar el sistema
└── README.md               # Este archivo
```

## Clases Implementadas

### 1. Direccion (model/Direccion.java)
Clase que representa una dirección física.

**Atributos:**
- `calle` (String): Nombre de la calle
- `numero` (String): Número de la dirección
- `ciudad` (String): Ciudad
- `pais` (String): País

**Métodos:**
- Constructor vacío y constructor con parámetros
- Getters y setters para todos los atributos
- `toString()`: Retorna la dirección en formato legible

### 2. Persona (model/Persona.java)
Clase base que representa a una persona. Aplica **composición** con la clase Direccion.

**Atributos:**
- `rut` (String): RUT de la persona
- `nombre` (String): Nombre
- `apellido` (String): Apellido
- `email` (String): Correo electrónico
- `telefono` (String): Número de teléfono
- `direccion` (Direccion): Objeto Direccion (composición)

**Métodos:**
- Constructor vacío y constructores con parámetros
- Getters y setters para todos los atributos
- `toString()`: Retorna los datos de la persona en formato legible

### 3. Empleado (model/Empleado.java)
Clase que **hereda** de Persona, representando a un empleado de la empresa.

**Atributos adicionales:**
- `cargo` (String): Cargo del empleado
- `departamento` (String): Departamento donde trabaja
- `salario` (double): Salario del empleado
- `fechaContratacion` (String): Fecha de contratación

**Métodos:**
- Constructores que invocan al constructor de la clase
- Getters y setters para los atributos específicos
- `toString()` sobrescrito: Retorna los datos completos del empleado

### 4. Main (app/Main.java)
Clase principal que ejecuta el sistema y realiza pruebas.

**Funcionalidad:**
- Crea instancias de Direccion, Persona y Empleado
- Muestra la información de los objetos por consola usando `toString()`
- Demuestra el uso de getters y setters modificando datos

## Principios de POO Aplicados

1. **Encapsulamiento**: Todos los atributos son privados con acceso mediante getters y setters públicos
2. **Herencia**: La clase Empleado extiende la clase Persona
3. **Composición**: La clase Persona contiene un objeto Direccion
4. **Polimorfismo**: Sobrescritura del método `toString()` en todas las clases

## Autor

- **Nombre del Estudiante**: Mariana Arenas Vergara
- **Asignatura**: PRY2202 - Programación Orientada a Objetos I
- **Institución**: DuocUC
- **Fecha**: Noviembre 2025
