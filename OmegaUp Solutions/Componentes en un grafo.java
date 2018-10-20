
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class DisjointSet {

    private int[] parent;
    private int[] rank;
    public int[] vertex;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        vertex = new int[size];
        for (int i = 0; i<size;i++){
            this.makeSet(i);
        }

    }

    public int[] getParent() {
        return parent;
    }

    public void setParent(int[] parent) {
        this.parent = parent;
    }

    public int[] getRank() {
        return rank;
    }
    public int[] getVertex() {
        return vertex;
    }
    public void setRank(int[] rank) {
        this.rank = rank;
    }

    public void makeSet(int index) {
        parent[index]=index;
        rank[index]=0;
        vertex[index]=1;
    }

    public int find(int index) {
        while (parent[index]!=index){
            index = parent[index];
        }
        return index;
    }

    public int findWithPathCompression(int index) {
        if (index != parent[index]){
            parent[index] = this.find(index);
        }
        return parent[index];
    }

    public void union(int i, int j) {
        int id_i = this.find(i);
        int id_j = this.find(j);
        if (id_i != id_j){
                parent[id_j]= parent [id_i];
                int temp = vertex[id_i];
                vertex[id_i]+=vertex[id_j];
            }
        }
    }
public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            DisjointSet DS = new DisjointSet((2*n));
            while (n-- > 0) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                DS.union(a-1,b-1);
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i<(DS.vertex.length);i++){
                int padre = DS.find(i);
                int rango = DS.vertex[padre];
                if(rango>1&&rango<min){
                    min = rango;
                }
                if (rango>1&&rango >max){
                    max = rango;
                }
            }
            System.out.println(min+" "+max);
        }
    }

