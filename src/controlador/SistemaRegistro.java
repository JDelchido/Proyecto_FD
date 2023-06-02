package controlador;

import ConexionBaseDeDatos.QuerysUsuario;
import dominio.Usuario;

public class SistemaRegistro {

    public void insertar(Usuario u){ //Se utiliza para registrar los datoss una cuenta nueva ya verficados
        QuerysUsuario.insertar(u); //Devuelve un booleano si se logro insertar

    }
    public boolean buscarUsuario(String u){ //Se utiliza para saber si ya hay cuentas creadas con el mismo nombre de cuenta (Variable usuario) o el mismo email
        //Devuleve el numero de filas que tengan el mismo usuario o email
        return u.equals(QuerysUsuario.buscarUsuario(u));
    }
    public boolean buscarEmail(String m){ //Se utiliza para saber si ya hay cuentas creadas con el mismo nombre de cuenta (Variable usuario) o el mismo email
        return m.equals(QuerysUsuario.buscarEmail(m));
    }


}
