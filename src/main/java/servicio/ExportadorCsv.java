package servicio;

import modelo.Cliente;

import java.util.List;

public class ExportadorCsv extends Exportador {

    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        System.out.println("este método es heredado de Exportador");
    }
}
