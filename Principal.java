import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("Ingrese la cantidad de pisos en el edificio");
        int pisos=entrada.nextInt();
        System.out.println("Ingrese la cantidad de espacios en el edificio");
        int espacio=entrada.nextInt();
        System.out.println("Ingrese la cantidad a cobrar por hora a las motos");
        int dineroM = entrada.nextInt();
        System.out.println("Ingrese la cantidad a cobrar por hora a los carros");
        int dineroC = entrada.nextInt();


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
        System.out.println("10. Retirar vehiculo");
        System.out.println("11. Información vehiculos en archivo");
        int menu = entrada.nextInt();
        while(menu!=0){
            switch(menu){
                case 1:
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    try {
                        if (Vehiculo.cantidadVehiculos() < parqueados) {
                            System.out.println("¿Qué vehículo desea parquear?");
                            String tipo = entrada.next();
                            while ((!tipo.toLowerCase().equals("moto")) && (!tipo.toLowerCase().equals("carro"))) {
                                System.out.println("Ingrese un vehiculo válido");
                                tipo = entrada.next();
                            }
                            System.out.println("¿En qué espacio desea parquear su vehículo?");
                            System.out.println("Ingrese el piso: ");
                            int row = entrada.nextInt() - 1;
                            System.out.println("Ingrese el espacio en el piso " + (row + 1) + " en donde desea parquear: ");
                            int col = entrada.nextInt() - 1;
                            if ((Vehiculo.vehiculos[row][col] != null)) {
                                System.out.println("El espacio está ocupado");
                            } else {
                                System.out.println("Ingrese la placa del vehículo: ");
                                String placa = entrada.next();
                                System.out.println("Ingrese la marca del vehículo: ");
                                String marca = entrada.next();
                                System.out.println("Ingrese el color del vehículo: ");
                                String color = entrada.next();

                                if (tipo.toLowerCase().equals("moto")) {
                                    Vehiculo.vehiculos[row][col] = new Moto(placa, marca, color);
                                } else {
                                    Vehiculo.vehiculos[row][col] = new Carro(placa, marca, color);
                                }

                                Sensor.sensores[row][col] = new Sensor(1);
                                System.out.println("El " + Vehiculo.vehiculos[row][col].toString() + ", en la fecha: " + Sensor.sensores[row][col].getIngreso());

                            }
                        } else {
                            System.out.println("Se ha alcanzado la máxima cantidad de espacios en el edificio");
                        }
                    }catch (Exception e){
                        System.out.println("La posición ingresada es superior a la cantidad de pisos o espacios del edificio.");
                    }
                    break;
                case 3:
                    try {
                        if (Vehiculo.cantidadVehiculos() < parqueados) {
                            System.out.println("¿Qué vehículo desea parquear?");
                            String tipo = entrada.next();
                            while ((!tipo.toLowerCase().equals("moto")) && (!tipo.toLowerCase().equals("carro"))) {
                                System.out.println("Ingrese un vehiculo válido");
                                tipo = entrada.next();
                            }
                            System.out.println("¿En qué espacio desea parquear su vehículo?");
                            System.out.println("Ingrese el piso: ");
                            int row = entrada.nextInt() - 1;
                            System.out.println("Ingrese el espacio en el piso " + (row + 1) + " en donde desea parquear: ");
                            int col = entrada.nextInt() - 1;
                            if ((Vehiculo.vehiculos[row][col] != null) && (Sensor.sensores[row][col].getEstado() == 1)) {
                                System.out.println("El espacio está ocupado");
                            } else {
                                System.out.println("Ingrese la placa del vehículo: ");
                                String placa = entrada.next();
                                System.out.println("Ingrese la marca del vehículo: ");
                                String marca = entrada.next();
                                System.out.println("Ingrese el color del vehículo: ");
                                String color = entrada.next();
                                System.out.println("Ingrese el valor del vehículo: ");
                                int valor = entrada.nextInt();

                                if (tipo.toLowerCase().equals("moto")) {
                                    Vehiculo.vehiculos[row][col] = new Moto(placa, marca, color, valor);
                                } else {
                                    Vehiculo.vehiculos[row][col] = new Carro(placa, marca, color, valor);
                                }
                                Sensor.sensores[row][col] = new Sensor(1);
                                System.out.println("El " + Vehiculo.vehiculos[row][col].toString() + ", en la fecha: " + Sensor.sensores[row][col].getIngreso());

                            }
                        } else {
                            System.out.println("Se ha alcanzado la máxima cantidad de espacios en el edificio");
                        }
                    }catch (Exception e){
                        System.out.println("La posición ingresada es superior a la cantidad de pisos o espacios del edificio.");
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
                    try {
                        System.out.println("Ingrese el piso");
                        int piso1 = entrada.nextInt() - 1;
                        System.out.println("Ingrese el espacio");
                        int espacio1 = entrada.nextInt() - 1;
                        if (Sensor.sensores[piso1][espacio1] != null) {
                            System.out.println(Sensor.sensores[piso1][espacio1].getEstado() + "- Ocupado");
                        } else {
                            System.out.println("0- Libre");
                        }
                    }catch (Exception e) {
                        System.out.println("La posición ingresada es superior a la cantidad de pisos o espacios del edificio.");
                    }
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break;
                case 8:
                    System.out.println("Ingrese el color a buscar: ");
                    String color=entrada.next();
                    System.out.println(Vehiculo.buscarColorDeVehiculo(color));
                    break;
                case 9:
                    if(Vehiculo.cantidadVehiculos()!=0){
                        System.out.println("Mostrando vehículos: ");
                        Vehiculo orden[]=new Vehiculo[parqueados];
                        int h=0;
                        for(int i=0;i<pisos;i++){
                            for(int j=0;j<espacio;j++){
                                if(Vehiculo.vehiculos[i][j]!=null){
                                    orden[h]=Vehiculo.vehiculos[i][j];
                                    h++;
                                }
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
                case 10:
                    try {
                        System.out.println("Ingrese el piso en el que se encuentra el vehiculo");
                        int row = entrada.nextInt() - 1;
                        System.out.println("Ingrese el espacio en el que se encuentra el vehiculo");
                        int col = entrada.nextInt() - 1;
                        if (Vehiculo.vehiculos[row][col] != null) {
                            Sensor.sensores[row][col].setEstado(0);
                            double minutos = (double) Tiempo.difftime(Sensor.sensores[row][col].getIngreso(), Sensor.sensores[row][col].getSalida());
                            double horas = minutos / 60;
                            int horas2 = (int) Math.round(horas);
                            if (horas2 < 1) {
                                horas2 = 1;
                            }
                            int cobro;
                            if (Vehiculo.vehiculos[row][col].getTipo().toLowerCase().equals("moto")) {
                                cobro = horas2 * dineroM;
                            } else {
                                cobro = horas2 * dineroC;
                            }
                            System.out.println("El "+Vehiculo.vehiculos[row][col].toString()+"\nSe retira del parqueadero en la fecha: "+Sensor.sensores[row][col].getSalida()+"\nEl dinero a cobrar es: "+cobro);
                            Vehiculo.vehiculos[row][col] = null;
                            Sensor.sensores[row][col] = null;
                        } else {
                            System.out.println("El espacio ingresado está vacío");
                        }
                    }catch (Exception e){
                        System.out.println("La posición ingresada es superior a la cantidad de pisos o espacios del edificio.");
                    }
                    break;
                case 11:
                    try {
                        System.out.println("Exportando...");
                        String ruta = "InfoVehiculos.txt";
                        String contenido = Vehiculo.toStringVehiculos();
                        File file = new File(ruta);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(contenido);
                        bw.close();
                        System.out.println("Exportado con éxito");
                    } catch (Exception e) {
                        e.getMessage();
                        System.out.println("Algo ha salido mal :(");
                    }
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
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
            System.out.println("10. Retirar vehiculo");
            System.out.println("11. Información vehiculos en archivo");
            menu = entrada.nextInt();
        }
        System.out.println("Saliendo...");
    }
}
