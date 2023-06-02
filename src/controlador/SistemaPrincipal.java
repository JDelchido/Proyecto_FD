package controlador;

import dominio.Foro;
import dominio.Usuario;

public class SistemaPrincipal {
    private Usuario usuario;
    private Foro foros[];


    //GETTERS Y SETTERS
    public Foro[] getForos() {
        return foros;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setForos(Foro[] foros) {
        this.foros = foros;
    }

}
