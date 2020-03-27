import java.util.Random;
import java.security.SecureRandom;

public class MathTest{
    public static void main(String [] args){
        double f = Math.random();
        f = Math.log10(f);
        f = f + Math.PI;

        Random r = new Random();
        SecureRandom sr = new SecureRandom();
        int i = r.nextInt(50);
        int j = sr.nextInt(2);
        System.out.println(" "+ f +" "+i+" "+j);
    }
}