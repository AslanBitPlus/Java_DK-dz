package org.example;
/*
В качестве задачи предлагаю вам реализовать код для демонстрации парадокса Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности парадокса
(запустить игру в цикле на 1000 и вывести итоговый счет).
Необходимо:
Создать свой Java Maven или Gradle проект;
Подключить зависимость lombok.
Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
Самостоятельно реализовать прикладную задачу;
Сохранить результат в HashMap<шаг теста, результат>
Вывести на экран статистику по победам и поражениям

Работы принимаются в виде ссылки на гит репозиторий со всеми ключевыми файлами проекта
*/

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static boolean play(int plNum) {
        Random random = new Random();
        int doorPlayer;
        int doorVed;
        int priz;
        int[] dr = new int[3]; // Двери

        boolean result = false;


        System.out.println("Начало Игры " + plNum);

        // Дверь за которой приз
        // В массиве отмечаем дверь в которой находится приз цифрой 1
        // Изначально при инициализации все элементы массива равны 0
        priz = random.nextInt(1, 3);
        if (priz == 1) {
            dr[0] = 1;
        } else if (priz == 2) {
            dr[1] = 1;
        } else dr[2] = 1;
        System.out.println(priz);
        System.out.println(Arrays.toString(dr));
        System.out.println("ПРИЗ-------->" + priz);

        // Дверь которую выбирает игрок
        doorPlayer = random.nextInt(1, 3);
        dr[doorPlayer - 1]++;
        System.out.println("Выбор игрока -> " + doorPlayer);
        System.out.println(Arrays.toString(dr));


        // Ведущий открывает одну из дверей
        // естественно где нет приза
        int k = 0;
        for (int i = 0; i < dr.length; i++) {
            if (dr[i] == 0) k = i;
        }
        doorVed = k + 1;
        System.out.println("Ведущий открывает дверь ->" + doorVed);
        dr[k] = 1;

        // Определяем оставшуюся запертую дверь
        int t = 0;
        for (int i = 0; i < dr.length; i++) {
            if (dr[i] == 0) t = i;
        }
        t ++;

        System.out.println("Ведущий предлагает выбрать двери " + t + " или " + doorPlayer);
        // Выбор игрока
        int playerSel = 0;

        Scanner console = new Scanner(System.in);
        System.out.print("Какую дверь выбираете? ");
        playerSel = console.nextInt();

        System.out.println("Игрок выбрал дверь " + playerSel);
        if (playerSel != doorPlayer) {
            dr[playerSel - 1] ++;
            doorPlayer = playerSel;
        }


        if (dr[playerSel - 1] == 2) {
            System.out.println("Игрок ВЫИГРАЛ!");
            result = true;
        } else System.out.println("Игрок ПРОИГРАЛ!");

        return result;

    }

    public static void main(String[] args) {

        System.out.println("Семинар 06 - ДЗ!");

        int v = 0;
        double proc = 0.0;
        for (int i = 0; i < 10; i++) {
            if (play(i + 1)) v++;

        }
        proc = v/10;
        System.out.println("Процент выигрыша сотавляет " + proc);
    }

}