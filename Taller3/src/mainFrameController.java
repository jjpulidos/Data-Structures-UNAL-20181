/*
 *La siguiente Clase node fue Desarrollada por Juan Jesus Pulido Sanchez
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
/*
INSTRUCCIONES:
Primero se toma el tamaño de las bandas de la resistencia
Segundo se selecciona el color de las bandas
Tercero se visualiza los colores arrojados


Cuarto se procede a escribir el valor en la text box de calcular segun valor en ohmios
Quinto se presiona calcular y se interpretan resultados

*/

public class mainFrameController {
    /**
     * Esta Clase mainFrameController fue creada con todos los mecanismos lógicos desarrollados para el Taller 3 de Estructuras de Datos
     * contiene metodos como:
     *
     * inizializacion de los componentes de la GUI
     * listeners que ayudan a la union de procesos con los botones de la GUI
     * Remover elementos de la lista en tiempo real segun el indice (lista circular)
     * Realizar los calculos de la resisitividad de los colores ingresados
     * Realizar calculod e colores a partir de un valor ingresado
     * realizar un mapa auxiliar para invertir la funcion de los hashmap que nos retornan los valores de los colores,
     * temperatura y tolerancia
     *
     *
     * los valores de los colores y tolerancias se extrajo de : https://www.allaboutcircuits.com/tools/resistor-color-code-calculator/
     *
     **/
    private main_gui maingui;
    public JList posiblesColores;
    private JList coloresSeleccionados;
    private JTextField valorPPM;
    private JTextField valorTolerancia;
    private JTextField valorResistor;
    private DefaultListModel listacambiante = new DefaultListModel();
    public JButton agregarColor;
    private JLabel Label1;
    static HashMap<String, Double> colores = new HashMap<>();
    static HashMap<String, Double> tolerancias = new HashMap<>();
    static HashMap<String, Double> ppm = new HashMap<>();
    private JTextField indiceRemover;
    public listaCircular cadenaColores = new listaCircular();
    public int listaCambianteSize = cadenaColores.getSize();
    public int indexlistaCambiante = 0;
    public JTextField tamanoResistencia;
    private JButton removerColor;
    private JTextField calcValResis;
    private JButton botonCalcColores;
    private JTextField resCalcColores;

    public mainFrameController() {
        initComponents();
        initListeners();
    }

    public void showMainFrameWindow() {
        maingui.setVisible(true);
    }

    private void initComponents() {
        maingui = new main_gui();
        posiblesColores = maingui.getPosiblesColores();
        coloresSeleccionados = maingui.getColoresSeleccionados();
        valorPPM = maingui.getValorPPM();
        valorResistor = maingui.getValorResistor();
        valorTolerancia = maingui.getValorTolerancia();
        agregarColor = maingui.getAgregarColor();
        tamanoResistencia = maingui.getTamanoResistencia();
        removerColor = maingui.getRemoverColor();
        indiceRemover = maingui.getIndiceRemover();
        calcValResis = maingui.getCalcValResis();
        botonCalcColores=maingui.getBotonCalcColores();
        resCalcColores=maingui.getResCalcColores();
        colores.put("NEGRO", 0.0);
        colores.put("MARRON", 1.0);
        colores.put("ROJO", 2.0);
        colores.put("NARANJA", 3.0);
        colores.put("AMARILLO", 4.0);
        colores.put("VERDE", 5.0);
        colores.put("AZUL", 6.0);
        colores.put("MORADO", 7.0);
        colores.put("GRIS", 8.0);
        colores.put("BLANCO", 9.0);
        colores.put("DORADO", 0.1);
        colores.put("PLATEADO", 0.01);
        tolerancias.put("MARRON", 1.0);
        tolerancias.put("ROJO", 2.0);
        tolerancias.put("NARANJA", 3.0);
        tolerancias.put("AMARILLO", 4.0);
        tolerancias.put("VERDE", 0.5);
        tolerancias.put("AZUL", 0.25);
        tolerancias.put("MORADO", 0.10);
        tolerancias.put("GRIS", 0.05);
        tolerancias.put("DORADO", 5.0);
        tolerancias.put("PLATEADO", 10.0);
        //TEMPERATURA
        ppm.put("MARRON", 100.0);
        ppm.put("ROJO", 50.0);
        ppm.put("NARANJA", 15.0);
        ppm.put("AMARILLO", 25.0);
        ppm.put("AZUL", 10.0);
        ppm.put("MORADO", 5.0);
        valorResistor.setText("N/A");
        valorTolerancia.setText("N/A");
        valorPPM.setText("N/A");


        System.out.println("se inizializaron componenetes");
    }

    private void initListeners() {
        agregarColor.addActionListener(new agregarColorListener());
        removerColor.addActionListener(new removerColorListener());
        botonCalcColores.addActionListener(new botonCalcColoresListener());

    }

    private class agregarColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cadenaColores.setSize(Integer.parseInt(tamanoResistencia.getText()));
                if (Integer.parseInt(tamanoResistencia.getText()) > 3 && Integer.parseInt(tamanoResistencia.getText()) < 7) {
                    if (indexlistaCambiante < Integer.parseInt(tamanoResistencia.getText())) {
                        String banda = posiblesColores.getSelectedValue().toString();
                        if ((banda.equals("NEGRO")) && indexlistaCambiante == 0) {
                            JDialog dialog = new JDialog();
                            JLabel label = new JLabel("Una banda negra no puede estar de primera");
                            dialog.setLocationRelativeTo(null);
                            dialog.setTitle("Error");
                            dialog.add(label);
                            dialog.pack();
                            dialog.setVisible(true);
                        } else if(((banda.equals("DORADO")&& indexlistaCambiante == 0 ||(banda.equals("DORADO")&&
                                indexlistaCambiante == 1) ||(banda.equals("PLATEADO")&& indexlistaCambiante == 0 ||
                                (banda.equals("PLATEADO")&& indexlistaCambiante == 1)))&&Integer.parseInt(tamanoResistencia.getText())==4) ||
                                (((banda.equals("DORADO")&& indexlistaCambiante == 0 ||(banda.equals("DORADO")&& indexlistaCambiante == 1) ||
                                        (banda.equals("DORADO")&& indexlistaCambiante == 2)||(banda.equals("PLATEADO")&& indexlistaCambiante == 0 ||
                                (banda.equals("PLATEADO")&& indexlistaCambiante == 1)||(banda.equals("PLATEADO")&& indexlistaCambiante == 2)))&&
                                        ((Integer.parseInt(tamanoResistencia.getText())==5) ||(Integer.parseInt(tamanoResistencia.getText())==6) )))) {
                            JDialog dialog = new JDialog();
                            JLabel label = new JLabel("Banda Invalida");
                            dialog.setLocationRelativeTo(null);
                            dialog.setTitle("Error");
                            dialog.add(label);
                            dialog.pack();
                            dialog.setVisible(true);
                        }else{
                                System.out.println("banda de color " + banda + " indice " + indexlistaCambiante);
                                cadenaColores.agregarTodo(banda, indexlistaCambiante);
                                node nodoPrueba = cadenaColores.nodoCabecera;
                                for (int i = 0; i < indexlistaCambiante; i++) {
                                    nodoPrueba = nodoPrueba.siguienteNodo;
                                }
                                listacambiante.addElement(nodoPrueba.elemento);
                                indexlistaCambiante++;
                                coloresSeleccionados.setModel(listacambiante);

                                if (listacambiante.size() <= Integer.parseInt(tamanoResistencia.getText())&&listacambiante.size()>3) {
                                    try {
                                        if (Integer.parseInt(tamanoResistencia.getText()) == 4) {
                                            valorResistor.setText("" + String.format("%.3f",
                                                    bandas3(colores.get(cadenaColores.nodoCabecera.elemento),
                                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento))));
                                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                                            valorPPM.setText("N/A");
                                        } else {
                                            valorResistor.setText("" + String.format("%.3f",
                                                    bandas4(colores.get(cadenaColores.nodoCabecera.elemento),
                                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento),
                                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento))));
                                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                                            valorPPM.setText(ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) != null ?
                                                    "" + ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) : "N/A");
                                        }

                                    } catch (Exception e1) {
                                        System.out.println("nel");
                                    }

                                }

                        }

                        System.out.println(listacambiante.toString());
                    } else {
                        //pop up diciendo que no se puede agregar si no esta en los rangos establecidos
                        JDialog dialog = new JDialog();
                        JLabel label = new JLabel("No se puede Agregar Colores si el numero de bandas es mayor al establecido 1.0");
                        dialog.setLocationRelativeTo(null);
                        dialog.setTitle("Error");
                        dialog.add(label);
                        dialog.pack();
                        dialog.setVisible(true);
                    }

                } else {
                    JDialog dialog = new JDialog();
                    JLabel label = new JLabel("No se puede Agregar Colores si el numero de bandas mayor a 6 o menor a 3 1.1");
                    dialog.setLocationRelativeTo(null);
                    dialog.setTitle("Error");
                    dialog.add(label);
                    dialog.pack();
                    dialog.setVisible(true);
                }

            } catch (NumberFormatException e1) {
                JDialog dialog = new JDialog();
                JLabel label = new JLabel("No se reconoce el valor 1.2");
                dialog.setLocationRelativeTo(null);
                dialog.setTitle("Error");
                dialog.add(label);
                dialog.pack();
                dialog.setVisible(true);
            }

        }
    }

    public static double bandas3(double banda1, double banda2, double multiplicador) throws Exception {
        if (banda1 == 0.0) {
            throw new Exception("La banda uno no puede ser negra");
        }

        if(banda1 ==0.1||banda1 ==0.01||banda2==0.1||banda2 ==0.01){
            throw new Exception("Las primeras 2 o 3 bandas no pueden tener valor de tolerancia");
        }

        if (multiplicador > 1) {
            return (banda1 * Math.pow(10.0, multiplicador + 1) + banda2 * Math.pow(10.0, multiplicador));
        } else if (multiplicador == 0.1) {
            return (banda1 + banda2 / 10);
        } else if (multiplicador == 0.01) {
            return (banda1 / 10 + (banda2 / 100));
        } else {
            return (banda1 * Math.pow(10.0, multiplicador + 1) + banda2 * Math.pow(10.0, multiplicador));
        }
    }

    public static double bandas4(double banda1, double banda2, double banda3, double multiplicador)throws  Exception {
        if(banda1 ==0.1||banda1 ==0.01||banda2==0.1||banda2 ==0.01|| banda3 == 0.1 || banda3 ==0.01){
            throw new Exception("Las primeras 2 o 3 bandas no pueden tener valor de tolerancia");
        }

        if (multiplicador > 1) {
            return (banda1 * Math.pow(10.0, multiplicador + 2) + banda2 * Math.pow(10.0, multiplicador + 1) + banda3 * Math.pow(10.0, multiplicador));
        } else if (multiplicador == 0.1) {
            return (banda1 * 10 + banda2 + banda3 / 10);
        } else if (multiplicador == 0.01) {
            return (banda1 + (banda2 / 10) + (banda3 / 100));
        } else {
            return (banda1 * Math.pow(10.0, multiplicador + 2) + banda2 * Math.pow(10.0, multiplicador + 1) + banda3 * Math.pow(10.0, multiplicador));
        }
    }

    public static String color(double valorSN) throws Exception {
        String valor = (new BigDecimal(Double.toString(valorSN))).toPlainString();
        int firstDigit=-1;
        try{
            firstDigit = Integer.parseInt(valor.substring(0, 1));

        }catch(Exception e1){
            firstDigit=-1;
        }
        String dig1String = valor.substring(0, 1);
        String dig1StringOu = getKeyFromValue(colores, (double) firstDigit);

        int secondDigit=-1;
        try{
            secondDigit = Integer.parseInt(valor.substring(1, 2));

        }catch(Exception e1){
            secondDigit=-1;
        }
        String dig2String = valor.substring(1,2);
        String dig2StringOu = getKeyFromValue(colores, (double) secondDigit);


        int thirdDigit=-1;
        try{
            thirdDigit = Integer.parseInt(valor.substring(2, 3));

        }catch(Exception e1){
            thirdDigit=-1;
        }
        String dig3String = valor.substring(2,3);
        String dig3StringOu = getKeyFromValue(colores, (double) thirdDigit);

        int fourthDigit=-1;
        try{
            fourthDigit = Integer.parseInt(valor.substring(3, 4));

        }catch(Exception e1){
            fourthDigit=-1;
        }
        String dig4String = valor.substring(3,4);
        String dig4StringOu = getKeyFromValue(colores, (double) fourthDigit);


        int fifthDigit=-1;
        try{
            fifthDigit = Integer.parseInt(valor.substring(4, 5));

        }catch(Exception e1){
            fifthDigit=-1;
        }

        String dig5String = valor.substring(4,5);
        String dig5StringOu = getKeyFromValue(colores, (double) fifthDigit);


        if (dig1String.equals("0")){
            // el divisor es 100 a juro
            return dig3StringOu + " " + dig4StringOu+ " PLATEADO";
        }else if (!dig1String.equals("0")&& dig2String.equals(".")&&!dig3String.equals(".")&&dig4String.equals("0")&&dig5String.equals("0")){
            // el divisor es 10 a juro
            return dig1StringOu +" "+ dig3StringOu + " DORADO";
        }else if(!dig1String.equals("0")&& dig2String.equals(".")&&!dig3String.equals(".")&&!dig4String.equals(".")&&dig5String.equals("0")) {
            return dig1StringOu +" "+ dig3StringOu + " "+dig4StringOu+ " PLATEADO";
        }else if (!dig1String.equals("0")&&!dig2String.equals(".")&&dig3String.equals(".")&&dig4String.equals("0")&&dig5String.equals("0")){
            return dig1StringOu + " "+ dig2StringOu + " "+ "NEGRO";
        }else if(!dig1String.equals("0")&&!dig2String.equals(".")&&!dig3String.equals(".")&&dig4String.equals(".")&&dig5String.equals("0")){
            return dig1StringOu + " "+ dig2StringOu + " "+dig3StringOu+ " NEGRO";
        }else if(!dig1String.equals("0")&&!dig2String.equals(".")&&dig3String.equals("0")&&dig4String.equals("0")){
            int temp;
            try{
                temp = valor.substring(2, valor.indexOf('.')).length();
            }catch(Exception e1){
                temp = valor.substring(2, valor.length()).length();
            }
            String tempStr = getKeyFromValue(colores, (double) temp);
            return dig1StringOu + " " + dig2StringOu + " " +tempStr;
        }else{
            int temp;
            try{
                temp = valor.substring(3, valor.indexOf('.')).length();
            }catch(Exception e1){
                temp = valor.substring(3, valor.length()).length();
            }
            String tempStr = getKeyFromValue(colores, (double) temp);
            return dig1StringOu + " " + dig2StringOu + " "+ dig3StringOu+ " " +tempStr;
        }

    }

    public static String getKeyFromValue(Map<String, Double> hm, double value) {
        Map<Double, String> myNewHashMap = new HashMap<>();
        for (Map.Entry<String, Double> entry : colores.entrySet()) {
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }
        return myNewHashMap.get(value);
    }

    private class removerColorListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("REMOVER");
            System.out.println(Integer.parseInt(indiceRemover.getText()));

            if(indexlistaCambiante>4){
                cadenaColores.remover(Integer.parseInt(indiceRemover.getText()) - 1);
                listacambiante.remove(Integer.parseInt(indiceRemover.getText()) - 1);
                indexlistaCambiante--;
                coloresSeleccionados.setModel(listacambiante);
                if (listacambiante.size() <= Integer.parseInt(tamanoResistencia.getText())&&listacambiante.size()>3) {
                    try {
                        if (Integer.parseInt(tamanoResistencia.getText()) == 4) {
                            valorResistor.setText("" + String.format("%.3f",
                                    bandas3(colores.get(cadenaColores.nodoCabecera.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento))));
                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                            valorPPM.setText("N/A");
                        }


                        if(Integer.parseInt(tamanoResistencia.getText()) == 5){
                            valorResistor.setText("" + String.format("%.3f",
                                    bandas4(colores.get(cadenaColores.nodoCabecera.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento))));
                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                            valorPPM.setText(ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) != null ?
                                    "" + ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) : "N/A");
                        }
                        if(Integer.parseInt(tamanoResistencia.getText()) == 6){
                            valorResistor.setText("" + String.format("%.3f",
                                    bandas4(colores.get(cadenaColores.nodoCabecera.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento))));
                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                            valorPPM.setText(ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) != null ?
                                    "" + ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) : "N/A");
                        }


                    } catch (NumberFormatException e1) {
                        System.out.println("el indice es inválido");
                    } catch (IndexOutOfBoundsException e2) {
                        JDialog dialog = new JDialog();
                        JLabel label = new JLabel("el indice es mayor al numero de bandas del resistor, o el indice es negativo 1.3");
                        dialog.setLocationRelativeTo(null);
                        dialog.setTitle("Error");
                        dialog.add(label);
                        dialog.pack();
                        dialog.setVisible(true);
                    } catch (Exception e3) {
                        System.out.println("Error inesperado a ocurrido");
                    }

                } else {
                    try {
                        if (Integer.parseInt(tamanoResistencia.getText()) == 4) {
                            valorResistor.setText("" + String.format("%.3f",
                                    bandas3(colores.get(cadenaColores.nodoCabecera.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento))));
                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                            valorPPM.setText("N/A");
                        } else if (Integer.parseInt(tamanoResistencia.getText()) == 5) {
                            valorResistor.setText("" + String.format("%.3f",
                                    bandas4(colores.get(cadenaColores.nodoCabecera.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento))));
                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                            valorPPM.setText(ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) != null ?
                                    "" + ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) : "N/A");
                        }

                        if (Integer.parseInt(tamanoResistencia.getText()) == 6) {
                            valorResistor.setText("" + String.format("%.3f",
                                    bandas4(colores.get(cadenaColores.nodoCabecera.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.elemento),
                                            colores.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.elemento))));
                            valorTolerancia.setText("" + tolerancias.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento));
                            valorPPM.setText(ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) != null ?
                                    "" + ppm.get(cadenaColores.nodoCabecera.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.siguienteNodo.elemento) : "N/A");
                        } else {
                            valorResistor.setText("N/A");
                            valorTolerancia.setText("N/A");
                            valorPPM.setText("N/A");
                        }
                    } catch (Exception e1) {
                        System.out.println("Error en e1 con 6");
                    }

                }
            }


        }
    }

    private class botonCalcColoresListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                resCalcColores.setText(color(Double.parseDouble(calcValResis.getText())));
            }catch(Exception e1){
                JDialog dialog = new JDialog();
                JLabel label = new JLabel("Ha ocurrido un error con los calculos de los colores");
                dialog.setLocationRelativeTo(null);
                dialog.setTitle("Error");
                dialog.add(label);
                dialog.pack();
                dialog.setVisible(true);

            }


        }
    }
}