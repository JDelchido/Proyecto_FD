package controlador;

public class SistemaCrearForo {

    public SistemaCrearForo(){}

    public boolean CrearForo(String nombre, String tema, String descripcion, String administrador)
    {
        boolean insertado = false;

        //insertado = BaseDeDatos.insertar(nombre, tema, descripcion, administrador); //Se insertan los datos en la base de datos

        return insertado;
    }
}
