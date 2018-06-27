/*
 *La siguiente Clase node fue Desarrollada por Juan Jesus Pulido Sanchez
 */

import javax.swing.*;

public class main_gui extends JFrame{
    /**
     * Esta Clase main_gui fue generada por el editor gráfico de IntellijIdea, los metodos son en gran parte getters
     * para realizar un control y manejo de los mismos en la clase mainFrameController
     *
    **/

    private JPanel mainPanel;
    private JList posiblesColores;
    private JList coloresSeleccionados;
    private JTextField maximoValor;
    private JTextField minimoValor;
    private JTextField valorPPM;
    private JTextField valorTolerancia;
    private JTextField valorResistor;
    private JButton agregarColor;
    private JLabel Label1;
    private JTextField tamanoResistencia;
    private JButton removerColor;
    private JLabel valorResResistenci;
    private JLabel valorResTolelarancia;
    private JLabel aux1;
    private JLabel aux2;
    private JLabel aux0;
    private JLabel valorPPMLabel;
    private JLabel aux3;
    private JLabel LabelCalcColores;
    private JLabel aux4;
    private JLabel aux5;
    private JLabel aux6;
    private JLabel aux7;
    private JLabel aux8;
    private JTextField indiceRemover;
    private JTextField calcValResis;
    private JButton botonCalcColores;
    private JTextField resCalcColores;
    private JLabel aux9;
    private JLabel aux10;
    private JLabel aux11;
    private JLabel aux12;
    public static final int WIDTH= 1200;
    public static final int HEIGHT= 1200;



    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);

    }

    public main_gui(){
        setSize(WIDTH,HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);

    }

    public JTextField getValorPPM() {
        return valorPPM;
    }

    public JTextField getValorTolerancia() {
        return valorTolerancia;
    }

    public JTextField getValorResistor() {
        return valorResistor;
    }

    public JTextField getMaximoValor() {
        return maximoValor;
    }

    public JTextField getMinimoValor() {
        return minimoValor;
    }
    public JList getPosiblesColores() {
        return posiblesColores;
    }

    public JList getColoresSeleccionados() {
        return coloresSeleccionados;
    }

    public JButton getAgregarColor() {
        return agregarColor;
    }

    public JTextField getTamanoResistencia() {
        return tamanoResistencia;
    }

    public JButton getRemoverColor() {
        return removerColor;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JTextField getIndiceRemover() {
        return indiceRemover;
    }

    public JTextField getCalcValResis() {
        return calcValResis;
    }

    public JButton getBotonCalcColores() {
        return botonCalcColores;
    }

    public JTextField getResCalcColores() {
        return resCalcColores;
    }


}
