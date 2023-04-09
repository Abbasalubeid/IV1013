import java.util.Random;

public class MyRandom  extends Random {
    //Generated by Mathematica, m is a large prime that fits in the "long" range
    private static final long m = 1705533417848243881L;  
    private static final long a = 17; //Primitive root to m, calculated with Mathematica
    private static final long b = 0;
    private long seed;

    public MyRandom() {
        this(System.nanoTime());
    }

    public MyRandom(long seed) {
        this.seed = seed;
    }

    @Override
    public int next(int bits){
        long nextRandom = (((a * seed) + b ) % m);
        int mask = (1 << bits) - 1; // create a bit mask with the specified number of bits
        int maskedInt = (int) (nextRandom & mask); // mask to only include the specified number of bits 
        seed = maskedInt; 
        return maskedInt;
    }

    @Override
    public void setSeed(long seed){
        this.seed = seed;
    }
    
}
