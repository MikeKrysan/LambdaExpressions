package Alishev;

import java.sql.SQLOutput;

/*Лямбда-выражения - это способ передать какой-то кусок кода в метод или в качестве аргументов в конструктор
Они позволяют нам обойтись без использования анонимных классов
//Лямбда-функция- это анонимная функция, которая определена без привязки к идентификатору(вики). Анонимная функция - это метод без названия
//В Java8, где нужно писать анонимный класс, и использовать один метод, теперь это можно делать с помощью лямбда-выражений
//*/
//
//interface Executable {
//    double execute();
//}
//
//class Runner {
//    public void run(Executable e) { //В качестве аргумента в метод run() мы должны передать какой-то класс, реализующий интерфейс Executable
//        double a = e.execute();
//        System.out.println(a);
//        System.out.println();
//    }
//}
//
////1-й способ: создать класс
////class ExecutableImplementation implements Executable {
////    @Override
////    public void execute() {
////        System.out.println("Hello!");
////    }
////}
//
//public class Test {
//    public static void main(String[] args) {
//        Runner runner = new Runner();   //Создали новый объект класса Runner
//        // 1 вариант
////        runner.run(new ExecutableImplementation()); //когда мы на объекте runner вызываем метод run(), в качестве аргументов мы должны передать реализацию интерфейса Executable, для этого у нас три варианта. Первый создать класс, наследуемый от интерфейс, и в коснктруктор класса Runner передать новый объект ExecutableImplementation
//        //2 вариант.
//        runner.run(new Executable() {
//            @Override
//            public double execute() {
//                System.out.println("Hello!");
//                System.out.println("Goodbye!");
//                return 1.0;
//            }
//        });
//        //3 способ
//        runner.run(() -> 10);                      //лямбда не указывает тип возвращаемого значения, эта лямбда реализует метод execute(), и Java сопоставляет лямбду с cигнатурой метода, видит что тип возвращаемого значения - double, поэтому и в лямбда должно возвращаться такой же тип значения5);
//    }
//}

//Рассмотрим сигнатуру метода интерфейса, который на вход принимает параметры
interface Executable {
    int execute(int x, int y); // метод принимает параметры
}

class Runner {
    public void run(Executable e) {
        int a = e.execute(10, 15);
        System.out.println(a);
    }
}

public class Test {
    public static void main(String[] args) {
        Runner runner = new Runner();

        int b = 1;
        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) { //теперь в  анонимном классе мы должны поменять сигнатуру перепределяемого метода
                int b = 2;//здесь в переменную "b" мы можем положить другое значение, потому что метод execute() не видит переменной "b" созданной за рамками метода. У методов в Java своя область видимости
                return x + y;
            }
        });
//        final int b = 1;  //чтобы лямбде получить доступ к этому числу, единственное требование, которое есть - это чтобы это число было либо константой (final), либо не менялось после определения (effectivly final)
//        runner.run((/*int*/ x, y) -> x + b);   //мы можем не указывать тип определяемого значения, Java итак знает, что на вход в качестве аргум)ента ожидается целое число

        runner.run((x, y) -> {  // у лямбда-выражения область видимости та, где она была создана. Переменная "b" будет видна.
           // int b = 3;    //будет ошибка
            int c = 5;  //При этом создать другую переменную, не повторяющеюся, мы можем создать в лямбда-выражении
           return x + y;
        });



    }
}

/*
1. Особенностью лямбда выражения является то, что у нее нет своей области видимости (scope)
 */