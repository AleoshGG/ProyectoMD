public class Proveedor extends Persona {
    //Atributos 
    private long telefono;
    private String direccion;
    
    //Métodos SETTER y GETTER
    public void setTelefono(long numero){
        telefono = numero;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public long getTelefono(){
        return telefono;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    //Demás métodos
    public String verSujeto() {
        return "\nNombre: "+nombre+"\nDireccion: "+direccion+"\nTelefono: "+telefono+"\nIdentificador: "+identificador;
    }
}
