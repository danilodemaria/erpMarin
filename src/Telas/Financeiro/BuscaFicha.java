/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.Financeiro;

import BackEnd.Database;
import Telas.Pedidos.ExibePedidos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administração
 */
public class BuscaFicha extends javax.swing.JFrame {

    /**
     * Creates new form BuscaFicha
     */
    Database banco = new Database();

    public BuscaFicha() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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
        Color minhaCor = new Color(204, 255, 204);
        this.getContentPane().setBackground(minhaCor);
        atualizaTabela();
        createKeybindings(tabelaBusca);
    }

    public void atualizaTabela() {
        ResultSet rs = banco.buscaFichas();
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableModel model = (DefaultTableModel) tabelaBusca.getModel();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaBusca.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tabelaBusca.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabelaBusca.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabelaBusca.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tabelaBusca.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id"), rs.getString("titular"), rs.getString("num_ficha"), sfd.format(rs.getDate("datain")), rs.getString("total")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExibePedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tabela_IDMousePressed(java.awt.event.MouseEvent evt) throws SQLException {
        int a = tabelaBusca.getSelectedRow();
        ResultSet rs = null;
        String id = (String) tabelaBusca.getValueAt(a, 0);
        rs = banco.buscaFichaHospede(id);
        ExibeFicha b = null;
        try {
            b = new ExibeFicha(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaFicha.class.getName()).log(Level.SEVERE, null, ex);
        }
        b.setVisible(true);
    }

    private void createKeybindings(JTable table) {
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        table.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    tabela_IDMousePressed(null);
                } catch (SQLException ex) {
                    Logger.getLogger(BuscaFicha.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaBusca = new javax.swing.JTable();
        buttonVisualiza = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca Ficha");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Fichas de Hóspedes");

        tabelaBusca.setBackground(new java.awt.Color(102, 255, 204));
        tabelaBusca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabelaBusca.setForeground(new java.awt.Color(0, 0, 255));
        tabelaBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Hóspede", "Nº Ficha", "Data Entrada", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaBuscaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaBusca);
        if (tabelaBusca.getColumnModel().getColumnCount() > 0) {
            tabelaBusca.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaBusca.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabelaBusca.getColumnModel().getColumn(2).setPreferredWidth(10);
            tabelaBusca.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabelaBusca.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        buttonVisualiza.setText("Visualizar");
        buttonVisualiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonVisualizaMouseClicked(evt);
            }
        });

        buttonSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonVisualiza))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVisualiza)
                    .addComponent(buttonSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaBuscaMouseClicked
        // TODO add your handling code here:
        ResultSet rs = null;
        if (evt.getClickCount() == 2) {
            int a = tabelaBusca.getSelectedRow();
            String id = (String) tabelaBusca.getValueAt(a, 0);

            id = String.valueOf(tabelaBusca.getValueAt(a, 0));

            rs = banco.buscaFichaHospede(id);
            ExibeFicha b = null;
            try {
                b = new ExibeFicha(rs);
            } catch (SQLException ex) {
                Logger.getLogger(BuscaFicha.class.getName()).log(Level.SEVERE, null, ex);
            }
            b.setVisible(true);

        }

    }//GEN-LAST:event_tabelaBuscaMouseClicked

    private void buttonVisualizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVisualizaMouseClicked
        // TODO add your handling code here:
        ResultSet rs = null;
        int linha = 0;
        String id = "";
        linha = tabelaBusca.getSelectedRow();

        id = String.valueOf(tabelaBusca.getValueAt(linha, 0));

        rs = banco.buscaFichaHospede(id);
        ExibeFicha a = null;
        try {
            a = new ExibeFicha(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaFicha.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.setVisible(true);
    }//GEN-LAST:event_buttonVisualizaMouseClicked

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
            java.util.logging.Logger.getLogger(BuscaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaFicha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonVisualiza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaBusca;
    // End of variables declaration//GEN-END:variables
}
