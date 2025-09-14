package Main;

import java.util.Scanner;

public class main {
    public static Scanner MyScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 0;
        while(!(n == 4)){
            limpiar();
            n = opciones();
            switch(n){
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {limpiar(); esperar("Saliste.");}
                default -> {limpiar(); esperar("Ingresa una opcion valida.");}
            }
        }//Fin del while
    }//Fin del main
    
    public static int opciones(){
        Scanner mS = new Scanner(System.in);
        System.out.println("OPCIONES.");
        System.out.println("1.");
        System.out.println("2.");
        System.out.println("3.");
        System.out.println("4. Salir del programa");
        System.out.print("Ingresa una opcion: ");
        return mS.nextInt();
    }
    
    public static void limpiar(){
        for(int i = 0; i < 20; i++){
            System.out.println();
        }
    }
    
    public static void esperar(String s){
        Scanner mS = new Scanner(System.in);
        System.out.print(s + " Presiona enter para continuar.");
        mS.nextLine();
    }
    
}
