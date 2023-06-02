package presentacion;

import dominio.Foro;
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
    private JComboBox comboForoTema;
    private DefaultComboBoxModel temaComboBoxModel = new DefaultComboBoxModel();

    public PantallaBuscarForoTema(JFrame parent, Usuario u) {
        super(parent);
        setTitle("Busqueda de Foro");
        setContentPane(buscarForoTemaPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarForoTema();
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

    private void BuscarForoTema(){
        comboForoTema.getSelectedItem();
        String foro = tFConsultForoTema.getText();
        if(comboForoTema.isEditable()) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("No ingreso ningún dato");
        }

    }
    public static void main(String[] args)
    {
        PantallaBuscarForoTema myForm = new PantallaBuscarForoTema(null,null);
    }

}