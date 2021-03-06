/*
 * ConsultaVeiculo.java
 *
 * Created on 9 de Dezembro de 2007, 15:00
 */

package arrancada.Formularios;

import arrancada.Util.TeclaPress;
import arrancada.Util.ManipularJTable;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author  xp
 */
public class ConsultaVeiculo extends javax.swing.JDialog {
    
    /** Creates new form ConsultaVeiculo */
    public ConsultaVeiculo(java.awt.Frame parent, boolean modal) {
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

        jScrollPaneVeiculo = new javax.swing.JScrollPane();
        jTableVeiculo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelPesquisa = new javax.swing.JLabel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabelBusca = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSelecionar = new javax.swing.JMenu();
        jMenuFechar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Veículo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jScrollPaneVeiculo.setFocusable(false);

        jTableVeiculo.setAutoCreateRowSorter(true);
        jTableVeiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo"
            }
        ));
        jTableVeiculo.getTableHeader().setReorderingAllowed(false);
        jTableVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableVeiculoKeyPressed(evt);
            }
        });
        jScrollPaneVeiculo.setViewportView(jTableVeiculo);

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("[F2] Código    [F3] Nome     [F4]Tipo Veiculo");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabelPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelPesquisa.setText("Pesquisando Por:");

        jTextFieldPesquisa.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyPressed(evt);
            }
        });

        jLabelBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/search_f2.png"))); // NOI18N
        jLabelBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscaMouseClicked(evt);
            }
        });

        jMenuSelecionar.setMnemonic(KeyEvent.VK_S);
        jMenuSelecionar.setText("Selecionar");
        jMenuSelecionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSelecionarMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSelecionar);

        jMenuFechar.setMnemonic(KeyEvent.VK_F);
        jMenuFechar.setText("Fechar");
        jMenuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFecharActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuFechar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPaneVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelPesquisa)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSelecionarMouseClicked
        // Se a linha for == -1 siginifica que não tem linha selecionada
        if(jTableVeiculo.getSelectedRow() != -1) 
        {
            codigo = Integer.parseInt(String.valueOf(jTableVeiculo.getValueAt(jTableVeiculo.getSelectedRow() ,0)));
            this.dispose();
        } 
        else 
        {
            //Exibe Mensagem caso nenhuma linha esteja selecionada
            JOptionPane.showMessageDialog(null, "Selecione um Piloto na tabela.");
        }
    }//GEN-LAST:event_jMenuSelecionarMouseClicked

    private void jMenuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFecharActionPerformed
        codigo = -1;
        dispose();
    }//GEN-LAST:event_jMenuFecharActionPerformed

    private void jTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyPressed
        jLabelPesquisa.setText(teclaPress.KeyCategoriaPiloto(evt));
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            //manipularJtable.selecionarValor(jTableCategoria, jTextFieldPesquisa.getText(), 0);
            if(jTextFieldPesquisa.getText().trim().isEmpty()) 
            {
                manipularJTable.veiculo(jTableVeiculo, "", "0");
            } 
            else if(jLabelPesquisa.getText().equals("Pesquisando por Código")) {
                manipularJTable.veiculo(jTableVeiculo, jTextFieldPesquisa.getText(), "1");
            } 
            else if(jLabelPesquisa.getText().equals("Pesquisando por Nome")) {
                manipularJTable.veiculo(jTableVeiculo, jTextFieldPesquisa.getText(), "2");
            }
            if(jTableVeiculo.getRowCount() > 0) 
            {
                jTableVeiculo.requestFocus();
                jTableVeiculo.setRowSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_jTextFieldPesquisaKeyPressed

    private void jLabelBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscaMouseClicked
        // TODO add your handling code here:
        if(jTextFieldPesquisa.getText().trim().isEmpty()) 
        {
            manipularJTable.veiculo(jTableVeiculo, "", "0");
        } 
        else if(jLabelPesquisa.getText().equals("Pesquisando por Código")) {
            manipularJTable.veiculo(jTableVeiculo, jTextFieldPesquisa.getText(), "1");
        } 
        else if(jLabelPesquisa.getText().equals("Pesquisando por Nome")) {
            manipularJTable.veiculo(jTableVeiculo, jTextFieldPesquisa.getText(), "2");
        }
        jTableVeiculo.requestFocus();
        jTableVeiculo.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_jLabelBuscaMouseClicked

    private void jTableVeiculoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableVeiculoKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_F2) ||(evt.getKeyCode() == KeyEvent.VK_F3) ||(evt.getKeyCode() == KeyEvent.VK_F4)) 
        {
            jLabelPesquisa.setText(teclaPress.KeyCategoriaPiloto(evt));
            jTextFieldPesquisa.requestFocus();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            // Se a linha for == -1 siginifica que não tem linha selecionada
            if(jTableVeiculo.getSelectedRow() != -1) 
            {
                codigo = Integer.parseInt(String.valueOf(jTableVeiculo.getValueAt(jTableVeiculo.getSelectedRow() ,0)));
                dispose();
            } 
            else 
            {
                //Exibe Mensagem caso nenhuma linha esteja selecionada
                JOptionPane.showMessageDialog(null, "Selecione um Veículo na tabela.");
            }
        }
    }//GEN-LAST:event_jTableVeiculoKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jTextFieldPesquisa.requestFocus();
    }//GEN-LAST:event_formWindowActivated
    
    private void centralizar()
    {  
      /* Função para centralizar janela na tela */  
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
       Dimension frameSize = getSize();  
       setLocation(new Point((screenSize.width - frameSize.width) / 2,  
                             (screenSize.height - frameSize.width) / 2));  
    }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaVeiculo dialog = new ConsultaVeiculo(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBusca;
    private javax.swing.JLabel jLabelPesquisa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFechar;
    private javax.swing.JMenu jMenuSelecionar;
    private javax.swing.JScrollPane jScrollPaneVeiculo;
    private javax.swing.JTable jTableVeiculo;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
    
    GerenciaVeiculo gerenciaveiculo = new GerenciaVeiculo(null,true);
    ManipularJTable manipularJTable = new ManipularJTable();
    TeclaPress teclaPress = new TeclaPress();
    int cont = 0;
    public static int codigo = -1;
}
