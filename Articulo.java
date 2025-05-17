package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articulo {
    private long id;
    private static String nombre;
    private String descripcion;
    private static Double precio;
    public static ArrayList<Articulo> listadoArticulos = new ArrayList<>();

    //Constructores
    public Articulo(){}

    public Articulo(long id, String nombre,String descripcion, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    //Getters and setters
    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }
    public static String getNombre() { return nombre;}
    public static void setNombre(String nombre) {
        Articulo.nombre = nombre;
    }
    public String getDescripcion() {return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public static Double getPrecio() {
        return precio;
    }
    public static void setPrecio(Double precio) {
        Articulo.precio = precio;
    }

    //Métodos CRUD Artículos
    public static void ConsultarArticulo(){
        if(!chequearArticulos()){
            for (Articulo elemento: listadoArticulos) {
                elemento.mostrarNombreArticulos();
            }
        }
        else{
            validarArticulos();
        }
    }
    public static void ListarArticulos(){
        if(!chequearArticulos()){
            for (Articulo elemento: listadoArticulos) {
                elemento.mostrarAtributos();
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
                if(a.id == id){
                    sc.nextLine();
                    System.out.println("Ingrese nuevo nombre: ");

                    System.out.println("Ingrese nuevo precio:");

                }
            }
            System.out.println("El artículo fué modificado correctamente.");
            sc.close();
        }
        else{
            validarArticulos();
        }

    }
    public static void BorrarArticulo(){
        if(!chequearArticulos()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese ID del artículo a eliminar: ");
            int id = sc.nextInt();
            sc.nextLine();
            listadoArticulos.removeIf(a -> a.id == id);
            System.out.println("El artículo fué removido, si es que existía.");
            sc.close();
        }
        else{
            validarArticulos();
        }
    }

    public void mostrarAtributos(){
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + Articulo.nombre);
        System.out.println("Descripción: " + this.descripcion);
        System.out.println("Precio: " + this.precio);
    }

    public void mostrarNombreArticulos(){
        System.out.println("ID: " + this.id + ", Nombre: " + this.nombre);
    }

    //Artículos vacios
    public static boolean chequearArticulos() {
        return nombre == null || nombre.isEmpty() && (precio == null);
    }
    public static void validarArticulos(){
        if(chequearArticulos())
            System.out.println("No existen artículos");
        else
            System.out.println("Encontramos un artículo!");
    }

}
