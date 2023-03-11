package JAVAHW;

import java.util.HashMap;

// 1. Создать множество, ключь и значение строки. Добавить шесть элементов. Вывести в консоль значения.
// 2. Добавить ко всем значениям символ "!".
// 3. Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключеми первого.
// 4. Объеденить значания во втором множестве и первом если ключи совподают. Вывести результат в консоль.

public class HW5 {
    public static void main(String[] args) {

        // 1.
        HashMap<Integer, String> cities = new HashMap<>();
        cities.put(1, "Москва");
        cities.put(2, "Минск");
        cities.put(3, "Керчь");
        cities.put(4, "Тула");
        cities.put(5, "Мурманск");
        cities.put(6, "Смоленск");
        cities.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(cities);

        // 2.
        cities.computeIfPresent(1, (k, v) -> v + '!');
        cities.computeIfPresent(2, (k, v) -> v + '!');
        cities.computeIfPresent(3, (k, v) -> v + '!');
        cities.computeIfPresent(4, (k, v) -> v + '!');
        cities.computeIfPresent(5, (k, v) -> v + '!');
        cities.computeIfPresent(6, (k, v) -> v + '!');
        System.out.println(cities);
        cities.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println(cities);

        // 3.
        HashMap<Integer, String> citiesSec = new HashMap<>();
        citiesSec.put(0, "Тверь");
        citiesSec.put(1, "Воронеж");
        citiesSec.put(6, "Самара");
        citiesSec.put(8, "Чита");
        citiesSec.put(9, "Клин");
        citiesSec.put(7, "Томск");
        System.out.println(citiesSec);

        // 4.
        for (Integer item : cities.keySet()) {
            cities.merge(item, citiesSec.getOrDefault(item, ""), (newVal, tempVal) -> newVal + tempVal);
        }
        System.out.println(cities);
        cities.forEach((k, v) -> System.out.println(k + " " + v));
    }

}
