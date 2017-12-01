package com.prop.domini;
/* Clase hecha por Mati */

import java.lang.System.*;
import java.lang.Object.*;

public class Rellotge {
    long begin;
    long end;
    long ellapsed;

    public Rellotge() {
        iniciarRellotge();
    }

    /*
    Inicia el rellotge.
        <- Retorna 1 per indicar que ha sigut correcte.
    */
    public int iniciarRellotge() {
        begin = System.currentTimeMillis();
        return 1;
    }

    /*
    Continua el rellotge.
        -> Se li passa com a paràmetre el temps en millisegons.
        <- Retorna 1 per indicar que ha sigut correcte.
    */
    public int continuarRellotge(long time) {
        begin = time;
        return 1;
    }

    /*
    Atura el rellotge.
        <- Retorna el temps en millisegons.
     */
    public long aturarRellotge() {
        end = System.currentTimeMillis();
        ellapsed = end - begin;
        return ellapsed;
    }

    /*
    Retorna el temps guardat.
        <- El retorna un string amb el temps en format hh:mm:ss
     */
    public String getTime() {
        int sec  = (int)(ellapsed/ 1000) % 60 ;
        int min  = (int)((ellapsed/ (1000*60)) % 60);
        int hr   = (int)((ellapsed/ (1000*60*60)) % 24);
        return "" + hr + ":" + min + ":" + sec;
    }
}