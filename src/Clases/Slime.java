package Clases;

import java.util.Random;

public class Slime {
    //Atributos:
        public String nombre;
        public String rareza;
        public int nivel;
        public double vida_actual;
        public double vida_maxima;
        public double daño;
        public int xp;
    //Constructores:
        public Slime(String rareza){
            nombre = "";
            this.rareza = rareza;
            nivel = 0;
            vida_actual = 0;
            vida_maxima = 0;
            daño = 0;
            xp = 0;
        }
    //Metodos getters y setters:
    //Metodos:
        public void setRareza(){
            switch(rareza){
                case "Comun" -> {comun();}
                case "Raro" -> {raro();}
                case "Epico" -> {epico();}
                case "Legendario" -> {legendario();}
                case "Mythic" -> {mythic();}
            }
            calcular_stats();
        }
        
        public void comun(){
            String[] nombres = {"JACOB","JUAN","RAUL","VICTOR","ALEJANDRO","PEPE","PACO"
                    ,"ISAAC","JOSUE","MAIKY 2"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 1;
        }
        
        public void raro(){
            String[] nombres = {"FRAN","BRYAM","NEO","ALEXIS","GAEL","EIDAN"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 2;
        }
        
        public void epico(){
            String[] nombres = {"YIYO","DANIEL","DAVID","GUTI"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 3;
        }
        
        public void legendario(){
            String[] nombres = {"TOSTON EL AJOLOTE","OSWI","MAIKY"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 4;
        }
        
        public void mythic(){
            String[] nombres = {"MICHELLE PADILLA","ZAPATA","ULLOA","KARLA"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 10;
        }
        
        public void calcular_stats(){
            this.nombre += " EL SLIME";
            this.vida_maxima = 15 + (1.5 * nivel);
            this.vida_actual = vida_maxima;
            this.daño = (nivel * 3) + 2.5;
            this.xp = 1 + (nivel * 3);
        }
        
        public void recibirDaño(double daño){
            vida_actual -= daño;
            vida_actual = Math.max(vida_actual, 0);
        }
        
        public void curarse(){
            vida_actual += (nivel/2) * 5;
            vida_actual = Math.min(vida_actual,vida_maxima);
        }
        
        public boolean vivo(){
            return vida_actual > 0;
        }
        
        public void mostrar_stats(){
            System.out.println(nombre + ".");
            System.out.println("==================================");
            System.out.println("Rareza: "+rareza);
            System.out.println("Nivel: "+nivel);
            System.out.println("Vida Actual: "+vida_actual);
            System.out.println("Vida maxima: "+vida_maxima);
            System.out.println("Ataque: "+daño);
            System.out.println("Xp: "+xp);
        }
}
