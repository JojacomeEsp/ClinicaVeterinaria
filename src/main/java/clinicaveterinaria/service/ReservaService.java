package clinicaveterinaria.service;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.EstadoCita;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;

import java.time.LocalDate;

public class ReservaService {
    private final BaseDatos baseDatos;

    public ReservaService(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }

    public Cita reservarCita(int id, Mascota mascota, Veterinario veterinario, LocalDate fecha) {
        if (veterinario.isDisponible()) {
            Cita cita = new Cita(id, mascota, veterinario, fecha, "Pendiente", EstadoCita.PROGRAMADA);
        
            baseDatos.getCitas().add(cita);
            veterinario.setDisponible(false);
            
            return cita; 
        }
        
        return null; 
    }

    /*public Cita reservarCita(int citaId, Mascota mascota, LocalDate fecha) {
        disponible = false;
        return new Cita(citaId, mascota, this, fecha, "Pendiente", EstadoCita.PROGRAMADA);
    }
    */

}
