/*
 * ConexaoDAO.java
 * 
 * Criado em 22/08/2007, 01:03:48
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Extra;

import arrancada.Exceptions.MyException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *Classe que define a conexão com o banco de dados
 * Última modificação em 30/12/2007
 * @author Bessa
 */
public class ConexaoDAOcommyException {
    
    // Visibilidade Default protect
      Connection con;      
      Statement operacao;
    
    private String url = "jdbc:postgresql://localhost:5432/arrancada";
    private String usuario = "postgres";
    private String senha = "654321";

// Definindo Setters e Getters
public void setUrl(String url)
{
   this.url =url; 
}

public void setUser(String user)
{
   this.usuario =user; 
}

public void setPassWord(String senha)
{
   this.senha =senha; 
}

public String getUser()
{
    return this.usuario;
}

public String getUrl()
{
    return this.url;
}

public String getPassWord()
{
    return this.senha;
}

public void criaConexao() throws MyException
{
try{

Class.forName("org.postgresql.Driver");
con = DriverManager.getConnection(url,usuario,senha); 
operacao = con.createStatement();

//JOptionPane.showMessageDialog(null,"Conexão estabelecida","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
//System.out.println("Conexão Estabelecida com sucesso");


} catch(Exception e)
{
   // JOptionPane.showMessageDialog(null,"Falha ao conectar com o Banco","Mensagem do Programa",JOptionPane.ERROR_MESSAGE);
  //System.out.println("Erro de Conexão tente novamente");
     throw new MyException("Exceção :"+ e.getMessage());
}


}   
    
    
    

}
