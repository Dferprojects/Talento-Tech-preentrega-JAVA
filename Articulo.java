package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articulo {
    private long id;
    private String nombre;
    private String descripcion;
    private Double precio;

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
    public String getNombre() { return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
