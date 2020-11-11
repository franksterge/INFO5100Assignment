package classes;

public class Sum {
    private long sum;

    public Sum() {
        sum = 0;
    }

    public long getSum() {
        return sum;
    }

    public void add(int a) {
        sum += a;
    }
}
