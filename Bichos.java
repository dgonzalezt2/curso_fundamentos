package com.company;

public class Bichos {
    int salud;
    String nombre;
    public Bichos() {}

    @Override
    public String toString(){
        if(salud>=10){
            return nombre+salud;
        }else if(salud>0){
            return nombre+"0"+salud;//Asi en vez de devolver "5" devuelve "05"
        }else{
            return "     ";
        }
    }
    public int getSalud() {
        return salud;
    }
    public void setSalud(int a){
        salud =salud-a;
        if(salud<0){//Es ilógico tener menos de 0 en salud
            salud=0;
        }
    }
}