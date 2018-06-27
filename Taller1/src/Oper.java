import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
/*Desarrollado por Juan Jesús Pulido Sánchez*/

/**
 * Clase Oper que implementa los metodos de structOper
 *
 * memo es un diccionario de Big Integers que nos facilita la velocidad al calcular el fibonacci utilizando programacion dinamica
 *
 */

public class Oper implements structOper {
    public static Map<Integer, BigInteger> memo = new HashMap<>();


    @Override
    public void sumaArr(Arreglo arr1, Arreglo arr2) {
        /**
         * sumaArr es un metodo que suma componente a componente los valores de dos arreglos
         * @param arr1 arreglo 1
         * @param arr2 arreglo 2
         * @return retorna vacio
         */
        int temp = arr1.getTam()-arr2.getTam();
        if(temp>=0){
            System.out.print("[ ");
            //tiene o el mismo tamaño o arr1 es mas grande
            for (int i = 0; i<arr2.getTam();i++){
                System.out.print(arr1.vector1[i]+arr2.vector1[i]+ ", ");
            }
            for(int j = 0;j<temp;j++){
                System.out.print("E, ");
            }
            System.out.println("]");
        }else{
            System.out.print("[ ");
            //arr2 es mas grande
            for (int i = 0; i<arr1.getTam();i++){
                System.out.print(arr1.vector1[i]+arr2.vector1[i]+ ", ");
            }
            for(int j = 0;j>temp;j--){
                System.out.print("E, ");
            }
            System.out.print("]");
            }
        System.out.println("Si los arrays tenian distintos tamanos, no se puede realizar operaciones en todos sus elementos, por lo tanto se mostrara una e indicando error");


    }

    @Override
    public void restaArr(Arreglo arr1, Arreglo arr2) {
        /**
         * restaArr es un metodo que resta componente a componente los valores de dos arreglos
         * @param arr1 arreglo 1
         * @param arr2 arreglo 2
         * @return retorna vacio
         */
        int temp = arr1.getTam()-arr2.getTam();
        if(temp>=0){
            System.out.print("[ ");
            //tiene o el mismo tamaño o arr1 es mas grande
            for (int i = 0; i<arr2.getTam();i++){
                System.out.print(arr1.vector1[i]-arr2.vector1[i]+ ", ");
            }
            for(int j = 0;j<temp;j++){
                System.out.print("E, ");
            }
            System.out.println("]");
        }else{
            System.out.print("[ ");
            //arr2 es mas grande
            for (int i = 0; i<arr1.getTam();i++){
                System.out.print(arr1.vector1[i]-arr2.vector1[i]+ ", ");
            }
            for(int j = 0;j>temp;j--){
                System.out.print("E, ");
            }
            System.out.print("]");


        }
        System.out.println("Si los arrays tenian distintos tamanos, no se puede realizar operaciones en todos sus elementos, por lo tanto se mostrara una e indicando error");
    }

    @Override
    public void multpArr(Arreglo arr1, Arreglo arr2) {
        /**
         * multpArr es un metodo que multiplica componente a componente los valores de dos arreglos
         * @param arr1 arreglo 1
         * @param arr2 arreglo 2
         * @return retorna vacio
         */
        int temp = arr1.getTam()-arr2.getTam();
        if(temp>=0){
            System.out.print("[ ");
            //tiene o el mismo tamaño o arr1 es mas grande
            for (int i = 0; i<arr2.getTam();i++){
                System.out.print(arr1.vector1[i]*arr2.vector1[i]+ ", ");
            }
            for(int j = 0;j<temp;j++){
                System.out.print("E, ");
            }
            System.out.println("]");
        }else{
            System.out.print("[ ");
            //arr2 es mas grande
            for (int i = 0; i<arr1.getTam();i++){
                System.out.print(arr1.vector1[i]*arr2.vector1[i]+ ", ");
            }
            for(int j = 0;j>temp;j--){
                System.out.print("E, ");
            }
            System.out.print("]");


        }
        System.out.println("Si los arrays tenian distintos tamanos, no se puede realizar operaciones en todos sus elementos, por lo tanto se mostrara una e indicando error");
    }

    @Override
    public void factArr(Arreglo arr) {
        /**
         * factArr es un metodo que imprime el valor del factorial segun n siendo el valor del arreglo en cada posicion
         * @param arr1 arreglo 1
         * @param arr2 arreglo 2
         * @return retorna vacio
         */
        System.out.print("[ ");
        for (int i=0;i<arr.getTam();i++){
            System.out.print(factorial(BigInteger.valueOf(arr.vector1[i]))+ ", ");
        }
        System.out.println("]");
    }

    @Override
    public void fiboArr(Arreglo arr) {
        /**
         * fiboArr es un metodo que imprime el valor del indice de la sucesion del fibonacci segun n siendo el valor del arreglo en cada posicion
         * @param arr1 arreglo 1
         * @param arr2 arreglo 2
         * @return retorna el valor fibonacci en BigInteger
         */
        System.out.print("[");
        for (int i = 0; i < arr.getTam(); i++) {
            int n = arr.vector1[i];
            System.out.print(fibonacci(n-1)+", ");
        }
        System.out.println("]");
    }

    public static BigInteger fibonacci(int n) {
        /**
         * fibonacci calcula el indice n de la serie de fibonaccio
         * @param n indice de fibonacci
         * @return retorna vacio
         */
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        BigInteger v = fibonacci(n - 2).add(fibonacci(n - 1));
        memo.put(n, v);
        return v;
    }


    public static BigInteger factorial(BigInteger n){
        /**
         * factorial calcula un factorial de un numero n
         * @param n valor para calcular su factorial
         * @return retorna el valor factorial en BigInteger
         */

        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));

        /*
        Asi quedaria la version iterativa y mas eficiente del factorial
        BigInteger fact= BigInteger.ONE;

        for (int i = 2; i <= n; i++)
        {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println("The factorial of " + n +" is: " + fact);

    */
    }

}
