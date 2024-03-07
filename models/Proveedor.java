package models;

public class Proveedor extends Persona {
    //Atributos 
    private int telefono;
    private String direccion;
    
    //Métodos SETTER y GETTER
    public void setTelefono(int numero){
        telefono = numero;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public int getTelefono(){
        return telefono;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    //Demás métodos
    public void crearProveedor(String nombre,int telefono, String direccion){
        super.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public void verPersona(){
        System.out.println("Nombre: "+nombre+" Telefono: "+telefono+" Direccion: "+direccion);
    }
}
