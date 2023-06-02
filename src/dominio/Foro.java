package dominio;

public class Foro {
    private Comentario[] comentario;
    private String tema;
    private String administrador;
    private Usuario usuario;


    //GETTERS Y SETTERS
    public Usuario getUsuario() {
        return usuario;
    }
    public Comentario[] getComentario() {
        return comentario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setComentario(Comentario[] comentario) {
        this.comentario = comentario;
    }
}
