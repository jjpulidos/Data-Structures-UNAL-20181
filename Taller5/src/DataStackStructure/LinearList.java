/*
 La siguiente Clase fue desarrollada por el docente a cargo de la materia de Estructura de Datos
 y implementada por Juan Jesús Pulido Sánchez
*/
package DataStackStructure;
public interface LinearList {
    /**
     * La Interface LinearList declara metodos para ser implementados por distintas estructuras, y en este caso la pila.
     * en nuestro aplicativo solo se sobreescribe el metodo toString.
     * Metodos:
     * 1) isEmpty() retorna un valor de falso o verdadero si la pila esta vacia o no
     * 2) size() retorna el tamano de la lista linear
     * 3) get(int index) retorna el valor de el elemento en dicho indice de la lista linear
     * 4) remove(int index) remueve el valor de un objeto en un indice y lo retorna
     * 5) add(int index, Object theElement) agrega un elemento a un dicho indice de la lista linear
     * 6) toString() retorna un String con los elementos de la lista linear
     */
    public boolean isEmpty();

    public int size();

    public Object get(int index);

    public int indexOf(Object theElement);

    public Object remove(int index);

    public void add(int index, Object theElement);

    public String toString();
}
