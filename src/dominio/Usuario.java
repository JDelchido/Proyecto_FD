//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dominio;

public class Usuario {
    private String usuario;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String email;

    public Usuario() {
    }

    public Usuario(String usuario, String nombre, String apellido, String email, String contraseña) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
