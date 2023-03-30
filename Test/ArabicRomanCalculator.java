package Test;

import java.util.Scanner;


public class ArabicRomanCalculator {

    public static void main(String[] args) {
        
        output_result(Main.calc(input_data()));
    }

    public static String input_data(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение для рассчета, используя арабские цифры и знак операции (+, -, * или /) или римские цифры и знак операции:");
        System.out.println("Для ввода римских цифр используйте латинский алфавит в верхнем регистре: I, V, X");
        String user_data =  in.nextLine();
        in.close();
        return user_data;
    }

    public static void output_result(String result){
        System.out.println(result);
    }
}