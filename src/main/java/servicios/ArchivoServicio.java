package servicios;

import lombok.Data;
import modelos.CategoriaEnum;
import modelos.Cliente;
import utilidades.ColorConsola;
import utilidades.Utilidad;
import java.io.*;
import java.util.List;

@Data
public class ArchivoServicio {

    String ruta = "C:/Users/andre/Desktop/";

    public void cargarDatos(String fileName, List<Cliente> listaClientes)  {
        String archivo = ruta + fileName;

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr))  {
            String line;
            while((line = br.readLine()) != null) {
                String[] dato = line.split(",");

                if(dato.length == 5) {
                    Cliente cliente = new Cliente(dato[0], dato[1], dato[2], dato[3], CategoriaEnum.valueOf(dato[4].toUpperCase()));
                    listaClientes.add(cliente);
                }
            }
            Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Clientes cargados correctamente");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void exportar(String fileName, List<Cliente> listaClientes,int opcion) throws IOException {
        ExportadorTxt exTXT = new ExportadorTxt();
        ExportadorCsv exCSV = new ExportadorCsv();

        if(opcion == 1) {
            exCSV.exportar(fileName, listaClientes);
        } else if (opcion == 2) {
            exTXT.exportar(fileName, listaClientes);
        }
    }
}
