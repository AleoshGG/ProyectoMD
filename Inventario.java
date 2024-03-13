import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList();
    
    public ArrayList<Producto> getListaProductos() {
        return productos;
    }
    
    public void crearProducto() {
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();
        
        System.out.println("\tREGISTRO");
        System.out.print("Ingrese el codigo de barras: ");
        producto.setCodigoBarras(sc.nextInt());
        System.out.print("Ingrese el costo con el que se adquirio: ");
        producto.setCosto(sc.nextDouble());
        sc.nextLine();
        System.out.print("Ingrese el nombre: ");
        producto.setNombre(sc.nextLine());        
        producto.setCategoria(elegirCategoria());
        agregarFecha(producto);
        System.out.println("\tUbicacion");
        System.out.print("Ingrese el numero de anaquel: ");
        producto.getAnaquel().setNumeroAnaquel(sc.nextInt());
        System.out.print("Ingrese el numero de seccion: ");
        producto.getAnaquel().setSeccion(sc.nextInt());
        System.out.print("Ingrese la cantidad de productos a guardar: ");
        producto.setExistenciaProducto(sc.nextInt());
    
        productos.add(producto);
        
    }
    
    public static String elegirCategoria() {
        Scanner sc = new Scanner(System.in);
        String categoria = "Sin categoria";
        int opcion;
        System.out.println("\nElija la categoria");
        System.out.print("1. Alimentos Enlatados\n2. Lacteos\n3. Bebidas\n4. Panaderia\n5. Carnes y embutidos\n6. Cereales y Legumbres\n7. Golosinas\n8. Limpieza\n9. Condimentos y Especias\n10. Cuidado personal\n11. Para el hogar\n12. Sin categoria\n>> ");
        opcion = sc.nextInt();
        
        switch (opcion) {
            case 1: categoria = "Alimentos Enlatados";
            break;
            case 2: categoria = "Lacteos";
            break;
            case 3: categoria = "Bebidas";
            break;
            case 4: categoria = "Panaderia";
            break;
            case 5: categoria = "Carnes y Embutidos";
            break;
            case 6: categoria = "Cereales y Legumbres";
            break;
            case 7: categoria = "Golosinas";
            break;
            case 8: categoria = "Limpieza";
            break;
            case 9: categoria = "Condimentos y Especias";
            break;
            case 10: categoria = "Cuidado personal";
            break;
            case 11: categoria = "Para el hogar";
            break;
            case 12: categoria = "Sin categoria";
            break;
            default:System.out.println("Se aniadio a SIN CATEGORIA");
            break;
        }
        return categoria;
    }
    
    private void agregarFecha(Producto producto) {
        Scanner sc = new Scanner(System.in);
        int year, month, day;
        
        System.out.println("\n\tFecha de caducidad");
        System.out.print("Ingrese el anio: ");
        year = sc.nextInt();
        System.out.print("Ingrese el mes: ");
        month = sc.nextInt();
        System.out.print("Ingrese el dia: ");
        day = sc.nextInt();
        
        Calendar fechaCaducidad = new GregorianCalendar(year,month,day);
        
        producto.setFecha(fechaCaducidad);
    }
    
    public void guardarProducto(String categoria, int codigo, int cantidad) {
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
                        productos.get(i).setExistenciaProducto(productos.get(i).getExistenciaProducto()-cantidad);
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
                for (int i = 0; i < productos.size(); i++) {
                    if (fechaActual.get(Calendar.YEAR) >= productos.get(i).getFechaCaducidad().get(Calendar.YEAR) &&
                        fechaActual.get(Calendar.MONTH) >= productos.get(i).getFechaCaducidad().get(Calendar.MONTH) &&    
                        fechaActual.get(Calendar.DAY_OF_MONTH) >= productos.get(i).getFechaCaducidad().get(Calendar.DAY_OF_MONTH)) {
                        System.out.println("PRODUCTO CADUCADO");
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
