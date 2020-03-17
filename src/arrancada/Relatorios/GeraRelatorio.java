/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Relatorios;

import arrancada.Dao.ServicoBDAO;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Classe para a criação de relatórios dinâmicos para a aplicação Arrancada.
 * Editada em : 28/12/2007
 * @author Bessa
 */
public class GeraRelatorio {
    
    
    
    
    // Objeto de interação com Banco da Aplicação
        private ServicoBDAO  servico = new ServicoBDAO();
    // Nosso select 
        private ResultSet rs = null;
    //Caminho padrão para alocação dos arquivos jrXML
        private String path ="C:\\Arquivos de Programas\\Arrancada\\XML\\";     
    //design a ser definido em tempo de execução
        private String jrXml = "";   
    // Aqui crio um vizualizador 
       // private JasperViewer jrviewer = null;
        
        
       // Metodos get e set que são uma especificação JavaBeans
            public void setPath( String caminho)
        {
            this.path = caminho;
        }
        
        public String getPath()
        {
            return this.path;
        }
        

       
    // Método onde defino qual consulta vou utilizar no relatório.
    private  ResultSet realizaConsulta(int consulta)
    {
        
        switch( consulta ){
                case 1:   rs = servico.selectPiloto("","0");
                           jrXml = path + "piloto.jrxml";
                           break;
                           
                case 2:   rs = servico.selectCompetidor("","","","0");
                           jrXml = path + "competidor.jrxml";
                           break;
        
                case 3:   rs = servico.selectCompeticao("", "0");
                           jrXml = path + "competicao.jrxml";
                           break;
                           
                case 4:   rs = servico.selectCategoria("","0");
                          jrXml = path + "categoria.jrxml";
                          break;
                          
                case 5:    rs = servico.selectVeiculo("","0");
                           jrXml = path + "veiculo.jrxml";
                            break;
                            
               case 6:    rs = servico.selectPuxada("","","","0");
                           jrXml = path + "Puxada.jrxml";
                            break;
                            
                default :  System.out.println("Codigo de relatório não cadastrado");
        }
      
        return rs;
    }
    
         
    
    // metodo para compilar o relatório do Jasper    
    private final JasperReport compilaRelatorio() throws JRException 
    {     
        
           JasperDesign design = JRXmlLoader.load(jrXml);
          
           JasperReport  jr = JasperCompileManager.compileReport(design);
           
           return jr;
        
    }
    /**Aqui monto o relatorio recebendo como parâmetro de qual relatório eu quero,
     * <p>
     * >> 1 - Relatório de pilotos<p>
     * >> 2 - Relatório de Competidor<p>
     * >> 3 - Relatório de Competição<p>
     * >> 4 - Relatório de Categoria<p>
     * >> 5 - Relatório de Veículo<p>
     * >> 6 - Relatório de Puxada<p>
     * @param relatorio
     * @return não retorna nada
     */
    public final void montaRelatorio(int relatorio, String title) throws JRException
    {
        try{         
         
           
        //criando JDialog para adicionar o visualisador de relatório do Jasper
        JDialog visualizador = new JDialog(new JFrame(),"Visualização do Relatório "+title, true);
        visualizador.setSize(900,700);
        
        //ajustando alinhamento
        visualizador.setLocationRelativeTo(null); 
        
        // Meus parâmetros de relatorios;        
        Map parameters = new HashMap(); 
            // Crio uma instancia de interface com a consulta desejada.  
      JRResultSetDataSource jrRS = new JRResultSetDataSource(realizaConsulta(relatorio));
           //Instancia com o relatório Compilado
       
       JasperReport  jr = compilaRelatorio();
           // Montando efetivamente o relatório
       JasperPrint impressao = JasperFillManager.fillReport(jr,parameters, jrRS);
          
         // Aqui crio um vizualizador 
       JasperViewer  jrviewer = new JasperViewer(impressao,true); 
       
       //adiciona o Panel do jrviewer dentro do JDialog visualizador
        visualizador.getContentPane().add(jrviewer.getContentPane()); 
        visualizador.setVisible(true);
       
          
        
       }
        catch(JRException ex)
        {
            throw new JRException("Erro na execução do relatório - (JRException :"+ ex.getMessage()+")");
        }
      
    }
    

}
