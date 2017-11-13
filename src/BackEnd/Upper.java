/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administração
 */
public class Upper {
    
    public void upperCase(JTextField text) {
        text.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JTextField campo = (JTextField) e.getSource();
                        int posicaoCursor = campo.getCaretPosition();
                        campo.setText(campo.getText().toUpperCase());
                        if (posicaoCursor != campo.getCaretPosition()) {
                            campo.setCaretPosition(posicaoCursor);
                        }
                    }
                });
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

        });

    }

    
}
