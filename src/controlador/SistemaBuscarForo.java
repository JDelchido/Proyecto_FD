package controlador;

import ConexionBaseDeDatos.QuerysForo;
import dominio.Foro;

import java.util.Vector;

public class SistemaBuscarForo {

    public SistemaBuscarForo(){}

    public Vector<Foro> BuscarForoPorNombre(String nombre)
    {
        Vector<Foro> foros = null;
        
        foros = QuerysForo.BuscarForosPorNombre(nombre);// Busca si ese mismo tema y nombre ya fueron utilizados
        
        return foros;
    }

    public Vector<Foro> BuscarForoPorTema(String tema)
    {
        Vector<Foro> foros = null;

        foros = QuerysForo.BuscarForosPorTema(tema);

        return foros;
    }

    public Foro EncontrarForo(String nombre, String tema)
    {
        Foro f = null;

        f = QuerysForo.EncontrarForo(nombre, tema);

        return f;
    }
}
