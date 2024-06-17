package utilidades;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Utilidad {
    public static void mensaje(String mensaje) {
        System.out.println(ColorConsola.TEXTO_DEFAULT + mensaje);
        System.out.println(" ");
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println(" ");
        }
    }

    public static void delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearArchivo(File archivo) throws IOException {
        if (!archivo.exists()) {
            archivo.createNewFile();
            System.out.println(ColorConsola.TEXTO_AMARILLO + "Archivo se creará");
        } else {
            System.out.println(ColorConsola.TEXTO_AMARILLO + "Archivo se actualizará");
        }
    }

    public static String generarRutaPorOS(Scanner sc) {
        String sistemaOperativo = System.getProperty("os.name");
        String separadorDir = "";
        String ruta = "";

        try {
            String textoRuta = sc.nextLine();

            if (textoRuta == null || textoRuta.isEmpty()) {
                return null;
            }
            String[] arrayRuta = textoRuta.split("/");

            if (sistemaOperativo.startsWith("Win")) {
                separadorDir = "\\";
            } else if (sistemaOperativo.startsWith("Lin")) {
                separadorDir = "/";
            }

            StringBuilder directorioRuta = new StringBuilder();
            for (String carpeta : arrayRuta) {
                directorioRuta.append(carpeta).append(separadorDir);
            }

            ruta = directorioRuta.toString();
            File directorio = new File(ruta);
            if (!directorio.exists() || !directorio.isDirectory()) {
                System.out.println("Error: La ruta especificada no existe o no es un directorio.");
                return null;
            }

        } catch (Exception e) {
            System.out.println(ColorConsola.TEXTO_ROJO + e.getMessage());
        }
        return ruta;
    }
}



