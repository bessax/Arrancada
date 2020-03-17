/*
 * ManipularJTable.java
 * 
 * Created on 07/09/2007, 11:27:49
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrancada.Util;

import arrancada.Dao.ServicoBDAO;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author xp
 */
public class ManipularJTable {
    //Método responsável por preencher o jTable da tela de Categoria
    public int categoria(JTable table, String valor, String tipo)
    {   //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //Instanciando um ResultSet com o retorno do método selectCategoria
        ResultSet rs = servico.selectCategoria(valor, tipo);
        //Definindo a seleção de apenas uma linha no Jtable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Declarando uma String com o nome das Colunas utilizadas no Jtable
        String[] nomeColunasTabela = {"Código", "Nome"};
        //Instanciando um modelo de Tabela passando como parâmetro um Object vazio e o nome das colunas
        DefaultTableModel aModel = new DefaultTableModel(new Object[] []{ }, nomeColunasTabela) 
        {
            //Sobrescrevendo o método isCellEditable para que o usuário não possa alterar as células do Jtable
            @Override
            public boolean isCellEditable(int row, int col) 
            {  
                return false;  
            }
        };
        //***** Verificar se é necessário isso aki
        aModel.setColumnIdentifiers (nomeColunasTabela);
        //Limpando todas as linhas do jTable
        aModel.setNumRows(0);
        //***** Esqueci o que é ....
        Object[] retorno = new Object[2];
        try
        {
            if(rs == null || rs.next() == false )
            {
                return 0;
            }
            else
            {
                do
                {
                    //concatena o código retorna com zeros
                    String zeros = "0000" + rs.getString(1);
                    //atribuindo  o retorno do banco para o objeto retorno
                    retorno[0] = zeros.substring(zeros.length() - 4);
                    retorno[1] = rs.getString(2);
                    //Adicionando uma nova linha no modelo de jTable com os valores contidos em retorno
                    aModel.addRow(retorno);
                }
               while(rs.next());
                //Definindo o modelo para o jTable passando todas as modificações feitas no modelo
                table.setModel(aModel);
                //definindo tamanho da coluna 0 do JTable
                table.getColumnModel().getColumn(0).setPreferredWidth(50);
                //definindo tamanho da coluna 1 do JTable
                table.getColumnModel().getColumn(1).setPreferredWidth(490);
                //Criando uma interface para trabalhar com as células do jTable
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                //Definindo o alinhamento das células do modelo como Centralizado
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                //setando a interface modificada nas células da coluna 0
                table.getColumnModel().getColumn(0).setCellRenderer(renderer);
                rs.close();
                return 1;
            }
        }
       catch(SQLException ex)
       {
           
       }
       return 1;
    }
    
    public int competicao(JTable table, String valor, String tipo)
    {
        //Instanciando um ResultSet com o retorno do método selectCompeticao
        ResultSet rs = servico.selectCompeticao(valor, tipo);
        //Definindo a seleção de apenas uma linha no Jtable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Declarando uma String com o nome das Colunas utilizadas no Jtable
        String[] tableColumnsName = {"Código", "Nome", "Data", "UF", "Cidade"};
        //Instanciando um modelo de Tabela passando como parâmetro um Object vazio e o nome das colunas
        DefaultTableModel aModel = new DefaultTableModel(new Object[] []{ }, tableColumnsName) 
        {  
            //Sobrescrevendo o método isCellEditable para que o usuário não possa alterar as células do Jtable
            public boolean isCellEditable(int row, int col) 
            {  
                return false;  
            }
        };
        //***** Verificar se é necessário isso aki
        aModel.setColumnIdentifiers (tableColumnsName);
        //Limpando todas as linhas do jTable
        aModel.setNumRows(0);
        Object[] retorno = new Object[5];
        try
        {
            if(rs == null || rs.next() == false)
            {
                return 0;
            }
            else
            {
                do
                {
                    //concatena o código retorna com zeros
                    String zeros = "0000" + rs.getString(1);
                    //atribuindo  o retorno do banco para o objeto retorno
                    retorno[0] = zeros.substring(zeros.length() - 4);
                    retorno[1] = rs.getString(2);
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    retorno[2] = formato.format(rs.getDate(3));                
                    retorno[3] = rs.getString(4);
                    retorno[4] = rs.getString(5);
                    //Adicionando uma nova linha no modelo de jTable com os valores contidos em retorno
                    aModel.addRow(retorno);
                }
                while(rs.next()); 
                //Definindo o modelo para o jTable passando todas as modificações feitas no modelo     
                table.setModel(aModel);
                //definindo tamanho da coluna 0 do JTable
                table.getColumnModel().getColumn(0).setPreferredWidth(43);
                //definindo tamanho da coluna 1 do JTable
                table.getColumnModel().getColumn(1).setPreferredWidth(193);
                table.getColumnModel().getColumn(2).setPreferredWidth(72);
                table.getColumnModel().getColumn(3).setPreferredWidth(22);
                table.getColumnModel().getColumn(4).setPreferredWidth(201);
                //Criando uma interface para trabalhar com as células do jTable
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                //Definindo o alinhamento das células do modelo como Centralizado
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                //setando a interface modificada nas células da coluna 0
                table.getColumnModel().getColumn(0).setCellRenderer(renderer);
                rs.close();
                return 1;
            }          
        }
       catch(SQLException ex)
       {
           
       }
        return 1;
    }
    
    public int competidor(JTable table, String valor, String tipo)
    {
        //Instanciando um ResultSet com o retorno do método selectCompeticao
        ResultSet rs = servico.selectCompetidor(valor,"","", tipo);
        //Definindo a seleção de apenas uma linha no Jtable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Declarando uma String com o nome das Colunas utilizadas no Jtable
        String[] tableColumnsName = {"Nº Veículo","Competição", "Categoria", "Piloto", "Veículo", "Placa"};
        //Instanciando um modelo de Tabela passando como parâmetro um Object vazio e o nome das colunas
        DefaultTableModel aModel = new DefaultTableModel(new Object[] []{ }, tableColumnsName) 
        {  
            //Sobrescrevendo o método isCellEditable para que o usuário não possa alterar as células do Jtable
            public boolean isCellEditable(int row, int col) 
            {  
                return false;  
            }
        };
        //***** Verificar se é necessário isso aki
        aModel.setColumnIdentifiers (tableColumnsName);
        //Limpando todas as linhas do jTable
        aModel.setNumRows(0);
        //***** Esqueci o que é ....
        Object[] retorno = new Object[6];
        try
        {
            rs.next();
            do
            {
                retorno[0] = rs.getString(1);
                retorno[1] = rs.getString(2);
                retorno[2] = rs.getString(3);
                retorno[3] = rs.getString(4);
                retorno[4] = rs.getString(5);
                retorno[5] = rs.getString(6);
                //Adicionando uma nova linha no modelo de jTable com os valores contidos em retorno
                aModel.addRow(retorno);
            }
               while(rs.next());
           //Definindo o modelo para o jTable passando todas as modificações feitas no modelo     
           table.setModel(aModel);
           //definindo tamanho da coluna 0 do JTable
            table.getColumnModel().getColumn(0).setPreferredWidth(61);
            //definindo tamanho da coluna 1 do JTable
            table.getColumnModel().getColumn(1).setPreferredWidth(154);
            table.getColumnModel().getColumn(2).setPreferredWidth(154);
            table.getColumnModel().getColumn(3).setPreferredWidth(186);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(62);
            //Criando uma interface para trabalhar com as células do jTable
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            //Definindo o alinhamento das células do modelo como Centralizado
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            //setando a interface modificada nas células da coluna 0
            table.getColumnModel().getColumn(0).setCellRenderer(renderer);
           rs.close();
           return 1;
        }
       catch(SQLException ex)
       {
           
       }
        return 1;
    }
    

	public int puxada(JTable table,String valor, String tipo)
    {
        //Instanciando um ResultSet com o retorno do método selectVeiculo
        ResultSet rs = servico.selectPuxada(valor,"","",tipo);
        //Definindo a seleção de apenas uma linha no Jtable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Declarando uma String com o nome das Colunas utilizadas no Jtable
        String[] tableColumnsName = {"Código", "Competição", "Categoria", "Competidor","Tempo","Status","Puxada"};
        //Instanciando um modelo de Tabela passando como parâmetro um Object vazio e o nome das colunas
        DefaultTableModel aModel = new DefaultTableModel(new Object[] []{ }, tableColumnsName) 
        {  
            //Sobrescrevendo o método isCellEditable para que o usuário não possa alterar as células do Jtable
            public boolean isCellEditable(int row, int col) 
            {  
                return false;  
            }
        };  
        //***** Verificar se é necessário isso aki
        aModel.setColumnIdentifiers (tableColumnsName);
        //Limpando todas as linhas do jTable
        aModel.setNumRows(0);
        //***** Esqueci o que é ....
        Object[] retorno = new Object[7];
        try
        {
            rs.next();
            do
            {
                //concatena o código retorna com zeros
                String zeros = "0000" + rs.getString(1);
                //atribuindo  o retorno do banco para o objeto retorno
                retorno[0] = zeros.substring(zeros.length() - 4);
                retorno[1] = rs.getString(2);
                retorno[2] = rs.getString(3);
                retorno[3] = rs.getString(4);
                retorno[4] = rs.getString(5);
                retorno[5] = rs.getString(6);
                retorno[6] = rs.getString(7);
                //Adicionando uma nova linha no modelo de jTable com os valores contidos em retorno
                aModel.addRow(retorno);
              
            }
               while(rs.next());
           //Definindo o modelo para o jTable passando todas as modificações feitas no modelo     
           table.setModel(aModel);
           //definindo tamanho da coluna 0 do JTable
            table.getColumnModel().getColumn(0).setPreferredWidth(44);
            //definindo tamanho da coluna 1 do JTable
            table.getColumnModel().getColumn(1).setPreferredWidth(139);
            table.getColumnModel().getColumn(2).setPreferredWidth(140);
            table.getColumnModel().getColumn(3).setPreferredWidth(206);
            table.getColumnModel().getColumn(4).setPreferredWidth(61);
            table.getColumnModel().getColumn(5).setPreferredWidth(73);
            table.getColumnModel().getColumn(6).setPreferredWidth(45);
            //Criando uma interface para trabalhar com as células do jTable
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            //Definindo o alinhamento das células do modelo como Centralizado
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            //setando a interface modificada nas células da coluna 0
            table.getColumnModel().getColumn(0).setCellRenderer(renderer);
            table.getColumnModel().getColumn(6).setCellRenderer(renderer);
            table.getColumnModel().getColumn(4).setCellRenderer(renderer);
           rs.close();
           return 1;
        }
       catch(SQLException ex)
       {
           
       }
        return 1;
    }

    
    public int veiculo(JTable table, String valor, String tipo)
    {
        
        //Instanciando um ResultSet com o retorno do método selectVeiculo
        ResultSet rs = servico.selectVeiculo(valor, tipo);
        //Definindo a seleção de apenas uma linha no Jtable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Declarando uma String com o nome das Colunas utilizadas no Jtable
        String[] tableColumnsName = {"Código", "Nome", "Tipo"};
        //Instanciando um modelo de Tabela passando como parâmetro um Object vazio e o nome das colunas
        DefaultTableModel aModel = new DefaultTableModel(new Object[] []{ }, tableColumnsName) 
        {  
            //Sobrescrevendo o método isCellEditable para que o usuário não possa alterar as células do Jtable
            @Override
            public boolean isCellEditable(int row, int col) 
            {  
                return false;  
            }
        };  
        //***** Verificar se é necessário isso aki
        aModel.setColumnIdentifiers (tableColumnsName);
        //Limpando todas as linhas do jTable
        aModel.setNumRows(0);
        //***** Esqueci o que é ....
        Object[] retorno = new Object[3];
        try
        {
            if(rs == null || rs.next() == false )
            {
                return 0;
            }
            else
            {
                do
                {
                    int i = rs.getInt(1);
                    //concatena o código retorna com zeros
                    String zeros = "0000" + rs.getString(1);
                    //atribuindo  o retorno do banco para o objeto retorno
                    retorno[0] = zeros.substring(zeros.length() - 4);
                    retorno[1] = rs.getString(2);
                    retorno[2] = rs.getString(3);
                    //Adicionando uma nova linha no modelo de jTable com os valores contidos em retorno
                    aModel.addRow(retorno);
                }
                while(rs.next());
           //Definindo o modelo para o jTable passando todas as modificações feitas no modelo     
           table.setModel(aModel);
           table.getColumnModel().getColumn(0).setPreferredWidth(48);
            //definindo tamanho da coluna 1 do JTable
            table.getColumnModel().getColumn(1).setPreferredWidth(383);
            table.getColumnModel().getColumn(2).setPreferredWidth(44);
            //Criando uma interface para trabalhar com as células do jTable
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            //Definindo o alinhamento das células do modelo como Centralizado
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            //setando a interface modificada nas células da coluna 0
            table.getColumnModel().getColumn(0).setCellRenderer(renderer);
           rs.close();
           //dimensionar.dimensionaTabela(table);
           
           return 1;
            }
        }
       catch(SQLException ex)
       {
           
       }
        return 1;
    }
    
    public int piloto(JTable table, String valor, String tipo)
    {
        //Instanciando um ResultSet com o retorno do método selectVeiculo
        ResultSet rs = servico.selectPiloto(valor, tipo);
        //Definindo a seleção de apenas uma linha no Jtable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Declarando uma String com o nome das Colunas utilizadas no Jtable
        String[] tableColumnsName = {"Código", "Nome", "UF", "Cidade"};
        //Instanciando um modelo de Tabela passando como parâmetro um Object vazio e o nome das colunas
        DefaultTableModel aModel = new DefaultTableModel(new Object[] []{ }, tableColumnsName) 
        {  
            //Sobrescrevendo o método isCellEditable para que o usuário não possa alterar as células do Jtable
            public boolean isCellEditable(int row, int col) 
            {  
                return false;  
            }
        };
        //***** Verificar se é necessário isso aki
        aModel.setColumnIdentifiers (tableColumnsName);
        //Limpando todas as linhas do jTable
        aModel.setNumRows(0);
        //***** Esqueci o que é ....
        Object[] retorno = new Object[4];
        try
        {
            rs.next();
            do
            {
                //concatena o código retorna com zeros
                String zeros = "0000" + rs.getString(1);
                //atribuindo  o retorno do banco para o objeto retorno
                retorno[0] = zeros.substring(zeros.length() - 4);
                retorno[1] = rs.getString(2);
                retorno[2] = rs.getString(3);
                retorno[3] = rs.getString(4);
                aModel.addRow(retorno);
            }
               while(rs.next());
           table.setModel(aModel);
           table.getColumnModel().getColumn(0).setPreferredWidth(45);
            //definindo tamanho da coluna 1 do JTable
            table.getColumnModel().getColumn(1).setPreferredWidth(221);
            table.getColumnModel().getColumn(2).setPreferredWidth(23);
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
            //Criando uma interface para trabalhar com as células do jTable
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            //Definindo o alinhamento das células do modelo como Centralizado
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
            //setando a interface modificada nas células da coluna 0
            table.getColumnModel().getColumn(0).setCellRenderer(renderer);
           rs.close();
           return 1;
        }
       catch(SQLException ex)
       {
           
       }
        return 1;
    }
    
    public void selecionarValor(JTable table, String valor, int coluna)
    {
        DefaultTableModel modelo = (DefaultTableModel)table.getModel();
        boolean controle = false;
        int linha = 0;
        // Faz um looping em cima das linhas do modelo
        while(linha < modelo.getRowCount())
        {
            // Obtem o valor atual na coluna
            String valorAtual = (String)modelo.getValueAt(linha, coluna);
            if( valorAtual.toUpperCase().equals(valor.toUpperCase()))
            {
                //Seleciona a linha
                table.setRowSelectionInterval(linha, linha);
                controle = true;
            }
            linha++;
        }
        if(controle == false)
        {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum registro.");
        }
    }

    private ServicoBDAO servico = new ServicoBDAO();
}

