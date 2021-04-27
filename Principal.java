import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de pisos en el edificio");
        int pisos=entrada.nextInt();
        System.out.println("Ingrese la cantidad de espacios en el edificio");
        int espacio=entrada.nextInt();

        Vehiculo.vehiculos=new Vehiculo[pisos][espacio];
        Sensor.sensores=new Sensor[pisos][espacio];
        int parqueados=pisos*espacio;

        System.out.println("¿Qué desea hacer?");
        System.out.println("0. Salir");
        System.out.println("1. Ver sensores desocupados");
        System.out.println("2. Parquear con placa,marca y color");
        System.out.println("3. Parquear con placa,marca,color y valor");
        System.out.println("4. Vehiculos almacenados");
        System.out.println("5. Historial de cantidad de vehiculos parqueados");
        System.out.println("6. Ver estado del sensor");
        System.out.println("7. Ver estado de todos los sensores");
        System.out.println("8. Mostrar todos los autos que tengan el color solicitado");
        System.out.println("9. Mostrar todos los vehículos ordenados de menor a mayor por valor comercial");
        int menu = entrada.nextInt();
        while(menu!=0){
            switch(menu){
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    if(Vehiculo.cantidadVehiculos()<parqueados){
                        System.out.println("¿En qué espacio desea parquear su vehículo?");
                        System.out.println("Ingrese el piso: ");
                        int row=entrada.nextInt()-1;
                        System.out.println("Ingrese el espacio en el piso "+ (row+1)+" en donde desea parquear: ");
                        int col=entrada.nextInt()-1;
                        if((Vehiculo.vehiculos[row][col]!=null)){
                            System.out.println("El espacio está ocupado");
                        }else{
                            System.out.println("Ingrese la placa del vehículo: ");
                            String placa=entrada.next();
                            System.out.println("Ingrese la marca del vehículo: ");
                            String marca=entrada.next();
                            System.out.println("Ingrese el color del vehículo: ");
                            String color=entrada.next();
                            Vehiculo.vehiculos[row][col]=new Vehiculo(placa,marca,color);

                            System.out.println(Vehiculo.vehiculos[row][col].toString());
                            Sensor.sensores[row][col]=new Sensor(1);
                        }
                    }else{
                        System.out.println("Se ha alcanzado la máxima cantidad de espacios en el edificio");
                    }
                    break;
                case 3:
                    if(Vehiculo.cantidadVehiculos()<parqueados){
                        System.out.println("¿En qué espacio desea parquear su vehículo?");
                        System.out.println("Ingrese el piso: ");
                        int row=entrada.nextInt()-1;
                        System.out.println("Ingrese el espacio en el piso "+ (row+1)+" en donde desea parquear: ");
                        int col=entrada.nextInt()-1;
                        if((Vehiculo.vehiculos[row][col]!=null)&&(Sensor.sensores[row][col].getEstado()==1)){
                            System.out.println("El espacio está ocupado");
                        }else{
                            System.out.println("Ingrese la placa del vehículo: ");
                            String placa=entrada.next();
                            System.out.println("Ingrese la marca del vehículo: ");
                            String marca=entrada.next();
                            System.out.println("Ingrese el color del vehículo: ");
                            String color=entrada.next();
                            System.out.println("Ingrese el valor del vehículo: ");
                            int valor=entrada.nextInt();
                            Vehiculo.vehiculos[row][col]=new Vehiculo(placa,marca,color,valor);

                            System.out.println(Vehiculo.vehiculos[row][col].toString());
                            Sensor.sensores[row][col]=new Sensor(1);
                        }
                    }else{
                        System.out.println("Se ha alcanzado la máxima cantidad de espacios en el edificio");
                    }
                    break;
                case 4:
                    if(Vehiculo.toStringVehiculos().equals("")){
                        System.out.println("No se han ingresado vehículos aún");
                    }else{
                        System.out.println(Vehiculo.toStringVehiculos());
                    }
                    break;
                case 5:
                    System.out.println("Hay parqueado(s): "+Vehiculo.cantidadVehiculos()+" vehículo(s)");
                    break;
                case 6:
                    System.out.println("Ingrese el piso");
                    int piso1 = entrada.nextInt()-1;
                    System.out.println("Ingrese el espacio");
                    int espacio1 = entrada.nextInt()-1;
                    if(Sensor.sensores[piso1][espacio1]!=null){
                        System.out.println(Sensor.sensores[piso1][espacio1].getEstado()+"- Ocupado");
                    }else{
                        System.out.println("0- Libre");
                    }

                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;
                case 8:
                    System.out.println("Ingrese el color a buscar: ");
                    String color=entrada.next();
                    int cont=0;
                    for(int i=0;i<pisos;i++){
                        for(int j=0;j<espacio;j++){
                            if(Vehiculo.vehiculos[i][j]!=null){
                                if(Vehiculo.vehiculos[i][j].getColor().equalsIgnoreCase(color)){
                                    System.out.print("Piso: "+(i+1)+" || Espacio: "+(j+1)+"  -> ");
                                    System.out.println(Vehiculo.vehiculos[i][j].toString());
                                    cont++;
                                }
                            }
                        }

                    }
                    if(cont==0){
                        System.out.println("No se han ingresado vehículos con el color solicitado");
                    }
                    System.out.println("");
                    break;
                case 9:
                    if(Vehiculo.cantidadVehiculos()!=0){
                        System.out.println("Mostrando vehículos: ");
                        Vehiculo orden[]=new Vehiculo[parqueados];
                        int h=0;
                        for(int i=0;i<pisos;i++){
                            for(int j=0;j<espacio;j++){

                                orden[h]=Vehiculo.vehiculos[i][j];
                                h++;
                            }

                        }
                        Vehiculo.ordenarValorComercial(orden);
                        for(int i=0;i<orden.length;i++){
                            if(orden[i]!=null){
                                System.out.println(orden[i].toString());
                            }
                        }

                    }else{
                        System.out.println("No se ha creado ningún vehículo seleccione una de las opciones para crear vehículos");
                    }
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            System.out.println("");
            System.out.println("La ejecución ha terminado");
            System.out.println("¿Qué desea hacer?");
            System.out.println("0. Salir");
            System.out.println("1. Ver sensores desocupados");
            System.out.println("2. Parquear con placa,marca y color");
            System.out.println("3. Parquear con placa,marca,color y valor");
            System.out.println("4. Vehiculos almacenados");
            System.out.println("5. Historial de cantidad de vehiculos parqueados");
            System.out.println("6. Ver estado del sensor");
            System.out.println("7. Ver estado de todos los sensores");
            System.out.println("8. Mostrar todos los autos que tengan el color solicitado");
            System.out.println("9. Mostrar todos los vehículos ordenados de menor a mayor por valor comercial");
            menu = entrada.nextInt();
        }
        System.out.println("Saliendo...");

    }
}
