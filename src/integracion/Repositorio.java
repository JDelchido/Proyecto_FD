//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package integracion;

import dominio.Foro;
import dominio.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repositorio {
    private String consult;
    final String usser = "root";
    final String password = "";
    final String enlace = "jdbc:mysql://localhost:3306/usuario";

    public Repositorio() {
    }

    public boolean insertar(Usuario u) {
        boolean aux = false;
        String var10000 = u.getUsuario();
        String consult = "INSERT INTO usuario (nombre_usuario, nombre, apellido, email, contrasena) VALUES('" + var10000 + "','" + u.getNombre() + "','" + u.getApellido() + "','" + u.getEmail() + "','" + u.getContraseña() + "')";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(consult);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                aux = true;
                System.out.println("entro");
            }
        } catch (SQLException var7) {
            System.out.println("Error de conexión insertar" + var7.toString());
            var7.printStackTrace();
        }

        return aux;
    }

    public String buscar(String usuario) {
        String aux = "";
        this.consult = "SELECT contrasena FROM usuario WHERE nombre_usuario = '" + usuario + "'";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(this.consult);
            ResultSet resultado = ps.executeQuery();

            while(resultado.next()) {
                aux = resultado.getString("contrasena");
                System.out.println("entro");
            }
        } catch (SQLException var6) {
            System.out.println("Error de conexión buscar" + var6.toString());
            var6.printStackTrace();
        }

        return aux;
    }

    public String buscarUsuario(String usuario) {
        String aux = "";
        this.consult = "SELECT nombre_usuario FROM usuario WHERE nombre_usuario = '" + usuario + "'";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(this.consult);
            ResultSet resultado = ps.executeQuery();

            while(resultado.next()) {
                aux = resultado.getString("nombre_usuario");
                System.out.println("entro");
            }
        } catch (SQLException var6) {
            System.out.println("Error de conexión buscarUsuario" + var6.toString());
            var6.printStackTrace();
        }

        return aux;
    }

    public String buscarEmail(String email) {
        String aux = "";
        this.consult = "SELECT email FROM usuario WHERE email = '" + email + "'";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(this.consult);
            ResultSet resultado = ps.executeQuery();

            while(resultado.next()) {
                aux = resultado.getString("email");
                System.out.println("entro");
            }
        } catch (SQLException var6) {
            System.out.println("Error de conexión buscarEmail" + var6.toString());
            var6.printStackTrace();
        }

        return aux;
    }

    public Usuario obetenerUsuario(String usuario) {
        Usuario aux = new Usuario();
        this.consult = "SELECT * FROM usuario WHERE nombre_usuario = '" + usuario + "'";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(this.consult);
            ResultSet resultado = ps.executeQuery();

            while(resultado.next()) {
                aux.setUsuario(resultado.getString("nombre_usuario"));
                aux.setNombre(resultado.getString("nombre"));
                aux.setApellido(resultado.getString("apellido"));
                aux.setEmail(resultado.getString("email"));
                aux.setContraseña(resultado.getString("contrasena"));
                System.out.println("entro");
            }
        } catch (SQLException var6) {
            System.out.println("Error de conexión obtenerUsuario" + var6.toString());
            var6.printStackTrace();
        }

        return aux;
    }

    public void eliminar(String usuario) {
        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(this.consult);
            ResultSet resultado = ps.executeQuery();
            String query = "DELETE FROM usuario where nombre_usuario='" + usuario + "'";
            ps.executeUpdate(query);
        } catch (SQLException var6) {
            System.out.println("Error al conectarse a la base de datos: " + var6.getMessage());
        }

    }

    public boolean crearForo(Foro F) {
        boolean aux = false;
        String var10000 = F.getNombre();
        String consult = "INSERT INTO foro (nombreForo, tema, descripcion) VALUES('" + var10000 + "','" + F.getTema() + "','" + F.getDescipcion() + "')";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(consult);
            int resultado = ps.executeUpdate();
            if (resultado > 0) {
                aux = true;
                System.out.println("entro");
            }
        } catch (SQLException var7) {
            System.out.println("Error de conexión crear FORO" + var7.toString());
            var7.printStackTrace();
        }

        return aux;
    }

    public String buscarForoNombreTema(String nombreForo, String tema) {
        String aux = "";
        this.consult = "SELECT nombreForo, tema FROM foro WHERE nombreForo = '" + nombreForo + "'AND tema = '" + tema + "'";

        try {
            Connection aux1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuario", "root", "");
            PreparedStatement ps = aux1.prepareStatement(this.consult);
            ResultSet resultado = ps.executeQuery();

            while(resultado.next()) {
                aux = resultado.getString("nombreForo");
                System.out.println("entro");
            }
        } catch (SQLException var7) {
            System.out.println("Error de conexión buscarForoNombre" + var7.toString());
            var7.printStackTrace();
        }

        return aux;
    }
}
