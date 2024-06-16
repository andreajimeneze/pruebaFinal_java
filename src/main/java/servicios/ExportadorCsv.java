package servicios;

import modelos.Cliente;
import utilidades.ColorConsola;
import utilidades.Utilidad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorCsv extends Exportador {

    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) throws IOException {
        String ruta = "C:/Users/andre/Desktop/";;
        File archivo = new File(ruta + fileName.concat(".csv"));

        Utilidad.crearArchivo(archivo);

        try (FileWriter fw = new FileWriter(archivo);
             BufferedWriter bf = new BufferedWriter(fw);) {
            if(archivo.exists()) {
                for(int i = 0; i < listaClientes.size(); i++) {
                    bf.write(listaClientes.get(i).toString());
                    bf.newLine();
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Archivo .CSV cargado con éxito");
    }
}
