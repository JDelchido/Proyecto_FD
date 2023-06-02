package ConexionBaseDeDatos;
import dominio.Comentario;
import dominio.Foro;
import dominio.Usuario;

import java.sql.*;
import java.util.Vector;

public class QuerysForo {
    public static boolean buscarForoNombreTema(String tema, String nombre) {
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM Proyecto.Foro WHERE nombre = ? AND tema = ?")) {

            stmt.setString(1, nombre);
            stmt.setString(2, tema);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int contador = resultSet.getInt(1);
                    return contador>0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static void CrearForo(Foro foro)
    {
        boolean aux = false;
        try {
            Connection conn = ConexionBaseDatos.getConexion();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Proyecto.Foro (nombre,tema,descripcion) VALUES (?, ?, ?)");
            stmt.setString(1,foro.getNombre());
            stmt.setString(2, foro.getTema());
            stmt.setString(3, foro.getDescripcion());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de conexión insertar" + ex.toString());
            ex.printStackTrace();
        }
    }
    public static Foro EncontrarForo(String nombre, String tema) {
        Foro aux = new Foro();
        try (Connection conn = ConexionBaseDatos.getConexion();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Proyecto.Foro WHERE nombre = ? AND tema = ?")) {

            stmt.setString(1, nombre);
            stmt.setString(2, tema);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    aux.setNombre(rs.getString("nombre"));
                    aux.setTema(rs.getString("tema"));
                    aux.setDescripcion(rs.getString("descripcion"));
                    aux.setID(rs.getInt("foro_id"));

                    Vector<Comentario> comentarios = QueryComentario.obtenerComentariosForo(conn,aux.getID());
                    aux.setComentario(comentarios);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aux;
    }
    public static Vector<Foro> BuscarForosPorNombre(String Nombre)
    {
        Vector<Foro> foros = new Vector<>();
        try(Connection conn = ConexionBaseDatos.getConexion();
            PreparedStatement stmt =conn.prepareStatement("SELECT * FROM Proyecto.Foro WHERE nombre LIKE ?")){
            stmt.setString(1, "%" + Nombre + "%");
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    String nombre=rs.getString("nombre");
                    String tema=rs.getString("tema");
                    String descripcion=rs.getString("descripcion");
                    int ID=rs.getInt("foro_id");
                    Vector<Comentario> comentarios=QueryComentario.obtenerComentariosForo(conn,ID);
                    Foro foro=new Foro(ID,nombre,tema,descripcion,comentarios);
                    foros.add(foro);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foros;
    }
    public static Vector<Foro> BuscarForosPorTema(String Tema)
    {
        Vector<Foro> foros = new Vector<>();
        try(Connection conn = ConexionBaseDatos.getConexion();
            PreparedStatement stmt =conn.prepareStatement("SELECT * FROM Proyecto.foro WHERE tema = ?")){
            stmt.setString(1,Tema);
            try(ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    String nombre=rs.getString("nombre");
                    String tema=rs.getString("tema");
                    String descripcion=rs.getString("descripcion");
                    int ID=rs.getInt("foro_id");
                    Vector<Comentario> comentarios=QueryComentario.obtenerComentariosForo(conn,ID);
                    Foro foro=new Foro(ID,nombre,tema,descripcion,comentarios);
                    foros.add(foro);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foros;
    }
}
