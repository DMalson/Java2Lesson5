package Lesson5;


public class ProgrammLauncher {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static final float[] arr = new float[SIZE];
    static final float[] arr1 = new float[HALF];
    static final float[] arr2 = new float[HALF];


    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Simple method." + "\n" +"Start execution");
        simpleCalculate();
        System.out.println("Execution time is " + (System.currentTimeMillis() - a) + " ms");

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        a = System.currentTimeMillis();
        System.out.println("2-Thread method." + "\n" +"Start execution");
        twoThreadCalculate();
        System.out.println("Execution time is " + (System.currentTimeMillis() - a) + " ms");

    }

    public static void simpleCalculate() {

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

    public static void twoThreadCalculate(){
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        Thread t1 = new Thread(new Update1());
        Thread t2 = new Thread(new Update2());
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e)      {
                e.printStackTrace();
            }
        }
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
    }
}
