import java.util.Scanner;
/*Desarrollado por Juan Jesús Pulido Sánchez*/
/**
 * La clase Taller1 Contempla toda la funcionalidad de lo especificado en el taller 1 de la materia Estructura de Datos
 *
 * el metodo menu esta sobre cargado para ser utilizado segun el caso
 * para menu principal pasamos un char por parametro y se imprimira el menu principal
 * para sub menus depende del entero que se pase por parametro para la impresion de dichos sub menus
 */

public class Taller1 {

    public static void menu(char a){
        System.out.println("********Menu Principal*********");
        System.out.println("El siguiente programa solo acepta entradas numericas, por favor abstenerse de realizar entradas distintas a las mencionadas");
        System.out.println("1. Arreglo 1");
        System.out.println("2. Arreglo 2");
        System.out.println("3. Operaciones");
    }

    public static void menu(int a){
        if (a==1){
            System.out.println("********Sub Menu Arreglo 1*********");
            System.out.println("1. Define tamaño arreglo 1");
            System.out.println("2. Agrega Datos arreglo 1");
            System.out.println("3. Elimina un campo arreglo 1");
            System.out.println("4. Agrega un campo en arreglo 1");
            System.out.println("5. Volver");

        }else if (a==2){
            System.out.println("********Sub Menu Arreglo 2*********");
            System.out.println("1. Define tamaño arreglo 2");
            System.out.println("2. Agrega Datos arreglo 2");
            System.out.println("3. Elimina un campo arreglo 2");
            System.out.println("4. Agrega un campo en arreglo 2");
            System.out.println("5. Volver");

        }else if(a==3){
            System.out.println("********Sub Menu Operaciones*********");
            System.out.println("1. Suma de arreglos 1 y 2");
            System.out.println("2. Resta de arreglos 1 y 2");
            System.out.println("3. Multiplicacion de arreglos 1 y 2");
            System.out.println("4. Factorial de un Arreglo");
            System.out.println("5. Fibonacci de un Arreglo");
            System.out.println("6. Volver");
        }

    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flagGen = true;
        Arreglo arr = new Arreglo();
        Arreglo arr2 = new Arreglo();
        while (flagGen) {
            menu('a');
            int n=4;
                n = sc.nextInt();

            switch (n) {

                case 1:


                    boolean flagArr1 = true;

                    while (flagArr1) {
                       menu(1);
                        int n1 = sc.nextInt();

                        switch (n1) {

                            case 1:
                                System.out.println("Ingrese el nuevo tamano del arreglo 1: ");
                                int tam = sc.nextInt();
                                arr.defineTam(tam);
                                break;

                            case 2:
                                System.out.println("Ingrese el indice del dato a ingresar en el arreglo 1: ");
                                int indice = sc.nextInt();
                                System.out.println("Ingrese el valor del dato a ingresar en el arreglo 1: ");
                                int valor = sc.nextInt();
                                arr.AddData(indice, valor);
                                break;

                            case 3:
                                System.out.println("Ingrese el indice con el campo a borrar");
                                int indiceDel = sc.nextInt();
                                arr.DeleteData(indiceDel);
                                break;
                            case 4:
                                System.out.println("Ingrese el indice del campo que desea anadir");
                                int indiceAdd = sc.nextInt();
                                arr.AddCampo(indiceAdd);
                                break;
                            case 5:
                                flagArr1 = false;
                                break;
                            default:
                                flagGen=false;
                                System.out.println("Operacion no valida, vuelva a ingresar uno de los valores del menu");
                                break;
                        }
                    }
                    break;
                case 2:


                    boolean flagArr2 = true;

                    while (flagArr2) {
                        menu(2);
                        int n2 = sc.nextInt();

                        switch (n2) {

                            case 1:
                                System.out.println("Ingrese el nuevo tamano del arreglo 2: ");
                                int tam = sc.nextInt();
                                arr2.defineTam(tam);
                                break;

                            case 2:
                                System.out.println("Ingrese el indice del dato a ingresar en el arreglo 2: ");
                                int indice = sc.nextInt();
                                System.out.println("Ingrese el valor del dato a ingresar en el arreglo 2: ");
                                int valor = sc.nextInt();
                                arr2.AddData(indice, valor);
                                break;

                            case 3:
                                System.out.println("Ingrese el indice con el campo a borrar");
                                int indiceDel = sc.nextInt();
                                arr2.DeleteData(indiceDel);
                                break;
                            case 4:
                                System.out.println("Ingrese el indice del campo que desea anadir");
                                int indiceAdd = sc.nextInt();
                                arr2.AddCampo(indiceAdd);
                                break;
                            case 5:
                                flagArr2 = false;
                                break;
                            default:
                                System.out.println("Operacion no valida, vuelva a ingresar uno de los valores del menu");
                                break;

                        }
                    }
                    break;


                case 3:
                    boolean flagOper = true;
                    menu(3);
                    while (flagOper) {

                        int n3 = sc.nextInt();
                        Oper operaciones = new Oper();
                        switch (n3) {
                            case 6:
                                flagOper = false;
                                break;
                            case 1:
                                operaciones.sumaArr(arr, arr2);
                                break;
                            case 2:
                                operaciones.restaArr(arr, arr2);
                                break;
                            case 3:
                                operaciones.multpArr(arr, arr2);
                                break;
                            case 4:
                                System.out.println("1. Arreglo 1");
                                System.out.println("2. Arreglo 2");
                                int s1 = sc.nextInt();
                                switch (s1) {
                                    case 1:
                                        operaciones.factArr(arr);
                                        break;
                                    case 2:
                                        operaciones.factArr(arr2);
                                        break;
                                    default:
                                        System.out.println("Operacion no valida, vuelva a ingresar uno de los valores del menu");
                                        break;
                                }
                                break;
                            case 5:
                                System.out.println("1. Arreglo 1");
                                System.out.println("2. Arreglo 2");
                                int s2 = sc.nextInt();
                                switch (s2) {
                                    case 1:
                                        operaciones.fiboArr(arr);
                                        break;
                                    case 2:
                                        operaciones.fiboArr(arr2);
                                        break;
                                    default:
                                        System.out.println("Operacion no valida, vuelva a ingresar uno de los valores del menu");
                                        break;

                                }

                            default:
                                System.out.println("Operacion no valida, vuelva a ingresar uno de los valores del menu");
                                break;

                        }

                    }
            }
        }
    }
}
