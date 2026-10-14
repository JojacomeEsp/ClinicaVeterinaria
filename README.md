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
- Integrante 4 (Jorge Jacome): refactorizar ISP y DIP.
Se dividió IServicioClinica en interfaces más pequeñas y específicas: IMascotaService, ICitaService, IFacturaService e IReporteService.
Se creó e implementó la interfaz IRecepcionVet.java.
Se actualizó RecepcionService para que dependa únicamente de las interfaces que realmente utiliza.
Se modificó la clase Clinica para recibir por constructor las dependencias de IVeterinarioService e IBaseDatos.
Se ajustó GestorReportesClinica para recibir sus dependencias desde el exterior.
Se realizaron las pruebas correspondientes en el Main.java integrando las implementaciones concretas.



Lee `guia.md` para instrucciones, checklists y preguntas de discusión.
