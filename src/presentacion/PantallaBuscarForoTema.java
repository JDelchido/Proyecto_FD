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

public class PantallaBuscarForoTema extends JDialog {
    private JButton buscarButton;
    private JButton atrasButton;
    private JPanel buscarForoTemaPanel;
    private JLabel mensajeEntrar;
    private JComboBox comboForoTema;
    private JComboBox comboBoxForos;
    private JLabel mensajeBusqueda;
    private JButton entrarButton;
    //private DefaultComboBoxModel temaComboBoxModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel forosComboBoxModel = new DefaultComboBoxModel();

    SistemaBuscarForo sistemaBuscarForo = new SistemaBuscarForo();

    public PantallaBuscarForoTema(JFrame parent, Usuario u) {
        super(parent);
        setTitle("Busqueda de Foro");
        setContentPane(buscarForoTemaPanel);
        setMinimumSize(new Dimension(600, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        //comboForoTema.setModel(temaComboBoxModel);
        comboBoxForos.setModel(forosComboBoxModel);


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

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntrarAForo(u);
            }
        });
         setVisible(true);
    }

    void PasarAPrincipal (Usuario u){

        new PantallaPrincipal(null, u);
    }

    void PasarAForo (Usuario u, Foro f){new PantallaForo(null, u, f);}

    private void BuscarForoTema(){
        String foro = comboForoTema.getSelectedItem().toString();
        Vector<Foro> foros = null;

        if(foro.isEmpty())
        {
            mensajeBusqueda.setForeground(new Color(255, 35, 0));
            mensajeBusqueda.setText("No ingreso ningún dato");
        }
        else
        {
            foros = sistemaBuscarForo.BuscarForoPorTema(foro);

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
    }

    public void EntrarAForo(Usuario u)
    {
        String s = Objects.requireNonNull(forosComboBoxModel.getSelectedItem()).toString();

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
