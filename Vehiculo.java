public class Vehiculo {
    //Atributos
    public static int tamano;
    public static int cantidad = 0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    private String tipo;
    public static Vehiculo vehiculos [][];


    public Vehiculo (){}//Constructor sin parametros

    public Vehiculo(String plac, String marc, String colo) {//Constructor con 3 parámetros
        this(plac, marc, colo, 30000000);                   //Asigna por defecto un valor de 30000000
    }

    public Vehiculo(String placa, String marca, String color, int valorComercial) {//Constructor de 4 parametros
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.valorComercial = valorComercial;

        cantidad++;                             //Cada que se crea un vehículo aumenta cantidad en uno
    }

    //Getters & Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(int valorComercial) {
        this.valorComercial = valorComercial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    //To strings
    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", tipo='" + tipo +'\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", valorComercial=" + valorComercial +
                '}';
    }

    public static String toStringVehiculos(){
        String resultados ="";
        for(int row=0;row<vehiculos.length;row++){
            for (int col=0;col<vehiculos[0].length;col++)
            {
                if(vehiculos[row][col]!=null)
                {
                    Vehiculo carro = vehiculos[row][col];
                    resultados+= "Vehiculo{" + "placa='" + carro.getPlaca()+ "', tipo='" + carro.getTipo() + "', marca='" + carro.getMarca() +"', color='" + carro.getColor() +
                            "', valorComercial=" + carro.getValorComercial() +'}'+'\n';
                }
            }
        }
        return resultados;
    }

    public static int cantidadVehiculos() { //Indica la cantidad de vehiculos almacenados
        return cantidad;
    }

    public static String buscarColorDeVehiculo(String color){//Itera sobre la lista de vehiculos para encontrar un vehiculo con el color ingresado
        String retorno="";
        int cont=0;
        for(int i=0;i<Vehiculo.vehiculos.length;i++){
            for(int j=0;j<Vehiculo.vehiculos[0].length;j++){
                if(Vehiculo.vehiculos[i][j]!=null){
                    if(Vehiculo.vehiculos[i][j].getColor().equalsIgnoreCase(color)){
                        retorno+="Piso: "+(i+1)+" | Espacio: "+(j+1)+" -> "+Vehiculo.vehiculos[i][j].toString()+'\n';

                        cont++;
                    }
                }
            }
        }
        if(cont==0){
            retorno="No se han ingresado vehículos con el color solicitado";
        }
        return retorno;
    }

    public static void ordenarValorComercial(Vehiculo []arreglo){// Ordena los vehiculos de menor a maayor por valor comercial
        Vehiculo aux;
        for(int i=1;i<arreglo.length;i++){
            for(int j=0;j<arreglo.length-1;j++){
                if((arreglo[j]!=null)&&(arreglo[j+1]!=null)){
                    if(arreglo[j].getValorComercial()>arreglo[j+1].getValorComercial()){
                        aux = arreglo[j];
                        arreglo[j]=arreglo[j+1];
                        arreglo[j+1]=aux;

                    }
                }
            }
        }
    }
}
