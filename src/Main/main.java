package Main;

import Clases.Heroe;
import java.util.Scanner;

public class main {
    public static Scanner MyScanner = new Scanner(System.in);
    public static Heroe[] arreglo = new Heroe[5];
    public static int indice = 0;
    
    public static void main(String[] args) {
        int n = 0;
        while(!(n == 5)){
            n = opcionesMenu();
            switch(n){
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {salir();}
                default -> {limpiar(); esperar("Ingresa un valor valido.");}
            }
        }//Fin del while
    }//Fin del main
    
    public static int opcionesMenu(){
        limpiar();
        Scanner mS = new Scanner(System.in);
        System.out.println("MENU OPCIONES.");
        System.out.println("1. Iniciar aventura.");
        System.out.println("2. Crear heroe.");
        System.out.println("3. Ver tus heroes.");
        System.out.println("4. Modificar heroes");
        System.out.println("5. Salir del programa");
        System.out.print("Ingresa una opcion: ");
        return mS.nextInt();
    }
    
    public static void salir(){
        limpiar();
        System.out.println("Saliste del programa.");
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
