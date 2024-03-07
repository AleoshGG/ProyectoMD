package models;

public class Anaquel {
    //Atributos
    private int numeroAnaquel;
    private int seccion;
    private int existenciaProducto;
    
    //Métodos SETTER y GETTER
    public void setNumeroAnaquel(int numero){
        numeroAnaquel = numero;
    }
    
    public void setSeccion(int seccion){
        this.seccion = seccion;
    }
    
    public void setExistenciaProducto(int existencia){
        existenciaProducto = existencia;
    }
    
    public int getNumeroAnaquel(){
        return numeroAnaquel;
    }
    
    public int getSeccion(){
        return seccion;
    }
    
    public int getExistenciaProducto(){
        return existenciaProducto;
    }
    
    //Demás métodos
    public void verUbicacion(){
        System.out.println("\tUbicacion\nAnaquel: "+numeroAnaquel+"Seccion: "+seccion);
    }
}
