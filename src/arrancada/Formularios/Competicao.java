/*
 * Competicao1.java
 *
 * Created on 7 de Setembro de 2007, 16:03
 */

package arrancada.Formularios;

import arrancada.Relatorios.GeraRelatorio;
import arrancada.Util.TeclaPress;
import arrancada.Util.ManipularJTable;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author  Vitor
 */
public class Competicao extends javax.swing.JDialog {
    
    /** Creates new form Competicao1 */
    public Competicao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centralizar();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneCompeticao1 = new javax.swing.JScrollPane();
        jTableCompeticao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelPesquisa = new javax.swing.JLabel();
        jLabelBusca = new javax.swing.JLabel();
        jFormattedTextFieldPesquisa = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInclusao = new javax.swing.JMenu();
        jMenuAlteracao = new javax.swing.JMenu();
        jMenuExclusao = new javax.swing.JMenu();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuFechar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Competição");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jScrollPaneCompeticao1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableCompeticao.setAutoCreateRowSorter(true);
        jTableCompeticao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Data", "UF", "Cidade"
            }
        ));
        jTableCompeticao.setFocusable(false);
        jTableCompeticao.getTableHeader().setReorderingAllowed(false);
        jTableCompeticao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableCompeticaoKeyPressed(evt);
            }
        });
        jScrollPaneCompeticao1.setViewportView(jTableCompeticao);

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("[F2]Código    [F3]Nome    [F4]Data");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelPesquisa.setText("Pesquisando por Código");

        jLabelBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/search_f2.png"))); // NOI18N
        jLabelBusca.setName("jLabelImagem"); // NOI18N
        jLabelBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscaMouseClicked(evt);
            }
        });

        jFormattedTextFieldPesquisa.setBackground(new java.awt.Color(255, 255, 204));
        jFormattedTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldPesquisaKeyPressed(evt);
            }
        });

        jMenuBar1.setFocusable(false);

        jMenuInclusao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuInclusao.setMnemonic(KeyEvent.VK_I);
        jMenuInclusao.setText("INCLUSÃO");
        jMenuInclusao.setFont(new java.awt.Font("Tahoma", 1, 11));
        jMenuInclusao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuInclusaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuInclusao);

        jMenuAlteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuAlteracao.setMnemonic(KeyEvent.VK_A);
        jMenuAlteracao.setText("ALTERAÇÃO");
        jMenuAlteracao.setFont(new java.awt.Font("Tahoma", 1, 11));
        jMenuAlteracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuAlteracaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuAlteracao);

        jMenuExclusao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuExclusao.setMnemonic(KeyEvent.VK_E);
        jMenuExclusao.setText("EXCLUSÃO");
        jMenuExclusao.setFont(new java.awt.Font("Tahoma", 1, 11));
        jMenuExclusao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuExclusaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuExclusao);

        jMenuRelatorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuRelatorio.setMnemonic(KeyEvent.VK_R);
        jMenuRelatorio.setText("RELATÓRIO");
        jMenuRelatorio.setFont(new java.awt.Font("Tahoma", 1, 11));
        jMenuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuRelatorioMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuRelatorio);

        jMenuFechar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuFechar.setMnemonic(KeyEvent.VK_F);
        jMenuFechar.setText("FECHAR");
        jMenuFechar.setFont(new java.awt.Font("Tahoma", 1, 11));
        jMenuFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuFecharMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuFechar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jFormattedTextFieldPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabelBusca)
                .addContainerGap())
            .addComponent(jScrollPaneCompeticao1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneCompeticao1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPesquisa)
                    .addComponent(jLabelBusca)
                    .addComponent(jFormattedTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("[F2]Código    [F3]Nome   [F4]Data");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jMenuExclusaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuExclusaoMouseClicked
    // Se linha for == -1 siginifica que não tem linha selecionada
    if(jTableCompeticao.getSelectedRow() != -1)
    {
        gerenciacompeticao.setTitle("Exclusão de Competição");
        gerenciacompeticao.clikmenu = "2";
        gerenciacompeticao.codigo = String.valueOf(jTableCompeticao.getValueAt(jTableCompeticao.getSelectedRow() ,0));
        gerenciacompeticao.setVisible(true);
    }
    else
    {
        //Exibe Mensagem caso nenhuma linha esteja selecionada
        JOptionPane.showMessageDialog(null, "Selecione uma Competição na tabela.");
    }
}//GEN-LAST:event_jMenuExclusaoMouseClicked

private void jMenuAlteracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAlteracaoMouseClicked
    // Se linha for == -1 siginifica que não tem linha selecionada
    if(jTableCompeticao.getSelectedRow() != -1)
    {
        gerenciacompeticao.setTitle("Alteração de Competição");
        gerenciacompeticao.clikmenu = "1";
        gerenciacompeticao.codigo = String.valueOf(jTableCompeticao.getValueAt(jTableCompeticao.getSelectedRow() ,0));
        gerenciacompeticao.setVisible(true);
    }
    else
    {
        //Exibe Mensagem caso nenhuma linha esteja selecionada
        JOptionPane.showMessageDialog(null, "Selecione uma Competição na tabela.");
    }
}//GEN-LAST:event_jMenuAlteracaoMouseClicked

private void jMenuInclusaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuInclusaoMouseClicked

    gerenciacompeticao.setTitle("Inclusão de Competição");
    gerenciacompeticao.clikmenu = "0";
    gerenciacompeticao.setVisible(true);
}//GEN-LAST:event_jMenuInclusaoMouseClicked

private void jMenuFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuFecharMouseClicked
    // TODO add your handling code here:
    cont = 0;
    dispose();
}//GEN-LAST:event_jMenuFecharMouseClicked

private void centralizar(){  
      /* Função para centralizar janela na tela */  
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
       Dimension frameSize = getSize();  
       setLocation(new Point((screenSize.width - frameSize.width) / 2,  
                             (screenSize.height - frameSize.width) / 2));  
    }

private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    //Se não tiver nada no banco o método fica dando loop na mensagem de erro
    jFormattedTextFieldPesquisa.requestFocus();
}//GEN-LAST:event_formWindowActivated

private void jTableCompeticaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCompeticaoKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_F4)
    {

        jLabelPesquisa.setText(teclaPress.KeyCompeticao(evt));
        jFormattedTextFieldPesquisa.requestFocus();
    }
    if((evt.getKeyCode() == KeyEvent.VK_F2) ||(evt.getKeyCode() == KeyEvent.VK_F3))
    {
        jLabelPesquisa.setText(teclaPress.KeyCompeticao(evt));
        jFormattedTextFieldPesquisa.requestFocus();
        jFormattedTextFieldPesquisa.setFormatterFactory(null);
    }
    else if((evt.getKeyCode() == KeyEvent.VK_ENTER))
    {
        
    }
        
}//GEN-LAST:event_jTableCompeticaoKeyPressed

private void jLabelBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscaMouseClicked
    int retorno = 0;
    if(jFormattedTextFieldPesquisa.getText().trim().isEmpty())
    {
       retorno = manipularJtable.competicao(jTableCompeticao, "", "0");
    }
    else if(jLabelPesquisa.getText().equals("Pesquisando por Código"))
    {
        retorno = manipularJtable.competicao(jTableCompeticao, jFormattedTextFieldPesquisa.getText(), "1");
    }
    else if(jLabelPesquisa.getText().equals("Pesquisando por Nome"))
    {
        retorno = manipularJtable.competicao(jTableCompeticao, jFormattedTextFieldPesquisa.getText(), "2");
    }
    else if(jLabelPesquisa.getText().equals("Pesquisando por Data"))
    {
        retorno = manipularJtable.competicao(jTableCompeticao, jFormattedTextFieldPesquisa.getText(), "2");
    }
    if(retorno == 1)
    {
        jTableCompeticao.requestFocus();
        jTableCompeticao.setRowSelectionInterval(0, 0);  
    }
    else
    {
       JOptionPane.showMessageDialog(null, "Nenhuma Competição foi Encontrada!"); 
    }
}//GEN-LAST:event_jLabelBuscaMouseClicked

private void jFormattedTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldPesquisaKeyPressed
    int retorno = 0;
    if((evt.getKeyCode() == KeyEvent.VK_F2) || (evt.getKeyCode() == KeyEvent.VK_F3))
    {
        jFormattedTextFieldPesquisa.setFormatterFactory(null);
        jFormattedTextFieldPesquisa.setText("");
    }
    else
    {
        if(evt.getKeyCode() == KeyEvent.VK_F4)
            {
                jFormattedTextFieldPesquisa.setFormatterFactory(setFormatoData());
                jLabelPesquisa.setText(teclaPress.KeyCompeticao(evt));
                jFormattedTextFieldPesquisa.requestFocus();
            }  
    }
    jLabelPesquisa.setText(teclaPress.KeyCompeticao(evt));
    if(evt.getKeyCode() == KeyEvent.VK_ENTER)
    {
        if(jFormattedTextFieldPesquisa.getText().trim().isEmpty() || (jFormattedTextFieldPesquisa.getText().equals("__/__/____")))
        {
            retorno = manipularJtable.competicao(jTableCompeticao, "", "0");
        }
        else if(jLabelPesquisa.getText().equals("Pesquisando por Código"))
        {
            retorno = manipularJtable.competicao(jTableCompeticao, jFormattedTextFieldPesquisa.getText().trim(), "1");
        }
        else if(jLabelPesquisa.getText().equals("Pesquisando por Nome"))
        {
            retorno = manipularJtable.competicao(jTableCompeticao, jFormattedTextFieldPesquisa.getText().toUpperCase(), "2");
        }
        else if(jLabelPesquisa.getText().equals("Pesquisando por Data"))
        {
            retorno = manipularJtable.competicao(jTableCompeticao, jFormattedTextFieldPesquisa.getText(), "3");
        }
        if(retorno == 1)
        {
            jTableCompeticao.requestFocus();
            jTableCompeticao.setRowSelectionInterval(0, 0);  
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Nenhuma Competição foi Encontrada!"); 
        }
    }
}//GEN-LAST:event_jFormattedTextFieldPesquisaKeyPressed

private void jMenuRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuRelatorioMouseClicked
//       try {
//
//             new GeraRelatorio().montaRelatorio(3,"Competição");
//              
//             } catch (JRException ex)
//             {
//             JOptionPane.showMessageDialog(null,ex.getMessage());              
//              }
    new ConfiguraRelatorioCompeticao(null,true).setVisible(true);
}//GEN-LAST:event_jMenuRelatorioMouseClicked
 
public DefaultFormatterFactory setFormatoData() {  
    MaskFormatter mascara = null;  
    try {  
            mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
        } catch (ParseException pe) { }  
        DefaultFormatterFactory factory = new DefaultFormatterFactory(mascara, mascara);  
        return factory;  
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Competicao dialog = new Competicao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBusca;
    private javax.swing.JLabel jLabelPesquisa;
    private javax.swing.JMenu jMenuAlteracao;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuExclusao;
    private javax.swing.JMenu jMenuFechar;
    private javax.swing.JMenu jMenuInclusao;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JScrollPane jScrollPaneCompeticao1;
    private javax.swing.JTable jTableCompeticao;
    // End of variables declaration//GEN-END:variables
    
    GerenciaCompeticao gerenciacompeticao = new  GerenciaCompeticao(null,true);
    TeclaPress teclaPress = new TeclaPress();
    ManipularJTable manipularJtable = new ManipularJTable();
    int cont = 0;
}
