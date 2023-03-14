package sajatnev;

import java.util.Random;
import java.util.Scanner;

public class SajatNev {

    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] tomb = feltolt(5);
        kiir(tomb);
        
        //felhasznalas
        boolean van13 = vanBenne13(tomb);
        System.out.println("van benne 13: " + (van13 ? "van": "nincs"));
        
        int i = bekeres(tomb);
        int szam = tomb[i];
        System.out.println("vizsgált szám: " + tomb[i]);
        
        osztok(tomb, i);
    }

    private static int[] feltolt(int db) {
        int[] tomb = new int[db];
        for (int i = 0; i < db; i++) {
            //tomb[i] = rnd.nextInt(-5, 16);
            /*                   (felso - also + 1) + also */
            tomb[i] = rnd.nextInt(15 - -5 + 1 ) + -5;
        }
        
        return tomb;
    }

    private static void kiir(int[] tomb) {
        if (tomb.length > 0) {
            System.out.print(tomb[0]);
            for (int i = 1; i < tomb.length; i++) {
                System.out.print(", " + tomb[i]);
            }
            System.out.println("");            
        } else {
            System.out.println("üres a tömb!");
        }
    }
    
    private static void kiir(String str) {
        System.out.println(str);
    }
    
    private static boolean vanBenne13(int[] tomb){
        //eldöntés tétele sablon a többi kommentben
        int N = tomb.length;
        int i = 0;
        //while(i < N && !T){
        while(i < N && !(tomb[i] == 13)){
            i++;
        }
        //boolean van = i < N | i >= N;
        return i < N;
    }
    
    private static int bekeres(int[] tomb){
        int h = tomb.length;
        int i = -1;
        boolean jo;
        do {
            System.out.printf("melyik index (0-%d): ", h-1);
            i = sc.nextInt();
            jo = i >= 0 && i < h;
        } while (!jo);
        
        return i;
    }
    
    /* lehetne még:
    private static void osztok(int szam)
    */
    private static void osztok(int[] tomb, int index){
        if (tomb.length > 0) {
            System.out.println("|szám| osztói: ");
            int szam = Math.abs(tomb[index]);
            boolean oszto = false;
            //i az osztókat reprezentálja, 1 és a szam nincs benne
            for (int i = 2; i < szam; i++) {
                if (szam % i == 0) {
                    if(!oszto){
                        System.out.print(i);
                    }else{
                        System.out.print(", " + i);
                    }
                    oszto = true;
                }
            }
            if (!oszto) {
                System.out.println("prím szám");
            } else {
                System.out.println("");
            }
        } else {
            System.out.println("üres a tömb!");
        }
    }
}
