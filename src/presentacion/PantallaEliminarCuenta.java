package presentacion;

import Utilidades.RevisarTamano;
import controlador.SistemaEliminarCuenta;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaEliminarCuenta extends JDialog{
    private JPanel eliminarCuentaPanel;
    private JButton volverButton;
    private JButton eliminarCuentaButton;
    private JPasswordField pFContrasena;
    private JLabel mensajeError;

    SistemaEliminarCuenta sistemaEliminarCuenta = new SistemaEliminarCuenta();

    public PantallaEliminarCuenta(JFrame parent,Usuario u) {
        super(parent);
        setTitle("Crear una nueva cuenta");
        setContentPane(eliminarCuentaPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        eliminarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarCuenta(u);
            }
        });


        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarAPrincipal(u);
            }
        });

        setVisible(true);
    }

    private void EliminarCuenta(Usuario u) {
        String contrasena = String.valueOf(pFContrasena.getPassword());

        RevisarTamano revisarTamano = new RevisarTamano();

        if(revisarTamano.VerificarLongitud(contrasena,50) == false){
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Contraseña' excede la longitud máxima permitida");
        }

        if(contrasena.isEmpty())
        {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("La contraseña no esta vacia");
        }
        else
        {
            boolean correcta = sistemaEliminarCuenta.ConfirmarContrasena(u.getUsuario(), contrasena);

            if(correcta) {
                sistemaEliminarCuenta.EliminarUsuario(u.getUsuario());
                dispose();
                PasarALogIn();
            }
            else
            {
                mensajeError.setForeground(new Color(255, 35, 0));
                mensajeError.setText("La contraseña no es correcta");
            }
        }
    }

    void PasarAPrincipal (Usuario usuario){ new PantallaPrincipal(null, usuario); }

    void PasarALogIn(){new PantallaLogin(null);}
}
