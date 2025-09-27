package Clases;

import java.util.Random;

public class Slime {
    //Atributos:
        public String nombre;
        public String rareza;
        public int nivel;
        public double vida_actual;
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
                case "Mythic" -> {mythic();}
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
        
        public void mythic(){
            String[] nombres = {"Michelle Padilla","Zapata","Ulloa","Karla"};
            int n = nombres.length;
            Random rnd = new Random();
            this.nombre = nombres[rnd.nextInt(0,n)];
            this.nivel = 10;
        }
        
        public void calcular_stats(){
            this.nombre += " el slime";
            this.vida_actual = 15 + (1.5 * nivel);
            this.daño = (nivel * 2) + (2.5 * (nivel*.5));
            this.xp = 2 + (nivel * 6);
        }
        
        public void recibirDaño(double daño){
            vida_actual -= daño;
            vida_actual = Math.max(vida_actual, 0);
        }
        
        public void curarse(){
            vida_actual += (nivel/2) * 5;
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
            System.out.println("Ataque: "+daño);
            System.out.println("Xp: "+xp);
        }
}
