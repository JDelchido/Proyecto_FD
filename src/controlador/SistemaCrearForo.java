
package controlador;

import dominio.Foro;
import integracion.Repositorio;

public class SistemaCrearForo {
    private Repositorio BaseDeDatos2 = new Repositorio();

    public SistemaCrearForo() {
    }

    public void crearForo(Foro f) {
        this.BaseDeDatos2.crearForo(f);
    }

    public boolean buscarNombreTemaForo(String f, String t) {
        return f.equals(this.BaseDeDatos2.buscarForoNombreTema(f, t));
    }
}
