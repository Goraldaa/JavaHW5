package HomeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HW5_2 {
    public static void main(String[] args) {
        System.out.println("Введите число в арабской системе записи:");
        Scanner scanner = new Scanner(System.in);
        String romNum = scanner.nextLine();
        int romNumInt = Integer.parseInt(romNum);
        System.out.println(romanNum(romNumInt));
        System.out.println(newRomanNum(romNumInt));
    }
    public static String newRomanNum(Integer number){
        Map<Integer, String> num = Map.of(
                1, "I",
                5, "V",
                10, "X",
                50, "L",
                100, "C",
                500, "D",
                1000, "M"  );
        Set<Integer> setKeys = num.keySet();
        Integer[] numCount = {1000, 500, 100, 50, 10, 5, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCount.length; i++) {
            for (int j = 0; j < number / numCount[i]; j++) {
                sb.append(num.get(numCount[i]));
            }
            number %= numCount[i];
            if(i < numCount.length-2 && i % 2 == 0){
                if(number/(numCount[i]-numCount[i+2])==1){
                    sb.append(num.get(numCount[i+2])).append(num.get(numCount[i]));
                    i++;
                    number/=10;
                }
            }
        }
        return sb.toString();
    }
    public static String romanNum(Integer number){
        Map<Integer, String> num = new HashMap<>();
        num.put(1, "I");
        num.put(4,"IV");
        num.put(5, "V");
        num.put(9, "IX");
        num.put(10, "X");
        num.put(40,"XL");
        num.put(50, "L");
        num.put(90,"XC");
        num.put(100, "C");
        num.put(400, "CD");
        num.put(500, "D");
        num.put(900,"CM");
        num.put(1000, "M");
        Integer[] numCount = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int key = 0;
        for (int i = 0; i < numCount.length; i++) {
            key = numCount[i];
            for (int j = 0; j < number / key; j++) {
                sb.append(num.get(key));
            }
            number %= key;
        }
        return sb.toString();
    }
}
