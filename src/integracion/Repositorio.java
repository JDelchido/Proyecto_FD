package integracion;

import dominio.Usuario;

import java.sql.*;

public class Repositorio {
    private String consult;

    //cambiar para la base de datos de oracle
    final String usser = "root";
    final String password ="";
    final String enlace = "jdbc:mysql://localhost:3306/usuario";

    public boolean insertar(Usuario u){
        boolean aux = false;

        String consult = "INSERT INTO usuario (nombre_usuario, nombre, apellido, email, contrasena) VALUES('" + u.getUsuario() + "','" + u.getNombre() + "','" + u.getApellido() + "','" + u.getEmail() + "','" + u.getContraseña() + "')";
        try{
            Connection aux1= DriverManager.getConnection(enlace, usser, password);
            PreparedStatement ps = aux1.prepareStatement(consult);
            int resultado = ps.executeUpdate();
            if(resultado>0){
                aux=true;
                System.out.println("entro");
            }
        }catch(SQLException ex){
            System.out.println("Error de conexión insertar" +ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }
    public String buscar(String usuario){
        String aux = "";
        consult = "SELECT contrasena FROM usuario WHERE nombre_usuario = "+"'"+usuario+"'";
        try{
            Connection aux1= DriverManager.getConnection(enlace, usser, password);
            PreparedStatement ps = aux1.prepareStatement(consult);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                aux = resultado.getString("contrasena");
                System.out.println("entro");
            }
        }catch(SQLException ex){
            System.out.println("Error de conexión buscar" +ex.toString());
            ex.printStackTrace();
        }
        return aux;
     }

     public String buscarUsuario(String usuario){
         String aux = "";
         consult = "SELECT nombre_usuario FROM usuario WHERE nombre_usuario = "+"'"+usuario+"'";
         try{
             Connection aux1= DriverManager.getConnection(enlace, usser, password);
             PreparedStatement ps = aux1.prepareStatement(consult);
             ResultSet resultado = ps.executeQuery();
             while(resultado.next()){
                 aux = resultado.getString("nombre_usuario");
                 System.out.println("entro");
             }
         }catch(SQLException ex){
             System.out.println("Error de conexión buscarUsuario" +ex.toString());
             ex.printStackTrace();
         }
         return aux;
     }

    public String buscarEmail(String email){
        String aux = "";
        consult = "SELECT email FROM usuario WHERE email = "+"'"+email+"'";
        try{
            Connection aux1= DriverManager.getConnection(enlace, usser, password);
            PreparedStatement ps = aux1.prepareStatement(consult);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                aux = resultado.getString("email");
                System.out.println("entro");
            }
        }catch(SQLException ex){
            System.out.println("Error de conexión buscarEmail" +ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }
    public Usuario obetenerUsuario(String usuario){
        Usuario aux = new Usuario();
        consult = "SELECT * FROM usuario WHERE nombre_usuario = "+"'"+usuario+"'";
        try{
            Connection aux1= DriverManager.getConnection(enlace, usser, password);
            PreparedStatement ps = aux1.prepareStatement(consult);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                aux.setUsuario(resultado.getString("nombre_usuario"));
                aux.setNombre(resultado.getString("nombre"));
                aux.setApellido(resultado.getString("apellido"));
                aux.setEmail(resultado.getString("email"));
                aux.setContraseña(resultado.getString("contrasena"));
                System.out.println("entro");
            }
        }catch(SQLException ex){
            System.out.println("Error de conexión obtenerUsuario" +ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }

    public void eliminar(String usuario) {
        try {
            Connection aux1= DriverManager.getConnection(enlace, usser, password);
            PreparedStatement ps = aux1.prepareStatement(consult);
            ResultSet resultado = ps.executeQuery();
            String query = "DELETE FROM usuario where nombre_usuario='"+usuario+"'";
            ps.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());

        }

    }
}
