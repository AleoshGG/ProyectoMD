package models;

import java.util.Date;

public class Producto {
    //Atributos
    private int codigoBarras;
    private double costo;
    private String nombre;
    private String categoria;
    private Date fechaCaducidad;
    private Proveedor proveedor = new Proveedor();
    private Anaquel anaquel = new Anaquel();
    
    //Métodos SETTER y GETTER
    public void setCodigoBarras(int codigo){
        codigoBarras = codigo;
    }
    
    public void setCosto(double costo){
        this.costo = costo;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public void setFecha(Date fecha){
        fechaCaducidad = fecha;
    }
    
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    
    public void setAnaquel(Anaquel anaquel){
        this.anaquel = anaquel;
    }
    
    public int getCodigoBarras(){
        return codigoBarras;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public Date getFechaCaducidad(){
        return fechaCaducidad;
    }
    
    public Proveedor getProveedor(){
        return proveedor;
    }
    
    public Anaquel getAnaquel(){
        return anaquel;
    }
    
    //Demás métodos
    public void crearProducto(){
        
    }
}
