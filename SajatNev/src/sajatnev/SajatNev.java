package sajatnev;

import java.util.Random;

public class SajatNev {

    private static Random rnd = new Random();
    
    public static void main(String[] args) {
        int[] tomb = feltolt(5);
        kiir(tomb);
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
        for (int i = 0; i < tomb.length; i++) {
            System.out.print(tomb[i] + " ");
        }
    }
    
}
