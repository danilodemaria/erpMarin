/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpmarin;
import Telas.Menu_Principal;

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
       
    }
    
}
