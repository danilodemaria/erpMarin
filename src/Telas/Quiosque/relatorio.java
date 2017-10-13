/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.Quiosque;

import BackEnd.Database;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Administração
 */
public class relatorio extends javax.swing.JFrame {

    /**
     * Creates new form relatorio
     */
    MaskFormatter mascaracpf;

    private ArrayList<Object> id = new ArrayList<>();
    private ArrayList<Object> nome = new ArrayList<>();
    private ArrayList<Object> quantidade = new ArrayList<>();
    private ArrayList<Object> valor_total = new ArrayList<>();
    private double valorFinalTotal = 0;

    public relatorio() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        dataInicio.requestFocus();
        dataInicio.setSelectionStart(0);
        dataInicio.setSelectionEnd(dataInicio.getText().length());
        dataInicio.setText(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
        dataFinal.setText(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        
        URL url1 = this.getClass().getResource("/Imagens/02.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url1);
        this.setIconImage(iconeTitulo);
        Color minhaCor = new Color(204,255,204);
        this.getContentPane().setBackground(minhaCor);
    }

    public boolean fechar() {
        this.dispose();
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dataInicio = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        buscarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_ID = new javax.swing.JTable();
        sair = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        valor_total_diario = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Produtos Vendidos - Externo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Relatório Externo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Data Inicial");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Data Final");

        try{
            mascaracpf = new MaskFormatter("##/##/####");
            mascaracpf.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}

        dataInicio  = new JFormattedTextField(mascaracpf);
        dataInicio.setCaretPosition(0);
        dataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataInicioActionPerformed(evt);
            }
        });

        try{
            mascaracpf = new MaskFormatter("##/##/####");
            mascaracpf.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}

        dataFinal  = new JFormattedTextField(mascaracpf);
        dataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataFinalActionPerformed(evt);
            }
        });

        buscarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscarButton.setText("Buscar");
        buscarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarButtonMouseClicked(evt);
            }
        });

        tabela_ID.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tabela_ID);

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sair.png"))); // NOI18N
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Valor Total R$ ");

        valor_total_diario.setEditable(false);
        valor_total_diario.setForeground(new java.awt.Color(255, 0, 0));
        valor_total_diario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valor_total_diario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valor_total_diarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(sair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valor_total_diario, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(valor_total_diario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(sair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButtonMouseClicked
        Database a = new Database();
        ResultSet rs = null;
        DecimalFormat formatoDois2 = new DecimalFormat("R$ ##,###,###,###,##0.00", new DecimalFormatSymbols (new Locale("pt","BR")));
        formatoDois2.setMinimumFractionDigits(2);
        formatoDois2.setParseBigDecimal(true);
        double aux=0;
        String aux1=null;
        double total=0;
        try {
            rs = a.buscaRelatorio(dataInicio.getText(), dataFinal.getText());
        } catch (ParseException ex) {
            Logger.getLogger(relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                id.add(rs.getInt("id"));
                nome.add(rs.getString("nome"));
                quantidade.add(rs.getString("quantidade"));
                aux=rs.getDouble("valor_total");
                total=total+aux;
                aux1=formatoDois2.format(aux);
                valor_total.add(aux1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabela_ID.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabela_ID.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabela_ID.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabela_ID.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        DefaultTableModel model = (DefaultTableModel) tabela_ID.getModel();
        String concatena;
        for (int i = 0; i < id.size(); i++) {
            model.addRow(new Object[]{id.get(i), nome.get(i), quantidade.get(i), valor_total.get(i)});
        }   

        valor_total_diario.setText(String.valueOf(formatoDois2.format(total)));
    }//GEN-LAST:event_buscarButtonMouseClicked

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairMouseClicked

    private void dataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataInicioActionPerformed
        // TODO add your handling code here:
        dataFinal.requestFocus();
    }//GEN-LAST:event_dataInicioActionPerformed

    private void dataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataFinalActionPerformed
        // TODO add your handling code here:
        buscarButtonMouseClicked(null);
    }//GEN-LAST:event_dataFinalActionPerformed

    private void valor_total_diarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valor_total_diarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valor_total_diarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sair;
    public javax.swing.JTable tabela_ID;
    private javax.swing.JFormattedTextField valor_total_diario;
    // End of variables declaration//GEN-END:variables
}
