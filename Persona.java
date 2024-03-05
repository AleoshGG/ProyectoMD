package Bodega;

public class Persona {
    //Atributos heredables 
    protected String nombre;
    protected int identificador;
    
    //Métodos SETTER y GETTER
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setIdentificador(int id){
        identificador = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getIdentificador(){
        return identificador;
    }
    
    //Demás métodos
    
}
