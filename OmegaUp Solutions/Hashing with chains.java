import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static long bigPrime = 1000000007;
    private static LinkedList<String> listaH[];
    static long x=263;

    private static long PolyHash(String patron, int modulo){
        /**
         * PolyHash Function (Polynomial Hashing)
         *
         * @param patron = String que se desea Aplicar Hashing
         *
         * @return El hash del string patron
         *
         */
        long hash = 0;
        for(int i = patron.length()-1; i>=0;i--) hash = Math.floorMod((hash*x)+((int)patron.charAt(i)),bigPrime);
        return Math.floorMod(hash,modulo);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int modulo = Integer.parseInt(st.nextToken());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st3.nextToken());

        listaH = new LinkedList[modulo];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String oper = st2.nextToken();
            if (oper.equals("add")){
                String name = st2.nextToken();
                int hash = (int)PolyHash(name,modulo);
                if(listaH[hash]!=null){
                    if(!listaH[hash].contains(name)){
                        listaH[hash].push(name);
                    }
                }else{
                    listaH[hash] = new LinkedList<>();
                    listaH[hash].push(name);
                }

            }else if(oper.equals("del")){
                String name = st2.nextToken();
                int hash = (int)PolyHash(name,modulo);
                if(listaH[hash]!=null){
                    if (listaH[hash].contains(name)) listaH[hash].remove(name);
                }
            }else if(oper.equals("find")){
                String name = st2.nextToken();
                int hash = (int)PolyHash(name,modulo);
                if(listaH[hash]!=null){
                    if (listaH[hash].contains(name)) {
                        System.out.println("yes");
                    }else{
                        System.out.println("no");
                    }
                }else{
                    System.out.println("no");
                }

            }else if(oper.equals("check")){
                int n1 = Integer.parseInt(st2.nextToken());
                if(listaH[n1]!=null){
                    for(String temp : listaH[n1]){
                        if(PolyHash(temp,modulo)==n1){
                            System.out.print(temp+" ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
