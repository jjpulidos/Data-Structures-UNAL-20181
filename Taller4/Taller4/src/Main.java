/*
 La siguiente Clase fue desarrollada por Juan Jesús Pulido Sánchez para la materia de Estructura de Datos
*/
import java.util.Scanner;
public class Main {
    /***
     * Podemos visualizar un main con toda la funcionalidad especificada en el taller 4 en el metodo main,
     * En resumen el proceso es el siguiente:
     *
     *  1) se pide al usuario cuantas pilas desea utilizar (1 a 10)
     *  2) se pide como se rellenaran dichas pilas (agregado llenado personalizado segun bottom)
     *  3) se ingresan ciertas letras a buscar y se imprimen las distancias de recorrido desde el top
     *
     *  El programa consta con documentacion y ontroles de usuario
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPilas;
        DerivedArrayStack[] pilas;

        while (true) {
            System.out.println("Cuantas pilas desea utilizar");
            try {

                numPilas = Integer.parseInt(sc.nextLine());
                if (numPilas > 0 && numPilas < 11) {
                    pilas = new DerivedArrayStack[numPilas];
                    break;
                } else {
                    System.out.println("Numero no valido");
                }

            } catch (Exception e1) {
                System.out.println("numero invalido");
            }

        }

        for (int i = 0; i < numPilas; i++) {
            pilas[i] = new DerivedArrayStack();
            System.out.println("Para la pila Numero: " + (i + 1));

            System.out.println("Menu de relleno de pila");
            System.out.println("1. Rellenar desde la letra A hasta la letra Z (TOP A)");
            System.out.println("2. Rellenar desde la letra Z hasta la letra A (TOP Z)");
            System.out.println("3. Rellenar desde cualquier letra hasta la longitud del alfabeto anglosajon");
            int casosRellenoPila = 0;
            String str;
            try {
                casosRellenoPila = Integer.parseInt(sc.nextLine());

            } catch (Exception e1) {
                System.out.println("numero invalido de los casos");
            }
            switch (casosRellenoPila) {
                case 1:
                    str = "abcdefghijklmnopqrstuvwxyz";
                    for (int j = str.length() - 1; j >= 0; j--) {

                        pilas[i].push(Character.toUpperCase(str.charAt(j)));
                    }
                    System.out.println("La pila " + (i + 1) + " quedo llenada de la siguiente manera");
                    System.out.println(pilas[i].toString());
                    break;

                case 2:
                    str = "abcdefghijklmnopqrstuvwxyz";


                    for (int j = 0; j < str.length(); j++) {

                        pilas[i].push(Character.toUpperCase(str.charAt(j)));
                    }
                    System.out.println("La pila " + i + " quedo llenada de la siguiente manera");
                    System.out.println(pilas[i].toString());
                    break;

                case 3:
                    str = "abcdefghijklmnopqrstuvwxyz";
                    char temp = 'a';
                    while (true) {
                        System.out.println("Cual caracter deseas para el bottom de la pila");
                        try {
                            temp = sc.nextLine().charAt(0);
                            if (str.contains(temp + "")) {
                                break;
                            } else {
                                System.out.println("el dato ingresado no corresponde al alfabeto anglosajon, vuelva a ingresarlo");
                            }

                        } catch (Exception e1) {
                            System.out.println("el dato ingresado no fue un caracter");
                        }
                    }
                    int c = 0;
                    int lenTemp = str.length();
                    for (int j = 0; j < lenTemp; j++, c++) {
                        if ((c + str.indexOf(temp) == lenTemp)) {
                            c = -str.indexOf(temp);
                        }
                        pilas[i].push(Character.toUpperCase(str.charAt(c + str.indexOf(temp))));

                    }
                    System.out.println("La pila " + (i+1) + " quedo llenada de la siguiente manera");
                    System.out.println(pilas[i].toString());
                    break;
                default:
                    System.out.println("Debe ser un caso de los especificados");
                    i--;
                    break;
            }
        }
        System.out.println("Para buscar n letras en los arreglos, tenga en cuenta que seran buscadas de la siguiente manera: ");
        System.out.println("Solo se buscaran maximo n letras en m arreglos, por lo tanto n letras debe ser menor o igual a m");
        System.out.println("Si n letras es menor que el numero de arreglos (m), entonces se seleccionaran los primeros n arreglos");
        System.out.println("Si n letras es mayor que el numero de arreglos (m), entonces se buscaran las primeras n letras equivalentes a m");
        System.out.println("las busquedas se realizaran 1 a 1 entre las letras y los arreglos, secuencialmente");
        System.out.println("Querido Usuario, por favor presione enter para continuar con el programa y luego ingrese los n caracteres a buscar separados por enter");
        sc.nextLine();
        int letras = 0;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Por favor ingrese el numero de letras a buscar en los arreglos");
                letras = Integer.parseInt(sc.nextLine());
                if (letras <= 0) {
                    System.out.println("el numero de letras no puede ser negativo o cero");
                } else {
                    flag = false;
                    int menor = Math.min(letras, pilas.length);
                    int count = 0;
                    for (int i = 0; i < menor; i++) {
                        char letra = 'a';
                        char letraTemp = Character.toUpperCase(letra);
                        try {
                            System.out.println("Ingrese los " + letras + " caracteres a buscar separados por enter");
                            letra = sc.nextLine().charAt(0);
                            letraTemp = Character.toUpperCase(letra);
                        } catch (Exception e1) {
                            System.out.println("Hubo un problema con el char ingresado");
                            i--;
                        }
                        while (true) {
                            if (!pilas[i].empty()) {
                                if (pilas[i].peek().equals(letraTemp)) {
                                    System.out.println("Se eliminaron " + count + " posiciones de la pila " + (i + 1) + " para obtener la letra " + letraTemp);
                                    System.out.println(pilas[i]);
                                    count = 0;
                                    break;
                                } else {
                                    count++;
                                    pilas[i].pop();
                                }
                            } else {
                                System.out.println("No se encontro el elemento en la lista, por lo tanto se vacio completa");
                                System.out.println(pilas[i]);
                                count = 0;
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e1) {
                System.out.println("numero invalido de los casos");
            }
        }
    }
}
