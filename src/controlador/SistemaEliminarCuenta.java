package controlador;


import ConexionBaseDeDatos.QuerysUsuario;

public class SistemaEliminarCuenta {


    public void EliminarUsuario(String usuario)
    {
        QuerysUsuario.eliminar(usuario);//Se elimia la fila del usuario insertado
    }

    public boolean ConfirmarContrasena(String usuario, String contrasena)
    {
        boolean verificado = false;
        String nContrasena = new String();

        nContrasena = QuerysUsuario.ValidarContrasena(usuario); //Devuelve la contraseña que se encontro por el usuario

        if(contrasena.equals(nContrasena)){
            verificado = true;
        }
        return verificado;
    }
}