package com.company;

public class Tablero {
    public static Bichos[][] posiciones=new Bichos[2][2];

    public static void cantidadBichos(int i){//Se le pasa como parámetro la cantidad de bichos a instanciar
        int random;
        boolean a,b;
        for(int j=0;j<i;j++){
            random=(int)((Math.random()*2)+1);//Se crean enteros ya sea un 1 o un 2
            if(random==1){
                a=false;//inicializamos a
                for(int h=0;h<2;h++){
                    for(int k=0; k<2;k++){
                        if(!a){//si a es falso se mete aquí
                            if(posiciones[h][k]==null){
                                posiciones[h][k]=new BichoNormal();
                                a=true; //nunca entrará otra vez por 35 a crear otro bicho
                            }
                        }
                    }
                }
            }else if(random==2){//Lo mismo que arriba pero con b
                b=false;

                for(int h=0;h<2;h++){
                    for(int k=0; k<2;k++){
                        if(!b){
                            if(posiciones[h][k]==null){
                                posiciones[h][k]=new BichoAlien();
                                b=true;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void crearTablero(){//Esto es para imprimir el tablero
        System.out.println("-------------");
        System.out.print("|");
        for(int i=0;i<1;i++){//En esta iteración solo imprimimos la primera línea
            for(int j=0;j<2;j++){
                try{//Intentamos hacer un toString de todas las posiciones
                    System.out.print(posiciones[i][j].toString());
                }catch(NullPointerException e){//Si hay un espacio null nos lanza error entonces mejor colocamos un"   "
                    System.out.print("     ");
                }finally{
                    System.out.print("|");//Todas las posiciones terminan con un "|" asi que por eso está en finally
                }
            }
        }
        System.out.println("");
        System.out.println("-------------");
        System.out.print("|");
        for(int i=1;i<2;i++){//Solo se imprimirá la segunda fila
            for(int j=0;j<2;j++){
                try{
                    System.out.print(posiciones[i][j].toString());
                }catch(NullPointerException e){
                    System.out.print("     ");
                }finally{
                    System.out.print("|");
                }
            }
        }
        System.out.println("\n-------------");
    }

    public static boolean consultarTablero(){//Esto lo hacemos para validar que al menos un bicho tiene salud > 0
        boolean continuar=false;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                try{//Intentamos tomar la salud de cada bicho
                    if(posiciones[i][j].getSalud()>0){
                        continuar=true;//Si la vida de un bicho tiene salud>0 continuar será true
                    }
                }catch(NullPointerException e){
                    e.getMessage();//capturamos la excepción de cuando posicion[i][j] es igual a null
                    break;
                }
            }
        }
        return continuar;//Si se retorna true aun existen bichos
    }                    //Si se retorna false todos los bichos han muerto

}
