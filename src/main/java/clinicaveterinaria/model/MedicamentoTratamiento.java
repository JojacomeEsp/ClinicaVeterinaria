package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.*;
public class MedicamentoTratamiento implements ITratamiento{
 private final double costo;

public MedicamentoTratamiento(double costo){
    this.costo=costo;

}
 @Override
    public double calcularCostoFinal() {
        return costo * 1.10;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }
}
