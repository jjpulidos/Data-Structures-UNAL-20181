/*Desarrollado por Juan Jesús Pulido Sánchez*/

/**
 * Esta clase es super clase de la clase arreglo
 *
 * contiene un constructor, que al inicializar la estructura su tamano sera 0
 *
 * la propiedad entera tam se encarga de almacenar el tamano de la estructura
 */

public class Structure {

    int tam;

    public Structure(){
        tam = 6;
    }

    public int getTam() {
        /**
         * @return retorna el tamano de la estructura
         */
        return tam;
    }

    public void setTam(int tam) {
        /**
         * @param tam tamano de la estructura que se desea crear
         * @return retorna vacio
         */
        this.tam = tam;
    }

}
