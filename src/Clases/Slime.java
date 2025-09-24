package Clases;

import java.util.Random;

public class Slime {
    //Atributos:
        private String nombre;
        private String rareza;
        private int nivel;
        private double vida_actual;
        public double daño;
        public int xp;
    //Constructores:
        public Slime(String rareza){
            nombre = "";
            this.rareza = rareza;
            nivel = 0;
            vida_actual = 0;
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
            }
            calcular_stats();
        }
        
        public void comun(){
            String[] nombres = {"Jacob","Juan","Raul","Victor","Alejandro","Pepe","Paco"
                    ,"Isaac","Josue","Maiky2"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 1;
        }
        
        public void raro(){
            String[] nombres = {"Fran","Bryam","Neo","Alexis","Gael el acosador","Eidan"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 2;
        }
        
        public void epico(){
            String[] nombres = {"Yiyo","Daniel","David","Guti"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 3;
        }
        
        public void legendario(){
            String[] nombres = {"Toston el Ajolote","Oswi el profe","Maiky el god"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 4;
        }
        
        public void calcular_stats(){
            this.nombre += " el slime";
            this.vida_actual = 15 + (1.5 * nivel);
            this.daño = (nivel * 2) + (2.5 * (nivel*.5));
            this.xp = 2 + (nivel * 6);
        }
        
        public void mostrar_stats(){
            System.out.println(nombre + ".");
            System.out.println("==================================");
            System.out.println("Rareza: "+rareza);
            System.out.println("Nivel: "+nivel);
            System.out.println("Vida Actual: "+vida_actual);
            System.out.println("Daño: "+daño);
            System.out.println("Xp: "+xp);
        }
}
