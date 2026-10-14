package clinicaveterinaria;

import clinicaveterinaria.model.*;
import clinicaveterinaria.repository.*;
import clinicaveterinaria.service.*;

import java.io.PrintStream;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        MascotaService mascotaService = new MascotaService(baseDatos);
        VeterinarioCrudService veterinarioCrudService = new VeterinarioCrudService(baseDatos);
        ReservaService reservaService = new ReservaService(baseDatos);
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        FacturacionService facturacionService = new FacturacionService(baseDatos);
        TratamientoService tratamientoService = new TratamientoService(baseDatos);
        ReporteService reporteService = new ReporteService(baseDatos);

        Mascota mascota = new Mascota(1, "Luna", TipoAnimal.PERRO, 4, "Ana Perez");
        Veterinario veterinario = new Veterinario(1, "Dr. Ruiz", "Medicina general", true);
        Tratamiento tratamiento = new Tratamiento(1, TipoTratamiento.CIRUGIA, "Esterilizacion", 120.0);

        mascotaService.crearMascota(mascota);
        veterinarioCrudService.crearVeterinario(veterinario);
        tratamientoService.crearTratamiento(tratamiento);

        Cita cita = reservaService.reservarCita(1, mascota, veterinario, LocalDate.now());
        diagnosticoService.diagnosticar(cita, "Paciente estable para tratamiento.");
        Factura factura = facturacionService.generarFactura(1, cita, tratamiento.calcularCostoFinal());
        factura.setPagada(true);

        System.out.println("=== ClinicaVeterinaria funcionando ===");
        System.out.println(mascotaService.obtenerMascota(1));
        System.out.println(cita);
        System.out.println(factura);
        System.out.println("Preparacion: " + tratamientoService.prepararSala(tratamiento));
        System.out.println("Costo con impuestos: " + new CalculadoraCostoTratamiento().calcularConImpuestos(tratamiento));
        System.out.println("Citas Dr. Ruiz: " + reporteService.generarReporteCitasPorVeterinario(1).size());
        System.out.println("Mascotas de Ana Perez: " + reporteService.generarReporteMascotasPorDueno("Ana Perez").size());
        System.out.println("Ingresos del mes: " + reporteService.calcularIngresosMensual());

        demostrarViolacionesSinRomperEjecucion(baseDatos,veterinario, mascota, tratamiento);
        new Clinica().agendarConsultaRapida(mascota, veterinario);
        new ServicioClinicaCompleto(baseDatos).calcularTratamiento(tratamiento);
    }

    private static void demostrarViolacionesSinRomperEjecucion(BaseDatos baseDatos,Veterinario veterinario, Mascota mascota, Tratamiento tratamiento) {
        ReservaService reservaService = new ReservaService(baseDatos);
        veterinario.setDisponible(true);
        Cita citaDesdeModelo = reservaService.reservarCita(2, mascota, veterinario,LocalDate.now().plusDays(1));
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        diagnosticoService.diagnosticar(citaDesdeModelo, "Ejemplo de SRP violado desde el modelo.");
        ReporteService  reporteService = new ReporteService(baseDatos);
        int idVeterinario = veterinario.getId();
        System.out.println(reporteService.generarReporteCitasPorVeterinario(idVeterinario));

        Animal pez = new Pez(3, "Nemo");
        pez.nadar();
        System.out.println("El pez heredó caminar() y volar(), aunque no debe usarlos.");
        System.out.println("Tratamiento OCP violado pero funcional: " + tratamiento.obtenerIndicaciones());
    }
}
