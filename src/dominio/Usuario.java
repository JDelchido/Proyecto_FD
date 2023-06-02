package dominio;

public class Usuario {
    private String usuario;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String email;

    public Usuario()
    {

    }

    public Usuario(String usuario, String nombre, String apellido, String email,String contraseña)
    {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }

    //GETTERS Y SETTERS
    public String getUsuario() {
        return usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getApellido() {
        return apellido;
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
