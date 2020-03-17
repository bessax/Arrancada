/*
 * FormPesquisa.java
 * 
 * Created on 13/09/2007, 23:47:41
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Util;

import arrancada.Formularios.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class FormPesquisa {

    public FormPesquisa() {
    }

    /* Metodo para abrir o FORM de pesquisa ao precionar "enter/botoa de pesquisa" 
     * ao selecionar a consulta desejada no jTable e precionar enter ira retornar
     * uma string contendo o conteudo(CAMPO CODIGO) 
     */
    public String pesquisa(String tabela)
    {
        String codigo = "";
        if(tabela.equals("Piloto"))
        {
            Piloto piloto = new Piloto(null, true);
            piloto.setVisible(true);
        }
        else if (tabela.equals("Veiculo"))
        {
            Veiculo veiculo = new Veiculo(null, true);
            veiculo.setVisible(true);
        }
        else if (tabela.equals("Competicao"))
        {
            Competicao competicao = new Competicao(null, true);
            competicao.setVisible(true);
        }
        else if (tabela.equals("Categoria"))
        {
            Categoria categoria = new Categoria(null, true);
            categoria.setVisible(true);
        }
        else if (tabela.equals("Competidor"))
        {
            Competidor competidor = new Competidor(null, true);
            competidor.setVisible(true);
        }
        return codigo;
    }
    
    /* Metodo para verificar se o campo foi preenchido corretamente
     */
    public javax.swing.JTextField valida(javax.swing.JTextField jTextField)
    {    
        if(jTextField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Atenção... Código não encontrado.");
            jTextField.requestFocus();            
        }
        else
        {
            jTextField.transferFocus();
        }
        return jTextField;
    }
}

