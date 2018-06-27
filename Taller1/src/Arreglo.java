import java.util.Arrays;
/*Desarrollado por Juan Jesús Pulido Sánchez*/

/**
 *Clase arreglo que permite extender funcionalidades de los arreglos comunes
 *
 *
 *vector1 es el arreglo que manejaremos en todas las inicializaciones de arreglo
 * 
 * defineTam => define el tamano del arreglo
 * AddData =>ingresa un nuevo dato al arreglo en el indice especificado
 * Delete Data => borra un dato en un indice especificado
 * AddCampo => agrega un nuevo campo en el indice especificado
 */

public class Arreglo extends Structure{

    int vector1[]= new int[0];

    public Arreglo(){
        super.tam= vector1.length;
    }
    public void defineTam(int tam){
        /**
         * defineTam define el tamano del arreglo
         * @param tam corresponde al tamano del arreglo
         * @return retorna vacio
         */
        super.setTam(tam);
        vector1 = new int[tam];
        System.out.println("Se redefinio el tamano del arreglo 1 en: "+ tam);
        System.out.println(Arrays.toString(vector1));
    }

    public void AddData(int indice, int valor){
        /**
         * AddData ingresa un nuevo dato al arreglo en el indice especificado
         * @param indice corresponde al indice que deseamos ingresar el valor
         * @param valor correspone al valor a ingresar
         * @return retorna vacio
         */
        try{
            if(vector1[indice]== 0){
                vector1[indice]=valor;
                System.out.println("Ha sido agregado el valor : "+vector1[indice]+" en el indice "+indice);
                System.out.println(Arrays.toString(vector1));
            }else{
                System.out.println("Ya existe un valor en ese indice del arreglo 1");
                System.out.println(Arrays.toString(vector1));
            }

        }catch (Exception e1){
            System.out.println("El indice no es valido para el arreglo 1");
            System.out.println(Arrays.toString(vector1));

        }
    }

    public void DeleteData(int indice){
        /**
         * Delete Data borra un dato en un indice especificado
         * @param indice corresponde al indice del campo que deseamos eliminar
         * @return retorna vacio
         */

        try{
            int vector2[] = new int[vector1.length-1];
            System.arraycopy(vector1, 0, vector2, 0, indice );
            System.arraycopy(vector1, indice+1, vector2, indice, vector1.length -indice-1);
            System.out.println("Ha sido borrado el campo con indice : "+indice);
            this.vector1 = vector2;
            System.out.println(Arrays.toString(vector1));
        }catch (Exception e1){
            System.out.println("El indice del campo no es valido para el arreglo 1");
            System.out.println(Arrays.toString(vector1));

        }
    }

    public void AddCampo(int indice){
        /**
         * AddCampo agrega un nuevo campo en el indice especificado
         * @param indice corresponde al indice del campo que deseamos agregar
         * @return retorna vacio
         */

        try{
            int vector2[] = new int[vector1.length+1];
            System.arraycopy(vector1, 0, vector2, 0, indice);
            vector2[indice]=0;
            System.arraycopy(vector1, indice, vector2, indice+1, vector1.length -indice);
           // System.out.println("Ha sido borrado el campo con indice : "+indice);
            this.vector1 = vector2;
            System.out.println(Arrays.toString(vector1));
        }catch (Exception e1){
            System.out.println("El indice del campo no es valido para el arreglo 1");
            System.out.println(Arrays.toString(vector1));

        }

    }

}
