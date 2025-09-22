package Clases;

public class Heroe {
    //Atributos:
        private String nombre;
        private int nivel;
        private int xp;
        private int vida_actual;
        private int vida_maxima;
        private int fuerza;
    //Constructores (default y parametrizado):
        public Heroe(){
            nombre = "";
            nivel = 0;
            xp = 0;
            vida_actual = 0;
            vida_maxima = 0;
            fuerza = 0;
        }
        
        public Heroe(String nombre){
            this.nombre = nombre;
            nivel = 1;
            xp = 0;
            vida_actual = 20;
            vida_maxima = 20;
            fuerza = 5;
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
        
        public double getAtaque() {
            return fuerza + (nivel * 1.5);
        }   
    //Metodos:
        public void mostrar(){
            System.out.println("Nombre: "+ nombre);
            System.out.println("Nivel: "+ nivel);
            System.out.println("Xp: "+ xp +"/"+ (nivel*4.5));
            System.out.println("Vida: "+ vida_actual +"/"+ vida_maxima);
            System.out.println("Fuerza: "+ fuerza);
            System.out.println("Ataque: "+ getAtaque());
        }
        
        public void recibirXp(int xp){
            this.xp += xp;
            if(this.xp >= (nivel*4.5)){
                subirNivel();
                this.xp = this.xp - (int)(nivel*4.5);
            }
        }
        
        public void subirNivel(){
            nivel++;
            vida_maxima += (5*nivel);
            vida_actual = vida_maxima;
            fuerza += 2;
        }
}
