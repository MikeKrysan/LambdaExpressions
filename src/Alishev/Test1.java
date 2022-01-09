package Alishev;

interface Executable1 {
    void execute1();
}

class Runner1 {
    public void run1(Executable1 e){
        e.execute1();
    }
}

class ExecutableImplementations1 implements Executable1 {

    @Override
    public void execute1() {
        System.out.println("Hello number one!");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        runner1.run1(new ExecutableImplementations1());
    }
}
