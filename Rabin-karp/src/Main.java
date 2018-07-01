import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

    static long bigPrime = 100000007;
    private static long listaH[];
    static long x=31;

    private static long PolyHash(String patron){
        /**
         * PolyHash Function (Polynomial Hashing)
         *
         * @param patron = String que se desea Aplicar Hashing
         *
         * @return El hash del string patron
         *
         */
        long hash = 0;
        for(int i = patron.length()-1; i>=0;i--) hash = ((hash*x)+((int)patron.charAt(i)))%bigPrime;
        return hash;
    }

    private static void PrecomputeHashes(String Texto, int lenPatron){
        /**
         * PrecomputeHashes Function (Hashes Tables from Texto)
         *
         * @param Texto = Texto en el que se buscara el patron
         * @param lenPatron = longitud del string que se utilizara como Patron
         *
         * @return Retorna vacio, pero la funcion rellena una tabla hash estatica declarada en la clase (listaH)
         *
         */
        listaH= new long[Texto.length()-lenPatron+1] ;
        String S = Texto.substring((Texto.length()-lenPatron),Texto.length());
        listaH[Texto.length()-lenPatron] = PolyHash(S);
        long y = 1;
        for(int i = 1 ; i<= lenPatron; i++)  y = (y*x)%bigPrime;
        for(int i = Texto.length()-lenPatron-1; i>=0;i--){
            listaH[i] = Math.floorMod(((listaH[i + 1]* x) + (int) Texto.charAt(i) + (-y * (int) Texto.charAt(i + lenPatron))),bigPrime);
        }

    }

    public static int RabinKarp(String Texto, String patron) {
        int ocurrencias = 0;

        long phash = PolyHash(patron);
        PrecomputeHashes(Texto,patron.length());
        for(int i =  0; i<=Texto.length()-patron.length();i++){
            if(listaH[i]!=phash) continue;
            if (Texto.substring(i,i+patron.length()).equals(patron)){
                ocurrencias++;
            }
        }
        return ocurrencias;
    }

    public static void main(String[] args) {

        BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
        try{
            BufferedReader br = new BufferedReader(new FileReader("Quijote.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            String quijote = sb.toString();

            br.close();

            int numpatrones =0;

            System.out.println("Ingrese el Numero de patrones que desea analizar: ");
            numpatrones = Integer.parseInt(brInput.readLine());
            for(int i = 0; i< numpatrones;i++){
                System.out.println("Ingrese un patron: ");
                String patron = brInput.readLine();

                // Diferencia en Segundos
                long start = System.currentTimeMillis();
                System.out.println("Las Ocurrencias de \""+ patron + "\" en el texto fueron: "+RabinKarp(quijote,patron)); //RABIN-KARP ALGORITHM
                long elapsedTimeMillis = System.currentTimeMillis()-start;
                float elapsedTimeSec = elapsedTimeMillis/1000F;
                System.out.println("La busqueda del Patron por medio del Algoritmo Rabin-Karp se demoro: "+ elapsedTimeSec+" segundos");
            }

        }catch (Exception e1){
            System.out.println("Algo ocurrio mal con el archivo");
        }

    }
}
