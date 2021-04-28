public class Sensor {
    //Atributos
    public static Sensor[][] sensores;
    private int estado=0;

    //Constructores
    public Sensor(){}

    public Sensor(int e){
        this.estado=e;
    }

    //Get & Set estado
    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        if(estado==1){
            return "Sensor{" + "estado=" + estado + "-Ocupado"+'}';
        }else{
            return "Sensor{" + "estado=" + estado + "-Libre"+'}';
        }
    }

    public static String sensorLibre(){//Indica los pisos con espacios disponibles
        String resultados ="";
        for(int row=0;row<sensores.length;row++){
            for (int col=0;col<sensores[0].length;col++)
            {
                if(sensores[row][col]==null)
                {
                    resultados+= "Espacio disponible en : piso["+(row+1)+"] espacio["+(col+1)+"]"+'\n';
                }
            }
        }
        return resultados;
    }

    public static String sensoresEstado(){//Indica el estado de TODOS los sensores
        String resultados ="";
        for(int row=0;row<sensores.length;row++){
            for (int col=0;col<sensores[0].length;col++)
            {
                if(sensores[row][col]==null)
                {
                    resultados+= "{piso["+(row+1)+"] espacio["+(col+1)+"]"+ "} estado libre" +'\n';
                }else{
                    resultados+= "{piso["+(row+1)+"] espacio["+(col+1)+"]"+ "} estado ocupado" +'\n';
                }
            }
        }
        return resultados;
    } 
}
