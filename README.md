# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

- Integrante 1: refactorizar SRP.
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.

## Integrante 3 - LSP

- Problema encontrado: La clase Animal obligaba a sus clases hijas a tener métodos como volar(), nadar() y caminar(), aunque no todos los animales podían realizar esas acciones, lo que provocaba excepciones en clases como Perro, Gato y Pez.
- Cambios realizados: Separé las capacidades en tres interfaces: Caminador, Nadador y Volador. También modifiqué las clases de animales para que cada una tenga únicamente los métodos que necesita.
- Justificación: Estos cambios evitan que las clases hijas hereden comportamientos que no pueden cumplir y permiten respetar el principio LSP.
- Comprobación: Ejecuté Main.java en VS Code y el programa funcionó correctamente, incluyendo la demostración del pez nadando.