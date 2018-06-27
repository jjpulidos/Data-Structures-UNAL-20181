package resistencias;

/**
 *
 * @author MAURICIO MEZA B
 */
public class Cadena {
    protected nodoCadena primerNodo;
    protected int size;
    
    public Cadena(int size) {
        this.size = 0;
    }

    public Cadena() {
        this(0);
    }
    
    public void addCadena(int index, Color color){
        if(index == 0){
            primerNodo = new nodoCadena(color, primerNodo);
        }else if(index <= 6){
            nodoCadena n = primerNodo;
            for(int i=0; i<index-1; i++){
                n = n.next;
            }
            n.next = new nodoCadena(color, n.next);
        }else{
            System.out.print("Posicion Invalida para agregar");
        }
        size++;
    }
    
    public void removeCadena(int index){
        if(index == 0){
            primerNodo = primerNodo.next;
        }else if(index > 0 && index <= 6){
            nodoCadena n = primerNodo;
            for(int i=0; i<index-1; i++){
                n = n.next;
            }
            n.next = n.next.next;
        }else{
            System.out.print("Posicion Invalida para eliminar");
        }
        size--;
    }
    
    public Color getColor(int index){
       if(index >= 0 && index <= size){
           nodoCadena n = primerNodo;
           for(int i=0; i<index; i++){
               n = n.next;
           }
           return n.color;
       }        
        return null;
    }
    
    public int calculo(){
        if(size == 4){
            int n1 = primerNodo.color.getValor();
            int n2 = primerNodo.next.color.getValor();
            int n3 = primerNodo.next.next.color.getMultiplicador();
            
            int result  = (n1 + (n2*10)) * n3;
            return result;
        }else if(size == 5 || size == 6){
            int n1 = primerNodo.color.getValor();
            int n2 = primerNodo.next.color.getValor();
            int n3 = primerNodo.next.next.color.getValor();
            int n4 = primerNodo.next.next.next.color.getMultiplicador();
            
            int result  = (n1 + (n2*10) + (n3*100)) * n4;
            return result;
        }       
        return 0;
    }
    
}
