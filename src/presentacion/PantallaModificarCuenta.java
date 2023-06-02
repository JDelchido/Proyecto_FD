package presentacion;

import Utilidades.RevisarTamano;
import controlador.SistemaModificarCuenta;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaModificarCuenta extends JDialog{
    private JPanel modificarCuentaPanel;
    private JLabel modificarCuentaLabel;
    private JButton guardarCambiosButton;
    private JTextField tFNombreNuevo;
    private JTextField tFApellidosNuevos;
    private JPasswordField pFContrasenaAntigua;
    private JPasswordField pFContrasenaNueva1;
    private JLabel nombresNuevoLabel;
    private JLabel apellidosNuevoLabel;
    private JLabel contrasenaAntiguaLabel;
    private JLabel contrasenaNuevaLabel;
    private JLabel mensajeErrorLabel;
    private JButton atrasButton;
    private JPasswordField pFContrasenaNueva2;

    SistemaModificarCuenta sistemaModificarCuenta = new SistemaModificarCuenta();

    public PantallaModificarCuenta(JFrame parent, Usuario u)
    {
        super(parent);
        setTitle("Modificar la cuenta");
        setContentPane(modificarCuentaPanel);
        setMinimumSize(new Dimension(600, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        guardarCambiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCuenta(u);
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarAPantallaPrincipal(u);
            }
        });
        tFNombreNuevo.setText(u.getNombre());
        tFApellidosNuevos.setText(u.getApellido());

        setVisible(true);
    }

    private void PasarAPantallaPrincipal(Usuario u){new PantallaPrincipal(null, u);}

    private void modificarCuenta(Usuario u) {
        String nombreNuevo = tFNombreNuevo.getText();
        String apellidosNuevos = tFApellidosNuevos.getText();
        String contrasenaAntigua = String.valueOf(pFContrasenaAntigua.getPassword());
        String contrasenaNueva = String.valueOf(pFContrasenaNueva1.getPassword());
        String confirmarContrasenaNueva = String.valueOf(pFContrasenaNueva2.getPassword());

        String result = "Se cambio: ";
        boolean contrasenaCorrecta = true;

        RevisarTamano revisarTamano = new RevisarTamano();

        if(!revisarTamano.VerificarLongitud(nombreNuevo, 50))
        {
            mensajeErrorLabel.setForeground(new Color(255, 35, 0));
            mensajeErrorLabel.setText("Los nombres exceden la longitud máxima permitida");
        }

        if(!revisarTamano.VerificarLongitud(apellidosNuevos, 50))
        {
            mensajeErrorLabel.setForeground(new Color(255, 35, 0));
            mensajeErrorLabel.setText("Los apellidos exceden la longitud máxima permitida");
        }

        if(!revisarTamano.VerificarLongitud(contrasenaNueva, 50))
        {
            mensajeErrorLabel.setForeground(new Color(255, 35, 0));
            mensajeErrorLabel.setText("La contraseña exceden la longitud máxima permitida");
        }

        //contraseña

        if(contrasenaAntigua.equals(u.getContrasena()))
        {
            if(!contrasenaAntigua.equals(contrasenaNueva))
            {
                if(contrasenaNueva.equals(confirmarContrasenaNueva))
                {
                    result=result.concat(" Contraseña ");
                    u.setContrasena(contrasenaNueva);
                    sistemaModificarCuenta.cambiarUsuario(u);
                }
                else
                {
                    mensajeErrorLabel.setForeground(new Color(255, 35, 0));
                    mensajeErrorLabel.setText("La contraseña nueva y su confirmacion no concuerdan");
                }
            }
        }
        else
        {
            mensajeErrorLabel.setForeground(new Color(255, 35, 0));
            mensajeErrorLabel.setText("La contraseña es incorrecta");
            contrasenaCorrecta = false;
        }


        //para el nombre
        if (!nombreNuevo.equals(u.getNombre()) && !nombreNuevo.isEmpty() && contrasenaCorrecta) { //si el nuevo nombre es igual al que ya tiene
            result=result.concat(" Nombres ");
            u.setNombre(nombreNuevo);
            sistemaModificarCuenta.cambiarUsuario(u); //base de datos
        }

        //para el apellido
        if (!apellidosNuevos.equals(u.getApellido()) && !apellidosNuevos.isEmpty() && contrasenaCorrecta ) { //si el nuevo apellido es igual al que ya tiene
            result=result.concat(" Apellidos ");
            u.setApellido(apellidosNuevos);
            sistemaModificarCuenta.cambiarUsuario(u); //base de datos
        }

        if(contrasenaCorrecta)
        {
            result=result.concat(" correctamente");
            mensajeErrorLabel.setForeground(new Color(0, 255, 20));
            mensajeErrorLabel.setText(result);
        }
    }
}