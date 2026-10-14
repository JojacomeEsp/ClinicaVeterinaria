package clinicaveterinaria.service;

import clinicaveterinaria.interfaces.IBaseDatos;
import clinicaveterinaria.interfaces.IVeterinarioService;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;

import java.time.LocalDate;


public class Clinica {
    private final IVeterinarioService veterinarioService;
    private final IBaseDatos baseDatos;

    public Clinica(IVeterinarioService veterinarioService, IBaseDatos baseDatos) {
        this.veterinarioService = veterinarioService;
        this.baseDatos = baseDatos;
    }

    public Cita agendarConsultaRapida(Mascota mascota, Veterinario veterinario) {
        Cita cita = veterinarioService.reservarCita(mascota, veterinario, LocalDate.now());
        baseDatos.getCitas().add(cita);
        return cita;
    }
}
