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
        int opcion = 0;
        
        do {
            inventario.eliminarProducto("todas", 0, 0);
            System.out.println("\tMI BODEGA");
            System.out.println("Elija una de las opciones: ");
            System.out.println("1. Registrar Productos \n2. Guardar productos \n3. Sacar productos \n4. Eliminar Productos \n5. Ver Limpeza");
            System.out.print(">>");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Proveedor proveedor = new Proveedor();
                    proveedor.nombre = "Alexis"; 
                    inventario.crearProducto(proveedor);
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
