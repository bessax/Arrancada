/*
 * ConexaoDAO.java
 * 
 * Criado em 22/08/2007, 01:03:48
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *Classe criada exclusivamente para realizar a conexão com uma fonte de dados JDBC
 *Data da última alteração: 5/01/2008 
 * @author Bessa
 */
public class ConexaoDAO {
    
     Connection con;      
     Statement operacao;
    

public void criaConexao()
{
try{
String url = "jdbc:postgresql://localhost:5432/arrancada";
String usuario = "postgres";
String senha = "654321";
Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(url,usuario,senha); 
operacao = con.createStatement();


} catch(Exception ex)
{
    JOptionPane.showMessageDialog(null,"Erro de Conexão - (Exception:"+ex.getMessage()+")","Mensagem do Programa",JOptionPane.ERROR_MESSAGE);

}


}   
    
    
    

}
