package Clases;

public class Mochila {
    //Atributos:
        private int monedas;
        private int pociones;
        private int llaves;
    //Constructores:
        public Mochila(){
            monedas = 0;
            pociones = 0;
            llaves = 0;
        }
    //Metodos getters y setters:
        public int getMonedas() {return monedas;}
        public int getPociones() {return pociones;}
        public int getLlaves() {return llaves;}
    //Metodos:
        public void mostrar(){
            System.out.println("INVENTARIO.");
            System.out.println("===============================");
            System.out.println("Monedas. x"+monedas);
            System.out.println("Pociones. x"+pociones);
            System.out.println("Llaves. x"+llaves);
            System.out.println("================= s==============");
        }
}
