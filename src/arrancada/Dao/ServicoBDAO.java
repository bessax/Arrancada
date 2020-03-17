/*
 * ServicoBDAO.java
 * 
 * Criado em 31/08/2007, 00:27:30
 * Última alteração  em 09/09/2007, 07:56:40
 * 
 */

package arrancada.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Classe criada para executar os métodos de interação com o banco de dados.
 * Data da última alteração: 01/02/2008
 * @author Bessa
 */
public class ServicoBDAO {
    
    public ServicoBDAO()
	{ 
        /* Constructor da classe ServicoBDAO*/
        } 
    
  /* 
   * 
   * Campos com as proprieddades das tabelas do banco de Dados.
   * A Função aqui é melhorar a criação dos métodos de manipulação do banco 
   * referente a cada tabela.
   * 
   */
    
 
     
           ConexaoDAO conexaoBD = new ConexaoDAO();
           ResultSet rs;

     
    public String proximoCodigo(String tabela)     
    {
        String codigo = "1";
        try 
        {
            conexaoBD.criaConexao();
            String sql = "Select max(codigo) from " + tabela;
            rs = conexaoBD.operacao.executeQuery(sql);
            rs.next();
            if(rs.getString(1) == null)
            {
                return codigo;
            }
            else
            {
                return codigo =  String.valueOf(Integer.parseInt(rs.getString(1))+1);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
        return codigo;
    }
    
    public String proximaPuxada(String competicao, String categoria, String competidor)
    {
        String proxima = "1";
        try
        {
            conexaoBD.criaConexao();
            rs = conexaoBD.operacao.executeQuery("select GREATEST(max(puxada.puxada+1),1) " +
                      " from puxada " +
                      " where puxada.id_competicao = '" + competicao + "' and " +
                      " puxada.id_categoria = '" + categoria + "' and " +
                      " puxada.id_competidor = '" + competidor + "'");
            if(rs.next() != false)
            {
                proxima = rs.getString(1);
            }
            rs.close();
            return proxima;
        }
        catch (SQLException ex) 
        {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
            return proxima;
        }
    }
 
// Piloto
 /** 
  * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
  */
    public void insertPiloto(int codigo ,String nome,String uf,String cidade) 
{
        try 
        {
           // String de Insert
            String sql = "Insert into piloto values(" + codigo + ",\'" + nome + "\',\'" + uf + "\',\'" + cidade + "\')";

            int x = conexaoBD.operacao.executeUpdate(sql);
            if(x == 1)
            {
                JOptionPane.showMessageDialog(null,"Piloto cadastrado com Sucesso.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Piloto não foi Cadastrado.","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
}
    
    
/** 
* Método público que retorna um inteiro, para atualizações de dados na referida tabela no banco.   
*/
public int updatePiloto(int codigo ,String nome,String uf,String cidade) 
{
    int x = 0;
    try 
    {
        // String de Update
        String sql1 = "Update piloto set nome= '" + nome + "',"+
                                                      " uf = '" + uf + "',"+
                                                      " cidade ='" + cidade + "'" +
                                                      " where codigo = " + codigo;

        conexaoBD.criaConexao();

        x = conexaoBD.operacao.executeUpdate(sql1);
        conexaoBD.operacao.close();
        return x;
    } 
    catch (SQLException ex) 
    {
        Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return x;
}
   
        /** 
          * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
          */     
    public int deletePiloto(int codigo) 
    {
        int x = 0;
        try 
        {
            //String de Delete
            String sql =  "delete from piloto where codigo = " + codigo;

            conexaoBD.criaConexao();

            x = conexaoBD.operacao.executeUpdate(sql);
            
            conexaoBD.operacao.close();
            return x;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return x;
    }
       
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */
   public ResultSet selectPiloto(String valor, String tipo)
    {     
        try
        {
            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto order by codigo");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto where codigo = "+ valor +" order by codigo");
            }
            else if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto where (UPPER(Nome) LIKE '"+ valor.toUpperCase()+"%') order by Nome");
            }
            else if(tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto where (UPPER(uf) LIKE '"+ valor.toUpperCase()+ "%') order by uf");
            }
            else if(tipo.trim().equals("4"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto where (UPPER(cidade) LIKE '"+ valor.toUpperCase()+ "%') order by cidade");
            }
            return rs;
            
             
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      }
   
   
// Categoria
    /* *
     * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
     */  
   public void insertCategoria(String codigo ,String nome) 
{
        try 
        { 
            String sql = "Insert into categoria values('" + codigo + "','" + nome.toUpperCase() + "')";
            conexaoBD.criaConexao();
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                    JOptionPane.showMessageDialog(null, "Categoria cadastrada com Sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    conexaoBD.operacao.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Categoria não foi Cadastrada.", "Mensagem", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
}    
/**
 * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
 */
   public int updateCategoria(String codigo ,String nome) 
 {            
        try 
        {
            String sql = "Update categoria set nome= '" + nome.toUpperCase() + "' where codigo = '" + codigo + "'" ;

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                //JOptionPane.showMessageDialog(null, "Categoria Alterada com Sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                
                conexaoBD.operacao.close();
                return 1;
            } 
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
   }  
    /** 
     * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
     */
    public int deleteCategoria(String codigo ,String nome) 
    {
      try 
      {
            String sql =  "delete from categoria where codigo = '" + codigo + "'";

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            } 
       } 
      catch (SQLException ex) 
      {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
      }
      return 0;
}
   
/** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */
   public ResultSet selectCategoria(String valor, String tipo)
    {     
        try 
        {
            conexaoBD.criaConexao();

            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria order by codigo");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria where (Codigo LIKE '"+ valor +"') order by codigo");
            }
            else if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria where (UPPER(Nome) LIKE '"+valor.toUpperCase()+"%') order by Nome");
            }
             else if(tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria where codigo ="+ valor);
            }
            else if(tipo.trim().equals("4"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria where (UPPER(Nome) = '"+valor.toUpperCase()+"') order by Nome");
            }
            return rs;
          
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
   
   //Competição
    /** 
     * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
     */
   
  public void insertCompeticao(String codigo, String nome, String data, String uf, String cidade) 
{
    try {
            // String de Insert
            String sql = "Insert into competicao values('" + codigo + "','"+ nome.toUpperCase() +"',to_timestamp('"+ data +"','dd/mm/yyyy'),'"+ uf.toUpperCase() +"','"+ cidade.toUpperCase() +"')";
            conexaoBD.criaConexao(); 
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                JOptionPane.showMessageDialog(null, "Categoria cadastrada com Sucesso", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
} 
   /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
   public int updateCompeticao(String codigo, String nome, String data, String uf, String cidade) 
 {            
        try 
        {
            String sql = "update competicao set nome = '" + nome.toUpperCase() + "', data = to_timestamp('"+ data +"','dd/mm/yyyy'), uf = '" + uf.toUpperCase() + "', cidade = '" + cidade.toUpperCase() + "' where codigo = '" + codigo + "'" ;
            conexaoBD.criaConexao();
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            } 
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;           
   }    
   
   /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
    */
    public int deleteCompeticao(int codigo)
    {
      try {
            String sql =  "delete from competicao where codigo = " + codigo;
            conexaoBD.criaConexao();
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            } else {
                conexaoBD.operacao.close();
                return 0;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }   
                
        
    
    }
   
   
  public ResultSet selectCompeticao(String valor, String tipo){     
        try {

            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao order by codigo");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where (Codigo LIKE '"+ valor +"') order by codigo");
            }
            else if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where (UPPER(nome) LIKE '"+ valor.toUpperCase() +"%') order by nome");
            }
            else if(tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where date(data) = date(to_timestamp('"+ valor +"','dd/mm/yyyy'))");
            }
            // opção criada especialmente para selecionar o código e o nome da ultima competição cadatrada para a tela de puxada
            else if(tipo.trim().equals("4"))
            {
                rs = conexaoBD.operacao.executeQuery("select codigo, nome from competicao where data = (select max(competicao.data) from competicao)");
            }
              else if(tipo.trim().equals("5"))
            {
                rs = conexaoBD.operacao.executeQuery("select codigo, nome from competicao where codigo =" + valor.trim());
            }
            else if(tipo.trim().equals("6"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where (UPPER(nome) = '"+ valor.toUpperCase() +"') order by nome");
            }
            return rs;       
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}  
   
    /** 
     * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
     */
   public int insertVeiculo(String codigo, String nome, String tipo) 
{
       try {        
           // String de Insert
            String sql = "Insert into veiculo values("+ codigo +",'" + nome + "',"+ tipo +")";        
            conexaoBD.criaConexao(); 
            // o rs é usado para retornos de Querys do banco, porém este recebe um Statement
           int x = conexaoBD.operacao.executeUpdate(sql);
           if(x == 1)
           {
                conexaoBD.operacao.close();
                return 1;
           }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } 
    return 0;  
}
  
   /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
   public int updateVeiculo(String codigo, String nome, String tipo) 
 {            
        try 
        {
            // String de Update
            String sql = "Update veiculo set nome = '" + nome + "', tipo = '" + tipo + "' where codigo = '" + codigo +"'";
            conexaoBD.criaConexao();
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
   return 0;            
}  
  
   
    /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
    */
   public int deleteVeiculo(String codigo)
    {
      try {
            // String de Delete
            String sql =  "delete from veiculo where codigo = " + codigo;
            conexaoBD.criaConexao();
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }   
   return 0;
}
 
    public ResultSet selectVeiculo(String valor, String tipo)
    {   try {  
            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select veiculo.codigo,veiculo.nome,tipo_veiculo.tipo from veiculo,tipo_veiculo where veiculo.tipo = tipo_veiculo.codigo order by codigo");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo where Codigo = "+ valor);
            }
            else if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo where (UPPER(nome) LIKE '"+ valor.toUpperCase() +"%') order by nome");
            }
            else if(tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo where tipo = '" + valor + "' order by codigo"); 
            }
            else if (tipo.trim().equals("4"))
            {
                //consulta especial para alteração ou exclusão, para trazer 0 ou 1 no tipo do veículo, ao invés do nome
                rs = conexaoBD.operacao.executeQuery("Select veiculo.codigo,veiculo.nome,tipo_veiculo.tipo from veiculo,tipo_veiculo where tipo_veiculo.codigo = veiculo.tipo and veiculo.Codigo = "+ valor);
            }
            return rs;       
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}  
  
  
  // Competidor
  /** 
   * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
   */    
public int insertCompetidor(String codigo, String piloto, String veiculo, String competicao, String categoria, String placa) 
{
  try {
            // String de Insert
            String sql = "Insert into competidor values('" + codigo + "','"+ piloto +"','"+ veiculo +"','"+ competicao +"','" + categoria + "','" + placa.toUpperCase() + "')";
            conexaoBD.criaConexao(); 
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
  return 0;
}
  
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */
  public ResultSet selectCompetidor(String valor, String valor2, String valor3, String tipo)
    {     
        try {

            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome as categoria," +
                    " piloto.nome as piloto, veiculo.nome as veiculo, competidor.placa as placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    "inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    "inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    "inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    "order by Competicao.Nome, Categoria.nome, piloto.nome");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    " inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    " inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    " where (Competidor.Numero_Veiculo like '"+ valor +"%') " +
                    " order by Competidor.Numero_Veiculo, Competicao.Nome, Categoria.Nome, Piloto.Nome");
            }
            else if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    "inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    "inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    "inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    "where (competicao.nome like '" + valor.toUpperCase() +"%') " +
                    "order by Competicao.Nome, Categoria.Nome, Piloto.Nome, Competidor.Numero_Veiculo");
            }
            else if(tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    "inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    "inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    "inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    "where (categoria.nome like '" + valor.toUpperCase() +"%') " +
                    "order by Categoria.Nome, Competicao.Nome, Piloto.Nome, Competidor.Numero_Veiculo");
            }
            else if(tipo.trim().equals("4"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    "inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    "inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    "inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    "where (piloto.nome like '" + valor.toUpperCase() +"%') " +
                    "order by Piloto.Nome, Competicao.Nome, Categoria.Nome, Competidor.Numero_Veiculo");
            }
            else if(tipo.trim().equals("5"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    "inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    "inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    "inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    "where (veiculo.nome like '"+ valor.toUpperCase() +"%') " +
                    "order by Veiculo.Nome, Competicao.Nome, Categoria.Nome, Piloto.Nome, Competidor.Numero_Veiculo");
            }
            else if (tipo.trim().equals("6"))
            {
                //busca precisa pelo numero do veiculo, para verifica��o na hora de excluir um ve�culo
                //pois se ele estiver vinculado a um competidor, n�o podera ser exclu�do.
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo from competidor" +
                    " where (Competidor.id_veiculo like '"+ valor +"')");
            }
            else if (tipo.trim().equals("7"))
            {
                //busca criada especialmente para buscar o competidor para a tela de puxada
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    " inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    " inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    " where (Competidor.Numero_Veiculo like '"+ valor +"') " +
                    " order by Competidor.Numero_Veiculo, Competicao.Nome, Categoria.Nome, Piloto.Nome");
            }
            else if(tipo.trim().equals("8"))
            {
                //selecionar piloto para verificar se pode excluir ou n�o
                rs = conexaoBD.operacao.executeQuery("Select competidor.id_piloto from competidor " +
                    " where competidor.id_piloto = " + valor);
            }
            else if (tipo.trim().equals("9"))
            {
                //busca precisa pelo numero do veiculo
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    " inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    " inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    " where Competidor.Numero_Veiculo = "+ valor +
                    " and Competidor.id_categoria in (select c.codigo from categoria c where c.nome = '" + valor2 + "') " +
                    " and competidor.id_competicao in (select co.codigo from competicao co where co.nome = '" + valor3 + "') "+
                    " order by Competidor.Numero_Veiculo, Competicao.Nome, Categoria.Nome, Piloto.Nome");
            }
            else if(tipo.trim().equals("10"))
            {
                //selecionar competicao para verificar se pode excluir ou n�o)
                rs = conexaoBD.operacao.executeQuery("Select competidor.id_competicao from competidor " +
                    " where competidor.id_competicao = " + valor);
            }
               else if(tipo.trim().equals("11"))
            {
                //selecionar competicao para verificar se pode excluir ou n�o)
                rs = conexaoBD.operacao.executeQuery("select piloto.nome from piloto,competidor where piloto.codigo = competidor.id_piloto" +
                    " and competidor.numero_veiculo = " + valor);
            }
        return rs; 
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      } 
  
  /**
   *criado só para preencher os campos
   */
  public ResultSet selectCompetidorVeiculo(int codigoVeiculo)
   {
       
       try {

            conexaoBD.criaConexao();

            rs = conexaoBD.operacao.executeQuery("Select nome from veiculo where codigo = "+ codigoVeiculo);
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(null, "Veículo não encontrado na base de dados.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            } else { 
                return rs;
            }

          
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;      
       
       
   }
  
   /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
    */
   public int deleteCompetidor(String codigo, String categoria, String competicao)
    {
       try {
                String sql =  "delete from competidor " +
       " where Competidor.Numero_Veiculo = '" + codigo + "' " +
       " and Competidor.id_categoria in (select c.codigo from categoria c where c.nome = '" + categoria + "') " +
       " and competidor.id_competicao in (select co.codigo from competicao co where co.nome = '" + competicao + "')";
                conexaoBD.criaConexao();
                int x = conexaoBD.operacao.executeUpdate(sql);
                if (x == 1) 
                {
                    conexaoBD.operacao.close();
                    return 1;
                }
                else 
                {
                    return 0;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }   
    }
  
   /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
public int updateCompetidor(String numero_veiculo, String piloto, String veiculo, String competicao, String categoria, String placa) 
{
    try {
            String sql = "update competidor set placa = '" + placa.toUpperCase() + "',"+
                                                      " id_piloto = '" + piloto + "',"+
                                                      " id_veiculo = '" + veiculo + "',"+
                                                      " id_competicao = '" + competicao + "',"+
                                                      " id_categoria = '" + categoria + "'"+
                                                      " where numero_veiculo = '" + numero_veiculo +"'";
                                                      

            conexaoBD.criaConexao();
            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) 
            {
                conexaoBD.operacao.close();
                return 1;
            } 
            else 
            {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }       
}  
  
  // Puxada
     /** 
      * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
      */
public int insertPuxada(String codigo,String competicao, String categoria, String competidor, String tempo,String status,String numeroPuxada) 
{
    try 
    {
       // String de Insert
        String sql1 = "Insert into puxada values('" + codigo + "','" + competicao + "','" + categoria + "','" + competidor + "','" + tempo + "','" + status + "','" + numeroPuxada + "')";

        conexaoBD.criaConexao(); 
        int x = conexaoBD.operacao.executeUpdate(sql1);
        if(x == 1)
        {
           conexaoBD.operacao.close();
           return 1;
        }
        else
        {
            return 0;
        }
    } 
    catch (SQLException ex) 
    {
        Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
    } 
}
  
  
  /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
   public int updatePuxada(int codigo,int competidor ,int competicao,int categoria,String tempo,String status,int puxada) 
 {      
       int i =0;
        try {

           
            
            // String de Update
          String sql = "Update puxada set status = '" + status + "',"+
                                                      " id_competidor = " + competidor + ","+
                                                      " tempo = '" + tempo + "',"+
                                                      " puxada = " + puxada + ","+
                                                      " id_competicao = " + competicao + ","+
                                                      " id_categoria = " + categoria +
                                                      "where codigo = " + codigo;

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql);
            if (x == 1) {
                conexaoBD.operacao.close();
                 return i = 1;
            } else {
                
                return i = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
        return i ;       
   }   
  
  /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco, 
    * recebendo como parâmetros o código da puxada e o competidor cadastrado nela.   
    */
public int deletePuxada(int codigoPuxada )
    {
      try {

            

            // String de Delete
            String sql1 =  "delete from puxada where codigo = " + codigoPuxada; //+ " and competidor.codigo = " + competidor;
                    

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql1);
            if (x == 1) {
               
                conexaoBD.operacao.close();
                codigoPuxada = 0;
            } else {
                
                codigoPuxada = -1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
                
        return codigoPuxada;
    
    } 
  
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */   
  public ResultSet selectPuxada(String valor, String categoria, String competicao, String tipo)
   {
       
       try 
       {
            conexaoBD.criaConexao();           
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from puxada;");
            }
            else if(tipo.trim().equals("1"))
            {
                //selecionar todas puxadas
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome as competicao, categoria.nome as categoria, piloto.nome as competidor, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) order by puxada.codigo");
            }
            else if(tipo.trim().equals("2"))
            {
                //selecionar puxada espec�fica
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome, categoria.nome, piloto.nome, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                      " where (puxada.codigo = '" + valor + "')");
            }
            else if(tipo.trim().equals("3"))
            {
                //selecionar n�mero da pr�xima puxada do competidor(falta terminar)
                rs = conexaoBD.operacao.executeQuery("select GREATEST(max(puxada.puxada+1),1) " +
                      " from puxada " +
                      " where puxada.id_competicao = 3 and " +
                      " puxada.id_categoria = 3 and " +
                      " puxada.id_competidor = 3 ");
            }
            else if(tipo.trim().equals("4"))
            {
                //selecionar categoria para verificar se pode excluir ou n�o)
                rs = conexaoBD.operacao.executeQuery("Select puxada.id_categoria from puxada " +
                    " where puxada.id_categoria = " + valor);
            }
            else if(tipo.trim().equals("5"))
            {
                //selecionar competicao para verificar se pode excluir ou n�o)
                rs = conexaoBD.operacao.executeQuery("Select puxada.id_competicao from puxada " +
                    " where puxada.id_competicao = " + valor);
            }
            else if(tipo.trim().equals("6"))
            {
                //selecionar competicao para verificar se pode excluir ou n�o)
                rs = conexaoBD.operacao.executeQuery("Select puxada.id_competidor from puxada " +
                    " where puxada.id_competidor = " + valor + "" +
                    " and puxada.id_categoria = " + categoria + "" +
                    " and puxada.id_competicao = " + competicao + "");
            }
		else if(tipo.trim().equals("7"))
            {
                //selecionar puxada espec�fica
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome, categoria.nome, piloto.nome, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto)"+
                      " where puxada.id_competicao in (select competicao.codigo from competicao,puxada  where puxada.id_competicao = competicao.codigo and (UPPER(competicao.nome) LIKE '"+ valor.toUpperCase()+ "%'))");
            }
             else if(tipo.trim().equals("8"))
            {
                //selecionar puxada espec�fica para preencher o form
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo,puxada.id_competidor,puxada.id_categoria,puxada.id_competicao,competicao.nome,categoria.nome,piloto.nome,puxada.tempo," +
                      " puxada.status, puxada.puxada " +
                      "from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao)" +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria)" +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor)" +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                      " where puxada.codigo = "+ valor.trim());
            }
                 else if(tipo.trim().equals("9"))
            {
                //selecionar puxada espec�fica para preencher o form
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome, categoria.nome, piloto.nome, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto)"+
                      " where puxada.id_categoria = (select categoria.codigo from categoria where (UPPER(categoria.nome) LIKE '"+ valor.toUpperCase()+ "%'))");
            }
     else if(tipo.trim().equals("10"))
            {
                //selecionar puxada espec�fica para preencher o form
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome, categoria.nome, piloto.nome, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto)"+
                      " where puxada.id_competidor = (select competidor.numero_veiculo from competidor,piloto where competidor.id_piloto = piloto.codigo and (UPPER(piloto.nome) LIKE '"+ valor.toUpperCase()+ "%'))");
            }
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
   }  
   
   // Consultas para alterar relatório
   
   public ResultSet selectPiloto(String valor1,String valor2, String tipo)
    {     
        try
        {
            conexaoBD.criaConexao();
            if(tipo.trim().equals("5"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto where codigo BETWEEN '" +valor1 +"' and '"+valor2+"'");
            }
            
            return rs;
            
             
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      }
   
   public ResultSet selectCompetidor2(String valor,String valor2)
    {     
        try {

            conexaoBD.criaConexao();
           
               rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome as categoria," +
                    " piloto.nome as piloto, veiculo.nome as veiculo, competidor.placa as placa from competidor" +
                    " inner join competicao on (competicao.codigo = competidor.id_competicao)" +
                    "inner join veiculo on (veiculo.codigo = competidor.id_veiculo)" +
                    "inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                    "inner join categoria on (categoria.codigo = competidor.id_categoria) " +
                    "where numero_veiculo BETWEEN '"+valor+"' and '"+valor2+"'"+ 
                    "order by Competicao.Nome, Categoria.nome, piloto.nome");
            
                return rs;
           
         
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      } 
   
   public ResultSet selectCompeticao(String valor,String valor2,String valor3,String valor4,String tipo){     
        try {

            conexaoBD.criaConexao();
            if(tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where codigo BETWEEN '"+valor+"'and '"+valor2+"'");
            }
            else if (tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where date(data) BETWEEN to_timestamp('"+valor+"','dd/mm/yyyy')and to_timestamp('"+valor2+"','dd/mm/yyyy')");
            }
             else if (tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where codigo BETWEEN '"+valor+"'and '"+valor2+"'and date(data) BETWEEN to_timestamp('"+valor3+"','dd/mm/yyyy')and to_timestamp('"+valor4+"','dd/mm/yyyy')");
            }
            
            return rs;       
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}    
   
  public ResultSet selectVeiculo(String valor,String valor2,String tipo,String valor3,String valor4)
    {   try {  
            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select veiculo.codigo,veiculo.nome,tipo_veiculo.tipo from veiculo,tipo_veiculo where veiculo.codigo BETWEEN '"+valor+"' and '"+valor2+"' and veiculo.tipo = tipo_veiculo.codigo order by codigo");
            }
             if(tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select veiculo.codigo,veiculo.nome,tipo_veiculo.tipo from veiculo,tipo_veiculo where veiculo.tipo BETWEEN '"+valor+"' and '"+valor2+"' and veiculo.tipo = tipo_veiculo.codigo");
            }
              if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select veiculo.codigo,veiculo.nome,tipo_veiculo.tipo from veiculo,tipo_veiculo where veiculo.tipo BETWEEN '"+valor+"' and '"+valor2+"' and veiculo.codigo BETWEEN '"+valor3+"' and '"+valor4+"' and veiculo.tipo = tipo_veiculo.codigo  order by codigo");
            }
            return rs;       
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}    
  
  public ResultSet selectCategoria(String valor,String valor2,String tipo)
    {     
        try 
        {
            conexaoBD.criaConexao();

            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria order by codigo");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from categoria where categoria.codigo BETWEEN '"+ valor+"' and '"+ valor2+"'  order by codigo");
            }
          
          
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
}
  
  
  
   public ResultSet selectPuxada(String valor,String valor2,String competicao1,String competicao2,String data1,String data2,String categoria1,String categoria2, String tipo)
   {
       
       try 
       {
            conexaoBD.criaConexao();           
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from puxada;");
            }
            else if(tipo.trim().equals("1"))
            {
                //selecionar Código
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome as competicao, categoria.nome as categoria, piloto.nome as competidor, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto)"+
                      "where puxada.codigo BETWEEN '"+valor+"' and '"+valor2+"'");
            }
            else if(tipo.trim().equals("2"))
            {
                //selecionar Competição
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome as competicao, categoria.nome as categoria, piloto.nome as competidor, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                      "where puxada.id_competicao BETWEEN '"+competicao1+"' and '"+competicao2+"'");
                       
            }
            else if(tipo.trim().equals("3"))
            {
                //selecionar Data
               rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome as competicao, categoria.nome as categoria, piloto.nome as competidor, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                      "where date(competicao.data) BETWEEN to_timestamp('"+data1+"','dd/mm/yyyy')and to_timestamp('"+data2+"','dd/mm/yyyy') and puxada.id_competicao = competicao.codigo");
            }
                 else if(tipo.trim().equals("4"))
            {
                //selecionar Competição
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome as competicao, categoria.nome as categoria, piloto.nome as competidor, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                      "where puxada.id_categoria BETWEEN '"+categoria1+"' and '"+categoria2+"'");
            }
                   else if(tipo.trim().equals("5"))
            {
                //selecionar Competição
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome as competicao, categoria.nome as categoria, piloto.nome as competidor, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto) " +
                      "where puxada.id_categoria BETWEEN '"+categoria1+"' and '"+categoria2+"'and date(competicao.data) BETWEEN to_timestamp('"+data1+"','dd/mm/yyyy')and to_timestamp('"+data2+"','dd/mm/yyyy') and puxada.id_competicao = competicao.codigo and puxada.codigo BETWEEN '"+valor+"' and '"+valor2+"' and puxada.id_competicao BETWEEN '"+competicao1+"' and '"+competicao2+"'");
            }
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ServicoBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
   }  
  
  
   
}// Fim da classe
