import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            HashMap<Integer,String> hm=new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                String oper = st2.nextToken();
                int number = Integer.parseInt(st2.nextToken());
                if (oper.equals("add")){
                    String name = st2.nextToken();
                    hm.put(number,name);
                }else if(oper.equals("find")){
                    if (hm.get(number)==null){
                        System.out.println("not found");
                    }else{
                        System.out.println(hm.get(number));
                    }
                }else if(oper.equals("del")){
                    try{
                        hm.remove(number);
                    }catch (Exception e1){
                    }
                }
            }
        }
    }
