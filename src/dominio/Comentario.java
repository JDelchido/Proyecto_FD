package dominio;

import lombok.Data;

@Data

public class Comentario {
    private String contenido;
    private String usuario;

    public Comentario(String contenido, String usuario) {
        this.contenido=contenido;
        this.usuario=usuario;
    }
    public String getUsuario() {
        return usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

