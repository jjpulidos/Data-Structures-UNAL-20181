/*
 *La siguiente Clase node fue Desarrollada por Juan Jesus Pulido Sanchez
 */

public class node {
    /**
     * Esta Clase node indica cada una de las posiciones de mi lista circular y cada uno de estos nodos posee
     *
     *  elemento -> donde se almacenaran las notas musicales
     *  siguiente Nodo -> apuntador al nodo siguiente
     *
     *  Consta de dos Constructores:
     *
     *  1) inicializa el nodo con el elemento almacenado igual al objeto como parametro y el apuntador a null
     *  2) inicializa el nodo con el elemento almacenado igual al objeto como parametro y el apuntador a un nodo que es pasado por parametro
     */

    Object elemento;
    node siguienteNodo;

    public node(Object objeto){
        this.elemento = objeto;
        this.siguienteNodo = null;
    }

    public node(Object objeto, node siguienteNodo){
        this.elemento = objeto;
        this.siguienteNodo = siguienteNodo;
    }


}
