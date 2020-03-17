/*
 * ServicoBDAO.java
 * 
 * Criado em 31/08/2007, 00:27:30
 * Última alteração  em 09/09/2007, 07:56:40
 * 
 */

package arrancada.Extra;

import arrancada.Exceptions.MyException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bessa
 */
public class ServicoBDAOcomMyException {
    
    public ServicoBDAOcomMyException()
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
    
 //  ------------------ Propriedades da Classe -------------------------//
     
          private ConexaoDAOcommyException conexaoBD = new ConexaoDAOcommyException();
          private ResultSet rs;
//---------------------Propriedades das tabelas------------------------//     
    
     //Propriedades de piloto
          int pilotoCodigo;
          String pilotoNome;
          String pilotoUf;
          String pilotoCidade;
          
        
   // Propriedades de Competiçao
         int  competicaoCodigo;
         String competicaoNome;
         String competicaoData;
         String competicaoCidade;
         String competicaoUf;
         
 //  Propriedades de Veiculo
          int veiculoCodigo;
          String veiculoNome;
          int veiculoTipo;
          
          
//  Propriedades de Competidor
          int competidorCodigo;
          String competidorPlaca;
          int competidorPiloto; //Chave estrangeira.
          int competidorCategoria; //Chave estrangeira.
          int competidorCompeticao; //Chave estrangeira.
          int competidorVeiculo; //Chave estrangeira.            
          
          
//  Propriedades de Puxada
         int puxadaCodigo; 
         int puxadaCompeticao;
         int puxadaCompetidor;
         int puxadaCategoria; 
         int puxadaTempo;  
         String puxadaStatus; 
         int puxadaPuxada;  
         
 //------------------------ Fim das propriedades ----------------------------------//
     
    public String proximoCodigo(String tabela) throws MyException     
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
             throw new MyException("Exception :"+ex.getMessage());
        }
        finally
        {
            return codigo;   
        }
     
    }
    
    public String proximaPuxada() throws MyException
    {
        String proxima = "1";
        try
        {
            rs = conexaoBD.operacao.executeQuery("select GREATEST(max(puxada.puxada+1),1) " +
                      " from puxada " +
                      " where puxada.id_competicao = 3 and " +
                      " puxada.id_categoria = 3 and " +
                      " puxada.id_competidor = 3 ");
            rs.next();
            proxima = rs.getString(1);
            return proxima;
        }
        catch (SQLException ex) 
        {
            throw new MyException("Exception :"+ex.getMessage());
            
        }
        finally
        {
        return proxima;
        }
    }
     // Piloto
         /** 
          * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
          */
    public void insertPiloto(int codigo ,String nome,String uf,String cidade) throws MyException 
{
        try {
    
             pilotoCodigo = codigo;
             pilotoNome = nome;
             pilotoUf = uf;
             pilotoCidade = cidade;
                       
           // String de Insert
            String sql1 = "Insert into piloto values(" + pilotoCodigo + ",\'" + pilotoNome + "\',\'" + pilotoUf + "\',\'" + pilotoCidade + "\')";
          
            //  Usado pra verificar se tem alguém no banco             
            String sql = "Select codigo from piloto where codigo =" + pilotoCodigo + ""; 
         
            conexaoBD.criaConexao(); 
            // o rs é usado para retornos de Querys do banco, porém este recebe um Statement
            rs = conexaoBD.operacao.executeQuery(sql);        
                                 
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Código de Piloto já cadastrado no Banco.","Mensagem do Programa",JOptionPane.ERROR_MESSAGE);
            } else {

                int x = conexaoBD.operacao.executeUpdate(sql1);
                if(x == 1)
                {
                JOptionPane.showMessageDialog(null,"Piloto cadastrado com Sucesso","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
                }
            }
        } catch (SQLException ex) {
            throw new MyException("Exception :"+ex.getMessage());
        } 
        
           
   
}
    
    
         /** 
          * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
          */
   public void updatePiloto(int codigo ,String nome,String uf,String cidade) throws MyException 
 {            
        try {


            pilotoCodigo = codigo;
            pilotoNome = nome;
            pilotoUf = uf;
            pilotoCidade = cidade;
            
            // String de Update
            String sql1 = "Update piloto set nome= '" + pilotoNome + "',"+
                                                      " uf = '" + pilotoUf + "',"+
                                                      " cidade ='" + pilotoCidade + "'" +
                                                      " where codigo = " + pilotoCodigo ;

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql1);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Piloto Alterado com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Código de Piloto não encontrado no banco para efetuar alteração.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            throw new MyException("Exception :"+ex.getMessage());
        }
                
                
                
   }
   
        /** 
          * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
          */     
    public void deletePiloto(int codigo ,String nome,String uf,String cidade) throws MyException 
    {
      try {


            pilotoCodigo = codigo;
            pilotoNome = nome;
            pilotoUf = uf;
            pilotoCidade = cidade;


            // String de Delete
            String sql1 =  "delete from piloto where codigo = " + pilotoCodigo;

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql1);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Piloto Excluido com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Código de Piloto não encontrado no banco para efetuar Exclusão.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            throw new MyException("Exception :"+ex.getMessage());
        }   
                
        
    
    }
       
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */
   public ResultSet selectPiloto(String valor, String tipo) throws MyException
    {     
        try
        {
            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from piloto where (Codigo LIKE '"+ valor +"') order by codigo");
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
           throw new MyException("Exception :"+ex.getMessage());
        }
        finally{          
        
        return rs;
        }
      }
   
   
// Categoria
    /* *
     * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
     */  
   public void insertCategoria(String codigo ,String nome) throws MyException 
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
        } 
        catch (SQLException ex) 
        {
            throw new MyException("Exception :"+ex.getMessage());
        }      
}    
    /**
     * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
     */
   public int updateCategoria(String codigo ,String nome) throws MyException 
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
           throw new MyException("Exception :"+ex.getMessage());
         
        }
        return 0;
   }  
    /** 
     * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
     */
    public int deleteCategoria(String codigo ,String nome) throws MyException 
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
         throw new MyException("Exception :"+ex.getMessage());
      }
      return 0;
}
   
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */
   public ResultSet selectCategoria(String valor, String tipo) throws MyException
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
                rs = conexaoBD.operacao.executeQuery("Select * from categoria where (Nome LIKE '"+valor.toUpperCase()+"%') order by Nome");
            }
            
            return rs;
          
        }
        catch (SQLException ex) 
        {
           throw new MyException("Exception :"+ex.getMessage());
        }
        finally
        {
              return rs;
        }
}
   
   //Competição
    /** 
     * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
     */
   
  public void insertCompeticao(String codigo, String nome, String data, String uf, String cidade) throws MyException 
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
           throw new MyException("Exception :"+ex.getMessage());
        }       
} 
   /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
   public int updateCompeticao(String codigo, String nome, String data, String uf, String cidade) throws MyException 
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
          throw new MyException("Exception :"+ex.getMessage());
        }
        return 0;           
   }    
   
   /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
    */
    public int deleteCompeticao(int codigo) throws MyException
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
          throw new MyException("Exception :"+ex.getMessage());
        }   
                
        
    
    }
   
   
  public ResultSet selectCompeticao(String valor, String tipo) throws MyException{     
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
                rs = conexaoBD.operacao.executeQuery("Select * from competicao where (nome LIKE '"+ valor.toUpperCase() +"%') order by nome");
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
            return rs;       
        } catch (SQLException ex) {
           throw new MyException("Exception :"+ex.getMessage());
        }
        finally{
        return rs;
        }
}  
   
    /** 
     * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
     */
   public int insertVeiculo(String codigo, String nome, String tipo) throws MyException 
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
         throw new MyException("Exception :"+ex.getMessage());
        } 
    return 0;  
}
  
   /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
   public int updateVeiculo(String codigo, String nome, String tipo) throws MyException 
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
           throw new MyException("Exception :"+ex.getMessage());
        }
   return 0;            
}  
  
   
    /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
    */
   public int deleteVeiculo(String codigo) throws MyException
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
          throw new MyException("Exception :"+ex.getMessage());
        }   
   return 0;
}
 
    public ResultSet selectVeiculo(String valor, String tipo) throws MyException
    {   try {  
            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo order by codigo");
            }
            else if (tipo.trim().equals("1"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo where (Codigo LIKE '"+ valor +"') order by codigo");
            }
            else if(tipo.trim().equals("2"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo where (UPPER(nome) LIKE '"+ valor.toUpperCase() +"%') order by nome");
            }
            else if(tipo.trim().equals("3"))
            {
                rs = conexaoBD.operacao.executeQuery("Select * from veiculo where tipo = '" + valor + "' order by codigo"); 
            }
            return rs;       
        } catch (SQLException ex) {
            throw new MyException("Exception :"+ex.getMessage());
        }
        finally
        {
                   return rs;
        }
}  
  
  
  // Competidor
  /** 
   * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
   */    
public int insertCompetidor(String codigo, String piloto, String veiculo, String competicao, String categoria, String placa) throws MyException 
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
           throw new MyException("Exception :"+ex.getMessage());
        }
  return 0;
}
  
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */
  public ResultSet selectCompetidor(String valor, String tipo)throws MyException
    {     
        try {

            conexaoBD.criaConexao();
            if(tipo.trim().equals("0"))
            {
                rs = conexaoBD.operacao.executeQuery("Select Competidor.numero_veiculo, competicao.nome, categoria.nome," +
                    " piloto.nome, veiculo.nome, competidor.placa from competidor" +
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
                //busca precisa pelo numero do veiculo, para verificação na hora de excluir um veículo
                //pois se ele estiver vinculado a um competidor, não podera ser excluído.
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
        return rs; 
        } catch (SQLException ex) {
            throw new MyException("Exception :"+ex.getMessage());
        }
        finally
        {
         return rs;
        }
      } 
  
  /**
   *criado só para preencher os campos
   */
  public ResultSet selectCompetidorVeiculo(int codigoVeiculo)throws MyException
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
            throw new MyException("Exception :"+ex.getMessage());
        }
       finally
       {
        return rs;
       }
       
       
   }
  
   /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco.   
    */
   public int deleteCompetidor(String codigo, String competicao) throws MyException
    {
       try {
                String sql =  "delete from competidor where numero_veiculo = '" + codigo + "' and id_competicao = " + competicao;
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
            } 
       catch (SQLException ex) 
            {
                throw new MyException("Exception :"+ex.getMessage());                              
            }   
      
    }
  
   /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
public int updateCompetidor(String numero_veiculo, String piloto, String veiculo, String competicao, String categoria, String placa) throws MyException 
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
            throw new MyException("Exception :"+ex.getMessage());   
        }       
}  
  
  // Puxada
     /** 
      * método público que não retorna nada, para inserção de dados na referida tabela no banco.   
      */
public int insertPuxada(String codigo,String competicao, String categoria, String competidor, String tempo,String status,String numeroPuxada) throws MyException 
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
       throw new MyException("Exception :"+ex.getMessage());   
    } 
}
  
  
  /** 
    * método público que não retorna nada, para atualizações de dados na referida tabela no banco.   
    */
   public void updatePuxada(int codigo,int competidor ,int competicao,int categoria,int tempo,String status,int puxada) throws MyException 
 {            
        try {

          puxadaCodigo = codigo ; 
          puxadaCompeticao = competicao;
          puxadaCategoria = categoria; 
          puxadaTempo = tempo;  
          puxadaStatus = status; 
          puxadaPuxada = puxada; 
          puxadaCompetidor = competidor;
         
            
            // String de Update
          String sql1 = "Update puxada set placa= '" + puxadaStatus + "',"+
                                                      " id_competidor = " + puxadaCompetidor + 
                                                      " tempo = " + puxadaTempo + 
                                                      " puxada = " + puxadaPuxada + 
                                                      " id_competicao = " + puxadaCompeticao + 
                                                      " id_categoria = " + puxadaCategoria + 
                                                      "where codigo = " + puxadaCodigo ;

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql1);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Puxada Alterada com Sucesso", "Menssagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Código da Puxada não encontrado no banco para efetuar alteração.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
             throw new MyException("Exception :"+ex.getMessage());   
        }
                
                
                
   }   
  
  /** 
    * método público que não retorna nada, para deletar de dados na referida tabela no banco, 
    * recebendo como parâmetros o código da puxada e o competidor cadastrado nela.   
    */
  public void deletePuxada(int codigoPuxada,int competidor ) throws MyException
    {
      try {

            

            // String de Delete
            String sql1 =  "delete from puxada where codigo = " + codigoPuxada + "and" + competidor;

            conexaoBD.criaConexao();

            int x = conexaoBD.operacao.executeUpdate(sql1);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Puxada Excluída com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                conexaoBD.operacao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Código da Puxada não encontrado no banco para efetuar Exclusão.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            throw new MyException("Exception :"+ex.getMessage());   
        }   
                
        
    
    } 
  
     /** 
      * método público que  retorna um ResultSet, para ser trabalhado nas interfaces das telas(Jtable).   
      */   
   public ResultSet selectPuxada(String valor, String tipo) throws MyException
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
                rs = conexaoBD.operacao.executeQuery("select puxada.codigo, competicao.nome, categoria.nome, piloto.nome, puxada.tempo, " +
                      " puxada.status, puxada.puxada from puxada " +
                      " inner join competicao on (competicao.codigo = puxada.id_competicao) " +
                      " inner join categoria on (categoria.codigo = puxada.id_categoria) " +
                      " inner join competidor on (competidor.numero_veiculo = puxada.id_competidor) " +
                      " inner join piloto on (piloto.codigo = competidor.id_piloto)");
            }
            else if(tipo.trim().equals("2"))
            {
                //selecionar puxada específica
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
                //selecionar número da próxima puxada do competidor(falta terminar)
                rs = conexaoBD.operacao.executeQuery("select GREATEST(max(puxada.puxada+1),1) " +
                      " from puxada " +
                      " where puxada.id_competicao = 3 and " +
                      " puxada.id_categoria = 3 and " +
                      " puxada.id_competidor = 3 ");
            }
            return rs;
        } catch (SQLException ex) {
             throw new MyException("Exception :"+ex.getMessage());   
           
        }
       finally
       {
         return rs;   
       }
   }   
}// Fim da classe
