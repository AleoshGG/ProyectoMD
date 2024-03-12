import java.util.Scanner;

public class Administrador extends Persona {
    //Atributos
    private String password;
    
    public Administrador() {
        super.nombre = "Admin";
        password = "admin1";
    }
    
    //Demás métodos    
    public boolean accederSistema(){
        Scanner sc = new Scanner(System.in);
        boolean bandera;
        String password,nombre;
        int contador = 0;
        
        System.out.println("\tLogin");
        
        do {
            System.out.println("Ingrese el usuario: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese la contraseña: ");
            password = sc.nextLine();
            
            if (password.equals(this.password) && nombre.equals(this.nombre)) {
                //Validacion exitosa
                bandera = true;
            } else {
                contador++;
                bandera = false;
            }
        
        } while (contador != 0 && contador < 3);
        
        return bandera;
    }
    
    public String verSujeto() {
        return "\nNombre: "+nombre+"\nIdentificador: "+identificador;
    }
    
}
