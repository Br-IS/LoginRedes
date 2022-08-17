/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.Login;

/**
 *
 * @author Boris
 */
public class LoginController {

    private Login login;
    

    /// private 
    private JOptionPane jOptionPane;

    public List<Usuario> lista() {

        List<Usuario> listUsuario = new ArrayList<>();

        listUsuario.add(new Usuario("admin", "admin", "ADMINISTRADOR"));
        listUsuario.add(new Usuario("bodega", "bodega", "BODEGA"));
        listUsuario.add(new Usuario("venta", "venta", "VENTAS"));
        listUsuario.add(new Usuario("marketing", "marketing", "MARKETING"));
        listUsuario.add(new Usuario("gerente", "gerente", "GERENTE"));

        return listUsuario;

    }

    public LoginController(Login login) {
        this.login = login;
        login.setLocationRelativeTo(null);
        login.setVisible(true);

        iniciaControl();

    }

    private void iniciaControl() {
        login.getBtnEntrar().addActionListener(l -> iniciaLogin());
    }

    public boolean login(String usuario, String contrasena) {

        List<Usuario> listas = lista();

        for (int i = 0; i < listas.size(); i++) {

            if (listas.get(i).getUsuario().equals(usuario) && listas.get(i).getUsuario().equals(contrasena)) {
                login.getTxtRol().setText(listas.get(i).getRol());
                return true;
            }

        }
        return false;
    }

    private void iniciaLogin() {

        if (login(login.getTxtUsuario().getText(), login.getTxtContrasena().getText())) {
            //jOptionPane.showMessageDialog(null, "usuario correcto");
            
            login.getjDialog1().setVisible(true);
            login.getjDialog1().setLocationRelativeTo(login);
            login.getjDialog1().setSize(800,400);
            
   login.dispose();
            
            
        } else {
            jOptionPane.showMessageDialog(null, "usuario incorrecto");
        }

    }
    
    
    

    public static void main(String[] args) {

        Login login = new Login();

        new LoginController(login);
    }

}
