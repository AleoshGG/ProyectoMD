import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Administrador admin = new Administrador();
        iniciarSecion(admin);
    }
    
    public static void iniciarSecion(Administrador admin) {
        if (admin.accederSistema()==true){
            menuPrincipal(admin);
        }
    }
    
    public static void menuPrincipal(Administrador admin) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        do {
        
            System.out.println("\tMI BODEGA");
            System.out.println("Elija una de las opciones: ");
            System.out.println("1. Registrar entrada \n2. Sacar productos \n3. Ver categorias \n4. Proveedores \n5. Salir");
            System.out.print(">>");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    filtrarProductos(admin);
                break;
                case 2:
                    sacarProductos();
                break;
                case 3:
                    verCategorias();
                break;
                case 4:
                    verProveedores();
                break;
                case 5:
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
                admin.guardarProducto(-1, admin.getSinCategoria());
            break;
            case 2:
                sc.nextLine();
                System.out.println("Ingrese el nombres del producto: ");
                admin.busquedaNombre(sc.nextLine());
            break;
            case 3:
                sc.nextLine();
                System.out.println("Ingrese el nombres del producto: ");
                admin.busquedaCodigo(sc.nextInt());
            break;
            default: System.out.println("No valido");
            break;
        }
        
    }
    
    public static void sacarProductos(){}
    
    public static void verCategorias(){}
    
    public static void verProveedores(){}
}
