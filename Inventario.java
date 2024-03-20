import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList();
    
    public ArrayList<Producto> getListaProductos() {
        return productos;
    }
    
    public void crearProducto(ArrayList<Proveedor> proveedores) {
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
        agregarProveedor(proveedores, producto);
        productos.add(producto);
        System.out.println("\n\tGUARDADO");
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
            default:
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
    
    public static void agregarProveedor(ArrayList<Proveedor> proveedores, Producto producto) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean bandera = true;
        String nombre;
        
        if (proveedores.size()>=1) {
            System.out.print("\nDesea agregar un proveedor existente? \n1. SI\n2. NUEVO\n>> ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            if (opcion == 1) {
                System.out.print("\nEscriba el nombre del proveedor: ");
                nombre = sc.nextLine();
                for (int i = 0; i < proveedores.size(); i++) {
                    if (nombre.equals(proveedores.get(i).getNombre())) {
                        producto.setProveedor(proveedores.get(i));
                        bandera = false;
                    }
                }
                if (bandera) {
                    System.out.println("NO ENCONTRADO");
                }
            } else if (opcion == 2 || bandera) {
                agregarNuevoProveedor(proveedores, producto);
            }
        } else {
            agregarNuevoProveedor(proveedores, producto);
        }
        
    }
    
    public static void agregarNuevoProveedor(ArrayList<Proveedor> proveedores, Producto producto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\tAgregar Nuevo Proveedor");
        Proveedor proveedor = new Proveedor();
                
        System.out.print("Ingrese el nombre: ");
        proveedor.setNombre(sc.nextLine());
        System.out.print("Ingrese la direccion: ");
        proveedor.setDireccion(sc.nextLine());
        System.out.print("Ingrese el numero telefonico: ");
        proveedor.setTelefono(sc.nextLong());
                
        producto.setProveedor(proveedor);
        proveedores.add(proveedor);
    }
    
    public void guardarProducto() {
        boolean bandera = true;
        Scanner sc = new Scanner(System.in);
        int cantidad;
        String categoria;
        int codigo;
        
        System.out.println("\n\tGuardar Productos");
        categoria = elegirCategoria();
        System.out.print("Ingrese el codigo de barras: ");
        codigo = sc.nextInt();
        System.out.print("Ingrese la cantidad a guardar: ");
        cantidad = sc.nextInt();
        
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
    
    public void sacarProducto() {
        Scanner sc = new Scanner(System.in);
        int cantidad;
        String categoria;
        int codigo;
        
        System.out.println("\n\tSacar Productos");
        categoria = elegirCategoria();
        System.out.print("Ingrese el codigo de barras: ");
        codigo = sc.nextInt();
        System.out.print("Ingrese la cantidad a sacar: ");
        cantidad = sc.nextInt();
        
        boolean bandera = true;
        
        
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
    
    public void eliminarProducto(int comportamiento) {
        boolean bandera = true;
        Calendar fechaActual = Calendar.getInstance();
        
        if (comportamiento == 0) {
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
            
        if (comportamiento == 1) {
            Scanner sc = new Scanner(System.in);
        
            System.out.println("\n\tEliminar Producto");
            String categoria = elegirCategoria();
            System.out.print("Ingrese el codigo de barras: ");
            int codigo = sc.nextInt();
            
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
    
    public void modificarProducto(ArrayList<Proveedor> proveedores) {
        Scanner sc = new Scanner(System.in);
        String categoria = elegirCategoria();
        boolean bandera = true;
        int codigo;
        
        System.out.println("\n\tEdicion de productos");
        System.out.print("Ingrese el codigo de barras: ");
        codigo = sc.nextInt();
        
        for (int i = 0; i < productos.size(); i++) {
            if ((categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras())) {
                    int opcion;
                    
                    System.out.println("Elija el campo que desera alterar: ");
                    System.out.print("1. Atributos (Nombre/Categoria/Codigo de barras)\n2. Ubicacion\n3.Proveedor\n4. Fecha de caducidad \n5. Adquisicion (Cantidad/Precio)\n6. Regresar");
                    opcion = sc.nextInt();
                    
                    switch (opcion){
                        case 1:
                            System.out.print("Ingrese la categoria del producto: ");
                            productos.get(i).setCategoria(elegirCategoria());
                            System.out.print("Ingrese el codigo de barras: ");
                            productos.get(i).setCodigoBarras(sc.nextInt());
                            sc.nextLine();
                            System.out.print("Ingrese el nombre del producto: ");
                            productos.get(i).setNombre(sc.nextLine());
                        break;
                        case 2:
                            System.out.print("Ingrese el numero de anaquel: ");
                            productos.get(i).getAnaquel().setNumeroAnaquel(sc.nextInt());
                            System.out.print("Ingrese el numero de seccion: ");
                            productos.get(i).getAnaquel().setSeccion(sc.nextInt());
                        break;
                        case 3:
                            agregarProveedor(proveedores, productos.get(i));
                        break;
                        case 4:
                            agregarFecha(productos.get(i));
                        break;
                        case 5:
                            System.out.print("Ingrese la cantidad de productos a guardar: ");
                            productos.get(i).setExistenciaProducto(sc.nextInt());
                            System.out.print("Ingrese el costo con el que se adquirio: ");
                            productos.get(i).setCosto(sc.nextDouble());
                        break;
                        case 6:
                        break;
                        default:System.out.println("No valido");
                        break;
                    }
                
                    bandera = false;
                }
            }
        
        if (bandera) {
            System.out.println("NO ENCONTRADO");
        } 
    } 
}
