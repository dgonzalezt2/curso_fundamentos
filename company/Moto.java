package com.company;

public class Moto extends Vehiculo{

    public Moto() {
    }

    public Moto(String plac, String marc, String colo) {
        super(plac, marc, colo);
        super.setTipo("moto");
    }

    public Moto(String placa, String marca, String color, int valorComercial) {
        super(placa, marca, color, valorComercial);
        super.setTipo("moto");
    }

}

