import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;
import java.util.*;
/*
*La siguiente Clase Main fue Desarrollada por Juan Jesus Pulido Sanchez
*
*/

public class Main {
    /**
     * Esta clase Main indica el proceso principal para llevar a cabo el taller 2
     *
     * El diccionario notas almacena una referencia del string en mayuscula de la nota hacia el url de la ubicacion del
     * archivo que reproduce dicha nota
     *
     *      Metodos:
     *      Menu -> imprime el menu principal
     *      main -> proceso principal
     *      getSound -> Obtiene el sonido de la url, tiene como parametro el url en formato string y retorna un Clip
     *      playSound -> Metodo que controla la reproduccion del clip, tiene como parametro el Clip
     */


    static HashMap<String,Clip> notas = new HashMap<>();

    public static void menu(){
        System.out.println("*******Menu Principal********");
        System.out.println("1. Define el tamano de la cadena musical");
        System.out.println("2. Agregar Notas a la Cadena");
        System.out.println("3. Agregar una nota");
        System.out.println("4. Elimina una nota");
        System.out.println("5. Escucha la melodia");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        notas.put("DO",getSound("do.wav"));
        notas.put("RE",getSound("re.wav"));
        notas.put("MI",getSound("mi.wav"));
        notas.put("FA",getSound("fa.wav"));
        notas.put("SOL",getSound("sol.wav"));
        notas.put("LA",getSound("la.wav"));
        notas.put("SI",getSound("si.wav"));
        listaCircular cadenaMusical = new listaCircular();

        while(true){
            menu();
            int cas;
            try{
                cas = Integer.parseInt(sc.nextLine());
            }catch(Exception e1){
                cas = 6;
            }

            switch (cas){
                case 1:
                    System.out.println("Ingrese el tamano de la cadena musical");
                    int s;
                    try{
                        s = Integer.parseInt(sc.nextLine());
                        if(s<1){
                            System.out.println("Ingrese un tamano valido para la cadena musical");
                        }else{
                            cadenaMusical.setSize(s);
                        }
                    }catch(Exception e1){
                        System.out.println("Ingrese un tamano valido para la cadena musical");
                    }
                    break;

                case 2:
                    try{
                        System.out.println("Agregue uno por uno las notas que desea anadir seguido de un salto de linea");
                        int tempSize = cadenaMusical.getSize();
                        for(int i = 0; i<tempSize;i++){
                            String nota = sc.nextLine();
                            if (nota.toUpperCase().equals("DO") ||nota.toUpperCase().equals("RE") ||nota.toUpperCase().equals("MI")
                                    || nota.toUpperCase().equals("FA")||nota.toUpperCase().equals("SOL") ||nota.toUpperCase().equals("LA")
                                    ||nota.toUpperCase().equals("SI")){
                                cadenaMusical.agregarTodo(nota.toUpperCase(),i);
                            }else{
                                System.out.println("Ingrese una nota valida");
                                i--;
                            }

                        }
                    }catch (Exception e1){
                        System.out.println("La cadena musical no ha sido inicializada");

                    }
                    break;

                case 3:
                    int indice;
                    System.out.println("Agregue el indice de la nota a agregar:");
                    try{
                        indice =Integer.parseInt(sc.nextLine());
                        System.out.println("Agregue la nota deseada");
                        String nota = sc.nextLine();
                        if (nota.toUpperCase().equals("DO") ||nota.toUpperCase().equals("RE") ||nota.toUpperCase().equals("MI")
                                || nota.toUpperCase().equals("FA")||nota.toUpperCase().equals("SOL") ||nota.toUpperCase().equals("LA")
                                ||nota.toUpperCase().equals("SI")){
                            cadenaMusical.agregar(nota.toUpperCase(),indice);
                            System.out.println("Ha sido cambiada la melodia");
                        }else{
                            System.out.println("la nota es invalida");
                        }

                    }catch(Exception e1){
                        System.out.println("el indice no es valido");
                    }



                    break;
                case 4:
                    System.out.println("Agregue el indice de la nota a remover:");
                    int indiceR;
                    try{
                        indiceR =Integer.parseInt(sc.nextLine());
                        cadenaMusical.remover(indiceR);
                    }catch (Exception e1){
                        System.out.println("Indice no valido");
                    }
                    break;

                case 5:
                    for(int i = 0; i<9*cadenaMusical.getSize();i++){
                        if (cadenaMusical.nodoCabecera.elemento.equals("DO")) {
                            playSound(notas.get("DO"));
                        }else if(cadenaMusical.nodoCabecera.elemento.equals("RE")){
                            playSound(notas.get("RE"));
                        }else if(cadenaMusical.nodoCabecera.elemento.equals("MI")){
                            playSound(notas.get("MI"));
                        }else if(cadenaMusical.nodoCabecera.elemento.equals("FA")){
                            playSound(notas.get("FA"));
                        }else if(cadenaMusical.nodoCabecera.elemento.equals("SOL")){
                            playSound(notas.get("SOL"));
                        }else if(cadenaMusical.nodoCabecera.elemento.equals("LA")){
                            playSound(notas.get("LA"));
                        }else if(cadenaMusical.nodoCabecera.elemento.equals("SI")){
                            playSound(notas.get("SI"));
                        }
                        try
                        {
                            Thread.sleep(500);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("elemento "+cadenaMusical.nodoCabecera.elemento);
                        cadenaMusical.nodoCabecera=cadenaMusical.nodoCabecera.siguienteNodo;

                        }
                        //cadenaMusical.nodoCabecera=cadenaMusical.nodoCabecera.siguienteNodo;
                    break;

                default:
                    System.out.println("El comando fue invalido, vuelva a intentarlo");
                    break;
            }
        }
    }

    public static Clip getSound(String file)
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sonidos" + System.getProperty("file.separator") + file).getAbsoluteFile());
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip sound = (Clip) AudioSystem.getLine(info);
            sound.open(audioInputStream);
            return sound;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public static void playSound(Clip clip)
    {
        clip.stop();
        clip.setFramePosition(0);
        clip.start();
    }
}