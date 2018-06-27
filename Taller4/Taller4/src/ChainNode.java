/*
 La siguiente Clase fue desarrollada por el docente a cargo de la materia de Estructura de Datos
 y implementada por Juan Jesús Pulido Sánchez
*/
class ChainNode {
    /**
     * La clase ChainNode indica la definicion de los nodos manejados por los stack, en los cuales tendra un elemento
     * y un nodo siguiente. Esta clase consta de 3 constructores, uno por defecto sin parametros, otro que asigna un parametro al objeto a guardar
     * y el ultimo que ademas de asignar este elemento, tambien asigna el siguiente nodo.
     */
    Object element;
    ChainNode next;

    ChainNode() {
    }

    ChainNode(Object element) {
        this.element = element;
    }

    ChainNode(Object element, ChainNode next) {
        this.element = element;
        this.next = next;
    }
}
