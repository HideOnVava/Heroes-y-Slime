package Clases;

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
            
        }
}
