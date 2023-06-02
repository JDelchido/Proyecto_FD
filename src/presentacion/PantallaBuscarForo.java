package presentacion;

import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaBuscarForo extends JDialog{
    private JTextField tFConsultaForo;
    private JButton atrásButton;
    private JButton buscarButton;
    private JPanel buscarForoPanel;
    private JLabel mensajeError;

    public PantallaBuscarForo(JFrame parent, Usuario u) {
        //Configurar la ventana
        super(parent);
        setTitle("Busqueda de dominio.Foro");
        setContentPane(buscarForoPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);


        //Agregar un ActionListener al botón buscarButton
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarForo();
            }
        });

        atrásButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasarAPrincipal(u);
            }
        });
        setVisible(true);
    }

    void PasarAPrincipal (Usuario u){ new PantallaPrincipal(null, u); }

    private void BuscarForo(){
        String foro = tFConsultaForo.getText();
        if(foro.isEmpty()) {
            mensajeError.setForeground(new Color(255, 35, 0));
            mensajeError.setText("No ingreso ningún dato");
        }

    }
}
