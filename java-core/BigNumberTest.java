import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigNumberTest{
    public static void main(String [] args){
        BigInteger bi =new BigInteger("123456789");
        System.out.println(bi.longValueExact());

        // if larger than 3.4e38 return Infinity
        float a = bi.pow(9).floatValue();
        System.out.println(a);

        BigDecimal bd = new BigDecimal("2.45700");
        System.out.println("points of bd: " + bd.scale());
        BigDecimal bd_t = bd.stripTrailingZeros();
        System.out.println("points of bd_t: " + bd_t.scale());

        BigDecimal bd1 = new BigDecimal("1.2345678");
        System.out.println("No round: "+bd1.setScale(5, RoundingMode
        .HALF_UP));
        System.out.println("Round down: "+bd1.setScale(5, RoundingMode.DOWN));

        //precision points number in division
        System.out.println("division: "+ bd1.divide(bd,10,RoundingMode.DOWN));

        //compare
        //equals() scale need same
        int t = bd.compareTo(new BigDecimal("2.457"));
        int p = bd.compareTo(new BigDecimal(new BigInteger("24470"), 4));
        System.out.println(t+p);


    }
}