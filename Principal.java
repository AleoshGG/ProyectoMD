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
            System.out.println("1. Registrar Productos \n2. Guardar productos \n3. Sacar productos \n4. Eliminar Productos \n5. Ver Limpeza");
            System.out.print(">> ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:                                      
                    inventario.crearProducto();
                    agregarProveedor(proveedores, inventario);
                    System.out.println("\n\tGUARDADO");
                break;
                case 2:
                    inventario.guaradarProducto("Limpieza", 1234, 5);
                break;
                case 3:
                    inventario.sacarProducto("Limpieza", 1234, 5);
                break;
                case 4:
                    inventario.eliminarProducto("Limpieza", 1234, 1);
                break;
                case 5:
                    for (int i = 0; i < inventario.getListaProductos().size(); i++){
                        System.out.println("Proveedor: "+inventario.getListaProductos().get(i).getProveedor().verSujeto());
                        System.out.println(inventario.getListaProductos().get(i).getCategoria());
                        System.out.println(inventario.getListaProductos().get(i).getNombre());
                        System.out.println(inventario.getListaProductos().get(i).getExistenciaProducto());
                    }                    
                break;
                case 6:
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
    
    public static void filtrarProductos(Administrador admin){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        System.out.println("\tFlitro de productos");
        System.out.println("1. Seleccionar categoria\n 2. Buscar por nombre \n3.Buscar por codigo de barras");
        System.out.print(">> ");
        opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("se muestran todas las categorias");
                //guardar productos en cada opcion admin.guardarProducto
                
            break;
            case 2:
                sc.nextLine();
                System.out.println("Ingrese el nombres del producto: ");
               
            break;
            case 3:
                sc.nextLine();
                System.out.println("Ingrese el nombres del producto: ");
                
            break;
            default: System.out.println("No valido");
            break;
        }
        
    }
    
    public static void sacarProductos(){}
    
    public static void verCategorias(){}
    
    public static void verProveedores(){}
}
