public class Anaquel {
    //Atributos
    private int numeroAnaquel;
    private int seccion;
    
    //Métodos SETTER y GETTER
    public void setNumeroAnaquel(int numero){
        numeroAnaquel = numero;
    }
    
    public void setSeccion(int seccion){
        this.seccion = seccion;
    }    
    
    public int getNumeroAnaquel(){
        return numeroAnaquel;
    }
    
    public int getSeccion(){
        return seccion;
    }
     
    //Demás métodos
    public String verUbicacion() {
        return "\nEl producto esta ubicado en: \nAnaquel: "+numeroAnaquel+"  Seccion: "+seccion;
    }
}
