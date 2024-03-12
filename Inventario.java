import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList();
    
    public void crearProducto(Proveedor proveedor) {
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();
        
        System.out.println("\tREGISTRO");
        System.out.print("Ingrese el codigo de barras: ");
        producto.setCodigoBarras(sc.nextInt());
        System.out.print("\nIngrese el costo con el que se adquirio: ");
        producto.setCosto(sc.nextDouble());
        System.out.print("\nIngrese el nombre: ");
        producto.setNombre(sc.nextLine());
        sc.nextLine();
        System.out.print("\nIngrese su categoria: ");
        producto.setCategoria(sc.nextLine());
        agregarFecha(producto);
        producto.setProveedor(proveedor);
        sc.nextLine();
        System.out.println("\tUbicacion");
        System.out.print("Ingrese el numero de anaquel: ");
        producto.getAnaquel().setNumeroAnaquel(sc.nextInt());
        System.out.print("\nIngrese el numero de seccion: ");
        producto.getAnaquel().setSeccion(sc.nextInt());
        System.out.print("\nIngrese la cantidad de productos a guardar: ");
        producto.setExistenciaProducto(sc.nextInt());
        System.out.println("\n\tGUARDADO");
    }
    
    private void agregarFecha(Producto producto) {
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        
        System.out.println("\n\tFecha de caducidad");
        System.out.print("\nIngrese el anio: ");
        year = sc.nextInt();
        System.out.print("\nIngrese el mes: ");
        month = sc.nextInt();
        System.out.print("\nIngrese el dia: ");
        day = sc.nextInt();
        
        Calendar fechaCaducidad = new GregorianCalendar(year,month,day);
        
        producto.setFecha(fechaCaducidad);
    }
    
    public void guaradarProducto(String categoria, int codigo, int cantidad) {
        boolean bandera = true;
        
        if (productos.size()>=1){
            for (int i = 0; i < productos.size(); i++) {
                if (categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras()) {
                    productos.get(i).setExistenciaProducto(cantidad+productos.get(i).getExistenciaProducto());
                    agregarFecha(productos.get(i));
                    bandera = false;
                }
            }
            if (bandera) {
                System.out.println("NO ENCONTRADO");
            }           
        }
    }
    
    public void sacarProducto(String categoria, int codigo, int cantidad) {
        boolean bandera = true;
        
        if (productos.size()>=1){
            for (int i = 0; i < productos.size(); i++) {
                if (categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras()) {
                    if (cantidad <= productos.get(i).getExistenciaProducto()) {
                        productos.get(i).setExistenciaProducto(cantidad-productos.get(i).getExistenciaProducto());
                        bandera = false;
                    } else {
                        System.out.println("No se puede sacar mas de lo que hay en existencia");
                        bandera =  false;
                    }                    
                }
            }
            if (bandera) {
                System.out.println("NO ENCONTRADO");
            }           
        }
    }
    
    public void eliminarProducto(String categoria, int codigo, int opcion) {
        boolean bandera = true;
        Calendar fechaActual = Calendar.getInstance();
        
        if (opcion == 0) {
            if (productos.size()>=1){
                for (int i = 0; i < productos.size(); i++) {
                    if (fechaActual.get(Calendar.YEAR) == productos.get(i).getFechaCaducidad().get(Calendar.YEAR) &&
                        fechaActual.get(Calendar.MONTH) == productos.get(i).getFechaCaducidad().get(Calendar.MONTH) &&    
                        fechaActual.get(Calendar.DAY_OF_MONTH) == productos.get(i).getFechaCaducidad().get(Calendar.DAY_OF_MONTH)) {
                        productos.remove(i);
                        bandera = false;
                    }
                }        
        }
            
        if (opcion == 1) {
            for (int i = 0; i < productos.size(); i++) {
                if ((categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras())) {
                    productos.remove(i);
                    bandera = false;
                }
            }
            if (bandera) {
                System.out.println("NO ENCONTRADO");
            }
        }
                       
        }
    }
}
