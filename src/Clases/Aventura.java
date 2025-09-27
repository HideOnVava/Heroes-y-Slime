package Clases;

import java.util.Random;
import java.util.Scanner;

public class Aventura {
    //Atributos:
        private Heroe h1;
        private Slime s1;
    //Constructores:
        public Aventura(){
            h1 = null;
        }
        public Aventura(Heroe hero){
            h1 = hero;
            Slime enemigo = new Slime("Comun");
        }
    //Metodos getters y setters:
        public Heroe getHeroe(){return h1;}
    //Metodos:
        public void inicio(){
            while(h1.vivo()){
                int n = menu();
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
            //PREPAPRAR TODO PARA EL COMBATE
            boolean turno = true; // Turno del heroe inicia.
            //===============================================
            //GENERAR AL ENEMIGO EN ESTE COMBATE
            String rareza = generarRareza();
            s1 = new Slime(rareza);
            s1.setRareza();
            //===============================================
            //INICIAR SISTEMA DE COMBATE
            while(h1.vivo() && s1.vivo()){
                if(turno){
                    //TURNO DEL HEROE
                    int n = 0;
                    n = opcionesTurno();
                    switch(n){
                        case 1 -> {heroe_ataca();}
                        case 2 -> {s1.recibirDaño(999);}
                    }
                }else{
                    //TURNO DEL SLIME
                    turno_slime();
                }
                turno = !turno;
            }
            //===============================================
        }
        
        public void inventario(){
            limpiar();
            h1.mochila.mostrar();
            esperar(".");
        }
        
        public String generarRareza(){
            Random rnd = new Random();
            int n = rnd.nextInt(1,101);
            if(n == 1){
                return "Mythic";
            }
            if(n <= 4){
                return "Legendario";
            }
            if(n <= 20){
                return "Epico";
            }
            if(n <= 45){
                return "Raro";
            }
            return "Comun";
        }
        
        public int opcionesTurno(){
            limpiar();
            Scanner MyScanner = new Scanner(System.in);
            System.out.println("TURNO DEL HEROE.");
            System.out.println("===================================");
            System.out.println("1. Atacar!");
            System.out.println("2. Huir!");
            System.out.println("===================================");
            System.out.print("Ingresa una opcion: ");
            return MyScanner.nextInt();
        }
        
        public void heroe_ataca(){
            limpiar();
            System.out.println("===============================================");
            double ataque = h1.getAtaque();
            System.out.println("Realizas "+ataque +" de damage!");
            s1.recibirDaño(ataque);
            System.out.println("Vida del slime: "+s1.vida_actual+"/"+s1.vida_maxima);
            System.out.println("===============================================");
        }
        
        public void turno_slime(){
            Random rnd = new Random();
            int n = rnd.nextInt(1,101);
            System.out.println("TURNO DE "+s1.nombre);
            if(n <= 10){
                System.out.println("El slime se ha curado - "+s1.vida_actual+"/"+s1.vida_maxima);
                s1.curarse();
            }else if(n <= 100){
                System.out.println("El slime realiza "+s1.daño +" de damage");
                h1.recibirDaño(s1.daño);
                System.out.println("Vida del heroe: "+h1.getVidaActual()+"/"+h1.getVidaMaxima());
            }
            System.out.println("===============================================");
            esperar("Ronda terminada!");
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
