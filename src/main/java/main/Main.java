package main;

import modelo.CategoriaEnum;
import utilidades.ColorConsola;
import vista.Menu;

public class Main {
    public static void main(String[] args) {
//        String dato = "ACTIVO";
//        String dato2 = "INACTIVO";
        String dato3 = "Activo";

        System.out.println(CategoriaEnum.valueOf(dato3.toUpperCase()));

        Menu menu = new Menu();
        menu.iniciarMenu();

    }
}
