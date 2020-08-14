package tasks;

import java.util.Scanner;

public class Shifting {
    public static void main(String[] args) {
        // считываем число
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();


        System.out.println("Двоичное представление числа: " + Integer.toBinaryString(number));
        //производим замену последнего 0 на 1 в двоичном представлении числа
        int res = bit(number);
        System.out.println("Двоичное представление ответа: " + Integer.toBinaryString(res));
        System.out.println("Десятичное представление ответа: " + res);
        //производим замену последнего 0 на 1
        String res_str = shiftString(number);
        System.out.println("Замена последнего нуля в числе на 1: " + res_str);





    }
    public static int bit(int x) {
        int res = x;
        // прибавляем к числу 1 и с исходным числом производим побитовое сравнение "ИЛИ"
        x = x + 1;
        res = res | x;
        return res;
    }
    public static String shiftString(int num){
        //представляем число как строку и находим индекс последнего 0 в этой строке
        String str = String.valueOf(num);
        int i = str.lastIndexOf("0");
        if(i < 0){
            return "В числе нет нулей";
        }else{
            // представляем полученную строку как массив
            char[] mas = str.toCharArray();
            // копируем все элементы массива до 0 в новую строку, заменяем 0 на 1 и копируем дальше
            String ans = String.copyValueOf(mas,0,i);
            ans = ans + 1;
            String qwe = String.copyValueOf(mas,i+1,mas.length - ans.length());
            return ans+qwe;

        }
    }


}
