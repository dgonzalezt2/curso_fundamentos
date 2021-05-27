package com.company;
import java.util.concurrent.TimeUnit;
import java.util.Date;
public class Tiempo {
    public Date getactual()
    {
        Date d1 = new Date();
        return d1;
    }

    public static long difftime(Date d1, Date d2)
    {
        try {
            long diferenciaTiempo=d2.getTime()-d1.getTime();//Diferencia en milisegundos
            //Diferencia en segundos, minutos, hora, años y días
            long diferenciaMinutos= TimeUnit.MILLISECONDS.toMinutes(diferenciaTiempo)% 60;
            return diferenciaMinutos;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}


