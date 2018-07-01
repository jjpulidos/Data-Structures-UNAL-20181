public class MaxHeap {

    private int[] array;
    private int size;

    public MaxHeap() {
        this.array = new int[2];
        this.size = 0;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int Parent(int i){
        return (i/2);
    }

    public int LeftChild(int i){
        return 2*i;
    }

    public int RightChild(int i){
        return (2*i)+1;
    }

    public void SiftDown(int i){
        int maxIndex = i;
        int temp = this.LeftChild(i);
        if(temp<=getSize()-1 && array[temp]>array[maxIndex]){
            maxIndex = temp;
        }
        int temp2 =this.RightChild(i);
        if(temp2<=getSize()-1 && array[temp2]>array[maxIndex]){
            maxIndex = temp2;
        }
        if(i!= maxIndex){
            int t = array[i];
            array[i] = array [maxIndex];
            array[maxIndex]= t;
            this.SiftDown(maxIndex);
        }
    }
    public void SiftUp(int i){
        while(i > 1 && array[this.Parent(i)]<array[i]){
            int t = array[i];
            array[i] = array[this.Parent(i)];
            array[this.Parent(i)]= t;
            i= this.Parent(i);
        }
    }
    public void buildHeap(int[] array) {
        this.array = array;
        setSize(array.length);
        for(int i = (int)Math.floor(getSize()/2);i>0;i--){
            this.SiftDown(i);
        }
    }

    public void insert(int value) {
        if(array.length-1==getSize()){
            int[] nuevo = new int[(array.length)*2];
            for(int i = 0; i<array.length;i++){
                nuevo[i]=array[i];
            }
            this.array = nuevo;
            setSize(getSize()+1);
            int s = getSize();
            this.array[getSize()]=value;
            this.buildHeap(array);
            setSize(s);
        }else{
            setSize(getSize()+1);
            array[(getSize())]=value;
            this.SiftUp(getSize());
        }
    }

    public int extractMax() {
        int temp =array[1];
        array[1] = array[getSize()+1];
        setSize(getSize()-1);
        this.SiftDown(1);
        return temp;
    }

    public void sort(int[] array) {
        setSize(array.length);
        this.buildHeap(array);
        for(int k = 0;k<array.length-1;k++){
            int temp =array[1];
            array[1] = array[size-1];
            array[(size-1)]=temp;
            this.size--;
            this.SiftDown(1);
        }
    }
}