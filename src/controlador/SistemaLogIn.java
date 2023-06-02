package controlador;

import dominio.Usuario;
import integracion.Repositorio;

public class SistemaLogIn {

    public SistemaLogIn(){
        repositorio = new Repositorio();
    }

    private Repositorio repositorio;

    public boolean VerificarDatos(String usuario, String contraseña){
        boolean verificado = false;
        String nContraseña = new String();

        nContraseña = repositorio.buscar(usuario); //Devuelve la contraseña que se encontro por el usuario

        if(contraseña.equals(nContraseña)){
            verificado = true;
        }

        return verificado;
    }

    public Usuario obtenerUsuario(String usuario)
    {
        return repositorio.obetenerUsuario(usuario);
    }
}
