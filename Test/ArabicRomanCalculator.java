package Test;

import java.util.Scanner;


public class ArabicRomanCalculator {

    public static void main(String[] args) {
        System.out.println("Введите выражение для рассчета, используя арабские цифры и знак операции (+, -, * или /) или римские цифры и знак операции:");
        System.out.println("Для ввода римских цифр используйте латинский алфавит в верхнем регистре: I, V, X");
        System.out.println("Для выхода наберите 'Exit'");
        while (true) {
            String command = input_data();
            if (command.equals("Exit")) {
                break;
            }
            else output_result(Main.calc(command));
        }
        
    }

    public static String input_data(){
        Scanner in = new Scanner(System.in);        
        String user_data =  in.nextLine();
        return user_data;
    }

    public static void output_result(String result){
        System.out.println(result);
    }
}