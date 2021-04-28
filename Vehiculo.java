public class Vehiculo {
    //atributos de la clase
    public static int tamano;
    public static int cantidad = 0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;

    public static Vehiculo vehiculos [][];
    public Vehiculo (){}

    public Vehiculo(String plac, String marc, String colo) {
        this(plac, marc, colo, 30000000);
    }

    public Vehiculo(String placa, String marca, String color, int valorComercial) {
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.valorComercial = valorComercial;

        cantidad++;
    }

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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
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
                    resultados+= "Vehiculo{" + "placa='" + carro.getPlaca()+ "', marca='" + carro.getMarca() +"', color='" + carro.getColor() +
                            "', valorComercial=" + carro.getValorComercial() +'}'+'\n';
                }
            }
        }
        return resultados;
    }
    public static int cantidadVehiculos() {
        return cantidad;
    }

    public static void ordenarValorComercial(Vehiculo []arreglo){
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
