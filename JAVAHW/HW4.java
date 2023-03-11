package JAVAHW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW4 {
    // 1. Ввод с консоли в формате Ф.И.О Возраст пол
    // 2. Выход из режима ввода по горячей кнопке
    // 3. Вывод несортированного списка в формате Иванов И.И. 32M
    // 4. Два варианта продолжения, либо вывод списка сортированного по возрасту либо завершение приложения.
    public static void main(String[] args) {
        List<String> fullName = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<String> gender = new ArrayList<>();
        Scanner console = new Scanner(System.in);
        System.out.println("Ф.И.О Возраст пол, через пробел. Выход q");
        while (true) {
            String[] line = console.nextLine().split(" ");
            if (line[0].equals("q")) break;
            fullName.add(String.format("%1$s %2$s %3$s", line[0], line[1].charAt(0), line[2].charAt(0)));
            age.add(Integer.parseInt(line[3]));
            gender.add(line[4]);

        }
        LinkedList<Integer> linkID = new LinkedList<>();
        int count = 0;
        for (String fn : fullName) {
            System.out.println(fn);
            linkID.add(count);
            count++;
        }
        int cnt = linkID.size() - 1;
        while (cnt > -1) {
            int maxAge = age.get(linkID.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++) {
                if (maxAge < age.get(linkID.get(i))) {
                    maxAge = age.get(linkID.get(i));
                    index = i;
                }
            }
            int tmp = linkID.get(cnt);
            linkID.set(cnt, linkID.get(index));
            linkID.set(index, tmp);
            cnt--;
        }
        System.out.println(linkID);
        linkID.forEach(n -> System.out.printf("%1$s %2$s%n %3$s%n", fullName.get(n), age.get(n), gender.get(n)));
    }
}
