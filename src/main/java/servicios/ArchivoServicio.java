package servicios;

import lombok.Data;
import modelos.CategoriaEnum;
import modelos.Cliente;
import utilidades.ColorConsola;
import utilidades.Utilidad;
import java.io.*;
import java.util.List;
import java.util.Scanner;

@Data
public class ArchivoServicio extends Exportador{
    public void cargarDatos(String fileName, List<Cliente> listaClientes, Scanner sc)  {
        Utilidad.mensaje(ColorConsola.TEXTO_AMARILLO + "---------Cargar Datos según Sistema Operativo-----------");
        System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingresa la ruta donde se encuentra el archivo DBClientes.csv:");
        String ruta = Utilidad.generarRutaPorOS(sc);
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
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "El sistema no puede encontrar la ruta especificada");
        }
    }
   @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {

    }
}
