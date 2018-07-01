public class DisjointSet {

    private int[] parent;
    private int[] rank;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
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

    public void setRank(int[] rank) {
        this.rank = rank;
    }

    public void makeSet(int index) {
        parent[index]=index;
        rank[index]=0;
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
            if (rank[id_i]>rank[id_j]){
                parent[id_j]= parent [id_i];
            }else{
                parent[id_i]= parent [id_j];
                if (rank[id_i]==rank[id_j]){
                    rank[id_j] = rank[id_j]+1;
                }
            }
        }
    }

}