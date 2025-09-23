package Clases;

import java.util.Random;

public class Heroe {
    //Atributos:
        private String nombre;
        private int nivel;
        private int xp;
        private int vida_actual;
        private int vida_maxima;
        private int fuerza;
        
        public Mochila mochila;
    //Constructores (default y parametrizado):
        public Heroe(String nombre){
            this.nombre = nombre;
            nivel = 1;
            xp = 0;
            vida_actual = 20;
            vida_maxima = 20;
            fuerza = 5;
            
            mochila = new Mochila();
        }
    //Metodos getters y setters:
        public String getNombre() {return nombre;}
        public void setNombre(String nombre) {this.nombre = nombre;}
        
        public int getNivel() {return nivel;}
        public void setNivel(int nivel) {this.nivel = nivel;}
        
        public int getXp() {return xp;}
        public void setXp(int xp) {this.xp = xp;}
        
        public int getVidaActual() {return vida_actual;}
        public void setVidaActual(int vida_actual) {this.vida_actual = vida_actual;}
        
        public int getVidaMaxima() {return vida_maxima;}
        public void setVidaMaxima(int vida_maxima) {this.vida_maxima = vida_maxima;}
        
        public int getFuerza() {return fuerza;}
        public void setFuerza(int fuerza) {this.fuerza = fuerza;}
        
    //Metodos:
        public double getAtaque() {
            Random rnd = new Random();
            int n = rnd.nextInt(1,4);
            if(n == 1){
                return (fuerza + (nivel * 1.5) * 1.5);
            }
            return fuerza + (nivel * 1.5);
        }   
        
        public void mostrar(){
            System.out.println("Nombre: "+ nombre);
            System.out.println("Nivel: "+ nivel);
            System.out.println("Xp: "+ xp +"/"+ (nivel*4.5));
            System.out.println("Vida: "+ vida_actual +"/"+ vida_maxima);
            System.out.println("Fuerza: "+ fuerza);
            System.out.println("Ataque: "+ getAtaque());
        }
        
        public void recibirXp(int xp_obtenida){
            xp += xp_obtenida;
            if(xp >= (nivel*4.5)){
                xp = xp - (int)(nivel*4.5);
                subirNivel();
            }
        }
        
        public void subirNivel(){
            nivel++;
            vida_maxima += (5*nivel);
            vida_actual = vida_maxima;
            fuerza += 2;
        }
}
