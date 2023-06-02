package presentacion;

import controlador.SistemaPrincipal;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JDialog{
    private JButton crearForoButton;
    private JButton buscarForoNombreButton;
    private JButton cerrarSesiónButton;
    private JButton eliminarCuentaButton;
    private JPanel pantallaPrincipalPanel;
    private JButton modificarCuentaButton;
    private JButton buscarForoTemaButton;

    SistemaPrincipal sistemaPrincipal = new SistemaPrincipal();

    public PantallaPrincipal(JFrame parent,Usuario u)
    {
        super(parent);
        setTitle("Crear una nueva cuenta");
        setContentPane(pantallaPrincipalPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        crearForoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarACrearForo(u);
            }
        });

        buscarForoNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarABuscarForoNombre(u);
            }
        });

        buscarForoTemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarABuscarForoTema(u);
            }
        });


        eliminarCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PasarAEliminarCuenta(u);
            }
        });

        setVisible(true);
    }

    private void PasarACrearForo(Usuario u) { new PantallaCrearForo(null, u);}

    public void PasarABuscarForoNombre(Usuario u){ new PantallaBuscarForoNombre(null, u);}

    public void PasarABuscarForoTema (Usuario u){ new PantallaBuscarForoTema(null, u);}

    public void PasarAEliminarCuenta(Usuario u){ new PantallaEliminarCuenta(null, u);}
}
