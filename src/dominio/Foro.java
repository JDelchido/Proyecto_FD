package dominio;

import java.util.Vector;


public class Foro {

    private Vector<Comentario> comentario=new Vector<Comentario>();
    private int ID;
    private String nombre;
    private String tema;
    private String descripcion;

    public Foro(){}

    public Foro(int id,String nombre, String tema, String descripcion, Vector<Comentario> comentarios) {
        this.nombre = nombre;
        this.tema = tema;
        this.descripcion = descripcion;
        this.comentario = comentarios;
        this.ID=id;
    }

    public Foro(int id,String nombre, String tema, String descripcion) {
        this.ID=id;
        this.nombre = nombre;
        this.tema = tema;
        this.descripcion = descripcion;
    }
    public Vector<Comentario> getComentario() {
        return comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTema() {
        return tema;
    }

    public int getID(){return ID;}

    public void setID (int iD){this.ID=iD;}

    public String getDescripcion() {
        return descripcion;
    }

    public void setComentario(Vector<Comentario> comentario) {
        this.comentario = comentario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

