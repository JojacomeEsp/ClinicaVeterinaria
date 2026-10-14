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
- Integrante 4 (Jorge Jacome)

## Integrante 1 - SRP
Se modifico "Veterinario" ya que incumplia el principio de Single Responsability y se traslado la logica de reservar, diagnosticar, generar facturas y crear reporte llevando estas a sus respectivos servicios 

## Integrante 2 - OCP
¿Por qué los condicionales repetidos hacen más caro el cambio?
Debido a que son sensibles al añadir nuevos tipos de tratamiento en este caso, por lo que provoca que se modifiquen partes del código existente.
¿Qué pasaría si agregamos `Odontologia` como tratamiento?
Si mantenemos la logica de los ifs no se podría respetar OCP, pero como implementamos a partir de una interfaz entonces si se podría agregar lo nuevo.
¿Cuándo una interfaz ayuda a extender el sistema?
Cuando se requiere de añadir muchos más tipos de objetos, eso da flexibilidad para validar.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.

## Integrante 3 - LSP

- Problema encontrado: La clase Animal obligaba a sus clases hijas a tener métodos como volar(), nadar() y caminar(), aunque no todos los animales podían realizar esas acciones, lo que provocaba excepciones en clases como Perro, Gato y Pez.
- Cambios realizados: Separé las capacidades en tres interfaces: Caminador, Nadador y Volador. También modifiqué las clases de animales para que cada una tenga únicamente los métodos que necesita.
- Justificación: Estos cambios evitan que las clases hijas hereden comportamientos que no pueden cumplir y permiten respetar el principio LSP.
- Comprobación: Ejecuté Main.java en VS Code y el programa funcionó correctamente, incluyendo la demostración del pez nadando.

# Integrante 4 - ISP y DIP
- Se dividió IServicioClinica en interfaces más pequeñas y específicas: IMascotaService, ICitaService, IFacturaService e IReporteService.
- Se creó e implementó la interfaz IRecepcionVet.java.
- Se actualizó RecepcionService para que dependa únicamente de las interfaces que realmente utiliza.
- Se modificó la clase Clinica para recibir por constructor las dependencias de IVeterinarioService e IBaseDatos.
- Se ajustó GestorReportesClinica para recibir sus dependencias desde el exterior.
- Se realizaron las pruebas correspondientes en el Main.java integrando las implementaciones concretas.