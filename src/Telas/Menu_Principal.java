package Telas;

import BackEnd.AplicaNimbusLookAndFeel;
import Telas.Quiosque.exibeProdutos;
import Telas.Quiosque.cadastrar;
import Telas.Financeiro.Relatorio_Financeiro;
import Telas.Financeiro.Financeiro_Cadastrar_Ficha;
import Telas.Cartao.Cartao_Cielo;
import Telas.Cartao.Cartao_Rede;
import Funcionarios.Cadastra;
import Funcionarios.CadastraFolga;
import Funcionarios.ExibeFolgas;
import Funcionarios.Extras;
import Funcionarios.Lancamento;
import Telas.Agenda.CadastrarAgenda;
import Telas.Agenda.VisualizaAgenda;
import Telas.Cartao.Cartao_Amex;
import Telas.Cartao.Cartao_Cielo_Parcelado;
import Telas.Cartao.Cartoes_Booking;
import Telas.Financeiro.BuscaFicha;
import Telas.Financeiro.Faturamento_Entrada;
import Telas.Financeiro.Faturamento_Saida;
import Telas.Financeiro.Faturamento_Total;
import Telas.Financeiro.Visualiza_Faturamento_Entrada;
import Telas.Financeiro.Visualiza_Faturamento_Saida;
import Telas.Manutencao.CadastraManutencao;
import Telas.Manutencao.ExibeManuConcluidas;
import Telas.Manutencao.ExibeManutencoes;
import Telas.Pedidos.ExibePedidos;
import Telas.Pedidos.NovoPedido;
import Telas.Quiosque.LancaInterno;
import Telas.Quiosque.estoquePorcoes;
import Telas.Quiosque.lancamento;
import Telas.Quiosque.relatorio;
import Telas.Quiosque.relatorioInterno;
import Telas.Quiosque.relatorioProduto;
import Telas.Quiosque.relatorioProdutoInterno;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author amdemassh
 */
public class Menu_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Principal
     */
    public Menu_Principal() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        initComponents();
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);      
        alteraIcone();
        AplicaNimbusLookAndFeel.pegaNimbus();
        Color minhaCor = new Color(204,255,204);
        this.getContentPane().setBackground(minhaCor);
        labelFundo.setDropTarget(null);
    }

    public boolean fechar() {
        int resp = 0;
        resp = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
            return true;
        } else {
            return false;
        }

    }

    public void alteraIcone() {
        URL url1 = this.getClass().getResource("/Imagens/02.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url1);
        this.setIconImage(iconeTitulo);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        labelFundo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFinanceiro = new javax.swing.JMenu();
        menuCadastraFicha = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuFaturaEntrada = new javax.swing.JMenuItem();
        menuFaturaSaida = new javax.swing.JMenuItem();
        menuFaturaTotal = new javax.swing.JMenuItem();
        menuVisualizaEntrada = new javax.swing.JMenuItem();
        menuVisualizaSaida = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        menuQuiosque = new javax.swing.JMenu();
        menuCadastraProduto = new javax.swing.JMenuItem();
        menuComandaExt = new javax.swing.JMenuItem();
        menuComandaInt = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenuItem();
        menuRelatorioGeralExt = new javax.swing.JMenuItem();
        menuRelatorioGeralInt = new javax.swing.JMenuItem();
        menuRelatorioExt = new javax.swing.JMenuItem();
        menuRelatorioInt = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuCartao = new javax.swing.JMenu();
        menuRede = new javax.swing.JMenuItem();
        menuCielo = new javax.swing.JMenuItem();
        menuAmex = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuFuncionarios = new javax.swing.JMenu();
        menuCadastraFuncionario = new javax.swing.JMenuItem();
        menuCadastraSalario = new javax.swing.JMenuItem();
        menuRelatoriosFuncionarios = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuPedidos = new javax.swing.JMenu();
        menuCadastraPedido = new javax.swing.JMenuItem();
        menuVisualizaPedidos = new javax.swing.JMenuItem();
        menuManutencao = new javax.swing.JMenu();
        menuCadastraManutencao = new javax.swing.JMenuItem();
        menuVisualizaManutencao = new javax.swing.JMenuItem();
        menuManuConcluidas = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem11.setText("jMenuItem11");

        setTitle("Hotel Marin Château - V.1.0");

        labelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundo.jpg"))); // NOI18N

        menuFinanceiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Paper_Money_32px.png"))); // NOI18N
        menuFinanceiro.setText("Financeiro");
        menuFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFinanceiroActionPerformed(evt);
            }
        });

        menuCadastraFicha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuCadastraFicha.setText("Cadastrar Ficha");
        menuCadastraFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastraFichaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuCadastraFicha);

        menuRelatorio.setText("Relatórios");
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuRelatorio);

        jMenuItem4.setText("Visualiza Fichas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuFinanceiro.add(jMenuItem4);

        menuFaturaEntrada.setText("Faturamento (Entrada)");
        menuFaturaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFaturaEntradaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuFaturaEntrada);

        menuFaturaSaida.setText("Faturamento (Saída)");
        menuFaturaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFaturaSaidaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuFaturaSaida);

        menuFaturaTotal.setText("Faturamento (Total)");
        menuFaturaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFaturaTotalActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuFaturaTotal);

        menuVisualizaEntrada.setText("Visualizar Faturamento (Entrada)");
        menuVisualizaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizaEntradaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuVisualizaEntrada);

        menuVisualizaSaida.setText("Visualizar Faturamento (Saída)");
        menuVisualizaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizaSaidaActionPerformed(evt);
            }
        });
        menuFinanceiro.add(menuVisualizaSaida);

        jMenuItem14.setText("CheckIn Online");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        menuFinanceiro.add(jMenuItem14);

        jMenuBar1.add(menuFinanceiro);

        menuQuiosque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Coconut_Cocktail_32px.png"))); // NOI18N
        menuQuiosque.setText("Quiosque");

        menuCadastraProduto.setText("Cadastrar Produto");
        menuCadastraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastraProdutoActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuCadastraProduto);

        menuComandaExt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        menuComandaExt.setText("Lançar Comanda (Ext)");
        menuComandaExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuComandaExtActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuComandaExt);

        menuComandaInt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        menuComandaInt.setText("Lançar Comanda (Int)");
        menuComandaInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuComandaIntActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuComandaInt);

        menuProdutos.setText("Exibir Produtos");
        menuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutosActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuProdutos);

        menuRelatorioGeralExt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        menuRelatorioGeralExt.setText("Relatório Geral (Ext)");
        menuRelatorioGeralExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioGeralExtActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuRelatorioGeralExt);

        menuRelatorioGeralInt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuRelatorioGeralInt.setText("Relatório Geral (Int)");
        menuRelatorioGeralInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioGeralIntActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuRelatorioGeralInt);

        menuRelatorioExt.setText("Relatório Por Produto (Ext)");
        menuRelatorioExt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioExtActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuRelatorioExt);

        menuRelatorioInt.setText("Relatório Por Produto (Int)");
        menuRelatorioInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioIntActionPerformed(evt);
            }
        });
        menuQuiosque.add(menuRelatorioInt);

        jMenuItem3.setText("Controle Entrada Porções");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuQuiosque.add(jMenuItem3);

        jMenuBar1.add(menuQuiosque);

        menuCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Card_Payment_32px.png"))); // NOI18N
        menuCartao.setText("Cartão");

        menuRede.setText("Rede");
        menuRede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRedeActionPerformed(evt);
            }
        });
        menuCartao.add(menuRede);

        menuCielo.setText("Cielo");
        menuCielo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCieloActionPerformed(evt);
            }
        });
        menuCartao.add(menuCielo);

        menuAmex.setText("Amex");
        menuAmex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAmexActionPerformed(evt);
            }
        });
        menuCartao.add(menuAmex);

        jMenuItem5.setText("Booking");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuCartao.add(jMenuItem5);

        jMenuItem7.setText("Cielo Parcelado");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuCartao.add(jMenuItem7);

        jMenuBar1.add(menuCartao);

        menuFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Business_Building_32px.png"))); // NOI18N
        menuFuncionarios.setText("Funcionários");

        menuCadastraFuncionario.setText("Cadastrar Funcionário");
        menuCadastraFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastraFuncionarioActionPerformed(evt);
            }
        });
        menuFuncionarios.add(menuCadastraFuncionario);

        menuCadastraSalario.setText("Cadastrar Salário");
        menuCadastraSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastraSalarioActionPerformed(evt);
            }
        });
        menuFuncionarios.add(menuCadastraSalario);

        menuRelatoriosFuncionarios.setText("Cadastrar Folga");
        menuRelatoriosFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatoriosFuncionariosActionPerformed(evt);
            }
        });
        menuFuncionarios.add(menuRelatoriosFuncionarios);

        jMenuItem6.setText("Exibir Folgas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuFuncionarios.add(jMenuItem6);

        jMenuItem8.setText("Extras");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuFuncionarios.add(jMenuItem8);

        jMenuBar1.add(menuFuncionarios);

        menuPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Shopping_Cart_32px.png"))); // NOI18N
        menuPedidos.setText("Pedidos");

        menuCadastraPedido.setText("Cadastrar Pedido");
        menuCadastraPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastraPedidoActionPerformed(evt);
            }
        });
        menuPedidos.add(menuCadastraPedido);

        menuVisualizaPedidos.setText("Visualizar Pedidos");
        menuVisualizaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizaPedidosActionPerformed(evt);
            }
        });
        menuPedidos.add(menuVisualizaPedidos);

        jMenuBar1.add(menuPedidos);

        menuManutencao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Maintenance_32px.png"))); // NOI18N
        menuManutencao.setText("Manutenção");

        menuCadastraManutencao.setText("Cadastrar Manutenção");
        menuCadastraManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastraManutencaoActionPerformed(evt);
            }
        });
        menuManutencao.add(menuCadastraManutencao);

        menuVisualizaManutencao.setText("Não Concluídas");
        menuVisualizaManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVisualizaManutencaoActionPerformed(evt);
            }
        });
        menuManutencao.add(menuVisualizaManutencao);

        menuManuConcluidas.setText("Concluídas");
        menuManuConcluidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuManuConcluidasActionPerformed(evt);
            }
        });
        menuManutencao.add(menuManuConcluidas);

        jMenuBar1.add(menuManutencao);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Phone_32px.png"))); // NOI18N
        jMenu1.setText("Agenda");

        jMenuItem10.setText("Cadastrar");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem12.setText("Visualizar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuItem13.setText("Editar");
        jMenu1.add(jMenuItem13);

        jMenuBar1.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Shutdown_32px.png"))); // NOI18N
        jMenu5.setText("Sair");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelFundo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
        fechar();
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void menuCadastraFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastraFichaActionPerformed
        // TODO add your handling code here:
        Financeiro_Cadastrar_Ficha ficha = new Financeiro_Cadastrar_Ficha();
        ficha.setVisible(true);
    }//GEN-LAST:event_menuCadastraFichaActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        fechar();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void menuRelatorioGeralExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioGeralExtActionPerformed
        // TODO add your handling code here:
        relatorio telaRelatorio = new relatorio();
        telaRelatorio.setVisible(true);
    }//GEN-LAST:event_menuRelatorioGeralExtActionPerformed

    private void menuComandaExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuComandaExtActionPerformed
        // TODO add your handling code here:
        lancamento telaLancamento = new lancamento();
        telaLancamento.setVisible(true);
    }//GEN-LAST:event_menuComandaExtActionPerformed

    private void menuCadastraFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastraFuncionarioActionPerformed
        // TODO add your handling code here:
        Cadastra funcionario = new Cadastra();
        funcionario.setVisible(true);
    }//GEN-LAST:event_menuCadastraFuncionarioActionPerformed

    private void menuRedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRedeActionPerformed
        // TODO add your handling code here:
        Cartao_Rede card = new Cartao_Rede();
        card.setVisible(true);
    }//GEN-LAST:event_menuRedeActionPerformed

    private void menuCieloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCieloActionPerformed
        // TODO add your handling code here:
        Cartao_Cielo cardCielo = new Cartao_Cielo();
        cardCielo.setVisible(true);
    }//GEN-LAST:event_menuCieloActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        // TODO add your handling code here:
        Relatorio_Financeiro relatorio = new Relatorio_Financeiro();
        relatorio.setVisible(true);
    }//GEN-LAST:event_menuRelatorioActionPerformed

    private void menuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutosActionPerformed
        // TODO add your handling code here:
        exibeProdutos tela = null;
        try {
            tela = new exibeProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        tela.setVisible(true);

    }//GEN-LAST:event_menuProdutosActionPerformed

    private void menuCadastraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastraProdutoActionPerformed
        // TODO add your handling code here:
        cadastrar telaCadastro = new cadastrar();
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_menuCadastraProdutoActionPerformed

    private void menuRelatorioExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioExtActionPerformed
        // TODO add your handling code here:
        relatorioProduto telaProduto = new relatorioProduto();
        telaProduto.setVisible(true);
    }//GEN-LAST:event_menuRelatorioExtActionPerformed

    private void menuFaturaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFaturaEntradaActionPerformed
        // TODO add your handling code here:
        Faturamento_Entrada faturaEntrada = new Faturamento_Entrada();
        faturaEntrada.setVisible(true);
    }//GEN-LAST:event_menuFaturaEntradaActionPerformed

    private void menuFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFinanceiroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_menuFinanceiroActionPerformed

    private void menuFaturaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFaturaSaidaActionPerformed
        // TODO add your handling code here:
        Faturamento_Saida faturaSaida = new Faturamento_Saida();
        faturaSaida.setVisible(true);
    }//GEN-LAST:event_menuFaturaSaidaActionPerformed

    private void menuFaturaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFaturaTotalActionPerformed
        // TODO add your handling code here:
        Faturamento_Total faturaTotal = new Faturamento_Total();
        faturaTotal.setVisible(true);
    }//GEN-LAST:event_menuFaturaTotalActionPerformed

    private void menuVisualizaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizaEntradaActionPerformed
        // TODO add your handling code here:
        Visualiza_Faturamento_Entrada visualiza = null;
        try {
            visualiza = new Visualiza_Faturamento_Entrada();
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        visualiza.setVisible(true);
    }//GEN-LAST:event_menuVisualizaEntradaActionPerformed

    private void menuVisualizaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizaSaidaActionPerformed
        // TODO add your handling code here:
        Visualiza_Faturamento_Saida visualiza = null;
        try {
            visualiza = new Visualiza_Faturamento_Saida();
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        visualiza.setVisible(true);
    }//GEN-LAST:event_menuVisualizaSaidaActionPerformed

    private void menuCadastraSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastraSalarioActionPerformed
        // TODO add your handling code here:
        Lancamento funcionario = new Lancamento();
        funcionario.setVisible(true);
    }//GEN-LAST:event_menuCadastraSalarioActionPerformed

    private void menuCadastraPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastraPedidoActionPerformed
        // TODO add your handling code here:
        NovoPedido novo = new NovoPedido();
        novo.setVisible(true);                
    }//GEN-LAST:event_menuCadastraPedidoActionPerformed

    private void menuVisualizaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizaPedidosActionPerformed
        // TODO add your handling code here:
        ExibePedidos exibe = new ExibePedidos();
        exibe.setVisible(true);
    }//GEN-LAST:event_menuVisualizaPedidosActionPerformed

    private void menuComandaIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuComandaIntActionPerformed
        // TODO add your handling code here:
        LancaInterno a = new LancaInterno();
        a.setVisible(true);
    }//GEN-LAST:event_menuComandaIntActionPerformed

    private void menuRelatorioIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioIntActionPerformed
        // TODO add your handling code here:
        relatorioProdutoInterno a = new relatorioProdutoInterno();
        a.setVisible(true);
    }//GEN-LAST:event_menuRelatorioIntActionPerformed

    private void menuRelatorioGeralIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioGeralIntActionPerformed
        // TODO add your handling code here:
        relatorioInterno a = new relatorioInterno();
        a.setVisible(true);
    }//GEN-LAST:event_menuRelatorioGeralIntActionPerformed

    private void menuCadastraManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastraManutencaoActionPerformed
        // TODO add your handling code here:
        CadastraManutencao a = new CadastraManutencao();
        a.setVisible(true);
    }//GEN-LAST:event_menuCadastraManutencaoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        estoquePorcoes a = new estoquePorcoes();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuVisualizaManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVisualizaManutencaoActionPerformed
        // TODO add your handling code here:
        ExibeManutencoes a = new ExibeManutencoes();
        a.setVisible(true);
    }//GEN-LAST:event_menuVisualizaManutencaoActionPerformed

    private void menuManuConcluidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuManuConcluidasActionPerformed
        // TODO add your handling code here:
        ExibeManuConcluidas a = new ExibeManuConcluidas();
        a.setVisible(true);
    }//GEN-LAST:event_menuManuConcluidasActionPerformed


    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        BuscaFicha a = new BuscaFicha();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuAmexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAmexActionPerformed
        // TODO add your handling code here:
        Cartao_Amex card;
        card = new Cartao_Amex();
        card.setVisible(true);
    }//GEN-LAST:event_menuAmexActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Cartoes_Booking booking = new Cartoes_Booking();
        booking.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menuRelatoriosFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatoriosFuncionariosActionPerformed
        // TODO add your handling code here:
        CadastraFolga folga = new CadastraFolga();
        folga.setVisible(true);
    }//GEN-LAST:event_menuRelatoriosFuncionariosActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        ExibeFolgas a = new ExibeFolgas();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Cartao_Cielo_Parcelado a = new Cartao_Cielo_Parcelado();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        Extras a = new Extras();
        a.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        CadastrarAgenda a = new CadastrarAgenda();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        VisualizaAgenda a = new VisualizaAgenda();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        Menu a = new Menu();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed


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
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel labelFundo;
    private javax.swing.JMenuItem menuAmex;
    private javax.swing.JMenuItem menuCadastraFicha;
    private javax.swing.JMenuItem menuCadastraFuncionario;
    private javax.swing.JMenuItem menuCadastraManutencao;
    private javax.swing.JMenuItem menuCadastraPedido;
    private javax.swing.JMenuItem menuCadastraProduto;
    private javax.swing.JMenuItem menuCadastraSalario;
    private javax.swing.JMenu menuCartao;
    private javax.swing.JMenuItem menuCielo;
    private javax.swing.JMenuItem menuComandaExt;
    private javax.swing.JMenuItem menuComandaInt;
    private javax.swing.JMenuItem menuFaturaEntrada;
    private javax.swing.JMenuItem menuFaturaSaida;
    private javax.swing.JMenuItem menuFaturaTotal;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenu menuFuncionarios;
    private javax.swing.JMenuItem menuManuConcluidas;
    private javax.swing.JMenu menuManutencao;
    private javax.swing.JMenu menuPedidos;
    private javax.swing.JMenuItem menuProdutos;
    private javax.swing.JMenu menuQuiosque;
    private javax.swing.JMenuItem menuRede;
    private javax.swing.JMenuItem menuRelatorio;
    private javax.swing.JMenuItem menuRelatorioExt;
    private javax.swing.JMenuItem menuRelatorioGeralExt;
    private javax.swing.JMenuItem menuRelatorioGeralInt;
    private javax.swing.JMenuItem menuRelatorioInt;
    private javax.swing.JMenuItem menuRelatoriosFuncionarios;
    private javax.swing.JMenuItem menuVisualizaEntrada;
    private javax.swing.JMenuItem menuVisualizaManutencao;
    private javax.swing.JMenuItem menuVisualizaPedidos;
    private javax.swing.JMenuItem menuVisualizaSaida;
    // End of variables declaration//GEN-END:variables

}
