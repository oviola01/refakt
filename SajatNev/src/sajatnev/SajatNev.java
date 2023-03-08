package sajatnev;

import java.util.Random;

public class SajatNev {

    private static Random rnd = new Random();
    
    public static void main(String[] args) {
        int[] tomb = new int[5];
        for (int i = 0; i < 5; i++) {
            tomb[i] = rnd.nextInt();
        }
    }
    
}
