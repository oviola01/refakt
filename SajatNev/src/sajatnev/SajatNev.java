package sajatnev;

import java.util.Random;
import java.util.Scanner;

public class SajatNev {

    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[] tomb = feltolt(5);
        stringbeVesszovel(tomb);
        
        boolean van13 = vanBenne13(tomb);
        kiirKonzolra("van benne 13: " + (van13 ? "van": "nincs"));
        
        int i = bekeres(tomb);
        int szam = tomb[i];
        kiirKonzolra("vizsgált szám: " + tomb[i]);
        
        osztok(tomb, i);
    }

    private static int[] feltolt(int db) {
        int[] tomb = new int[db];
        for (int i = 0; i < db; i++) {
            tomb[i] = rnd.nextInt(15 - -5 + 1 ) + -5;
        }
        
        return tomb;
    }

    private static String stringbeVesszovel(int[] tomb) {
        String s = "üres a tömb!";
        if (tomb.length > 0) {
            s = tomb[0]+"";
            for (int i = 1; i < tomb.length; i++) {
                s += ", " + tomb[i];
            }
            
        } 
        return s;
    }
    
    private static void kiir(String str, boolean sortores) {
        String s = sortores ? "\n" : "";
        System.out.print(str + s);
    }
    
    private static void kiirKonzolra(String str) {
        kiir(str, true);
    }
    
    private static boolean vanBenne13(int[] tomb){
        int N = tomb.length;
        int i = 0;
        while(i < N && !(tomb[i] == 13)){
            i++;
        }
        return i < N;
    }
    
    private static int bekeres(int[] tomb){
        int h = tomb.length;
        int i = -1;
        boolean jo;
        do {
            String s = String.format("melyik index (0-%d): ", h-1);
            kiir(s, false);
            i = sc.nextInt();
            jo = i >= 0 && i < h;
        } while (!jo);
        
        return i;
    }

    private static String osztok(int[] tomb, int index){
        String s = "|szám| osztói: ";
        if (tomb.length > 0) {
            int szam = Math.abs(tomb[index]);
            boolean talaltOszto = false;
            for (int oszto = 2; oszto < szam; oszto++) {
                if (szam % oszto == 0) {
                    if(!talaltOszto){
                        s += oszto;
                    }else{
                        s += ", " + oszto;
                    }
                    talaltOszto = true;
                }
            }
            if (!talaltOszto) {
                s = "prím szám";
            } 
        } else {
            s = "üres a tömb!";
        }
        return s;
    }
    
}
