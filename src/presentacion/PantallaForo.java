package presentacion;

import Utilidades.RevisarTamano;
import controlador.SistemaForo;
import dominio.Foro;
import dominio.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaForo extends JDialog {

    String uName;

    private JPanel pantallaForoPanel;

    private JPanel panelForo;
    private JTextArea textArea1;
    private JTextField tFPublicar;
    private JButton publicarButton;
    private JButton volverButton;
    private JLabel labelForo;
    private JLabel labelComentario;

    RevisarTamano revisarTamano = new RevisarTamano();

    public PantallaForo(JFrame parent, Usuario u, Foro f)
    {
        super(parent);
        setTitle(f.getNombre());
        setContentPane(panelForo);
        setMinimumSize(new Dimension(600, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        labelForo.setText("FORO: " + f.getNombre() + " - " + f.getTema());
        labelComentario.setText("*Pulse el boton para publicar un comentario");
        if(!f.getComentario().isEmpty())
        {
            uName = " ";
            for(int i=0; i<f.getComentario().size(); i++)
            {
                if(uName.equals(f.getComentario().get(i).getUsuario()))
                {
                    textArea1.append(f.getComentario().get(i).getContenido() + "\n");
                }
                else
                {
                    textArea1.append(f.getComentario().get(i).getUsuario() + ": \n");
                    textArea1.append(f.getComentario().get(i).getContenido() + "\n");
                    uName = f.getComentario().get(i).getUsuario();
                    System.out.println(uName);
                }

            }
        }


        publicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tFPublicar.getText().isEmpty() == false)
                {
                    if(revisarTamano.VerificarLongitud(tFPublicar.getText(),280) == false)
                    {
                        labelComentario.setForeground(new Color(255, 35, 0));
                        labelComentario.setText("El comentario es demasiado largo");
                    }
                    else
                    {
                        if(uName != u.getUsuario())
                        {
                            textArea1.append(u.getUsuario() + ": \n");
                            textArea1.append(tFPublicar.getText() + "\n");
                            SistemaForo.agregarcomentario(u.getUsuario(),tFPublicar.getText(), f.getID());
                            tFPublicar.setText(" ");
                            labelComentario.setForeground(new Color(0, 0, 0));
                            labelComentario.setText("*Pulse el boton para publicar un comentario");
                            uName = u.getUsuario();
                        }
                        else
                        {
                            textArea1.append(tFPublicar.getText() + "\n");
                            SistemaForo.agregarcomentario(u.getUsuario(),tFPublicar.getText(),f.getID());
                            tFPublicar.setText(" ");
                            labelComentario.setForeground(new Color(0, 0, 0));
                            labelComentario.setText("*Pulse el boton para publicar un comentario");
                        }
                    }
                }
                else
                {
                    labelComentario.setForeground(new Color(0, 0, 0));
                    labelComentario.setText("*Escriba algun comentario");
                }
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

    private void PasarAPrincipal(Usuario u) {new PantallaPrincipal(null, u);}
}

