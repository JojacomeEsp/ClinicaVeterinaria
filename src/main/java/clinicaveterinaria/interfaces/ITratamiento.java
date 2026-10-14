package clinicaveterinaria.interfaces;

public interface ITratamiento {
    double calcularCostoFinal();

    String obtenerIndicaciones();
    int getId(); // <-- Agregamos esto para que cualquier tratamiento esté obligado a tener un ID
    String getDescripcion();
}
