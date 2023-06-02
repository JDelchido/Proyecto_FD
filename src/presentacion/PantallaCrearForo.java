package presentacion;

import Utilidades.RevisarTamano;
import controlador.SistemaCrearForo;
import dominio.Foro;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PantallaCrearForo extends JDialog{
    private JPanel crearForoPanel;
    private JTextField tFDescripcion;
    private JButton volverButton;
    private JButton crearButton;
    private JLabel mensajeError;
    private JTextField tFNombre;
    private JComboBox <String> comboForoTema;
    SistemaCrearForo sistemaCrearForo = new SistemaCrearForo();

    public PantallaCrearForo(JFrame parent,Usuario u)
    {
        super(parent);
        System.out.println("LLegamos aqui?");
        setTitle("Crear una nuevo foro");
        setContentPane(crearForoPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);


        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CrearForo(u);
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

    void PasarAPrincipal (Usuario usuario){
        new PantallaPrincipal(null, usuario);
    }
    void PasarAForo(Usuario u, Foro f){new PantallaForo(null, u, f);}

    private void CrearForo(Usuario u) {
        int id=0;
        String nombre = tFNombre.getText();
        String descripcion = tFDescripcion.getText();
        String tema = (String) comboForoTema.getSelectedItem();

        RevisarTamano revisarTamano = new RevisarTamano();

        if(revisarTamano.VerificarLongitud(nombre,50) == false){
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Nombre' excede la longitud máxima permitida");
        }

        if(revisarTamano.VerificarLongitud(descripcion,200) == false){
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Descripción' excede la longitud máxima permitida");
        }

        if(revisarTamano.VerificarLongitud(tema,50) == false){
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("El dato 'Tema' excede la longitud máxima permitida");
        }

        if (nombre.isEmpty() || descripcion.isEmpty() || tema.isEmpty()) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("Alguno de los cuadros estan vacios");
        } else {
            boolean nombreAsignado = sistemaCrearForo.buscarNombreTemaForo(nombre,tema);

            mensajeError.setForeground(new Color(255, 35, 0));
            if (!nombreAsignado) {
                mensajeError.setText("El foro se creo exitosamente");
                Foro f = new Foro(id,nombre, tema, descripcion);
                sistemaCrearForo.crearForo(f);
                System.out.println("LLegamoooooo!");
                dispose();
                PasarAForo(u,f);
            } else {
                mensajeError.setText("El nombre y tema asignado al foro ya fueron usados para crear otro foro, asigne otro nombre o cambie el tema");
            }
        }
    }
}
