package Lesson5;

public class ProgrammLauncher {
    static final int SIZE = 100000000;
    static final int HALF = SIZE / 2;
    static final float[] arr = new float[SIZE];
    static final float[] arr1 = new float[HALF];
    static final float[] arr2 = new float[HALF];

    public static void main(String[] args) {

        initArray();
        long a = System.currentTimeMillis();
        System.out.println("Simple method." + "\n" + "Start execution");
        simpleCalculate();
        System.out.println("Execution time is " + (System.currentTimeMillis() - a) + " ms");

        initArray();

        a = System.currentTimeMillis();
        System.out.println("2-Thread method." + "\n" + "Start execution");
        twoThreadCalculate();
        System.out.println("Execution time is " + (System.currentTimeMillis() - a) + " ms");
    }

    public static void simpleCalculate() {
        Update1 update1 = new Update1(arr, 0);
        update1.arrayCalculate();
    }

    public static void twoThreadCalculate() {
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        Thread t1 = new Thread(new Update1(arr1, 0));
        Thread t2 = new Thread(new Update1(arr2, HALF));
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
    }

    public static void initArray() {
        for (int i = 0; i < SIZE; i++) arr[i] = 1;
    }
}
