package servicios;

import modelos.Cliente;
import utilidades.ColorConsola;
import utilidades.Utilidad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ExportadorCsv extends Exportador {
    Scanner sc = new Scanner(System.in);
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) throws IOException {

        if (listaClientes.isEmpty()) {
            Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "No se puede guardar una lista vacía");
        } else {

            System.out.println(ColorConsola.TEXTO_DEFAULT + "Ingresa la ruta donde quiere guardar el archivo:");
            String ruta = Utilidad.generarRutaPorOS(sc);

            if (ruta == null) {
                Utilidad.mensaje(ColorConsola.TEXTO_ROJO + "Error: La ruta del archivo es inválida");
            } else {
                File archivo = new File(ruta + fileName.concat(".csv"));
                Utilidad.crearArchivo(archivo);

                try (FileWriter fw = new FileWriter(archivo);
                     BufferedWriter bf = new BufferedWriter(fw);) {
                    if (archivo.exists()) {
                        for (int i = 0; i < listaClientes.size(); i++) {
                            bf.write(listaClientes.get(i).toString());
                            bf.newLine();
                        }
                        Utilidad.mensaje(ColorConsola.TEXTO_VERDE + "Archivo .CSV cargado con éxito");
                    }
                } catch (Exception e) {
                    Utilidad.mensaje(ColorConsola.TEXTO_ROJO + e.getMessage());
                }
            }
        }
    }
}
