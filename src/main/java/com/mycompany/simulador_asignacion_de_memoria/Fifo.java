package com.mycompany.simulador_asignacion_de_memoria;

import com.mycompany.simulador_asignacion_de_memoria.Nodo;

/**
 * @author Lalo Barriguett
 */
public class Fifo {

    private Nodo sig, frente, ultimo;
    char dato;
    char matriz[];
    int marco;

    Fifo(int x) {
        marco = x;
        matriz = new char[x];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = ' ';
        }
        frente = ultimo = null;
    }
    public int contador = 0;
    public static String cad = "";

    void Insertar(char x) {
        Nodo nuevo;
        if (frente == null) {
            nuevo = new Nodo(x, null);
            frente = ultimo = nuevo;
            InsertarM(x);
            cad = cad + "  fallo  ";
        } else {
            if (Existe(x)) {
                cad = cad + "  -----  ";
            } else {
                if (Tamaño()) {
                    cad = cad + "  fallo  ";
                    InsertarM(x);
                    nuevo = new Nodo(x, null);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;

                } else {
                    cad = cad + "  fallo  ";
                    SacarM(Sacar());
                    InsertarM(x);
                    nuevo = new Nodo(x, null);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;

                    contador++;
                }
            }
        }
    }

    void InsertarM(char x) {
        boolean ban = true;
        int i = 0;
        while (ban) {
            if (matriz[i] == ' ') {
                matriz[i] = x;
                ban = false;
            }
            i++;
        }
    }

    boolean Existe(char x) {
        Nodo aux = frente;
        while (aux != null) {
            if (aux.dato == x) {
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    boolean Tamaño() {
        boolean ban = true;
        int i = 0;
        while (ban && i < marco) {
            if (matriz[i] == ' ') {
                return true;
            }
            i++;
        }
        return false;
    }

    char Sacar() {
        Nodo aux = frente;
        frente = frente.sig;
        return aux.dato;
    }

    void SacarM(char x) {
        boolean ban = true;
        int i = 0;
        while (ban) {
            if (matriz[i] == x) {
                matriz[i] = ' ';
                ban = false;
            }
            i++;
        }
    }

    int conta() {
        int x = contador;
        return x;
    }

    String Imprimir() {
        String salida = "";
        for (int i = 0; i < matriz.length; i++) {
            salida += matriz[i] + "|";
        }

        return salida;

    }

}
