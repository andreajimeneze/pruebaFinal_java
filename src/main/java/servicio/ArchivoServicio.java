package servicio;

import lombok.Data;
import modelo.CategoriaEnum;
import modelo.Cliente;
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
            System.out.println(ColorConsola.TEXTO_VERDE + "Clientes cargados correctamente");
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    @Override
    public void exportar(String fileName, List<Cliente> listaClientes,int opcion) throws IOException {
        ExportadorTxt exTXT = new ExportadorTxt();
        ExportadorCsv exCSV = new ExportadorCsv();

        if(opcion == 1) {
            exCSV.exportar(fileName, listaClientes);
        } else if (opcion == 2) {
            exTXT.exportar(fileName, listaClientes);
        }
    }

//        File archivo = new File(ruta + fileName.concat(".txt"));
//
//        if(!archivo.exists()) {
//            archivo.createNewFile();
//            System.out.println("Archivo creado con éxito");
//        } else {
//            System.out.println("Archivo ya existe");
//        }
//
//        try (FileWriter fw = new FileWriter(archivo);
//        BufferedWriter bf = new BufferedWriter(fw);) {
//            if(archivo.exists()) {
//                for(int i = 0; i < listaClientes.size(); i++) {
//                    bf.write(listaClientes.get(i).toString());
//                    bf.newLine();
//                }
//            }
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
