package resistencias;

public class Color {
    protected String nombre;
    protected int valor;
    protected int multiplicador;
    protected int ppm;
    protected int tolerancia;

    public Color(String nombre, int valor, int multiplicador, int ppm, int tolerancia) {
        this.nombre = nombre;
        this.valor = valor;
        this.multiplicador = multiplicador;
        this.ppm = ppm;
        this.tolerancia = tolerancia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public int getPpm() {
        return ppm;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }
    
    
}
