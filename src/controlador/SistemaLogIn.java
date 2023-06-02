package controlador;

import ConexionBaseDeDatos.QuerysUsuario;
import dominio.Usuario;

public class SistemaLogIn {
    public boolean VerificarDatos(String usuario, String contrasena){
        boolean verificado = false;
        String nContrasena;

        nContrasena = QuerysUsuario.ValidarContrasena(usuario); //Devuelve la contraseña que se encontro por el usuario

        if(contrasena.equals(nContrasena)){
            verificado = true;
        }

        return verificado;
    }

    public Usuario obtenerUsuario(String usuario)
    {
        return QuerysUsuario.obtenerUsuario(usuario);
    }
}

