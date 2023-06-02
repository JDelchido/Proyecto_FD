package presentacion;

//import controlador.SistemaRegistro;
import controlador.SistemaRegistro;
import dominio.Usuario;
import integracion.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaRegistro extends JDialog{
    private JPasswordField pFContraseña_1;
    private JButton registrarButton;
    private JButton logInButton; //atras
    private JTextField tFUsuario;
    private JPasswordField pFContraseña_2;
    private JTextField tFNombre;
    private JTextField tFApellidos;
    private JTextField tFEmail;
    private JPanel registroPanel;
    private JLabel mensajeError;

    SistemaRegistro sistemaRegistro = new SistemaRegistro();

    public PantallaRegistro(JFrame parent)
    {
        super(parent);
        setTitle("Crear una nueva cuenta");
        setContentPane(registroPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistrarUsuario();
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarALogin();
            }
        });

        setVisible(true);

    }

    private void PasarALogin() {
        new PantallaLogin(null);
    }

    private void RegistrarUsuario() {
        String usuario = tFUsuario.getText();
        String nombre = tFNombre.getText();
        String apellido = tFApellidos.getText();
        String email = tFEmail.getText();
        String contraseña = String.valueOf(pFContraseña_1.getPassword());
        String confirmarContraseña = String.valueOf(pFContraseña_2.getPassword());

        //Se ingresan todos los datos
        if(usuario.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contraseña.isEmpty() || confirmarContraseña.isEmpty())
        {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("Alguno de los cuadros estan vacios");
        }
        else
        {
            if(!email.matches("^[a-zA-Z0-9._%+-]+@javeriana\\.edu\\.co$")){
                mensajeError.setForeground(new Color(255, 35, 0));
                mensajeError.setText("Correo invalido");
            }
            else
            {
                if(contraseña.equals(confirmarContraseña)) ///Las dos contraseñas son iguales
                {

                    boolean usuarioUsado = sistemaRegistro.buscarUsuario(usuario); //
                    boolean emailUsado = sistemaRegistro.buscarEmail(email); //

                    if(usuarioUsado == false && emailUsado == false) //Verifica si el email o nombre de usuario se uso para crear otro usuario
                    {
                        mensajeError.setForeground(new Color(0, 255, 20));
                        mensajeError.setText("La cuenta se creo exitosamente");
                        Usuario u = new Usuario(usuario, nombre, apellido, email, contraseña);
                        sistemaRegistro.insertar(u); //Se utiliza sistemRegistro**
                    }
                    else
                    {
                        if(usuarioUsado == true)
                        {
                            mensajeError.setForeground(new Color(255, 35, 0));
                            mensajeError.setText("El nombre de usuario ya fue usado para crear otro usuario");

                        }

                        if(emailUsado == true)
                        {
                            mensajeError.setForeground(new Color(255, 35, 0));
                            mensajeError.setText("El correo ya fue usado para crear otro usuario");

                        }
                    }
                }
                else
                {
                    mensajeError.setForeground(new Color(255, 35, 0));
                    mensajeError.setText("Las dos contraseñas no son iguales");
                }
            }
        }
    }

}