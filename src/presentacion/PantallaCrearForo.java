package presentacion;

import controlador.SistemaCrearForo;
import dominio.Foro;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Objects;

public class PantallaCrearForo extends JDialog{
    private JPanel crearForoPanel;
    private JTextField tFDescripcion;
    private JButton volverButton;
    private JButton crearButton;
    private JLabel mensajeError;
    private JTextField tFNombre;
    SistemaCrearForo sistemaCrearForo = new SistemaCrearForo();
    private JComboBox <String> comboForoTema;
    private void llenarTemaComboBox(){
        String [] temas = {"Opinion", "Anuncio","Asignatura"};
        DefaultComboBoxModel <String> modelo = new DefaultComboBoxModel<>(temas);
        comboForoTema.setModel(modelo);
        comboForoTema.isEditable();
    }

    public PantallaCrearForo(JFrame parent,Usuario u)
    {
        super(parent);
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
    private void CrearForo(Usuario u) {
        String nombre = tFNombre.getText();
        String descripcion = tFDescripcion.getText();
        String tema = (String) comboForoTema.getSelectedItem();

        if (nombre.isEmpty() || descripcion.isEmpty() || tema.isEmpty()) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("Alguno de los cuadros estan vacios");
        } else {
            boolean nombreAsignado = sistemaCrearForo.buscarNombreTemaForo(nombre,tema);

            mensajeError.setForeground(new Color(255, 35, 0));
            if (!nombreAsignado) {
                mensajeError.setText("El foro se creo exitosamente");
                Foro f = new Foro(nombre, tema, descripcion);
                sistemaCrearForo.crearForo(f);
            } else {
                mensajeError.setText("El nombre y tema asignado al foro ya fueron usados para crear otro foro, asigne otro nombre o cambie el tema");
            }
        }
    }
    public static void main(String[] args)
    {
        PantallaCrearForo myFor = new PantallaCrearForo(null,null);
    }

}
