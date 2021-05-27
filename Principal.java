package com.company;

import java.util.*;
public class Principal {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int azar=(int)((Math.random()*4)+1);//Creamos un valor al azar entre 1-4
        Tablero.cantidadBichos(azar);//Le pasamos a cantidadBichos que debe instanciar la cantidad de bichos que se obtuvo aleatoriamente
        Tablero.crearTablero();//Se muestra el tablero creado al azar
        System.out.println("Si desea disparar ingrese '1', de lo contrario ingrese '0'");
        int disparo=entrada.nextInt();//Determina si se dispara o no
        boolean continuar=true;
        while(disparo!=0 && continuar){//Para que se cumpla el bucle disparo debe ser !=0 y debemos poder continuar(true)
            switch(disparo){
                case 1:
                    System.out.println("¿A qué posición deseas disparar?");
                    System.out.println("Ingrese el número de la fila:");
                    int fila=entrada.nextInt()-1;
                    System.out.println("Ingrese el número de la columna");
                    int columna=entrada.nextInt()-1;
                    try{//Cuando fila y columna tienen valores menores a 2 porque de lo contrario se sale de la matriz
                        if(Tablero.posiciones[fila][columna]==null || Tablero.posiciones[fila][columna].getSalud()==0){
                            //Ya sea que no haya bicho en la posición o esté tenga un valor de salud de 0 no se le podrá disparar
                            System.out.println("No hay ningún bicho vivo en la posición ingresada");
                        }else{
                            Tablero.posiciones[fila][columna].setSalud(5);//Si efectivamente existe un bicho, le quitamos 5 de vida
                        }
                        if(Tablero.consultarTablero()==false){//Si se cumple es porque no hay ningún bicho con vida
                            System.out.println("Todos los bichos han muerto");
                        }
                        Tablero.crearTablero();//Siempre mostramos el tablero después de cada disparo
                        continuar=Tablero.consultarTablero();//Cuando Consultar tablero retorne false no se cumplirá la condición de la linea del while
                        //entonces igualamos continuar y asi si es false ya no entrará al swhitch y todos los bichos habrán muerto
                    }catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Ingrese valores válidos para el tablero 2x2");
                    }
                    break;
                default:
                    System.out.println("Las opciones a elegir son: \n0.Salir\n1.Disparar");
                    break;
            }
            if(continuar){
                System.out.println("Si desea continuar disparando ingrese '1' de lo contrario ingrese un '0'");
                disparo=entrada.nextInt();
            }
        }
        System.out.println("Saliendo...");
    }
}
