package Bodega;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Persona {
    //Atributos
    private String password = "admin";
    private ArrayList<Producto> alimentosEnlatados = new ArrayList<>();
    private ArrayList<Producto> lacteos = new ArrayList<>();
    private ArrayList<Producto> bebidas = new ArrayList<>();
    private ArrayList<Producto> panaderiaPasteleria = new ArrayList<>();
    private ArrayList<Producto> carnesEmbutidos = new ArrayList<>();
    private ArrayList<Producto> cerealesLegumbres = new ArrayList<>();
    private ArrayList<Producto> golosinas = new ArrayList<>();
    private ArrayList<Producto> limpieza = new ArrayList<>();
    private ArrayList<Producto> condimentosEspecias = new ArrayList<>();
    private ArrayList<Producto> cuidadoPersonal = new ArrayList<>();
    private ArrayList<Producto> paraElHogar = new ArrayList<>();
    private ArrayList<Producto> sinCategoria = new ArrayList<>();
    
    
    //Métodos SETTER y GETTER
    public void setPasword(String password){
        this.password = password;
    }
    
    public void setLiAlimentosEnlatados(Producto producto){
        alimentosEnlatados.add(producto);
    }
    
    public void setLiLacteos(Producto producto){
        lacteos.add(producto);
    }
    
    public void setLiBebidas(Producto producto){
        bebidas.add(producto);
    }
    
    public void setLiPanaderia(Producto producto){
        panaderiaPasteleria.add(producto);
    }
    
    public void setLiCarnes(Producto producto){
        carnesEmbutidos.add(producto);
    }
    
    public void setLiCereales(Producto producto){
        cerealesLegumbres.add(producto);
    }
    
    public void setLiGolosinas(Producto producto){
        golosinas.add(producto);
    }
    
    public void setLiLimpieza(Producto producto){
        limpieza.add(producto);
    }
    
    public void setLiCondimentos(Producto producto){
        condimentosEspecias.add(producto);
    }
    
    public void setLiCuidado(Producto producto){
        cuidadoPersonal.add(producto);
    }
    
    public void setLiHogar(Producto producto){
        paraElHogar.add(producto);
    }
    
    public void setSinCategoria(Producto producto){
        sinCategoria.add(producto);
    }
    
    public String getPassword(){
        return password;
    }
    
    public ArrayList<Producto> getLiAlimentosEnlatados(){
        return alimentosEnlatados;
    }
    
    public ArrayList<Producto> getLiLacteos(){
        return lacteos;
    }
    
    public ArrayList<Producto> getLiBebidas(){
        return bebidas;
    }
    
    public ArrayList<Producto> getLiPanaderia(){
        return panaderiaPasteleria;
    }
    
    public ArrayList<Producto> getLiCarnes(){
        return carnesEmbutidos;
    }
    
    public ArrayList<Producto> getLiCereales(){
        return cerealesLegumbres;
    }
    
    public ArrayList<Producto> getLiGolosinas(){
        return golosinas;
    }
    
    public ArrayList<Producto> getLiLimpieza(){
        return limpieza;
    }
    
    public ArrayList<Producto> getLiCondimentos(){
        return condimentosEspecias;
    }
    
    public ArrayList<Producto> getLiCuidado(){
        return cuidadoPersonal;
    }
    
    public ArrayList<Producto> getLiHogar(){
        return paraElHogar;
    }
    
    public ArrayList<Producto> getSinCategoria(){
        return sinCategoria;
    }
    
    //Demás métodos    
    public boolean accederSistema(){
        Scanner sc = new Scanner(System.in);
        boolean bandera;
        String password;
        int contador = 0;
        
        System.out.println("\tLogin");
        
        do {
            System.out.println("Ingrese la contraseña: ");
            password = sc.nextLine();
            
            if (password.equals(this.password)) {
                //Validacion exitosa
                bandera = true;
            } else {
                contador++;
                bandera = false;
            }
        
        } while (contador != 0 && contador < 3);
        return bandera;
    }

    public int busquedaNombre(String nombre){
        int indice = -1;
        
        int indices[] = {busquedaNombreListas(nombre,alimentosEnlatados),
                         busquedaNombreListas(nombre,lacteos),
                         busquedaNombreListas(nombre,bebidas),
                         busquedaNombreListas(nombre,panaderiaPasteleria),
                         busquedaNombreListas(nombre,carnesEmbutidos),
                         busquedaNombreListas(nombre,cerealesLegumbres),
                         busquedaNombreListas(nombre,golosinas),
                         busquedaNombreListas(nombre,limpieza),
                         busquedaNombreListas(nombre,condimentosEspecias),
                         busquedaNombreListas(nombre,cuidadoPersonal),
                         busquedaNombreListas(nombre,paraElHogar),
                         busquedaNombreListas(nombre,sinCategoria)
        };
        
        for (int i = 0; i < indices.length; i++){
            if (indices[i] >=0 ) {
                indice = indices[i];
            }
        }
        
        if (indice == -1 ) {
            System.out.println("No se encontro");
        } 
        
        return indice;
    }
    
    public int busquedaNombreListas(String nombre, ArrayList<Producto> categoria){
        int indice = -1;
        
        for (int i = 0; i < categoria.size(); i++) {
            if (nombre.equals(categoria.get(indice).getNombre())) {
                indice = i;
            }
        }
        
        return indice;
    }
    
    public int busquedaCodigo(int codigo){
        int indice = -1;
        
        int indices[] = {busquedaCodigoListas(codigo,alimentosEnlatados),
                         busquedaCodigoListas(codigo,lacteos),
                         busquedaCodigoListas(codigo,bebidas),
                         busquedaCodigoListas(codigo,panaderiaPasteleria),
                         busquedaCodigoListas(codigo,carnesEmbutidos),
                         busquedaCodigoListas(codigo,cerealesLegumbres),
                         busquedaCodigoListas(codigo,golosinas),
                         busquedaCodigoListas(codigo,limpieza),
                         busquedaCodigoListas(codigo,condimentosEspecias),
                         busquedaCodigoListas(codigo,cuidadoPersonal),
                         busquedaCodigoListas(codigo,paraElHogar),
                         busquedaCodigoListas(codigo,sinCategoria)
        };
        
        for (int i = 0; i < indices.length; i++){
            if (indices[i] >=0 ) {
                indice = indices[i];
            }
        }
        
        if (indice == -1 ) {
            System.out.println("No se encontro");
        } 
        
        return indice;
    }
    
    public int busquedaCodigoListas(int codigo, ArrayList<Producto> categoria){
        int indice = -1;
        
        for (int i = 0; i < categoria.size(); i++) {
            if (nombre.equals(categoria.get(indice).getCodigoBarras())) {
                indice = i;
            }
        }
        
        return indice;
    }
}
