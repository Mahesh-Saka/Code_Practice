public class Fibo {

    public static void main(String[] args) {
        System.out.println(fibo(10));
    }

    private static int fibo(int i) {
        if (i <= 1)
            return i;
        else
            return fibo(i - 1) + fibo(i - 2);
    }

    // 0,1,1,2,3,5,8,13,21,
}
