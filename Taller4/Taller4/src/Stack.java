/*
 La siguiente Interface fue desarrollada por el docente a cargo de la materia de Estructura de Datos
 y implementada por Juan Jesús Pulido Sánchez
*/
public interface Stack {
    /***
     * La interface Stack declara los metodos que va a realizar nuestro propio stack:
     *
     * Metodos:
     *
     * 1) empty() retorna un valor de falso o verdadero si la pila esta vacia o no
     * 2) peek() retorna el valor top de la pila
     * 3) push() introduce el objeto por parametro dentro de la estructura en la posicion peek
     * 4) pop() borra el primer elemento de la pila (top)
     */
    public boolean empty();

    public Object peek();

    public void push(Object theObject);

    public Object pop();
}
