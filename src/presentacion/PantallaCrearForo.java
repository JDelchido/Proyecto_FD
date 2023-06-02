package presentacion;

import controlador.SistemaCrearForo;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PantallaCrearForo extends JDialog{
    private JPanel crearForoPanel;
    private JTextField tFDescripcion;
    private JButton volverButton;
    private JButton crearButton;
    private JComboBox comboBox1;
    private DefaultComboBoxModel temaComboBoxModel = new DefaultComboBoxModel();
    private JLabel mensajeError;
    private JTextField tFNombre;

    SistemaCrearForo sistemaCrearForo = new SistemaCrearForo();

    public PantallaCrearForo(JFrame parent,Usuario u)
    {
        super(parent);
        setTitle("Crear una nueva cuenta");
        setContentPane(crearForoPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        comboBox1.setModel(temaComboBoxModel);
        temaComboBoxModel.addElement("Opinion");
        temaComboBoxModel.addElement("Anuncio");
        temaComboBoxModel.addElement("Asignatura");
        temaComboBoxModel.addElement("Recomendaciones");
        temaComboBoxModel.addElement("");

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    private void CrearForo(Usuario u) {
        String nombre = tFNombre.getText();
        String descripcion = tFDescripcion.getText();
        String tema = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();

        if(nombre.isEmpty() || descripcion.isEmpty() || tema.isEmpty())
        {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("Alguno de los cuadros estan vacios");
        }
        else
        {
            boolean insertado = sistemaCrearForo.CrearForo(nombre, tema, descripcion, u.getUsuario());
            if(!insertado)
            {
                mensajeError.setForeground(new Color(255, 35, 0));
                mensajeError.setText("No se ha podido crear el foro");
            }
        }
    }

    void PasarAPrincipal (Usuario usuario){ new PantallaPrincipal(null, usuario); }
}
