/*
 *La siguiente Clase listaCircular fue Desarrollada por Juan Jesus Pulido Sanchez
 */

public class listaCircular {
    /**
     * Esta Clase listaCircular contiene todos los metodos correspondientes a la lista circular utilizada en el taller 2
     *
     * nodoCabecera -> nodo que indica el primer elemento de la lista circular
     * size -> numero entero que indica el tamano de la lista Circular
     *
     *      Constructor-> inicializa el tamano del arreglo en 0
     *
     *      Metodos:
     * 1) getSize -> retorna el tamano de la lista Circular
     * 2) setSize -> se pasa por parametro el tamano de la lista y se toma como el nuevo tamano de la lista
     * 3) revisarIndice -> se pasa por parametro el indice a revisar y dependiendo si es valido o no se lanza una excepcion
     * 4) remover -> remueve  el elemento en el indice pasado por parametro
     * 5) agregarTodo -> agrega en las posiciones de la lista Circular los datos indicados por el usuario
     * 6) agregar -> agrega en el indice indicado el elemento indicado como parametros
     */
    public node nodoCabecera;
    public int size;

    public listaCircular(){
        this.size = 0;
    }

    public listaCircular(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size){
        this.size = size;
        System.out.println("La Lista circular ha sido cambiada de tamano a: "+ size);
    }

    void revisarIndice(int indice){
        if (indice<0 || indice>=size){
            throw new IndexOutOfBoundsException("Indice = "+indice+ " Size = "+ size);
        }
    }

    public void remover(int indice) {
        revisarIndice(indice);
        node nodoPrueba = nodoCabecera;
        if (indice == 0) {
            nodoCabecera=nodoPrueba.siguienteNodo;
            for (int i = 0; i < size - 1; i++) {
                nodoPrueba = nodoPrueba.siguienteNodo;
            }
            nodoPrueba.siguienteNodo = nodoCabecera;
            size--;
        } else {
            for (int i = 0; i < indice-1; i++) {
                nodoPrueba = nodoPrueba.siguienteNodo;
                System.out.println("Nodo Prueba elemento " + nodoPrueba.elemento);
            }
            System.out.println("Nodo Prueba elemento final a borrar" + nodoPrueba.elemento);
            Object elementoEliminado = nodoPrueba.elemento;
            nodoPrueba.siguienteNodo = nodoPrueba.siguienteNodo.siguienteNodo;
            size--;
            System.out.println("Se ha borrado el elemento: " + elementoEliminado);

        }
    }

    public void agregarTodo(Object elemento,int indice){
        if(nodoCabecera==null){
            nodoCabecera = new node(elemento);
            nodoCabecera.siguienteNodo=nodoCabecera;
        }else{
            if (indice==1){
                nodoCabecera.siguienteNodo= new node(elemento,nodoCabecera);
            }else{
                node prueba = nodoCabecera;
                for(int i = 1; i<indice;i++){
                    prueba = prueba.siguienteNodo;
                }
                prueba.siguienteNodo= new node(elemento,nodoCabecera);
            }
        }
    }

    public void agregar(Object elemento,int indice){
        if(indice == size){
            node prueba = nodoCabecera;
            for(int i = 1; i<indice;i++){
                prueba = prueba.siguienteNodo;
            }
            prueba.siguienteNodo= new node(elemento,nodoCabecera);
            size++;
        }else{
            revisarIndice(indice);
            node nodoPrueba = nodoCabecera;
            if(indice ==0){
                node nuevo = new node(elemento);
                nuevo.siguienteNodo=nodoPrueba;
                for(int i = 1;i<size;i++){
                    nodoPrueba=nodoPrueba.siguienteNodo;
                }
                nodoPrueba.siguienteNodo= nuevo;
                nodoCabecera=nuevo;
                size++;
            }else{
                for(int i  =0;i<indice-1; i++){
                    nodoPrueba = nodoPrueba.siguienteNodo;
                }
                nodoPrueba.siguienteNodo = new node(elemento,nodoPrueba.siguienteNodo);
                size++;
            }
        }
    }
}
