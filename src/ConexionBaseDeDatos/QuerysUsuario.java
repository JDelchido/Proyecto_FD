package ConexionBaseDeDatos;

import dominio.Usuario;

import java.sql.*;

public class QuerysUsuario {

    public static String ValidarContrasena(String usuario) {
        String aux = "";
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement("SELECT contrasena FROM Proyecto.usuario WHERE nombre_usuario = ?")) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    aux = rs.getString("contrasena");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return aux;
    }

    public static Usuario obtenerUsuario(String usuario){
        Usuario aux = new Usuario();
        try{
            Connection conn = ConexionBaseDatos.getConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Proyecto.usuario WHERE nombre_usuario = ?");
            stmt.setString(1, usuario);
            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    aux.setUsuario(rs.getString("nombre_usuario"));
                    aux.setNombre(rs.getString("nombre"));
                    aux.setApellido(rs.getString("apellido"));
                    aux.setEmail(rs.getString("email"));
                    aux.setContrasena(rs.getString("contrasena"));
                }
            }
        }catch(SQLException ex){
            System.out.println("Error de conexión obtenerUsuario" +ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }

    public static boolean insertar(Usuario u) {
        boolean aux = false;
        try {
            Connection conn = ConexionBaseDatos.getConexion();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Proyecto.usuario (nombre_usuario, nombre, apellido, email, contrasena) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getNombre());
            stmt.setString(3, u.getApellido());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getContrasena());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                aux = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión insertar" + ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }
    public static String buscarUsuario(String usuario) {
        String aux = "";
        String consult = "SELECT nombre_usuario FROM Proyecto.usuario WHERE nombre_usuario = ?";
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement(consult)) {
            stmt.setString(1, usuario);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    aux = resultado.getString("nombre_usuario");
                    System.out.println("entro");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión buscarUsuario" + ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }
    public static String buscarEmail(String email) {
        String aux = "";
        String consult = "SELECT email FROM Proyecto.usuario WHERE email = ?";
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement(consult)) {
            stmt.setString(1, email);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    aux = resultado.getString("email");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexión buscarEmail" + ex.toString());
            ex.printStackTrace();
        }
        return aux;
    }
    public static void eliminar(String usuario) {
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Proyecto.usuario WHERE nombre_usuario = ?")) {
            stmt.setString(1, usuario);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        }
    }
    public static void cambiarUsuario(Usuario u) {
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement("UPDATE Proyecto.usuario SET nombre=?,nombre_usuario=?,apellido=?,contrasena=? WHERE Email = ?")) {
            stmt.setString(1, u.getNombre());
            stmt.setString(2, u.getUsuario());
            stmt.setString(3, u.getApellido());
            stmt.setString(4, u.getContrasena());
            stmt.setString(5, u.getEmail());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        }
    }

}






