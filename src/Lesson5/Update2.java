package Lesson5;

public class Update2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < ProgrammLauncher.HALF; i++) {
            ProgrammLauncher.arr2[i] = (float) (ProgrammLauncher.arr2[i] * Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
