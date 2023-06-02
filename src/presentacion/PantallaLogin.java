package presentacion;

import controlador.SistemaLogIn;
import dominio.Usuario;
import Utilidades.RevisarTamano;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaLogin extends JDialog {
    private JTextField tFUsuario;
    private JPasswordField pFContrasena;
    private JButton ingresarButton;
    private JButton registrarseButton;
    private JPanel loginPanel;
    private JLabel mensajeError;
    SistemaLogIn sistemaLogIn;

    public PantallaLogin(JFrame parent) {
        super(parent);
        setTitle("Ingresar con una cuenta");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        sistemaLogIn = new SistemaLogIn();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingresar();
            }
        });

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarARegistro();
            }
        });

        setVisible(true);
    }

    void PasarARegistro() {
        new PantallaRegistro(null);
    }

    void PasarAPrincipal(Usuario usuario) {
        new PantallaPrincipal(null, usuario);
    }


    private void Ingresar() {
        String usuario = tFUsuario.getText();
        String contrasena = String.valueOf(pFContrasena.getPassword());

        RevisarTamano revisarTamano = new RevisarTamano();

        if (revisarTamano.VerificarLongitud(usuario, 50) == false) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Usuario' excede la longitud máxima permitida");
        }

        if (revisarTamano.VerificarLongitud(contrasena, 50) == false) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Contraseña' excede la longitud máxima permitida");
        }

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("Alguno de los datos esta vacio");
        } else {
            boolean encontrado = sistemaLogIn.VerificarDatos(usuario, contrasena);
            if (encontrado) {
                Usuario u = sistemaLogIn.obtenerUsuario(usuario);
                dispose();
                PasarAPrincipal(u);
            } else {
                mensajeError.setForeground(new Color(255, 35, 0));
                mensajeError.setText("Alguno de los datos es erroneo");
            }
        }
    }

    public static void main(String[] args) {
        PantallaLogin myForm = new PantallaLogin(null);
    }
}
