package servicio;

import modelo.Cliente;

import java.util.List;

public class ExportadorTxt extends Exportador {
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        System.out.println("este método TAMBIÉN es heredado de Exportador");
    }
}
