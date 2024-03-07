package models;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
        
    }
    
    @Override 
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/viewLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void iniciarSecion(Administrador admin) {

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
