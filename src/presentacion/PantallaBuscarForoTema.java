package presentacion;

import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaBuscarForoTema extends JDialog {
    private JButton buscarButton;
    private JButton atrasButton;
    private JTextField tFConsultForoTema;
    private JPanel buscarForoTemaPanel;
    private JLabel mensajeError;
    private JComboBox comboBox1;
    private DefaultComboBoxModel temaComboBoxModel = new DefaultComboBoxModel();

    public PantallaBuscarForoTema(JFrame parent, Usuario u) {
        super(parent);
        setTitle("Busqueda de dominio.Foro");
        setContentPane(buscarForoTemaPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        comboBox1.setModel(temaComboBoxModel);
        temaComboBoxModel.addElement("Opinion");
        temaComboBoxModel.addElement("Anuncio");
        temaComboBoxModel.addElement("Asignatura");
        temaComboBoxModel.addElement("Recomendaciones");
        temaComboBoxModel.addElement("");

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarForoNombre();
            }
        });

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarAPrincipal(u);
            }
        });
         setVisible(true);
    }

    void PasarAPrincipal (Usuario u){
        new PantallaPrincipal(null, u);
    }

    private void BuscarForoNombre(){
        String foro = tFConsultForoTema.getText();
        if(foro.isEmpty()) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("No ingreso ningún dato");
        }
    }


}
