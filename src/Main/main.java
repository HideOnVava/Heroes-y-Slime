package Main;

import java.util.Scanner;

public class main {
    public static Scanner MyScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 0;
        while(true){
            System.out.print("Ingresa -1 para salir: ");
            n = MyScanner.nextInt();
            if(n == -1){
                break;
            }
            System.out.println("Decidiste continuar.");
        }//Fin del while
    }//Fin del main
    
}
