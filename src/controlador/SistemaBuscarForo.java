package controlador;

import dominio.Foro;

import java.util.Vector;

public class SistemaBuscarForo {

    public SistemaBuscarForo(){}

    public Vector<Foro> BuscarForoPorNombre(String nombre)
    {
        Vector<Foro> foros = null;

        //foros = BaseDeDatos.BuscarForosPorTema(nombre);

        return foros;
    }

    public Foro EncontrarForo(String nombre, String tema)
    {
        Foro f = null;

        //f = BaseDeDatos.EncontrarForo(nombre, tema);

        return f;
    }
}
