/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resistencias;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author MAURICIO MEZA B
 */
    
public class CustomListModel extends AbstractListModel {
    
    private ArrayList<Color> listaColores= new ArrayList<>();
    
    
        
    @Override
    public int getSize() {
        return listaColores.size();    
    }

    @Override
    public Object getElementAt(int index) {
        return listaColores.get(index);
    }
    
}
