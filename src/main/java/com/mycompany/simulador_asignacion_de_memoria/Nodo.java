package com.mycompany.simulador_asignacion_de_memoria;

/**
 * @author Lalo Barriguett
 */
public class Nodo {

    Nodo sig;
    char dato;

    Nodo(char x, Nodo enlace) {
        sig = enlace;
        dato = x;
    }

}
