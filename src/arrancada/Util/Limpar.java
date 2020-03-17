/*
 * limpar.java
 * 
 * Created on 09/09/2007, 23:02:13
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Util;

/**
 *
 * @author Vitor
 */
public class Limpar {

    public Limpar() {
    }

    /* Metodo feito para limpar qualquer componente jTextField.
     *   Metodo recebe o componente a ser limpo
     */
    public void limpajTextField(javax.swing.JTextField jTextField)
    {
        jTextField.setText("");        
    }
    
    public void limpajComboBox(javax.swing.JComboBox jComboBox)
    {
        //jComboBox.setModel(jComboBox.getModel());
        jComboBox.removeAllItems();
    }
    
    public javax.swing.JTextField focus(javax.swing.JTextField jTextField)
    {        
        return jTextField;
    }
}
