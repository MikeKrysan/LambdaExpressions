package Alishev2;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
Рассмотрим все методы, которые позволяют нам коротко и быстро манипулировать наборами данных
Предположим, что мы хотим в нашем List каждое целое число умножить на 2 и получить интовый массив элементов
 */
public class Test {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

//        System.out.println(list);
//        System.out.println(Arrays.toString(arr));

//        for(int i = 0; i < 10; i++) {
//            arr[i] = arr[i] *2;
//            list.set(i, list.get(i)*2);
//        }
        //map()
        arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray();  //1.2.3. "Map" - означает отображение. Пришло к нам из теории множеств. Это когда есть оригинальное множество и преобразованное множество. Мы берем каждый элемент из оригинального множества, и по какому-то правилу сопоставляем этому элементу элемент из нового множества. Эта операция называется "Отображение"
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());  //4

        arr1 = Arrays.stream(arr1).map(a -> 3).toArray();
        arr1 = Arrays.stream(arr1).map(a -> a + 1).toArray();

        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        //filter() - например, мы можем использовать в нашем массиве, или коллекции только те числа, которые делятся без остатка на 2
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();    // Критерий метода filter() мы описываем в теле лямбда-выражения. Метод должен возвращать boolean переменную
        list2 = list2.stream().filter(a -> a%2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        //forEach()
        Arrays.stream(arr2).forEach(System.out::println);   //мы даем понять методу forEach, что для каждого элемента мы хотим вызвать метод println(), при этом на вход мы хотим передать этот элемент, по которому мы в данный момент итерируемся
        list2.stream().forEach(System.out::println);

        //reduce() - уменьшение. Берет набор данных и сжимает его в один элемент
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillArr(arr3);
        fillList(list3);

        int sum1 = Arrays.stream(arr3).reduce(0,(acc, b) -> acc + b);   //5.6. acc - акуммулятор - временная переменная (переменная-счетчик), которая будет каждый раз обновлятся. "b" - на каждой итерации внутреннего цикла в методе reduce(), он у нас является текущим элементом
        int sum2 = list3.stream().reduce((acc, b) -> acc * b ).get();   //перед вызовом метода get() желательно проверить ifPresent() - есть ли этот элемент или нет

        //[1, 2, 3] - когда мы не указываем значение акумулятора, итерация в наборе данных начинается со второго элемента
        // 0 [1, 2, 3] - когда мы указали значение акумулятора, итерация начинается с первого элемента

        System.out.println(sum1);
        System.out.println(sum2);

        //Так как все методы принимают stream()  и возвращают stream(), мы можем их вызывать один на другом:
        int[] arr4 = new int[10];
        fillArr(arr4);

        int[] newArray =  Arrays.stream(arr4).filter(a -> a%2 != 0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(newArray));

        //методы можно вызывать на любых коллекциях:
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        System.out.println(set);

        set = set.stream().map(a -> a * 3).collect(Collectors.toSet());
        System.out.println(set);

    }

    private static void fillList(List<Integer> list) {
        for(int i = 0; i < 10; i++) {
            list.add(i+1);
        }
    }

    private static void fillArr(int[] arr) {
        for(int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}


/*
1. stream() -метод принимающий массив, и возвращающий поток (не имеет отношения к потоку в поточности)
2. map() - метод позыченний из функционального яп, берет каждый элемент из массива данных и сопоставляет ему новый элемент. И это сопоставление мы опишем с помощью
лямбда-выражения.
3. Чтобы преобразовать поток stream в массив, нам нужно вызвать метод toArray()
4. collect(Collectors.toList()) - берется поток и превращается обратно в List
5. getAsInt() - метод преобразует поток stream в конкретное целое число
6. //[1,2,3] b = 1, acc = 1. По умолчанию акумулятор равен первому элементу в массиве. Но мы можем указать свое значение для аккумулятора:
int sum1 = Arrays.stream(arr3).reduce(identity: 0, (acc, b) -> acc + b).getAsInt();  //Говорим, что начальное значение аккумулятора равно 0. В этом случае мы можем обойтись без приведения к целому числу
Если мы не указываем аккумулятор, то мы берем первый элемент в качестве начального значения аккумулятора, и начинаем итерацию со второго элемента: b = 2, acc = 1 -> 2+1 = 3 - то что возвращается в теле лямбда-выражения, на каждей итерации внутреннего цикла - это присваевается как новое значение аккумулятора.
следующая итерация: b = 3, acc = 3. 3+3=6 acc -> 6
Если мы
 */
