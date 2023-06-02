package controlador;


import integracion.Repositorio;

public class SistemaEliminarCuenta {

    private Repositorio BasesDeDatos2;
    public SistemaEliminarCuenta() {
        BasesDeDatos2 = new Repositorio();
    }

    public void EliminarUsuario(String usuario)
    {
        BasesDeDatos2.eliminar(usuario);//Se elimia la fila del usuario insertado
    }

    public boolean ConfirmarContraseña(String usuario, String contraseña)
    {
        boolean verificado = false;
        String nContraseña = new String();

        nContraseña = BasesDeDatos2.buscar(usuario); //Devuelve la contraseña que se encontro por el usuario

        if(contraseña.equals(nContraseña)){
            verificado = true;
        }
        return verificado;
    }
}
