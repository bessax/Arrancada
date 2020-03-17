/*
 * TeclaPress.java
 * 
 * Created on 09/09/2007, 22:38:21
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Util;

import java.awt.event.KeyEvent;
/**
 *Data da Última alteraçao 01/02/2008 - Bessa
 * @author Vitor
 */
public class TeclaPress {

    public TeclaPress() {
    }

private String stringKeyPress = "Pesquisando por Código";    
public String KeyCategoriaPiloto(java.awt.event.KeyEvent evt)
{
    // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_F2)
    {
       stringKeyPress = "Pesquisando por Código";      
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F3)
    {
        stringKeyPress = "Pesquisando por Nome";
    }
    return (stringKeyPress);
}

public String KeyPiloto(java.awt.event.KeyEvent evt)
{
    
    // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_F2)
    {
       stringKeyPress = "Pesquisando por Código";      
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F3)
    {
        stringKeyPress = "Pesquisando por Nome";
    }
     else if (evt.getKeyCode() == KeyEvent.VK_F4)
    {
        stringKeyPress = "Pesquisando por UF";
    }  
     else if (evt.getKeyCode() == KeyEvent.VK_F5)
    {
        stringKeyPress = "Pesquisando por Cidade";
    }  
    return (stringKeyPress);
}
 

public String KeyCompeticao(java.awt.event.KeyEvent evt)
{
    
    // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_F2)
    {
       stringKeyPress = "Pesquisando por Código";       
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F3)
    {
        stringKeyPress = "Pesquisando por Nome";
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F4)
    {
        stringKeyPress = "Pesquisando por Data";
    }
    return (stringKeyPress);
}


public String KeyVeiculo(java.awt.event.KeyEvent evt)
{
    
    // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_F2)
    {
       stringKeyPress = "Pesquisando por Código";       
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F3)
    {
        stringKeyPress = "Pesquisando por Nome";
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F4)
    {
        stringKeyPress = "Pesquisando por Tipo Veículo";
    }
    return (stringKeyPress);
}

public String KeyCompetidor(java.awt.event.KeyEvent evt)
{    
    // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_F2)
    {
       stringKeyPress = "Pesquisando por Código";       
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F3)
    {
        stringKeyPress = "Pesquisando por Competição";
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F4)
    {
        stringKeyPress = "Pesquisando por Categoria";
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F5)
    {
        stringKeyPress = "Pesquisando por Piloto";
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F6)
    {
        stringKeyPress = "Pesquisando por Veículo";
    }
    return (stringKeyPress);
}

public String KeyPuxada(java.awt.event.KeyEvent evt)
{    
    // TODO add your handling code here:
    if (evt.getKeyCode() == KeyEvent.VK_F2)
    {
       stringKeyPress = "Pesquisando por Código";       
    }
    else if (evt.getKeyCode() == KeyEvent.VK_F3)
    {
        stringKeyPress = "Pesquisando por Competição";
    }
      else if (evt.getKeyCode() == KeyEvent.VK_F4)
    {
        stringKeyPress = "Pesquisando por Categoria";
    }
      else if (evt.getKeyCode() == KeyEvent.VK_F5)
    {
        stringKeyPress = "Pesquisando por Competidor";
    }
       return (stringKeyPress);
}

}
