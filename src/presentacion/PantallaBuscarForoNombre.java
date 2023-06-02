package presentacion;

import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

package presentacion;
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
    private JButton atrásButton;
    private JButton buscarButton;
    private JPanel buscarForoPanel;
    private JLabel mensajeBusqueda;
    private JComboBox forosBox;
    private DefaultComboBoxModel forosComboBoxModel = new DefaultComboBoxModel();
    private JButton entrarButton;
    private JLabel mensajeEntrar;

    SistemaBuscarForo sistemaBuscarForo = new SistemaBuscarForo();

    public PantallaBuscarForoNombre(JFrame parent, Usuario u) {
        //Configurar la ventana
        super(parent);
        setTitle("Busqueda de Foro");
        setContentPane(buscarForoPanel);
        setMinimumSize(new Dimension(500, 474));
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

        atrásButton.addActionListener(new ActionListener() {
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
            foros = sistemaBuscarForo.BuscarForoPorNombre(foro);

            if(foros.size() > 0)
            {
                for(int i=0; i<foros.size(); i++)
                {
                    forosComboBoxModel.addElement(foros.get(i).getNombre() + "-" + foros.get(i).getTema());
                }
            }
            else
            {
                mensajeBusqueda.setForeground(new Color(255, 35, 0));
                mensajeBusqueda.setText("No se encontro ningun foro con ese nombre");
            }
        }

    }

    private void EntrarForo(Usuario u)
    {

        String s = Objects.requireNonNull(forosBox.getSelectedItem()).toString();

        if(s.isEmpty() == false)
        {
            String[] p = s.split("-");

            Foro f = sistemaBuscarForo.EncontrarForo(p[0], p[1]);
            PasarAForo(u, f);
        }
        else
        {
            mensajeEntrar.setForeground(new Color(255, 35, 0));
            mensajeEntrar.setText("No se ha seleccionado un foro valido");
        }
    }
    public static void main(String[] args)
    {
        PantallaBuscarForoNombre myForm = new PantallaBuscarForoNombre(null,null);
    }
}
