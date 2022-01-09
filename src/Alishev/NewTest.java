package Alishev;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello!");
        list.add("Goodbye!");
        list.add("a");
        list.add("ab");

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length() > o2.length()) {
//                    return 1;
//                } else if(o1.length() < o2.length()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });

        Comparator<String> comparator = (s1, s2) -> {   //Лямбда-выражение возвращает реализацию для интерфейса Comparator (параметризованный типом String). В переменную comparator мы записали лямбда-выражение
            if(s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return 0;
        };

        list.sort(comparator);

        System.out.println(list);
    }
}
