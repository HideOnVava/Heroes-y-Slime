package Clases;

import java.util.Random;
import java.util.Scanner;

public class Aventura {
    //Atributos:
        private Heroe h1;
    //Constructores:
        public Aventura(){
            h1 = null;
        }
        public Aventura(Heroe hero){
            h1 = hero;
        }
    //Metodos getters y setters:
        public Heroe getHeroe(){return h1;}
    //Metodos:
        public void inicio(){
            int n = 0;
            while(h1.vivo()){
                n = menu();
                switch(n){
                    case 1 -> {combate();}
                    case 2 -> {inventario();}
                    case 3 -> {}
                    case 4 -> {}
                    case 5 -> {return;}
                    default -> {limpiar(); esperar("Ingresa una opcion valida!");}
                }
            }
        }
        
        public int menu(){
            limpiar();
            Scanner MyScanner = new Scanner(System.in);
            System.out.println("PRADERA VERDE.");
            System.out.println("===============================");
            System.out.println("1. Empezar combate");
            System.out.println("2. Inventario");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. Salir");
            System.out.println("===============================");
            System.out.print("Ingresa una opcion: ");
            return MyScanner.nextInt();
        }
        
        public void combate(){
            limpiar();
            //===============================================
            Random rnd = new Random();
            String rareza = "";
            int n = rnd.nextInt(1,10);
            if(n == 1){
                rareza = "Legendario";
            }else{
                n = rnd.nextInt(1,8);
                if(n == 1){
                    rareza = "Epico";
                }else{
                    n = rnd.nextInt(1,5);
                    if(n == 1){
                        rareza = "Raro";
                    }else{
                        rareza = "Comun";
                    }
                }
            }
            Slime enemigo = new Slime(rareza);
            enemigo.setRareza();
            //===============================================
            enemigo.mostrar_stats();
            h1.recibirDaño(enemigo.daño);
            esperar(".");
        }
        
        public void inventario(){
            limpiar();
            h1.mochila.mostrar();
            esperar(".");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        public void limpiar(){
            for(int i = 0; i < 20; i++){
                System.out.println("");
            }
        }
        
        public void esperar(String s){
            Scanner MyScanner = new Scanner(System.in);
            System.out.println(s + " Presiona enter para continuar.");
            MyScanner.nextLine();
        }
}
