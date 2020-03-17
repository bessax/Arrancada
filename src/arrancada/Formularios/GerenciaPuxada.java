/*
 * GerenciaPuxada.java
 *
 * Created on 23 de Janeiro de 2008, 21:12
 */

package arrancada.Formularios;


import arrancada.Dao.ServicoBDAO;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *Classe criada para gerênciar a tela de puxada.
 * Data da última alteração :23/01/2008
 * @author  Bessa
 */
public class GerenciaPuxada extends javax.swing.JDialog {
    
    /** Creates new form GerenciaPuxada */
    public GerenciaPuxada(java.awt.Frame parent, boolean modal) {
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

        jPanel2 = new javax.swing.JPanel();
        jTextFieldCodigoCompetidor = new javax.swing.JTextField();
        jTextFieldCodigo = new javax.swing.JTextField();
        jButtonConsultaCompetidor = new javax.swing.JButton();
        jLabelCompetidor = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCompetidor = new javax.swing.JTextField();
        jLabelCategoria = new javax.swing.JLabel();
        jTextFieldCodigoCategoriaPuxada = new javax.swing.JTextField();
        jButtonConsultaCategoria = new javax.swing.JButton();
        jTextFieldCategoria = new javax.swing.JTextField();
        jLabelTempo = new javax.swing.JLabel();
        jTextFieldTempo = new javax.swing.JTextField();
        jLabelStatusNovo = new javax.swing.JLabel();
        jComboBoxStatusNovo = new javax.swing.JComboBox();
        jButtonConsultaPuxada = new javax.swing.JButton();
        jLabelCompeticao = new javax.swing.JLabel();
        jTextFieldCompeticaoNome = new javax.swing.JTextField();
        jTextFieldCodigoCompeticao = new javax.swing.JTextField();
        jButtonConsultaCompeticao = new javax.swing.JButton();
        jLabelPuxada = new javax.swing.JLabel();
        jTextFieldnPuxada = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonCancelarPuxada = new javax.swing.JButton();
        jButtonConfirmarPuxada = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTextFieldCodigoCompetidor.setToolTipText("");
        jTextFieldCodigoCompetidor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoCompetidorFocusLost(evt);
            }
        });

        jTextFieldCodigo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldCodigo.setToolTipText("\"Código da Puxada\"");
        jTextFieldCodigo.setEnabled(false);

        jButtonConsultaCompetidor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/botaoconsulta.png"))); // NOI18N
        jButtonConsultaCompetidor.setToolTipText("\"Consultar Competidor.\"");
        jButtonConsultaCompetidor.setFocusable(false);
        jButtonConsultaCompetidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaCompetidorActionPerformed(evt);
            }
        });

        jLabelCompetidor.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelCompetidor.setText("Competidor:");

        jLabelCodigo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelCodigo.setText("Puxada:");

        jTextFieldCompetidor.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldCompetidor.setEnabled(false);

        jLabelCategoria.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelCategoria.setText("Categoria:");

        jTextFieldCodigoCategoriaPuxada.setToolTipText("");
        jTextFieldCodigoCategoriaPuxada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoCategoriaPuxadaFocusLost(evt);
            }
        });

        jButtonConsultaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/botaoconsulta.png"))); // NOI18N
        jButtonConsultaCategoria.setToolTipText("\"Consultar Categoria.\"");
        jButtonConsultaCategoria.setFocusable(false);
        jButtonConsultaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaCategoriaActionPerformed(evt);
            }
        });

        jTextFieldCategoria.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldCategoria.setEnabled(false);

        jLabelTempo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelTempo.setText("Tempo:");

        jTextFieldTempo.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldTempo.setEnabled(false);

        jLabelStatusNovo.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelStatusNovo.setText("Status:");

        jComboBoxStatusNovo.setFont(new java.awt.Font("Tahoma", 1, 10));
        jComboBoxStatusNovo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Largada Queimada", "Desclassificado", "Sem Competidor" }));
        jComboBoxStatusNovo.setFocusable(false);

        jButtonConsultaPuxada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/botaoconsulta.png"))); // NOI18N
        jButtonConsultaPuxada.setToolTipText("\"Consultar Puxadas.\"");
        jButtonConsultaPuxada.setFocusable(false);
        jButtonConsultaPuxada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaPuxadaActionPerformed(evt);
            }
        });

        jLabelCompeticao.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelCompeticao.setText("Competição:");

        jTextFieldCompeticaoNome.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldCompeticaoNome.setEnabled(false);
        jTextFieldCompeticaoNome.setFocusable(false);

        jTextFieldCodigoCompeticao.setToolTipText("F12 para consultar Categoria");
        jTextFieldCodigoCompeticao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoCompeticaoFocusLost(evt);
            }
        });

        jButtonConsultaCompeticao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/botaoconsulta.png"))); // NOI18N
        jButtonConsultaCompeticao.setToolTipText("\"Consultar Categoria.\"");
        jButtonConsultaCompeticao.setFocusable(false);
        jButtonConsultaCompeticao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaCompeticaoActionPerformed(evt);
            }
        });

        jLabelPuxada.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabelPuxada.setText("Nº Puxada:");

        jTextFieldnPuxada.setBackground(new java.awt.Color(255, 255, 204));
        jTextFieldnPuxada.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabelCodigo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelCategoria)
                                    .addComponent(jLabelCompetidor)
                                    .addComponent(jLabelStatusNovo)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCompeticao)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodigoCompetidor, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodigoCategoriaPuxada, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jTextFieldCodigoCompeticao, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButtonConsultaPuxada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButtonConsultaCompetidor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButtonConsultaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButtonConsultaCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelTempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCompeticaoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCompetidor, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jComboBoxStatusNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPuxada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldnPuxada, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCodigo)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTempo))
                    .addComponent(jButtonConsultaPuxada, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCompetidor)
                        .addComponent(jTextFieldCodigoCompetidor, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addComponent(jButtonConsultaCompetidor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCompetidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCategoria)
                        .addComponent(jTextFieldCodigoCategoriaPuxada))
                    .addComponent(jButtonConsultaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConsultaCompeticao, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCodigoCompeticao)
                        .addComponent(jLabelCompeticao))
                    .addComponent(jTextFieldCompeticaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatusNovo)
                    .addComponent(jComboBoxStatusNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPuxada)
                    .addComponent(jTextFieldnPuxada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonCancelarPuxada.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButtonCancelarPuxada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/15.png"))); // NOI18N
        jButtonCancelarPuxada.setText("Cancelar");
        jButtonCancelarPuxada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarPuxadaActionPerformed(evt);
            }
        });

        jButtonConfirmarPuxada.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButtonConfirmarPuxada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/14.png"))); // NOI18N
        jButtonConfirmarPuxada.setText("Confirmar");
        jButtonConfirmarPuxada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarPuxadaActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrancada.Imagens/06.png"))); // NOI18N
        jButtonCancelar.setText("Fechar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonConfirmarPuxada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelarPuxada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmarPuxada)
                    .addComponent(jButtonCancelarPuxada)
                    .addComponent(jButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   
        // Prenche os campos ao iniciar
        if((evt.getOppositeWindow() instanceof Puxada)||(evt.getOppositeWindow() instanceof PuxadaG))
        {
         preencherDadosPuxada();
        }
         // Se for a tela de delete inibe oc campos do código de categoria,competidor e competicao
         if((opcao == "1"))
         {
             jTextFieldCodigoCompetidor.setEnabled(false);
             jTextFieldCodigoCategoriaPuxada.setEnabled(false);
             jTextFieldCodigoCompeticao.setEnabled(false);
            
         
        }else{
             jTextFieldCodigoCompetidor.setEnabled(true);
             jTextFieldCodigoCategoriaPuxada.setEnabled(true);
             jTextFieldCodigoCompeticao.setEnabled(true); 
        }
        
    }//GEN-LAST:event_formWindowActivated

    private void jButtonConsultaCompetidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaCompetidorActionPerformed
    
    ConsultaCompetidor consultaCompetidor = new ConsultaCompetidor(null, true);
    consultaCompetidor.setVisible(true);
    if(consultaCompetidor.codigo !=-1)
    {
    jTextFieldCodigoCompetidor.setText(Integer.toString(consultaCompetidor.codigo));
    jTextFieldCompetidor.setText(consultaCompetidor.nome);
    jTextFieldCodigoCompetidor.transferFocus();
    }
    
    }//GEN-LAST:event_jButtonConsultaCompetidorActionPerformed

    private void jButtonConsultaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaCategoriaActionPerformed
        ConsultaCategoria consultaCategoria = new ConsultaCategoria(null, true);
        consultaCategoria.setVisible(true);
        if(consultaCategoria.codigo !=-1)
        {
        jTextFieldCodigoCategoriaPuxada.setText(Integer.toString(consultaCategoria.codigo));
        jTextFieldCategoria.setText(consultaCategoria.nome);
        jTextFieldCodigoCategoriaPuxada.transferFocus();       
        }
                
    }//GEN-LAST:event_jButtonConsultaCategoriaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
       
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonConsultaPuxadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaPuxadaActionPerformed
        // TODO add your handling code here:
        ConsultaPuxada consultapuxada = new ConsultaPuxada(null,true);
        consultapuxada.setTitle("Consulta Puxada");consultapuxada.setVisible(true);
        if(consultapuxada.codigo !=-1)
        {
         codigopuxada=Integer.toString(consultapuxada.codigo);  
        preencherDadosPuxada();
         jTextFieldCodigo.transferFocus();
        }
    
}//GEN-LAST:event_jButtonConsultaPuxadaActionPerformed

    private void jButtonConsultaCompeticaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaCompeticaoActionPerformed
      ConsultaCompeticao consultacompeticao = new ConsultaCompeticao(null,true);
      consultacompeticao.setTitle("Consulta Competição");consultacompeticao.setVisible(true);
      
        if(consultacompeticao.codigo!=-1)
        {
         jTextFieldCodigoCompeticao.setText(Integer.toString(consultacompeticao.codigo));
          jTextFieldCompeticaoNome.setText(consultacompeticao.nome);
          jTextFieldCompeticaoNome.transferFocus();
          preencherDadosPuxada();
        }
}//GEN-LAST:event_jButtonConsultaCompeticaoActionPerformed

    private void jButtonConfirmarPuxadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarPuxadaActionPerformed
        // Atualizando Puxada
       
     if(this.getTitle().equals("Alteração de Puxada")){
         
        
     int i = servico.updatePuxada(Integer.parseInt(jTextFieldCodigo.getText()),Integer.parseInt(jTextFieldCodigoCompetidor.getText()),Integer.parseInt(jTextFieldCodigoCompeticao.getText()),Integer.parseInt(jTextFieldCodigoCategoriaPuxada.getText()),jTextFieldTempo.getText(),(String)jComboBoxStatusNovo.getSelectedItem(),Integer.parseInt(jTextFieldnPuxada.getText()));
     if( i == 1) 
     {
      JOptionPane.showMessageDialog(null, "Puxada Alterada com Sucesso", "Menssagem do Programa", JOptionPane.INFORMATION_MESSAGE);       
      limpar();
      jTextFieldCodigo.setText("");
        
     }else{
       JOptionPane.showMessageDialog(null, "Código da Puxada não encontrado no banco para efetuar alteração.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);  
        limpar();
        jTextFieldCodigo.setText("");
     }
     }
     else if(this.getTitle().equals("Exclusão de Puxada"))
     {
        //Deletando puxada
       int i = servico.deletePuxada(Integer.parseInt(jTextFieldCodigo.getText()));
       
       if( i == 0)
       {
         JOptionPane.showMessageDialog(null, "Puxada Excluída com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);   
          limpar(); 
       jTextFieldCodigo.setText("");
       }
       else{
        JOptionPane.showMessageDialog(null, "Código da Puxada não encontrado no banco para efetuar Exclusão.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
       limpar(); 
       jTextFieldCodigo.setText("");
       } 
     }
     
        
}//GEN-LAST:event_jButtonConfirmarPuxadaActionPerformed

    private void jButtonCancelarPuxadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarPuxadaActionPerformed
        //Deletando puxada
//       int i = servico.deletePuxada(Integer.parseInt(jTextFieldCodigo.getText()));
//       
//       if( i == 0)
//       {
//         JOptionPane.showMessageDialog(null, "Puxada Excluída com Sucesso", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);   
//          limpar(); 
//       jTextFieldCodigo.setText("");
//       }
//       else{
//        JOptionPane.showMessageDialog(null, "Código da Puxada não encontrado no banco para efetuar Exclusão.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
//       limpar(); 
//       jTextFieldCodigo.setText("");
//       }
//       
        limpar();
      
       
        
}//GEN-LAST:event_jButtonCancelarPuxadaActionPerformed

    private void jTextFieldCodigoCompetidorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCompetidorFocusLost
        try {

            //jTextFieldCodigoCompetidor //jTextFieldCompetidor
            ResultSet rs = servico.selectCompetidor(jTextFieldCodigoCompetidor.getText(),"","","11");
            if ((rs.next() == false) || (rs == null)) {
                jTextFieldCodigo.setEditable(true);
                jTextFieldCodigo.requestFocus();
                JOptionPane.showMessageDialog(null, "Código não Encontrado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                jTextFieldCompetidor.setText(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de banco", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jTextFieldCodigoCompetidorFocusLost

    private void jTextFieldCodigoCategoriaPuxadaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCategoriaPuxadaFocusLost
    // jTextFieldCodigoCategoriaPuxada //jTextFieldCategoria
         try {

            //jTextFieldCodigoCompetidor //jTextFieldCompetidor
            ResultSet rs = servico.selectCategoria(jTextFieldCodigoCategoriaPuxada.getText(),"3");
            if ((rs.next() == false) || (rs == null)) {
                jTextFieldCodigoCategoriaPuxada.setEditable(true);
                jTextFieldCodigoCategoriaPuxada.requestFocus();
                JOptionPane.showMessageDialog(null, "Código não Encontrado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                jTextFieldCategoria.setText(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de banco", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jTextFieldCodigoCategoriaPuxadaFocusLost

    private void jTextFieldCodigoCompeticaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCompeticaoFocusLost
        try {
              
            
        
            ResultSet rs = servico.selectCompeticao(jTextFieldCodigoCompeticao.getText(),"5");
            if ((rs.next() == false) || (rs == null)) {
                jTextFieldCodigoCompeticao.setEditable(true);
                jTextFieldCodigoCompeticao.requestFocus();
                JOptionPane.showMessageDialog(null, "Código não Encontrado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            } else {
                jTextFieldCompeticaoNome.setText(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de banco", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jTextFieldCodigoCompeticaoFocusLost
    
    private void preencherDadosPuxada()
  {
        try {

            ResultSet rs = servico.selectPuxada(codigopuxada,"","","8");
            if ((rs.next() == false) || (rs == null)) {
                jTextFieldCodigo.setEditable(true);
                jTextFieldCodigo.requestFocus();
                JOptionPane.showMessageDialog(null, "Código não Encontrado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                
            }
            else
            {
            String zeros = "0000" + codigopuxada.trim();
            jTextFieldCodigo.setText(zeros.substring(zeros.length() - 4));
            //jTextFieldCodigo.setText(codigopuxada)   ;
            jTextFieldCodigoCompetidor.setText(rs.getString(2)) ;
            jTextFieldCodigoCategoriaPuxada.setText(rs.getString(3));
            jTextFieldCodigoCompeticao.setText(rs.getString(4));        
            jTextFieldCompetidor.setText(rs.getString(7));
            jTextFieldCategoria.setText(rs.getString(6));    
            jTextFieldCompeticaoNome.setText(rs.getString(5));
            jTextFieldTempo.setText(rs.getString(8));
            jTextFieldnPuxada.setText(rs.getString(10));
            setStatus(rs.getString(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciaPuxada.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GerenciaPuxada dialog = new GerenciaPuxada(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarPuxada;
    private javax.swing.JButton jButtonConfirmarPuxada;
    private javax.swing.JButton jButtonConsultaCategoria;
    private javax.swing.JButton jButtonConsultaCompeticao;
    private javax.swing.JButton jButtonConsultaCompetidor;
    private javax.swing.JButton jButtonConsultaPuxada;
    private javax.swing.JComboBox jComboBoxStatusNovo;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelCompeticao;
    private javax.swing.JLabel jLabelCompetidor;
    private javax.swing.JLabel jLabelPuxada;
    private javax.swing.JLabel jLabelStatusNovo;
    private javax.swing.JLabel jLabelTempo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCategoria;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldCodigoCategoriaPuxada;
    private javax.swing.JTextField jTextFieldCodigoCompeticao;
    private javax.swing.JTextField jTextFieldCodigoCompetidor;
    private javax.swing.JTextField jTextFieldCompeticaoNome;
    private javax.swing.JTextField jTextFieldCompetidor;
    private javax.swing.JTextField jTextFieldTempo;
    private javax.swing.JTextField jTextFieldnPuxada;
    // End of variables declaration//GEN-END:variables
    
public static String codigopuxada ="";
ServicoBDAO servico = new ServicoBDAO();
public static String opcao ="";

public void setStatus(String status)
{
if(status.equalsIgnoreCase("Normal"))
{
   jComboBoxStatusNovo.setSelectedIndex(0);

}
else if(status.equalsIgnoreCase("Largada Queimada"))
{
jComboBoxStatusNovo.setSelectedIndex(1);
}
else if(status.equalsIgnoreCase("Queimada"))
{
jComboBoxStatusNovo.setSelectedIndex(1);
}

else if(status.equalsIgnoreCase("Desclassificado"))
{
jComboBoxStatusNovo.setSelectedIndex(2);
}
else if(status.equalsIgnoreCase("Sem Competidor"))
{
jComboBoxStatusNovo.setSelectedIndex(3);
}
else if(status.equalsIgnoreCase(""))
{
jComboBoxStatusNovo.setSelectedIndex(0);
}

}


public void enableCombobox(int estado)
{
    if(estado == 0)
    {
    jComboBoxStatusNovo.setEnabled(false);
    }
    else
    {
      jComboBoxStatusNovo.setEnabled(true);  
    }
  
}


// Limpa os campos do formulario.
public void limpar()
{
    jTextFieldCodigoCompetidor.setText("");
    jTextFieldCodigoCategoriaPuxada.setText("");
    jTextFieldCodigoCompeticao.setText("");        
    jTextFieldCompetidor.setText("");
    jTextFieldCategoria.setText("");    
    jTextFieldCompeticaoNome.setText("");
    jTextFieldTempo.setText("");
    jTextFieldnPuxada.setText("");
    setStatus("");
}


   private void centralizar(){  
      /* Função para centralizar janela na tela */  
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
       Dimension frameSize = getSize();  
       setLocation(new Point((screenSize.width - frameSize.width) / 2,  
                             (screenSize.height - frameSize.width) / 2));  
    }

   
}
