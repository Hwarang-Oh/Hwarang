import java.io.*;;
import java.math.BigInteger;
import java.util.Arrays;

public class B11727_2n타일링2_오화랑 {
    static BigInteger[] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        tile = new BigInteger[Integer.parseInt(input.readLine()) + 1];
        Arrays.fill(tile, new BigInteger("0"));
        System.out.println(makeTile(tile.length - 1, new BigInteger("0")).remainder(new BigInteger("10007")));
    }
    public static BigInteger makeTile(int num, BigInteger base) {
        if (num == 1) return tile[1] = new BigInteger("1");
        if (num == 2) return tile[2] = new BigInteger("3");
        if (tile[num].equals(base)) return tile[num] = makeTile(num-1, base).add(makeTile(num -2, base)).add(makeTile(num-2,base));
        return tile[num];
    }
}
