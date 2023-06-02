package ConexionBaseDeDatos;

import dominio.Comentario;
import dominio.Foro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class QueryComentario {
    static Vector<Comentario> obtenerComentariosForo(Connection conn, int ID) throws SQLException {
        Vector<Comentario> comentarios = new Vector<>();
        try (PreparedStatement stmt = conn.prepareStatement("SELECT contenido, usuario FROM Proyecto.Comentario WHERE foro_id = ?")) {
            stmt.setInt(1, ID);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String contenido = rs.getString("contenido");
                    String usuario = rs.getString("usuario");
                    Comentario comentario = new Comentario(contenido, usuario);
                    comentarios.add(comentario);
                }
            }
        }
        return comentarios;
    }

    public static void Agregar(String usuario, String text, int id) {
        try {
            Connection conn = ConexionBaseDatos.getConexion();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Proyecto.comentario (usuario,foro_id,contenido) VALUES (?, ?, ?)");
            stmt.setString(1, usuario);
            stmt.setInt(2, id);
            stmt.setString(3, text);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de conexión insertar" + ex.toString());
            ex.printStackTrace();
        }
    }
}
