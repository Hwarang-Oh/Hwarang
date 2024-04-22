import java.math.BigInteger;

public class test {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("21231231231");
        BigInteger y = x.pow(123123123);
        BigInteger z = y.mod(new BigInteger("1000"));
        System.out.println(z);
    }

}
