![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# Sistema de Gestión de Empleados y Proveedores - Salmontt

## Autor del proyecto
- **Nombre completo:** Mariana Arenas Vergara
- **Carrera:** Analista Programador
- **Sede:** Online
- **Asignatura:** Desarrollo Orientado a Objetos I
- **Evaluación:** Experiencia 3 - Semana 8

---

## Descripción general del sistema

Este proyecto corresponde a la Experiencia 3 de la asignatura *Desarrollo Orientado a Objetos I*. Se trata de un sistema de gestión desarrollado en Java para la empresa salmonera Salmontt, cuyo objetivo es modelar y gestionar empleados y proveedores aplicando los principios de encapsulamiento, composición, herencia, polimorfismo e interfaces.

El sistema permite cargar, almacenar, buscar y mostrar información de empleados utilizando colecciones dinámicas y lectura de archivos externos. Además, incorpora una interfaz gráfica simple para facilitar la interacción del usuario con el sistema, permitiendo el registro de distintos tipos de entidades de forma polimórfica.

El proyecto fue desarrollado a partir de un caso contextualizado, abordando problemáticas reales de gestión de recursos humanos y proveedores, proponiendo una solución estructurada, modular y reutilizable.

---

## Estructura general del proyecto

```plaintext
POO-exp1-Salmontt/
├── src/
│   ├── model/                      # Clases de dominio
│   │   ├── Registrable.java        # Interfaz común para entidades registrables
│   │   ├── Persona.java            # Clase base con datos personales
│   │   ├── Empleado.java           # Empleado (extiende Persona, implementa Registrable)
│   │   ├── Proveedor.java          # Proveedor (extiende Persona, implementa Registrable)
│   │   └── Direccion.java          # Clase para direcciones físicas
│   │
│   ├── service/                    # Lógica de negocio
│   │   ├── GestorEmpleados.java   # Gestor específico para empleados
│   │   └── GestorEntidades.java   # Gestor polimórfico para entidades registrables
│   │
│   ├── util/                       # Utilidades y validaciones
│   │   └── Validador.java          # Métodos de validación de datos
│   │
│   └── ui/                         # Interfaz de usuario
│       ├── Main.java               # Programa principal (consola)
│       └── MainGUI.java            # Interfaz gráfica con JOptionPane
│
├── bin/                            # Archivos compilados (.class)
├── empleados.txt                   # Archivo de datos de empleados
└── README.md                       # Este archivo
```

---

## Paquetes Utilizados

### Paquete `model`
Contiene las clases que representan las entidades del sistema:
- **Registrable**: Interfaz que define el contrato común para entidades registrables
- **Direccion**: Representa una dirección física (calle, número, ciudad, país)
- **Persona**: Clase base con datos personales (RUT, nombre, apellido, email, teléfono, dirección)
- **Empleado**: Extiende Persona, implementa Registrable, agrega cargo, departamento, salario y fecha de contratación
- **Proveedor**: Extiende Persona, implementa Registrable, agrega empresa y rubro

### Paquete `service`
Contiene la lógica de negocio:
- **GestorEmpleados**: Administra la colección de empleados usando ArrayList
  - Carga datos desde archivos .txt
  - Agrega empleados con validación
  - Busca por departamento
  - Filtra por salario
  - Muestra listados
- **GestorEntidades**: Administra colecciones polimórficas de entidades registrables
  - Agrega entidades de distintos tipos (Empleado, Proveedor)
  - Obtiene resúmenes diferenciados por tipo usando instanceof
  - Gestiona colecciones heterogéneas

### Paquete `util`
Contiene utilidades para el sistema:
- **Validador**: Métodos estáticos para validar RUT, email, teléfono, salarios, textos, etc.

### Paquete `ui`
Contiene la interfaz de usuario:
- **Main**: Clase principal que ejecuta el sistema por consola, carga datos desde archivo y demuestra búsquedas
- **MainGUI**: Interfaz gráfica con JOptionPane para ingreso interactivo de empleados y proveedores

---

## Clases Implementadas

### Registrable (Interfaz)
- Define el contrato común para entidades registrables
- Método: `String mostrarResumen()`
- Implementada por: Empleado y Proveedor

### Direccion
- Atributos: calle, numero, ciudad, pais
- Métodos: constructores, getters, setters, toString()

### Persona
- Atributos: rut, nombre, apellido, email, telefono, direccion
- Aplica **composición** con Direccion
- Métodos: constructores, getters, setters, toString()

### Empleado (hereda de Persona, implementa Registrable)
- Atributos adicionales: cargo, departamento, salario, fechaContratacion
- Usa `super()` para llamar al constructor padre
- Métodos: constructores, getters, setters, toString(), mostrarResumen()

### Proveedor (hereda de Persona, implementa Registrable)
- Atributos adicionales: empresa, rubro
- Usa `super()` para llamar al constructor padre
- Métodos: constructores, getters, setters, toString(), mostrarResumen()

### GestorEmpleados
- Usa `ArrayList<Empleado>` para almacenar empleados
- Métodos principales:
  - `cargarDesdeArchivo()`: Lee datos desde archivo .txt
  - `agregarEmpleado()`: Agrega un empleado con validación
  - `buscarPorDepartamento()`: Busca empleados por departamento
  - `filtrarPorSalario()`: Filtra empleados por salario mínimo
  - `mostrarEmpleados()`: Muestra todos los empleados
  - `getCantidadEmpleados()`: Retorna el total de empleados

### GestorEntidades
- Usa `ArrayList<Registrable>` para almacenar entidades de distintos tipos
- Métodos principales:
  - `agregar(Registrable r)`: Agrega una entidad registrable
  - `obtenerResúmenes()`: Obtiene lista de resúmenes usando instanceof para diferenciar tipos
  - `getCantidad()`: Retorna el total de entidades registradas

---

## Conceptos de POO aplicados en el proyecto

### 1. Encapsulamiento
- Todos los atributos de las clases son `private`
- Acceso controlado mediante getters y setters públicos
- Ejemplo: Clase `Persona` con atributos privados (rut, nombre, apellido)

### 2. Herencia
- `Empleado` extiende `Persona`
- `Proveedor` extiende `Persona`
- Reutilización de código mediante `super()` para llamar al constructor padre
- Especialización de clases base añadiendo atributos específicos

### 3. Polimorfismo
- Sobrescritura del método `toString()` en todas las clases
- Implementación del método `mostrarResumen()` de forma diferente en `Empleado` y `Proveedor`
- Colecciones polimórficas: `ArrayList<Registrable>` que puede contener distintos tipos

### 4. Interfaces
- Interfaz `Registrable` que define un contrato común
- Implementada por `Empleado` y `Proveedor`
- Permite tratar objetos de distintas clases de forma uniforme

### 5. Composición
- `Persona` tiene un objeto `Direccion` (relación "tiene-un")
- `GestorEmpleados` contiene una lista de `Empleado`
- `GestorEntidades` contiene una lista de `Registrable`

### 6. Abstracción
- Uso de interfaces para definir comportamientos comunes
- Separación de responsabilidades en diferentes paquetes (model, service, util, ui)
- Clase `Validador` con métodos estáticos para validaciones

### 7. Uso de instanceof
- Diferenciación de tipos en tiempo de ejecución
- Aplicado en `GestorEntidades.obtenerResúmenes()` para identificar si es Empleado o Proveedor

---

## Resumen de cambios por clase (qué buscar en el código)

- model/Empleado.java
  - fechaContratacion cambia a LocalDate (getters/setters ajustados).
- service/GestorEmpleados.java
  - nuevo método exportarCSV(String ruta).
  - carga robusta desde archivo: detecta separador, acepta fechas en dos formatos, ignora líneas erróneas.
- util/Validador.java
  - validaciones de RUT y email más estrictas.
  - validación de salario y teléfono actualizada.
- ui/Main.java
  - nueva opción para exportar CSV y mensajes informativos.

---

## Ejemplo de salida (breve)
```
--- CARGANDO DATOS DESDE ARCHIVO ---
Cargando datos desde: empleados.txt (UTF-8) — separador detectado: ;
Empleados cargados exitosamente: 15 (2 filas ignoradas por formato)
--- EXPORTANDO A CSV ---
Exportado correctamente a: empleados_export.csv
```

---

## Funcionalidades Implementadas

### Colecciones Dinámicas
- Uso de `ArrayList<Empleado>` para almacenar empleados
- Operaciones de inserción, búsqueda y recorrido

### Lectura de Archivos
- Lectura de archivos .txt
- Uso de `BufferedReader` y `FileReader`
- Procesamiento línea por línea con `.split()`

### Búsquedas y Filtros
- Búsqueda por departamento
- Filtrado por salario mínimo
- Uso de bucles for-each

### Validación de Datos
- Uso de try-catch para capturar errores
- Validación de formato de datos
- Manejo de excepciones

### Principios POO

**Encapsulamiento:**
- Atributos `private` en todas las clases
- Acceso mediante getters y setters

**Herencia:**
- `Empleado` extiende `Persona`
- Uso de `super()` para llamar al constructor padre

**Composición:**
- `Persona` tiene una `Direccion`
- `GestorEmpleados` contiene una lista de `Empleado`

**Polimorfismo:**
- Sobrescritura del método `toString()` en todas las clases

---

### Funcionalidades disponibles

**En Main (consola):**
- Carga automática de empleados desde archivo empleados.txt
- Demostración de búsquedas por departamento
- Filtrado de empleados por salario
- Visualización de todos los empleados

**En MainGUI (interfaz gráfica):**
- Agregar empleados con validación de datos
- Agregar proveedores con validación de datos
- Mostrar resúmenes de todas las entidades registradas
- Validación con reintentos en caso de datos inválidos
- Cancelar operaciones en cualquier momento


---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Experiencia 3 - Semana 8

---

