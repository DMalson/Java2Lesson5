package Lesson5;

public class Update1 implements Runnable {
    private float[] floatArray;
    private int shift = 0;

    public Update1() {}

    public Update1(float[] floatArray, int shift) {
        this.floatArray = floatArray;
        this.shift = shift;
    }

     @Override
    public void run() {
        arrayCalculate();
    }

    public void arrayCalculate() {
        for (int i = 0; i < floatArray.length; i++) {
            floatArray[i] = (float) (floatArray[i] * Math.sin(0.2f + (i + shift) / 5) *
                    Math.cos(0.2f + (i + shift) / 5) * Math.cos(0.4f + (i + shift) / 2));
        }
    }
}
