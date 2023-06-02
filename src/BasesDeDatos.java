import dominio.Usuario;

import java.sql.*;

public class BasesDeDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/usuario";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static int buscar_usuario(String usuario) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = BasesDeDatos.conectar();

            stmt = conn.createStatement();

            String query = "SELECT COUNT(*) FROM usuario.infousuario WHERE Usuario = '" + usuario + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public static int buscar_correo(String correo) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = BasesDeDatos.conectar();

            stmt = conn.createStatement();

            String query = "SELECT COUNT(*) FROM usuario.infousuario WHERE Correo = '" + correo + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public static boolean insertar(Usuario usuario) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = BasesDeDatos.conectar();
            stmt = conn.createStatement();
            System.out.println(usuario.getNombre());

            String query = "INSERT INTO usuario.infousuario (Nombres, Apellidos, Correo, Usuario, Contrasena)\n" + "VALUES ('" + usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getEmail() + "', '" + usuario.getUsuario() + "','" + usuario.getContraseña() + "');";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static String buscarContraseña(String usuario) {
        String contraseña = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = BasesDeDatos.conectar();

            stmt = conn.createStatement();

            String query = "SELECT Contrasena FROM usuario.infousuario WHERE Usuario ='" + usuario + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                contraseña = rs.getString("Contrasena");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return contraseña;
    }

    public static String getnombre(String usuario) {
        String nombres = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = BasesDeDatos.conectar();

            stmt = conn.createStatement();

            String query = "SELECT Nombres FROM usuario.infousuario WHERE Usuario ='" + usuario + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                nombres = rs.getString("Nombres");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nombres;
    }

    public static String getapellido(String usuario) {
        String Apellidos = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = BasesDeDatos.conectar();

            stmt = conn.createStatement();

            String query = "SELECT Apellidos FROM usuario.infousuario WHERE Usuario ='" + usuario + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                Apellidos = rs.getString("Apellidos");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Apellidos;
    }

    public static String getcorreo(String usuario) {
        String Correo = "";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = BasesDeDatos.conectar();

            stmt = conn.createStatement();

            String query = "SELECT Correo FROM usuario.infousuario WHERE Usuario ='" + usuario + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                Correo = rs.getString("Correo");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Correo;
    }

    public static boolean Eliminar(String usuario) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = BasesDeDatos.conectar();
            stmt = conn.createStatement();

            String query = "DELETE FROM usuario.infousuario where Usuario='"+usuario+"'";
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}

