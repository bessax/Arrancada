/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Exceptions;

import net.sf.jasperreports.engine.JRException;

/**
 * Classe para tratar futuros erros na execução de relatórios com JasperReport
 * @author Bessa
 */
public class MyJRExceptions extends JRException {
    
   
    
    public MyJRExceptions(String string)
    {
        super(string);
    }
    

}
