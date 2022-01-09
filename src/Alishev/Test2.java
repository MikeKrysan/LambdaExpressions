package Alishev;

interface Executable2 {
    public void execute2();
}

class Runner2 {
    public void run(Executable2 e){
        e.execute2();
    }
}

class ExecutableImplementations2 implements Executable2 {
    @Override
    public void execute2() {
        System.out.println("Hello number three!");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Runner2 runner2 = new Runner2();
        runner2.run(new ExecutableImplementations2());
    }
}
