package clinicaveterinaria.model;
import clinicaveterinaria.interfaces.ITratamiento;
public class CirugiaTratamiento implements ITratamiento{
    private final double costo;

public CirugiaTratamiento(double costo){
    this.costo=costo;

}
 @Override
    public double calcularCostoFinal() {
        return costo * 1.25 + 80.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Ayuno previo y control postoperatorio.";
    }

};


