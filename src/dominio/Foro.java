//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dominio;

public class Foro {
    private Comentario[] comentario;
    private String descipcion;
    private String nombre;
    private String tema;
    private String administrador;
    private Usuario usuario;

    public Foro() {
    }

    public Foro(String nombre, String tema, String descipcion) {
        this.descipcion = descipcion;
        this.nombre = nombre;
        this.tema = tema;
    }

    public String toString() {
        return this.tema;
    }

    public Comentario[] getComentario() {
        return this.comentario;
    }

    public void setComentario(Comentario[] comentario) {
        this.comentario = comentario;
    }

    public String getDescipcion() {
        return this.descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return this.tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getAdministrador() {
        return this.administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}