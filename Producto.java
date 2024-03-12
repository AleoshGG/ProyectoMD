import java.util.Calendar;
import java.util.Scanner;

public class Producto {
    //Atributos
    private int codigoBarras;
    private double costo;
    private String nombre;
    private String categoria;
    private Calendar fechaCaducidad;
    private Proveedor proveedor = new Proveedor();
    private Anaquel anaquel = new Anaquel();
    private int existenciaProducto;
    
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
    
    public void setFecha(Calendar fecha){
        fechaCaducidad = fecha;
    }
    
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    
    public void setAnaquel(Anaquel anaquel){
        this.anaquel = anaquel;
    }
    
     public void setExistenciaProducto(int existencia){
        existenciaProducto = existencia;
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
    
    public Calendar getFechaCaducidad(){
        return fechaCaducidad;
    }
    
    public Proveedor getProveedor(){
        return proveedor;
    }
    
    public Anaquel getAnaquel(){
        return anaquel;
    }
    
    public int getExistenciaProducto(){
        return existenciaProducto;
    }
   
    //Demás métodos
    public void incluirProveedor() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el nombre: ");
        this.proveedor.setNombre(sc.nextLine());
      
        System.out.print("\nIngrese el numero de telefono: ");
        this.proveedor.setTelefono(sc.nextInt());
        sc.nextLine();
        System.out.print("\nIngrese la direccion: ");
        this.proveedor.setDireccion(sc.nextLine());
        
    }
    
    public void incluirAnaquel() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el numero de anaquel: ");
        this.anaquel.setNumeroAnaquel(sc.nextInt());

        System.out.print("\nIngrese el numero de seccion: ");
        this.anaquel.setSeccion(sc.nextInt());
       
    }
    
}
