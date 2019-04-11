/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpmarin;

import Telas.Cartao.Cartoes_Booking;
import Telas.Menu_Principal;
import Telas.Quiosque.LancaInterno;
import java.awt.AWTException;
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author amdemassh
 */
public class ERPMarin {

    static Menu_Principal menu = new Menu_Principal();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        menu.setVisible(true);
        Login seguro = new Login();
        seguro.setVisible(true);
        menu.enable(false);

        aplicaSystem();

    }

    public static void aplicaSystem() {

        final TrayIcon trayIcon; // declarando uma constante do tipo TrayIcon

        // Aqui vamos testar se o recurso é suportado
        if (SystemTray.isSupported()) {
            //declarando uma variavel  do tipo SystemTray
            SystemTray tray = SystemTray.getSystemTray();
            //declarando uma variavel  do tipo Image que contera a imagem tray.gif
            java.awt.Image image = Toolkit.getDefaultToolkit().getImage(ERPMarin.class.getResource("/Imagens/02.png"));
            //Criamos um listener para escutar os eventos de mouse
            MouseListener mouseListener = new MouseListener() {
                public void mouseClicked(MouseEvent e) {

                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    //Toda vez que for clicado imprime uma mensagem na tela
                    menu.requestFocus();
                }

                public void mouseReleased(MouseEvent e) {

                }

            };

            // Criamos um ActionListener para a ação de encerramento do programa.
            ActionListener exitListener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            
             ActionListener cardBooking = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                     Cartoes_Booking booking = new Cartoes_Booking();
                    booking.setVisible(true);
                }
            };
             
             ActionListener quiosqueShort = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                     LancaInterno lanca= new LancaInterno();
                    lanca.setVisible(true);
                }
            };

    // Criamos um ActionListener para a exibir uma mensagem na tela ao clicarmos
            //em um item do menu.
            ActionListener mostramsglistener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    menu.setVisible(true);
                }
            };

            //Criando um objeto PopupMenu
            PopupMenu popup = new PopupMenu("Menu de Opções");

            //criando itens do menu
            MenuItem abrir = new MenuItem("Abrir");
            MenuItem cartao = new MenuItem("Booking Card");
            MenuItem quiosque = new MenuItem("Lança Interno");

            MenuItem sair = new MenuItem("Sair");

            //na linha a seguir associamos os objetos aos eventos
            abrir.addActionListener(mostramsglistener);

            sair.addActionListener(exitListener);
            cartao.addActionListener(cardBooking);
            quiosque.addActionListener(quiosqueShort);
            //Adicionando itens ao PopupMenu
            popup.add(abrir);
            popup.add(cartao);
            popup.add(quiosque);
            popup.add(sair);

            trayIcon = new TrayIcon(image, "ERP Hotel Marin Château", popup);

            ActionListener actionListener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {

//                    trayIcon.displayMessage("Marin Château",
//                            "Abrindo aplicação",
//                            TrayIcon.MessageType.INFO);
                    menu.setVisible(true);

                }

            };

            //Na linha a seguir a imagem a ser utilizada como icone sera redimensionada
            trayIcon.setImageAutoSize(true);

            //Seguida adicionamos os actions listeners
            trayIcon.addActionListener(actionListener);

            trayIcon.addMouseListener(mouseListener);

            //Tratamento de erros
            try {

                tray.add(trayIcon);

            } catch (AWTException e) {

                System.err.println("Erro, TrayIcon não sera adicionado.");

            }

        } else {

            //Caso o item  System Tray não for suportado
            JOptionPane.showMessageDialog(null, "recurso ainda não esta disponível pra o seu sistema");

        }

    }

}// Fim do código.

