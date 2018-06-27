/*
 La siguiente Clase fue desarrollada por el docente a cargo de la materia de Estructura de Datos
 y implementada por Juan Jesús Pulido Sánchez
*/
package DataStackStructure;
import java.util.EmptyStackException;
public class DerivedArrayStack extends ArrayLinearList implements Stack {
    /**
     * La clase DerivedArrayStack implementa los metodos declarados en la interface stack (documentados alli)
     * tambien hereda ciertos metodos de ArrayLinearList ciertamente documentados alli como el toString, la capacidad inicial personalizada
     * y por defecto.
     */
    public DerivedArrayStack(int initialCapacity) {
        super(initialCapacity);
    }

    public DerivedArrayStack() {
        this(10);
    }

    // methods
    public boolean empty() {
        return isEmpty();
    }

    public Object peek() {
        if (empty()) throw new EmptyStackException();
        return get(size() - 1);
    }

    public void push(Object theElement) {
        add(size(), theElement);
    }

    public Object pop() {
        if (empty()) throw new EmptyStackException();
        return remove(size() - 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
