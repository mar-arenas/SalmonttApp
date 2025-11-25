# Sistema de Gestión de Empleados - SalmonttApp

## Descripción del Proyecto

Sistema de gestión de empleados desarrollado en Java para la empresa salmonera Salmontt. Este proyecto permite cargar, almacenar, buscar y mostrar información de empleados utilizando colecciones dinámicas y lectura de archivos externos.

El sistema aplica principios de Programación Orientada a Objetos (POO) y demuestra el uso de estructuras de datos provistas por Java.

---

## Estructura del Proyecto

```
SalmonttApp/
├── src/
│   ├── model/              # Clases de dominio
│   │   ├── Persona.java    # Clase base con datos personales
│   │   ├── Empleado.java   # Clase que extiende Persona
│   │   └── Direccion.java  # Clase para direcciones
│   │
│   ├── service/            # Lógica de negocio
│   │   └── GestorEmpleados.java  # Gestor de colecciones
│   │
│   ├── util/               # Utilidades
│   │   └── Validador.java  # Validación de datos
│   │
│   └── ui/                 # Interfaz de usuario
│       └── Main.java       # Clase principal
│
├── bin/                    # Archivos compilados
├── empleados.txt           # Archivo de datos
└── README.md              # Este archivo
```

---

## Paquetes Utilizados

### 📌 Paquete `model`
Contiene las clases que representan las entidades del sistema:
- **Direccion**: Representa una dirección física (calle, número, ciudad, país)
- **Persona**: Clase base con datos personales (RUT, nombre, apellido, email, teléfono, dirección)
- **Empleado**: Extiende Persona, agrega cargo, departamento, salario y fecha de contratación

### 📌 Paquete `service`
Contiene la lógica de negocio:
- **GestorEmpleados**: Administra la colección de empleados usando ArrayList
  - Carga datos desde archivos .txt
  - Agrega empleados
  - Busca por departamento
  - Filtra por salario
  - Muestra listados

### 📌 Paquete `util`
Contiene utilidades para el sistema:
- **Validador**: Métodos estáticos para validar RUT, email, teléfono, salarios, etc.

### 📌 Paquete `ui`
Contiene la interfaz de usuario:
- **Main**: Clase principal que ejecuta el sistema y muestra resultados por consola

---

## Clases Implementadas

### Direccion
- Atributos: calle, numero, ciudad, pais
- Métodos: constructores, getters, setters, toString()

### Persona
- Atributos: rut, nombre, apellido, email, telefono, direccion
- Aplica **composición** con Direccion
- Métodos: constructores, getters, setters, toString()

### Empleado (hereda de Persona)
- Atributos adicionales: cargo, departamento, salario, fechaContratacion
- Usa `super()` para llamar al constructor padre
- Métodos: constructores, getters, setters, toString()

### GestorEmpleados
- Usa `ArrayList<Empleado>` para almacenar empleados
- Métodos principales:
  - `cargarDesdeArchivo()`: Lee datos desde archivo .txt
  - `agregarEmpleado()`: Agrega un empleado a la colección
  - `buscarPorDepartamento()`: Busca empleados por departamento
  - `filtrarPorSalario()`: Filtra empleados por salario mínimo
  - `mostrarEmpleados()`: Muestra todos los empleados
  - `getCantidadEmpleados()`: Retorna el total de empleados

---

## Formato del Archivo de Datos (actualizado)

El archivo `empleados.txt` debe tener este formato principal (separado por punto y coma o coma). Campos opcionales al final: id, fechaNacimiento.

Formato obligado (13 campos):
```
rut;nombre;apellido;email;telefono;calle;numero;ciudad;pais;cargo;departamento;salario;fechaContratacion
```

Formato ejemplo (acepta fecha en dd/MM/yyyy o yyyy-MM-dd):
```
12.345.678-9;Juan;Pérez;juan.perez@salmontt.cl;+56912345678;Avenida Angelmó;1250;Puerto Montt;Chile;Ingeniero en Acuicultura;Producción;1800000;15/03/2020
```

Campos opcionales (si están presentes, se añaden al final de la línea):
```
...;id;fechaNacimiento
```
Ejemplo con opcionales:
```
12.345.678-9;Juan;Pérez;juan.perez@salmontt.cl;+56912345678;Avenida Angelmó;1250;Puerto Montt;Chile;Ingeniero;Producción;1800000;2020-03-15;12345;1990-07-21
```

---

## Instrucciones de Ejecución (actualizadas)

Recomendado: Java 11+.

Compilar:
```bash
cd C:\Users\marar\Desktop\Duoc\POO-exp1-Salmontt
javac -d bin -sourcepath src -encoding UTF-8 src\ui\Main.java
```

Ejecutar:
```bash
java -cp bin ui.Main
```
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

### ✅ Colecciones Dinámicas
- Uso de `ArrayList<Empleado>` para almacenar empleados
- Operaciones de inserción, búsqueda y recorrido

### ✅ Lectura de Archivos
- Lectura de archivos .txt
- Uso de `BufferedReader` y `FileReader`
- Procesamiento línea por línea con `.split()`

### ✅ Búsquedas y Filtros
- Búsqueda por departamento
- Filtrado por salario mínimo
- Uso de bucles for-each

### ✅ Validación de Datos
- Uso de try-catch para capturar errores
- Validación de formato de datos
- Manejo de excepciones

### ✅ Principios POO

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

### Autor: Mariana Arenas Vergara

**Proyecto desarrollado para:**
- Asignatura: Desarrollo Orientado a Objetos I
- Institución: DUOC UC
- Experiencia: 2 - Semana 5
- Empresa: Salmontt S.A.

---
