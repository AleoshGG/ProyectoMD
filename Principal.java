import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        iniciarSecion();
    }
    
    public static void iniciarSecion() {
        Administrador admin = new Administrador();
        
        if (admin.accederSistema()){
            menuPrincipal(admin);
        }
    }
    
    public static void menuPrincipal(Administrador admin) {
        Scanner sc = new Scanner(System.in);        
        Inventario inventario =  new Inventario();
        ArrayList<Proveedor> proveedores = new ArrayList();        
        int opcion = 0;
        
        do {
            inventario.eliminarProducto( 0);
            System.out.println("\tMI BODEGA");
            System.out.println("Elija una de las opciones: ");
            System.out.println("1. Registrar Productos \n2. Guardar productos \n3. Sacar productos \n4. Eliminar Productos \n5. Ver productos \n6. Ver la ubicacion de un producto\n7. Ver proveedores\n8. Modificar un producto\n9. Salir");
            System.out.print(">> ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:                                      
                    inventario.crearProducto(proveedores);                    
                break;
                case 2:
                    if (leerLista(inventario.getListaProductos(), "Aun no hay productos")) {
                        inventario.guardarProducto();
                    }
                break;
                case 3:
                    if (leerLista(inventario.getListaProductos(), "Aun no hay productos")) {
                        inventario.sacarProducto();
                    }
                break;
                case 4:
                    if (leerLista(inventario.getListaProductos(),"Aun no hay productos")) {
                        inventario.eliminarProducto( 1);
                    }
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
                    if (leerLista(inventario.getListaProductos(),"Aun no hay productos")) {
                        inventario.modificarProducto(proveedores);
                    }
                break;
                case 9:
                    opcion = 0;
                break;
                default: System.out.println("No valido");
                break;
            }
            
        } while (opcion != 0);
    }
    
    private static boolean leerLista(ArrayList lista, String mensaje){
        boolean bandera = false;
        
        if (lista.size() >= 1) {
            bandera = true;
        } else {
            System.out.println(mensaje);
        }
        
        return bandera;
    }
    
    public static void verUbicacionProducto(Inventario inventario) {
        if (leerLista(inventario.getListaProductos(),"Aun no hay productos")) {
            Scanner sc = new Scanner(System.in);
            boolean bandera = true;
            String categoria;
            String nombre;

            System.out.println("\n\tVer la ubicacion del producto");
            categoria = inventario.elegirCategoria();
            System.out.print("Ingrese la nombre del producto: ");
            nombre = sc.nextLine();
            
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
        if (leerLista(proveedores,"Aun no hay proveedores")) {
            for (int i = 0; i < proveedores.size(); i++) {
                System.out.println(proveedores.get(i).verSujeto());
            }
        } 
    }
    
    public static void verCantidadProductos(Inventario inventario) {
        System.out.println("\n\tDe los productos");
        
        if (leerLista(inventario.getListaProductos(),"Aun no hay productos")) {
            for (int i = 0; i < inventario.getListaProductos().size(); i++) {
                System.out.println("Categoria: "+inventario.getListaProductos().get(i).getCategoria()+" Nombre: "+inventario.getListaProductos().get(i).getNombre()+" Cantidad: "+inventario.getListaProductos().get(i).getExistenciaProducto()+" Codigo de barras: "+inventario.getListaProductos().get(i).getCodigoBarras());
            }
        }
    }

}
