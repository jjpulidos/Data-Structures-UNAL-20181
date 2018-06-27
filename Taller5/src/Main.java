import java.util.*;

import DataStackStructure.DerivedArrayStack;
/*
LA siguiente Clase Main fue desarrollada por Juan Jesus Pulido Sanchez
 */
public class Main {

    /***
     * La siguiente clase Main realiza el procedimiento especificado en la guia Taller 5 (Utilizando la implementacion de stack
     * como DerivedArrayStack)
     *
     * Explicacion:
     *
     * 1) se ingresa el numero de jugadores
     * 2) se ingresa uno a uno el color de cada jugador
     * 3) el sistema recalcula al azar una partida hasta que algun jugador gane
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DerivedArrayStack[] pilas;
        DerivedArrayStack[] pilasPorDefecto;
        ArrayList<String> coloresAsignados;
        ArrayList<String> coloresSinAsignar = new ArrayList<>(Arrays.asList("ROJO","ANARANJADO","AMARILLO","AZUL","VERDE","BLANCO","ROSADO","MARRON","GRIS","MORADO"));
        System.out.println("Cuantos jugadores van a participar");
        int dado=0;
        int jug = 0;
        while (true) {
            try {
                jug = Integer.parseInt(sc.nextLine());
                if (jug > 0 && jug < 6) {
                    pilas = new DerivedArrayStack[jug];
                    coloresAsignados = new ArrayList<String>(jug);
                    break;
                } else {
                    System.out.println("Numero de Jugadores imposible, no puede ser negativo ni mayor a 5");
                }

            } catch (Exception e1) {
                System.out.println("Ingrese solo un numero");
            }
        }

        for (int i = 0; i < jug; i++) {
            System.out.println("Ingrese el Color asignado al jugador " + (i + 1));
            String colorAsignado;
            try {
                colorAsignado = sc.nextLine();
                if (colorAsignado.toUpperCase().equals("NEGRO")) {
                    System.out.println("Ningun jugador puede tener el color negro asignado");
                    i--;
                }else if(coloresAsignados.contains(colorAsignado.toUpperCase())){
                    System.out.println("El color ya ha sido asignado a un jugador");
                    i--;
                }else if (colorAsignado.toUpperCase().equals("ROJO") || colorAsignado.toUpperCase().equals("ANARANJADO") || colorAsignado.toUpperCase().equals("AMARILLO") || colorAsignado.toUpperCase().equals("AZUL") || colorAsignado.toUpperCase().equals("VERDE")  || colorAsignado.toUpperCase().equals("BLANCO") || colorAsignado.toUpperCase().equals("ROSADO") || colorAsignado.toUpperCase().equals("MARRON") || colorAsignado.toUpperCase().equals("GRIS") || colorAsignado.toUpperCase().equals("MORADO")) {
                    coloresAsignados.add(i, colorAsignado.toUpperCase());
                    pilas[i]= new DerivedArrayStack();
                    if(coloresSinAsignar.contains(colorAsignado.toUpperCase())){
                        coloresSinAsignar.remove(colorAsignado.toUpperCase());
                    }
                } else {
                    System.out.println("Color no valido");
                    i--;
                }
            }catch(Exception e1){
                System.out.println("error Color no valido");
            }
        }
        System.out.println("Colores Asignados: "+coloresAsignados.toString());
        System.out.println("Colores sin Asignar: "+coloresSinAsignar.toString());
        HashMap<String,DerivedArrayStack> WAsign= new HashMap<>();
       pilasPorDefecto= new DerivedArrayStack[coloresSinAsignar.size()];
       for (int k = 0; k<pilasPorDefecto.length;k++){
           pilasPorDefecto[k]= new DerivedArrayStack();
           WAsign.put(coloresSinAsignar.get(k),pilasPorDefecto[k]);
       }
        boolean flag = true;
        while(flag){
            dado++;
            System.out.println("Se lanzo el dado por "+dado+" vez");
            int valorRan = (int) (Math.random() * 11);
            switch (valorRan){
                case 0:
                    System.out.println("El dado dice Color Negro");
                    for (int i = 0; i<jug;i++){
                        if (!pilas[i].empty()){
                            int toptemp = (Integer)pilas[i].peek()-1;
                            if(toptemp>=1){
                                pilas[i].pop();
                                pilas[i].push(toptemp);
                            }
                        }else{
                            pilas[i].push(0);
                        }

                    }
                    for (int i = 0; i<coloresSinAsignar.size();i++){
                        DerivedArrayStack temp=WAsign.get(coloresSinAsignar.get(i));
                        int toptemp;
                        if(!temp.empty()){
                            toptemp =(Integer) temp.peek() - 1;
                            if (toptemp>=1){
                                temp.pop();
                                temp.push(toptemp);
                                WAsign.put(coloresSinAsignar.get(i),temp);
                            }

                        }else{
                            temp.push(0);
                            WAsign.put(coloresSinAsignar.get(i),temp);
                        }

                    }
                    break;

                case 1:
                    System.out.println("El dado dice Color Anaranjado");
                    if(coloresAsignados.contains("ANARANJADO")){
                        int temp = coloresAsignados.indexOf("ANARANJADO");

                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador ANARANJADO");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }



                    }else if(WAsign.containsKey("ANARANJADO")){
                        DerivedArrayStack temp=WAsign.get("ANARANJADO");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA ANARANJADO");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("ANARANJADO",temp);
                    }
                    break;

                case 2:
                    System.out.println("El dado dice Color Amarillo");
                    if(coloresAsignados.contains("AMARILLO")){
                        int temp = coloresAsignados.indexOf("AMARILLO");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador AMARILLO");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("AMARILLO")){
                        DerivedArrayStack temp=WAsign.get("AMARILLO");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA AMARILLO");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("AMARILLO",temp);
                    }
                    break;

                case 3:
                    System.out.println("El dado dice Color AZUL");
                    if(coloresAsignados.contains("AZUL")){
                        int temp = coloresAsignados.indexOf("AZUL");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador AZUL");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("AZUL")){
                        DerivedArrayStack temp=WAsign.get("AZUL");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA AZUL");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("AZUL",temp);
                    }
                    break;

                case 4:
                    System.out.println("El dado dice Color VERDE");
                    if(coloresAsignados.contains("VERDE")){
                        int temp = coloresAsignados.indexOf("VERDE");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador VERDE");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }

                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("VERDE")){
                        DerivedArrayStack temp=WAsign.get("VERDE");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA VERDE");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("VERDE",temp);
                    }
                    break;

                case 5:
                    System.out.println("El dado dice Color BLANCO");
                    if(coloresAsignados.contains("BLANCO")){
                        int temp = coloresAsignados.indexOf("BLANCO");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador BLANCO");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("BLANCO")){
                        DerivedArrayStack temp=WAsign.get("BLANCO");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA BLANCO");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("BLANCO",temp);
                    }
                    break;
                case 6:
                    System.out.println("El dado dice Color ROSADO");
                    if(coloresAsignados.contains("ROSADO")){
                        int temp = coloresAsignados.indexOf("ROSADO");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador ROSADO");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("ROSADO")){
                        DerivedArrayStack temp=WAsign.get("ROSADO");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA ROSADO");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("ROSADO",temp);
                    }
                    break;

                case 7:
                    System.out.println("El dado dice Color MARRON");
                    if(coloresAsignados.contains("MARRON")){
                        int temp = coloresAsignados.indexOf("MARRON");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador MARRON");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("MARRON")){
                        DerivedArrayStack temp=WAsign.get("MARRON");
                        if (!temp.empty()){
                            int topTemp = (Integer)temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA MARRON");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("MARRON",temp);
                    }
                    break;

                case 8:
                    System.out.println("El dado dice Color GRIS");
                    if(coloresAsignados.contains("GRIS")){
                        int temp = coloresAsignados.indexOf("GRIS");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador GRIS");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("GRIS")){
                        DerivedArrayStack temp=WAsign.get("GRIS");
                        if (!temp.empty()){
                            int topTemp =(Integer) temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("EL ganador es la IA GRIS");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("GRIS",temp);
                    }
                    break;
                case 9:
                    System.out.println("El dado dice Color MORADO");
                    if(coloresAsignados.contains("MORADO")){
                        int temp = coloresAsignados.indexOf("MORADO");
                        if (!pilas[temp].empty()){
                            if((Integer)pilas[temp].peek()+10 >=100) {
                                flag = false;
                                System.out.println("EL ganador es el jugador MORADO");
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                                break;
                            }else{
                                pilas[temp].push((Integer)pilas[temp].peek()+10);
                            }
                        }else{
                            pilas[temp].push(10);
                        }
                    }else if(WAsign.containsKey("MORADO")){
                        DerivedArrayStack temp=WAsign.get("MORADO");
                        if (!temp.empty()){
                            int topTemp =(Integer) temp.peek();
                            temp.push(topTemp+10);
                            if(topTemp+10 >=100){
                                flag = false;
                                System.out.println("El Ganador es la IA MORADO ");
                                break;
                            }
                        }else{
                            temp.push(10);

                        }
                        WAsign.put("MORADO",temp);
                    }
                    break;

                    case 10:
                System.out.println("El dado dice Color ROJO");
                if(coloresAsignados.contains("ROJO")){
                    int temp = coloresAsignados.indexOf("ROJO");

                    if (!pilas[temp].empty()){
                        if((((Integer)pilas[temp].peek()+10)) >=100) {
                            flag = false;
                            System.out.println("EL ganador es el jugador ROJO");
                            pilas[temp].push((Integer)pilas[temp].peek()+10);
                            break;
                        }else{
                            pilas[temp].push((Integer)pilas[temp].peek()+10);
                        }
                    }else{
                        pilas[temp].push(10);
                    }



                }else if(WAsign.containsKey("ROJO")){
                    DerivedArrayStack temp=WAsign.get("ROJO");
                    if (!temp.empty()){
                        int topTemp = (Integer)temp.peek();
                        temp.push(topTemp+10);
                        if(topTemp+10 >=100){
                            flag = false;
                            System.out.println("EL ganador es la IA ROJO");
                            break;
                        }
                    }else{
                        temp.push(10);

                    }
                    WAsign.put("ROJO",temp);
                }
                break;

            }

            System.out.println("**********TABLA DE POSICIONES**********************");
            System.out.println();

            for (int i = 0; i<jug;i++){
                System.out.println(coloresAsignados.get(i).toUpperCase()+ " : "+pilas[i].toString());
            }

            for (int i = 0; i<coloresSinAsignar.size();i++){

                System.out.println(coloresSinAsignar.get(i).toUpperCase()+ " : "+WAsign.get(coloresSinAsignar.get(i)));
            }
            System.out.println();System.out.println();System.out.println();

        }

    }
}
