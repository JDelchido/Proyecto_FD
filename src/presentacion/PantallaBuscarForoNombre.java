
package presentacion;
import Utilidades.RevisarTamano;
import controlador.SistemaBuscarForo;
import dominio.Foro;
import dominio.Usuario;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Vector;

public class PantallaBuscarForoNombre extends JDialog {
    private JTextField tFConsultaForo;
    private JLabel label;
    private JButton atrasButton;
    private JButton buscarButton;
    private JPanel buscarForoPanel;
    private JLabel mensajeBusqueda;
    private JComboBox forosBox;
    private final DefaultComboBoxModel forosComboBoxModel = new DefaultComboBoxModel();
    private JButton entrarButton;
    private JLabel mensajeEntrar;

    SistemaBuscarForo sistemaBuscarForo = new SistemaBuscarForo();
    RevisarTamano revisarTamano = new RevisarTamano();

    public PantallaBuscarForoNombre(JFrame parent, Usuario u) {
        //Configurar la ventana
        super(parent);
        setTitle("Busqueda de Foro");
        setContentPane(buscarForoPanel);
        setMinimumSize(new Dimension(600, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        forosBox.setModel(forosComboBoxModel);

        Foro f = null;

        //Agregar un ActionListener al botón buscarButton
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarForo();
            }
        });

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntrarForo(u);
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

    void PasarAPrincipal(Usuario u) {
        new PantallaPrincipal(null, u);
    }

    void PasarAForo(Usuario u, Foro f){new PantallaForo(null, u, f);}

    private void BuscarForo() {
        String foro = tFConsultaForo.getText();

        Vector<Foro> foros = null;
        if (foro.isEmpty()) {
            mensajeBusqueda.setForeground(new Color(255, 35, 0));
            mensajeBusqueda.setText("No ingreso ningún dato");
        }
        else
        {
            if(revisarTamano.VerificarLongitud(foro,50))
            {
                foros = sistemaBuscarForo.BuscarForoPorNombre(foro);

                if(foros.size() > 0)
                {
                    for (Foro value : foros) {
                        forosComboBoxModel.addElement(value.getNombre() + "-" + value.getTema());
                    }
                }
                else
                {
                    mensajeBusqueda.setForeground(new Color(255, 35, 0));
                    mensajeBusqueda.setText("No se encontro ningun foro con ese nombre");
                }
            }
            else
            {
                mensajeBusqueda.setForeground(new Color(255, 35, 0));
                mensajeBusqueda.setText("El nombre insertado es demasiado largo");
            }
        }

    }

    private void EntrarForo(Usuario u)
    {
        String s = Objects.requireNonNull(forosBox.getSelectedItem()).toString();

        if(!s.isEmpty())
        {
            String[] p = s.split("-");

            Foro f = sistemaBuscarForo.EncontrarForo(p[0], p[1]);
            dispose();
            PasarAForo(u, f);
        }
        else
        {
            mensajeEntrar.setForeground(new Color(255, 35, 0));
            mensajeEntrar.setText("No se ha seleccionado un foro valido");
        }
    }
}

