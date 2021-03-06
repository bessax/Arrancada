/*
 * ConsultaCategoria.java
 *
 * Created on 26 de Dezembro de 2007, 21:24
 */

package arrancada.Formularios;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import arrancada.Util.TeclaPress;
import arrancada.Util.ManipularJTable;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author  xp
 */
public class ConsultaCategoria extends javax.swing.JDialog {
    
    /** Creates new form ConsultaCategoria */
    public ConsultaCategoria(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabelPesquisa = new javax.swing.JLabel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabelBusca = new javax.swing.JLabel();
        jScrollPanePiloto = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSelecionar = new javax.swing.JMenu();
        jMenuFechar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Categoria");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("[F2] Código  [F3] Nome");
        jLabel1.setToolTipText("\"Tecle [F2] para pesquisar por CÓDIGO,[F3] para pesquisar por NOME\"");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelPesquisa.setText("Pesquisando por Código");

        jTextFieldPesquisa.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldPesquisa.setToolTipText("\"Campo em branco lista todos\"");
        jTextFieldPesquisa.setName("jLabelPesquisa"); // NOI18N
        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyPressed(evt);
            }
        });

        jLabelBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/search_f2.png"))); // NOI18N
        jLabelBusca.setName("jLabelImagem"); // NOI18N
        jLabelBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBuscaMouseClicked(evt);
            }
        });

        jScrollPanePiloto.setFocusable(false);

        jTableCategoria.setAutoCreateRowSorter(true);
        jTableCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ));
        jTableCategoria.getTableHeader().setReorderingAllowed(false);
        jTableCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableCategoriaKeyPressed(evt);
            }
        });
        jScrollPanePiloto.setViewportView(jTableCategoria);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelBusca)))
                .addContainerGap())
            .addComponent(jScrollPanePiloto, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPanePiloto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBusca)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPesquisa)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
    private void jTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyPressed
        // TODO add your handling code here:
        jLabelPesquisa.setText(teclaPress.KeyCategoriaPiloto(evt));
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //manipularJtable.selecionarValor(jTableCategoria, jTextFieldPesquisa.getText(), 0);
            if(jTextFieldPesquisa.getText().trim().isEmpty()) 
            {
                manipularJtable.categoria(jTableCategoria, "", "0");
            } 
            else if(jLabelPesquisa.getText().equals("Pesquisando por Código")) 
            {
                manipularJtable.categoria(jTableCategoria, jTextFieldPesquisa.getText(), "1");
            } 
            else if(jLabelPesquisa.getText().equals("Pesquisando por Nome")) 
            {
                manipularJtable.categoria(jTableCategoria, jTextFieldPesquisa.getText(), "2");
            }
            if(jTableCategoria.getRowCount() > 0) 
            {
                jTableCategoria.requestFocus();
                jTableCategoria.setRowSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_jTextFieldPesquisaKeyPressed

    private void jLabelBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBuscaMouseClicked
        // TODO add your handling code here:
        if(jTextFieldPesquisa.getText().trim().isEmpty()) 
        {
            manipularJtable.categoria(jTableCategoria, "", "0");
        } 
        else if(jLabelPesquisa.getText().equals("Pesquisando por Código")) {
            manipularJtable.categoria(jTableCategoria, jTextFieldPesquisa.getText(), "1");
        } 
        else if(jLabelPesquisa.getText().equals("Pesquisando por Nome")) {
            manipularJtable.categoria(jTableCategoria, jTextFieldPesquisa.getText(), "2");
        }
        jTableCategoria.requestFocus();
        jTableCategoria.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_jLabelBuscaMouseClicked

    private void jMenuSelecionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSelecionarMouseClicked
        // Se a linha for == -1 siginifica que não tem linha selecionada
        if(jTableCategoria.getSelectedRow() != -1) {
            codigo = Integer.parseInt(String.valueOf(jTableCategoria.getValueAt(jTableCategoria.getSelectedRow() ,0)));
            nome = String.valueOf(jTableCategoria.getValueAt(jTableCategoria.getSelectedRow() ,1));
            dispose();
        } else {
            //Exibe Mensagem caso nenhuma linha esteja selecionada
            JOptionPane.showMessageDialog(null, "Selecione uma Competiçao na tabela.");
        }
    }//GEN-LAST:event_jMenuSelecionarMouseClicked

    private void jMenuFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuFecharMouseClicked
        codigo = -1;
        dispose();
    }//GEN-LAST:event_jMenuFecharMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jTextFieldPesquisa.requestFocus();
    }//GEN-LAST:event_formWindowActivated

    private void jTableCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCategoriaKeyPressed
        if((evt.getKeyCode() == KeyEvent.VK_F2) ||(evt.getKeyCode() == KeyEvent.VK_F3)) 
        {
            jLabelPesquisa.setText(teclaPress.KeyCategoriaPiloto(evt));
            jTextFieldPesquisa.requestFocus();
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(jTableCategoria.getSelectedRow() != -1)
            {
                codigo = Integer.parseInt(String.valueOf(jTableCategoria.getValueAt(jTableCategoria.getSelectedRow() ,0)));
                dispose();
            }
            else
            {
                //Exibe Mensagem caso nenhuma linha esteja selecionada
                JOptionPane.showMessageDialog(null, "Selecione uma Categoria na tabela.");
            }
        }
    }//GEN-LAST:event_jTableCategoriaKeyPressed
    
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
                ConsultaCategoria dialog = new ConsultaCategoria(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPanePiloto;
    private javax.swing.JTable jTableCategoria;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
    
    TeclaPress teclaPress = new TeclaPress();
    ManipularJTable manipularJtable = new ManipularJTable();
    public static int codigo = -1;
    public static String nome = null;
}
