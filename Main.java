package Business;
/*
Enunciado del ejercicio:
Consigna:
Crear un programa en Java que simule un menú de gestión de artículos en consola.
El menú debe tener las siguientes 6 opciones:
1-Crear un artículo nuevo
2-Consultar un artículo
3-Listar artículos
4-Modificar un artículo
5-Borrar un artículo
6-Salir
El programa debe funcionar de la siguiente manera:
Mostrar el menú de opciones.
Solicitar al usuario que ingrese un número correspondiente a la opción deseada.
Según la opción seleccionada, mostrar un mensaje en consola usando System.out.println(), indicando qué opción fue elegida (por ejemplo: "Opción Crear artículo seleccionada.").
El menú debe repetirse hasta que el usuario elija la opción 6 - Salir, momento en el cual el programa finalizará mostrando el mensaje "Programa finalizado.".
Notas:
Utilizar un bucle while para mantener el programa en ejecución hasta que el usuario decida salir.
Utilizar Scanner para capturar la entrada del usuario.
*/


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Business.Articulo.listadoArticulos;

public class Main {
    public static void main(String[] args) {
        Saludar();
        Menu();
    }
    public static void Saludar(){
        System.out.println("Bienvenido a la APP!");
    }
    public static void Menu(){
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        while(opcion !=6){
        System.out.println("A continuación elija una opción: ");
        System.out.println("1 - Crear un artículo nuevo");
        System.out.println("2 - Consultar un artículo");
        System.out.println("3 - Listar artículos");
        System.out.println("4 - Modificar un artículo");
        System.out.println("5 - Borrar un artículo");
        System.out.println("6 - Salir");
        opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1:
                CrearArticulo();
                break;
            case 2:
                Articulo.ConsultarArticulo();
                break;
            case 3:
                Articulo.ListarArticulos();
                break;
            case 4:
                Articulo.ModificarArticulo();
                break;
            case 5:
                Articulo.BorrarArticulo();
                break;
            case 6:
                Despedida();
                break;
            default:
                System.out.println("Opción inválida.");
        }
        }
    }
    public static void CrearArticulo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del artículo: ");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Ingrese el nombre del artículo: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese una breve descripción del artículo: ");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el precio del artículo: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        listadoArticulos.add(new Articulo(id, nombre, descripcion, precio));
        System.out.println("El artículo fué creado con éxito!");
    }
    public static void Despedida(){
        System.out.println("La aplicación se cerrará, nos vemos pronto.");
    }



}