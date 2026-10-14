package clinicaveterinaria.model;

import clinicaveterinaria.interfaces.Volador;

public class Pajaro extends Animal implements Volador {
    public Pajaro(int id, String nombre) {
        super(id, nombre, TipoAnimal.PAJARO);
    }

    @Override
    public void volar() {
        System.out.println(getNombre() + " esta volando.");
    }
}
