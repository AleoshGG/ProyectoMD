import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        iniciarSecion();
    }
    
    public static void iniciarSecion() {
        Administrador admin = new Administrador();
        
        if (admin.accederSistema()==true){
            menuPrincipal(admin);
        }
    }
    
    public static void menuPrincipal(Administrador admin) {
        Scanner sc = new Scanner(System.in);        
        Inventario inventario =  new Inventario();
        ArrayList<Proveedor> proveedores = new ArrayList();        
        int opcion = 0;
        
        do {
            inventario.eliminarProducto("todas", 0, 0);
            System.out.println("\tMI BODEGA");
            System.out.println("Elija una de las opciones: ");
            System.out.println("1. Registrar Productos \n2. Guardar productos \n3. Sacar productos \n4. Eliminar Productos \n5. Ver cantidad productos \n6. Ver ubicacion productos\n7. Ver proveedores\n8. Salir");
            System.out.print(">> ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:                                      
                    inventario.crearProducto();
                    agregarProveedor(proveedores, inventario);
                    System.out.println("\n\tGUARDADO");
                break;
                case 2:
                    guardarProductos(inventario);
                break;
                case 3:
                    sacarProductos(inventario);
                break;
                case 4:
                    eliminarProducto(inventario);
                break;
                case 5:
                    verCantidadProductos(inventario);                  
                break;
                case 6:
                    verUbicacionProducto(inventario);
                break;
                case 7:
                    verProveedores(proveedores);
                break;
                case 8:
                    opcion = 0;
                break;
                default: System.out.println("No valido");
                break;
            }
            
        } while (opcion != 0);
    }
    
    public static void agregarProveedor(ArrayList<Proveedor> proveedores, Inventario inventario) {
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
                        inventario.getListaProductos().get(inventario.getListaProductos().size()-1).setProveedor(proveedores.get(i));
                        bandera = false;
                    }
                }
                if (bandera) {
                    System.out.println("NO ENCONTRADO");
                }
            } else if (opcion == 2 || bandera) {
                agregarNuevoProveedor(proveedores, inventario);
            }
        } else {
            agregarNuevoProveedor(proveedores, inventario);
        }
        
    }
    
    public static void agregarNuevoProveedor(ArrayList<Proveedor> proveedores, Inventario inventario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\tAgregar Nuevo Proveedor");
        Proveedor proveedor = new Proveedor();
                
        System.out.print("Ingrese el nombre: ");
        proveedor.setNombre(sc.nextLine());
        System.out.print("Ingrese la direccion: ");
        proveedor.setDireccion(sc.nextLine());
        System.out.print("Ingrese el numero telefonico: ");
        proveedor.setTelefono(sc.nextLong());
                
        inventario.getListaProductos().get(inventario.getListaProductos().size()-1).setProveedor(proveedor);
        proveedores.add(proveedor);
    } 
     
    public static void sacarProductos(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        int cantidad;
        String categoria;
        int codigo;
        
        System.out.println("\n\tSacar Productos");
        System.out.print("Ingrese la categoria del producto: ");
        categoria = sc.nextLine();
        System.out.print("Ingrese el codigo de barras: ");
        codigo = sc.nextInt();
        System.out.print("Ingrese la cantidad a sacar: ");
        cantidad = sc.nextInt();
        
        inventario.sacarProducto(categoria, codigo, cantidad);
    }
    
    public static void guardarProductos(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        int cantidad;
        String categoria;
        int codigo;
        
        System.out.println("\n\tGuardar Productos");
        System.out.print("Ingrese la categoria del producto: ");
        categoria = sc.nextLine();
        System.out.print("Ingrese el codigo de barras: ");
        codigo = sc.nextInt();
        System.out.print("Ingrese la cantidad a guardar: ");
        cantidad = sc.nextInt();
        
        inventario.guardarProducto(categoria, codigo, cantidad);
    }
    
    public static void eliminarProducto(Inventario inventario){
        Scanner sc = new Scanner(System.in);
        String categoria;
        int codigo;
        
        System.out.println("\n\tEliminar Producto");
        System.out.print("Ingrese la categoria del producto: ");
        categoria = sc.nextLine();
        System.out.print("Ingrese el codigo de barras: ");
        codigo = sc.nextInt();
        inventario.eliminarProducto(categoria, codigo, 1);
    }
    
    public static void verUbicacionProducto(Inventario inventario) {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        String categoria;
        String nombre;
        
        System.out.println("\n\tVer la ubicacion del producto");
        System.out.print("Ingrese la categoria del producto: ");
        categoria = sc.nextLine();
        System.out.print("Ingrese la nombre del producto: ");
        nombre = sc.nextLine();
        
        if (inventario.getListaProductos().size()>=1) {
            for(int i = 0; i < inventario.getListaProductos().size(); i++) {
                if (categoria.equals(inventario.getListaProductos().get(i).getCategoria()) && nombre.equals(inventario.getListaProductos().get(i).getNombre())) {
                    System.out.println(inventario.getListaProductos().get(i).getAnaquel().verUbicacion());
                    bandera = false;
                }
            }

            if (bandera) {
                System.out.println("NO ENCONTRADO");
            }
        }
        
    }
    
    public static void verProveedores(ArrayList<Proveedor> proveedores){
        System.out.println("\n\tProveedores");
        if (proveedores.size()>=1) {
            for (int i = 0; i < proveedores.size(); i++) {
                System.out.println(proveedores.get(i).verSujeto());
            }
        } else {
            System.out.println("Aun no hay proveedores");
        }
    }
    
    public static void verCantidadProductos(Inventario inventario) {
        System.out.println("\n\tDe los productos");
        
        if (inventario.getListaProductos().size()>=1) {
            for (int i = 0; i < inventario.getListaProductos().size(); i++) {
                System.out.println("Categoria: "+inventario.getListaProductos().get(i).getCategoria()+" Nombre: "+inventario.getListaProductos().get(i).getNombre()+" Cantidad: "+inventario.getListaProductos().get(i).getExistenciaProducto());
            }
        } else {
            System.out.println("Aun no hay productos");
        }
    }
}
