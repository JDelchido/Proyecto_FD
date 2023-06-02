package presentacion;

import Utilidades.RevisarTamano;
import controlador.SistemaRegistro;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaRegistro extends JDialog{
    private JPasswordField pFContrasena_1;
    private JButton registrarButton;
    private JButton logInButton; //atras
    private JTextField tFUsuario;
    private JPasswordField pFContrasena_2;
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
                RegistrarUsuario();
                //dispose();
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
        String contrasena = String.valueOf(pFContrasena_1.getPassword());
        String confirmarContrasena = String.valueOf(pFContrasena_2.getPassword());

        RevisarTamano revisarTamano = new RevisarTamano();

        if (!revisarTamano.VerificarLongitud(usuario, 50)) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Usuario' excede la longitud máxima permitida");
        }

        if (!revisarTamano.VerificarLongitud(nombre, 50)) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Nombre' excede la longitud máxima permitida");
        }

        if (!revisarTamano.VerificarLongitud(apellido, 50)) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Apellido' excede la longitud máxima permitida");
        }

        if (!revisarTamano.VerificarLongitud(email, 50)) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Email' excede la longitud máxima permitida");
        }

        if (!revisarTamano.VerificarLongitud(contrasena, 50)) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Contraseña' excede la longitud máxima permitida");
        }

        if (!revisarTamano.VerificarLongitud(confirmarContrasena, 50)) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Confirmar contraseña' excede la longitud máxima permitida");
        }

            //Se ingresan todos los datos
            if (usuario.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                mensajeError.setForeground(new Color(255, 35, 0));
                mensajeError.setText("Alguno de los cuadros estan vacios");
            } else {
                if (!email.matches("^[a-zA-Z0-9._%+-]+@javeriana\\.edu\\.co$")) {
                    mensajeError.setForeground(new Color(255, 35, 0));
                    mensajeError.setText("Correo invalido");
                } else {
                    if (contrasena.equals(confirmarContrasena)) ///Las dos contraseñas son iguales
                    {

                        boolean usuarioUsado = sistemaRegistro.buscarUsuario(usuario); //
                        boolean emailUsado = sistemaRegistro.buscarEmail(email); //

                        if (!usuarioUsado && !emailUsado) //Verifica si el email o nombre de usuario se uso para crear otro usuario
                        {
                            mensajeError.setForeground(new Color(0, 255, 20));
                            mensajeError.setText("La cuenta se creo exitosamente");
                            Usuario u = new Usuario(usuario, nombre, apellido, email, contrasena);
                            sistemaRegistro.insertar(u); //Se utiliza sistemRegistro**
                        } else {
                            if (usuarioUsado) {
                                mensajeError.setForeground(new Color(255, 35, 0));
                                mensajeError.setText("El nombre de usuario ya fue usado para crear otro usuario");

                            }

                            if (emailUsado) {
                                mensajeError.setForeground(new Color(255, 35, 0));
                                mensajeError.setText("El correo ya fue usado para crear otro usuario");

                            }
                        }
                    } else {
                        mensajeError.setForeground(new Color(255, 35, 0));
                        mensajeError.setText("Las dos contraseñas no son iguales");
                    }
                }
            }
        }
    }

