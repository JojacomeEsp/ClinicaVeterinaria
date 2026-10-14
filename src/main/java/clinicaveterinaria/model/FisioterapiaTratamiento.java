package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.*;
public class FisioterapiaTratamiento implements ITratamiento {
 private final double costo;

public FisioterapiaTratamiento(double costo){
    this.costo=costo;

}
 @Override
    public double calcularCostoFinal() {
        return costo * 0.95;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Repetir sesiones dos veces por semana.";
    }
}
