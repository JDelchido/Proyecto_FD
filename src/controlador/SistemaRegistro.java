//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controlador;

import dominio.Usuario;
import integracion.Repositorio;

public class SistemaRegistro {
    private Repositorio BasesDeDatos2 = new Repositorio();

    public SistemaRegistro() {
    }

    public void insertar(Usuario u) {
        this.BasesDeDatos2.insertar(u);
    }

    public boolean buscarUsuario(String u) {
        return u.equals(this.BasesDeDatos2.buscarUsuario(u));
    }

    public boolean buscarEmail(String m) {
        return m.equals(this.BasesDeDatos2.buscarEmail(m));
    }
}

