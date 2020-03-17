/*
 * ValidarCodigoCategoria.java
 * 
 * Created on 20/09/2007, 23:46:43
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Util;

import arrancada.Dao.ServicoBDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author xp
 */
public class ValidarCodigoCategoria extends InputVerifier{

    public ValidarCodigoCategoria(JTextField aux)
    {
        nome = aux;
    }
    
    public boolean verify(JComponent input) {
        try {
            JTextField tf = (JTextField) input;
            String zeros = "0000" + tf.getText().trim();
            tf.setText(zeros.substring(zeros.length() - 4));
            int codformatado = Integer.parseInt(tf.getText().trim());
            ResultSet rs = servico.selectCategoria(Integer.toString(codformatado), "1");
            if ((rs.next() == false) || (rs == null)) 
            {
                tf.setEnabled(true);
                rs.close();
                JOptionPane.showMessageDialog(null,"Código não Cadastrado","Atenção",JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            else
            {
                nome.setText(rs.getString(2));
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ValidarCodigoCategoria.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        JTextField nome;
        ServicoBDAO servico = new ServicoBDAO();
        
        //new ValidarCodigoCategoria(jTextFieldNome)
}

