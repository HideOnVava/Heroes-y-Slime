package Main;

import Clases.Aventura;
import Clases.Heroe;
import java.util.Scanner;

public class main {
    public static Scanner MyScanner = new Scanner(System.in);
    public static Heroe[] arreglo = new Heroe[5];
    public static int indice = 0;
    
    public static void main(String[] args) {
        int n = 0;
        while(n != 5){
            n = opcionesMenu();
            switch(n){
                case 1 -> {iniciaraventura();}
                case 2 -> {crearheroe();}
                case 3 -> {listaheroes();}
                case 4 -> {modificarheroes();}
                case 5 -> {salir();}
                default -> {limpiar(); esperar("Ingresa un valor valido.");}
            }
        }//Fin del while
    }//Fin del main
    
    public static int opcionesMenu(){
        limpiar();
        Scanner mS = new Scanner(System.in);
        System.out.println("TABERNA DE HEROES.");
        System.out.println("===================================");
        System.out.println("1. Iniciar aventura");
        System.out.println("2. Crear heroe");
        System.out.println("3. Ver tus heroes");
        System.out.println("4. Modificar heroes");
        System.out.println("5. Salir del programa");
        System.out.println("===================================");
        System.out.print("Ingresa una opcion: ");
        return mS.nextInt();
    }
    
    //Funciones de Heroes:
    public static void crearheroe(){
        limpiar();
        if(indice == 5){
            esperar("Ya has creado 5 heroes!");
            return;
        }
        Scanner mS = new Scanner(System.in);
        System.out.print("Ingresa el nombre de tu heroe: ");
        String nombre_hero = mS.nextLine();
        Heroe hero_a = new Heroe(nombre_hero);
        arreglo[indice] = hero_a;
        indice++;
        esperar("Heroe "+nombre_hero+" creado exitosamente!");
    }
    
    public static void listaheroes(){
        limpiar();
        if(indice == 0){
            esperar("Crea un heroe primero!");
            return;
        }
        System.out.println("LISTA DE TUS HEROES.");
        for(int i = 0; i < indice; i++){
            String s = "";
            if(arreglo[i].vivo()){
                s = " - VIVO";
            }else{
                s = " - MUERTO";
            }
            System.out.println((i+1)+". "+arreglo[i].getNombre() + " - Nivel "
                    +arreglo[i].getNivel() + " | Vida "
                    +arreglo[i].getVidaActual() +"/"+arreglo[i].getVidaMaxima()
                    +" | XP "+arreglo[i].getXp() +"/"+arreglo[i].getNivel()*4.5
                    + s);
        }
        System.out.println("==========================================");
        esperar(".");
    }
    
    public static void modificarheroes(){
        limpiar();
        if(indice == 0){
            esperar("Crea un heroe primero!");
            return;
        }
        //Lista Heroes
        System.out.println("SELECCIONA UN HEROE.");
        System.out.println("===================================");
        for(int i = 0; i < indice; i++){
            System.out.println((i+1)+". "+arreglo[i].getNombre());
        }
        System.out.println("===================================");
        //Lista Heroes
        Scanner mS = new Scanner(System.in);
        System.out.print("Ingresa el nombre del heroe a modificar: ");
        String nombre = mS.nextLine();
        int id = obtenerId(nombre);
        if(id == -1){
            esperar("Heroe no encontrado!");
            return;
        }
        int n = 0;
        while(n != 3){
            n = opcionesConfig(id);
            switch(n){
                case 1 -> {
                limpiar();
                    System.out.println("");
                    System.out.print("Ingresa el nuevo nombre: ");
                    String new_nombre = mS.nextLine();
                    arreglo[id].setNombre(new_nombre);
                    esperar("Nombre cambiado!");
                }
                case 2 -> {
                    for(int i = id; i < (indice-1); i++){
                        arreglo[i] = arreglo[i+1];
                    }
                    arreglo[indice-1] = null;
                    indice--;
                    esperar("Heroe eliminado");
                    return;
                }
                case 3 -> {}
            }
        }
    }
    
    public static int obtenerId(String nombre){
        for(int i = 0; i < indice; i++){
            if(arreglo[i].getNombre().equals(nombre)){
                return i;
            }
        }
        return -1;
    }
    
    public static int opcionesConfig(int id){
        limpiar();
        Scanner mS = new Scanner(System.in);
        System.out.println("MODIFICA A TU HEROE. ["+arreglo[id].getNombre()+"]!");
        System.out.println("===================================");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Eliminar heroe");
        System.out.println("3. Volver al menu");
        System.out.println("===================================");
        System.out.print("Ingresa una opcion: ");
        return mS.nextInt();
    }
    
    public static void iniciaraventura(){
        limpiar();
        if(indice == 0){
            esperar("Crea un heroe primero!");
            return;
        }
        //Lista Heroes
        System.out.println("SELECCIONA UN HEROE.");
        System.out.println("===================================");
        for(int i = 0; i < indice; i++){
            System.out.println((i+1)+". "+arreglo[i].getNombre());
        }
        System.out.println("===================================");
        //Lista Heroes
        Scanner mS = new Scanner(System.in);
        System.out.print("Ingresa el nombre del heroe: ");
        String nombre = mS.nextLine();
        int id = obtenerId(nombre);
        if(id == -1){
            esperar("Heroe no encontrado!");
            return;
        }
        Aventura nueva_aventura = new Aventura(arreglo[id]);
        nueva_aventura.inicio();
        limpiar();
        arreglo[id] = nueva_aventura.getHeroe();
        if(arreglo[id].vivo()){
            esperar("Volviste vivo al campamento!");
        }else{
            esperar("Tu heroe a muerto!");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Funciones Utilidad:
    
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
