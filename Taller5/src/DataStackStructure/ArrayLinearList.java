/*
 La siguiente Clase fue desarrollada por el docente a cargo de la materia de Estructura de Datos
 y implementada por Juan Jesús Pulido Sánchez
*/
package DataStackStructure;
import java.lang.reflect.Array;
public class ArrayLinearList {
    /**
     * La Clase ArrayLinearList contiene un array de objetos, y su tamano como datos, y metodos tiene:
     *
     * Constructores con asignacion de tamano personalizados y por defecto en 10
     *
     * Metodos:
     * 1) isEmpty() retorna un valor de falso o verdadero si la pila esta vacia o no
     * 2) size() retorna el valor del tamano
     * 3) checkIndex(int index)  revisa si el indice pasado por parametro es valido
     * 4) get(int index) obtiene el elemento en dicho indice de la lista linear
     * 5) indexOf(Object theElement) retorna el indice del objeto a buscar
     * 6) remove(int index) remueve y retorna el objeto en el indice pasado por parametro
     * 7) add(int index, Object theElement) agrega un elemento a un cierto indice de la lista linear
     * 8) toString() retorna un string con todos los elementos de la lista linear
     */
    protected Object[] element; // array of elements
    protected int size; // number of elements in array

    // constructors
    public ArrayLinearList(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException
                    ("initialCapacity must be >= 1");
        element = new Object[initialCapacity];
    }

    /**
     * create a list with initial capacity 10
     */
    public ArrayLinearList() {// use default capacity of 10
        this(10);
    }
    // methods

    /**
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return current number of elements in list
     */
    public int size() {
        return size;
    }

    /**
     * @throws IndexOutOfBoundsException when
     *                                   index is not between 0 and size - 1
     */
    void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index = " + index + "  size = " + size);
    }

    public Object get(int index) {
        checkIndex(index);
        return element[index];
    }

    public int indexOf(Object theElement) {
        for (int i = 0; i < size; i++)
            if (element[i].equals(theElement))
                return i;
        return -1;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removedElement = element[index];
        for (int i = index + 1; i < size; i++)
            element[i - 1] = element[i];
        element[--size] = null;
        return removedElement;
    }

    public void add(int index, Object theElement) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException
                    ("index = " + index + "  size = " + size);
        if (size == element.length)
            element = changeLength1D(element, 2 * size);
        for (int i = size - 1; i >= index; i--)
            element[i + 1] = element[i];
        element[index] = theElement;
        size++;
    }

    public static Object[] changeLength1D(Object[] a, int n, int newLength) {
        if (n > newLength)
            throw new IllegalArgumentException
                    ("new length is too small");
        Object[] newArray = (Object[]) Array.newInstance
                (a.getClass().getComponentType(), newLength);
        System.arraycopy(a, 0, newArray, 0, n);
        return newArray;
    }

    public static Object[] changeLength1D(Object[] a, int newLength) {
        return changeLength1D(a, a.length, newLength);
    }

    public String toString() {
        StringBuffer s = new StringBuffer("[");
        for (int i = 0; i < size; i++)
            if (element[i] == null)
                s.append("null, ");
            else
                s.append(element[i].toString() + ", ");
        if (size > 0)
            s.delete(s.length() - 2, s.length());
        s.append("]");
        return new String(s);
    }

}