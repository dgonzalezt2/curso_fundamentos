package com.company;

public class Carro extends Vehiculo{

    public Carro() {
    }

    public Carro(String plac, String marc, String colo) {
        super(plac, marc, colo);
        super.setTipo("carro");
    }

    public Carro(String placa, String marca, String color, int valorComercial) {
        super(placa, marca, color, valorComercial);
        super.setTipo("carro");
    }

}
