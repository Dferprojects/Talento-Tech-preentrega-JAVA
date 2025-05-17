package Business;
/*
Enunciado del ejercicio:
Consigna:
Crear un programa en Java que simule un menú de gestión de artículos en consola.
El menú debe tener las siguientes 6 opciones:
1-Crear un artículo nuevo  FUNCA!
2-Consultar un artículo    FUNCA!
3-Listar artículos         FUNCA!
4-Modificar un artículo    FUNCA!
5-Borrar un artículo
6-Salir                    FUNCA!
El programa debe funcionar de la siguiente manera:
Mostrar el menú de opciones.
Solicitar al usuario que ingrese un número correspondiente a la opción deseada.
Según la opción seleccionada, mostrar un mensaje en consola usando System.out.println(), indicando qué opción fue elegida (por ejemplo: "Opción Crear artículo seleccionada.").
El menú debe repetirse hasta que el usuario elija la opción 6 - Salir, momento en el cual el programa finalizará mostrando el mensaje "Programa finalizado.".
Notas:
Utilizar un bucle while para mantener el programa en ejecución hasta que el usuario decida salir.
Utilizar Scanner para capturar la entrada del usuario.
*/



import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static ArrayList<Articulo> listadoArticulos = new ArrayList<>();
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
        System.out.println("6 - Crear un pedido");
        System.out.println("7 - Consultar un pedido");
        System.out.println("8 - Salir");
        opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion){
            case 1:
                CrearArticulo();
                break;
            case 2:
                ConsultarArticulo();
                break;
            case 3:
                ListarArticulos();
                break;
            case 4:
                ModificarArticulo();
                break;
            case 5:
                BorrarArticulo();
                break;
            case 6:
            case 7:
                Mensaje();
                break;
            case 8:
                Despedida();
                break;
            default:
                System.out.println("Opción inválida.");
        }
        }
    }

    //Métodos CRUD Artículos
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
    public static void ConsultarArticulo(){
        if(!chequearArticulos()){
            for (Articulo elemento: listadoArticulos) {
                System.out.println("ID: " + elemento.getId() + ", " + "Nombre: " + elemento.getNombre());
            }
        }
        else{
            validarArticulos();
        }
    }
    public static void ListarArticulos(){
        if(!chequearArticulos()){
            for (Articulo elemento: listadoArticulos) {
                System.out.println("ID: " + elemento.getId());
                System.out.println("Nombre: " + elemento.getNombre());
                System.out.println("Descripción: " + elemento.getDescripcion());
                System.out.println("Precio: " + elemento.getPrecio());
            }
        } else{
            validarArticulos();
        }
    }
    public static void ModificarArticulo(){
        if(!chequearArticulos()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese ID del artículo a modificar: ");
            int id = sc.nextInt();
            for (Articulo a: listadoArticulos){
                if(a.getId() == id){
                    sc.nextLine();
                    System.out.println("Ingrese un nuevo nombre: ");
                    a.setNombre(sc.nextLine());
                    System.out.println("Ingrese una nueva descripción: ");
                    a.setDescripcion(sc.nextLine());
                    System.out.println("Ingrese un nuevo precio:");
                    a.setPrecio(sc.nextDouble());
                    System.out.println("El artículo fué modificado correctamente.");
                    return;
                }
            }
            sc.close();
        }
        else{
            validarArticulos();
        }

    }
    public static void BorrarArticulo(){
        if(!chequearArticulos()){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese ID del artículo a eliminar: ");
                int id = sc.nextInt();
                sc.nextLine();
                for (Articulo elemento: listadoArticulos) {
                    if(elemento.getId()==id){
                        listadoArticulos.removeIf(articulo -> articulo.getId()==id);
                        System.out.println("El artículo fué removido con éxito.");}
                    else{
                    System.out.println("No se encontró el artículo solicitado.");
                }
            }
            sc.close();
        } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            validarArticulos();
        }
    }

    /*public static void BorrarArticulo() {
        if (!chequearArticulos()) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print("Ingrese ID del artículo a eliminar: ");
                if (sc.hasNextInt()) {
                    int id = sc.nextInt();
                    boolean eliminado = listadoArticulos.removeIf(articulo -> articulo.getId() == id);

                    if (eliminado) {
                        System.out.println("El artículo ha sido eliminado exitosamente.");
                    } else {
                        System.out.println("No se encontró un artículo con el ID proporcionado.");
                    }
                } else {
                    System.out.println("ID inválido. Por favor, ingrese un número.");
                }
            }
        }
        else{
            validarArticulos();
        }
    }
*/

    //Artículos vacio
    public static boolean chequearArticulos() {
        return listadoArticulos.isEmpty();
    }
    public static void validarArticulos(){
        if(!chequearArticulos())
            System.out.println("Encontramos un artículo!");
        else
            System.out.println("No existen artículos");
    }
    public static void Despedida(){
        System.out.println("La aplicación se cerrará, nos vemos pronto.");
    }
    public static void Mensaje(){
        System.out.println("*** En construcción ***");
        System.out.println("No funca aún jeje.");
    }
}