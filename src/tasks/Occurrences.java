package tasks;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Occurrences {


    public static void main(String[] args) {

        // Создаем список номеров для ввода
        ArrayList<Integer> inpNumbers = new ArrayList<>();

        String str;
        // Считываем данные с консоли, до тех пор пока не введена пустая строка
        // заносим введенные номера в список
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        String[] str_2 = str.split(" ");

        for(int i = 0; i < str_2.length; i++) {
            inpNumbers.add(Integer.parseInt(str_2[i]));
        }

        // Сортируем список
        Collections.sort(inpNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });


        // Находим колличество повторяющихся элементов в массиве
        // заносим их в итоговой список

        Map<Integer, AtomicInteger> map=new HashMap<>();
        for (Integer i = 0; i < inpNumbers.size(); i++) {
            if(map.containsKey(inpNumbers.get(i))){
                map.get(inpNumbers.get(i)).incrementAndGet();
            } else{
                map.put(inpNumbers.get(i), new AtomicInteger(1));
            }
        }

        // сортируем список по заданным условиям
        List<Entry<Integer, AtomicInteger>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Entry<Integer, AtomicInteger>>() {
            public int compare(Entry<Integer, AtomicInteger> a, Entry<Integer, AtomicInteger> b) {
                return Long.compare(
                        a.getValue().get() * ((long) Integer.MAX_VALUE) + a.getKey(),
                        b.getValue().get() * ((long) Integer.MAX_VALUE) + b.getKey());
            }
        });

        // вывод списка
        for (Entry<Integer, AtomicInteger> entry : entries) {
            System.out.println(entry.getKey() + "\t" + entry.getValue().get());
        }

    }
}





