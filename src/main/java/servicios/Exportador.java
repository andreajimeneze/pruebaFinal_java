package servicios;

import modelos.Cliente;

import java.io.IOException;
import java.util.List;

public  abstract class  Exportador {

    public abstract void exportar(String fileName, List<Cliente> listaClientes) throws IOException;
}
