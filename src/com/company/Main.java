package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void zadanie_1_1(List<Integer> numbers) {
        System.out.println("Najwieksza liczba to " + Collections.max(numbers));
    }

    public static void zadanie_1_2(List<Integer> numbers) {
        System.out.println("Najmnijsza liczba to " + Collections.min(numbers));
    }

    public static int zadanie_1_3(List<Integer> list) {
        int count = 0;
        for (int i : list) {
            if (isPrime(i)) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void zadanie_1_4(ArrayList<Integer> nums) {
        List<Integer> maxDividers = Collections.emptyList();
        Integer currentNumber = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (countDividers(nums.get(i)).size() > maxDividers.size()) {
                maxDividers = countDividers(nums.get(i));
                currentNumber = nums.get(i);
            }
        }
        System.out.println(currentNumber);
        System.out.println(maxDividers);
    }

    private static List<Integer> countDividers(Integer number) {
        List<Integer> dividers = new ArrayList<>();
        {
            int i;
            for (i = 1; i * i < number; i++) {
                if (number % i == 0)
                    dividers.add(i);
            }
            if (i - (number / i) == 1) {
                i--;
            }
            for (; i >= 1; i--) {
                if (number % i == 0)
                    dividers.add(number / i);
            }
        }
        return dividers;
    }

    static void zadanie_1() {
        System.out.println("Wpisz liczby ");

        Scanner sc = new Scanner(System.in);
        String liczby = sc.nextLine();
        String[] numbersString;

        numbersString = liczby.split(" ");
        int[] numbersInt = new int[numbersString.length];

        for (int i = 0; i < numbersString.length; i++) {
            numbersInt[i] = Integer.parseInt(numbersString[i]);
        }

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < numbersInt.length; i++) {
            System.out.print(numbersInt[i] + " ");
            nums.add(numbersInt[i]);
        }
        System.out.println();
        System.out.println("Zadanie 1_1 ");
        zadanie_1_1(nums);

        System.out.println("Zadanie 1_2 ");
        zadanie_1_2(nums);

        System.out.println("Zadanie 1_3 ");
        int result = zadanie_1_3(nums);
        System.out.println("Liczba liczb pierwszych " + result);

        System.out.println("Zadanie 1_4");
        zadanie_1_4(nums);

    }

    public static void zadanie_2() {
        System.out.println("Zadanie 2 ");
        System.out.println("Podaj imiona: ");
        Scanner sc = new Scanner(System.in);
        String imiona = sc.nextLine();
        String[] names = imiona.split(" ");

        if (names.length == 0) {
            System.out.println("Zadne imie nie zostalo podane ");
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < names.length; i++) {
            set.add(names[i]);
        }
        System.out.println("Ilość unkalnych imion: " + set.size());
    }

    public static ArrayList<Integer> primeFactors(int n){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; n != 1;) {
            if (n % i == 0) {
                result.add(i);
                n /= i;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void zadanie_3() {
        //populate numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 10; i <= 99; i++) {
            numbers.add(i);
        }

        ArrayList<Integer> primeNums = new ArrayList<>();
        int current = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (primeFactors(numbers.get(i)).size() > primeNums.size()) {
                primeNums = primeFactors(numbers.get(i));
                current = numbers.get(i);
            }
        }
        System.out.println("Najwięcej czynników pierwszych ma: " + current);
        System.out.println("Są to: " + primeNums);
    }


    public static void main(String[] args) {
        zadanie_1();
        zadanie_2();
        zadanie_3();
    }


}


/*
Zadanie 01:
Za pomoca scanera zapytaj uzytkownika o liczby rozdzielone spacja.
nastepnie dla kazdego podpunktu wykonaj osobna metode:
- znajdz najwiekszy element
- znajdz najmniejszy element
- policz ile jest liczb pierwszych
- znajdz liczbe z najwieksza iloscia dzielnikow

Zadanie 02:
Zapytaj uztkownika za pomoca scanera o imiona rozdzielone spacja i wypisz ile roznych imion wprowadzil uzytnowik.

Zadanie 03:
sposrod wszystkich liczb 2 cyfrowych wypisz tę która ma najwiecej czynnikow pierwszych.
np: liczba 10 ma 2 i 5
liczba 20 ma 2, 2, 5
liczba 100 ma 2,2,5,5
itp.
 */