package sajatnev;

import java.util.Random;

public class SajatNev {

    private static Random rnd = new Random();
    
    public static void main(String[] args) {
        feltolt(5);
    }

    private static void feltolt(int db) {
        int[] tomb = new int[db];
        for (int i = 0; i < db; i++) {
            //tomb[i] = rnd.nextInt(-5, 16);
            /*                   (felso - also + 1) + also */
            tomb[i] = rnd.nextInt(15 - -5 + 1 ) + -5;
        }
    }
    
}
