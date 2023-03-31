package Test;

public abstract class Main {

    static String calc(String input){

        char[] char_input = input.toCharArray();
        String first_value ="";
        String second_value ="";
        String operation_type ="";
        short flag = 0; /* Переменная для подсчета знаков операции в выражении. 
        При значении больше 1 - инициирует сообщение о некорректности введенных данных.
        Тип boolean использовать нецелесообразно по ряду причин */
        if (char_input[0] == '-'){
            return "Калькулятор не предусматривает работу с отрицательными начальными числами. Введите корректное значение.";    
        }/*Этой проверкой отсекаем ввод отрицательного числа еще на первом этапе обработки введенных данных */
        for (char c : char_input) {
            if (c != '+' & c !='-' & c != '*' & c != '/'){
                if (flag ==0) first_value += c;
                else second_value += c;
            }
            else {operation_type += c; flag++;}
            if (flag > 1){
                throw new RuntimeException("В выражении не может быть больше одного знака операции. Введите корректные данные");
            }   
        }
        
        // Проверяем полученные значения на валидность: наличие пары чисел и одного знака операции
        if (flag == 0 || second_value == ""){
            throw new RuntimeException("Строка не является математической операцией."); 
        }

        MyNumber first = new MyNumber(first_value);
        MyNumber second = new MyNumber(second_value);

        if (first.getType() != second.getType()) throw new RuntimeException("Нельзя одновременно использовать арабские и римские цифры");

        int res = 0;
        switch (operation_type) {
            case "+":
                res = first.getValue()+second.getValue();
                break;
            case "-":
                res = first.getValue()-second.getValue();
                break;
            case "*":
                res = first.getValue()*second.getValue();
                break;
            case "/":
                res = first.getValue()/second.getValue(); /*Т.к. оба числа типа int, результат в любом случае округлиться до целого */
                break;
            default:
                throw new RuntimeException("Некорректно указан тип операции");
        }

        MyNumber result = new MyNumber(res, first.getType());


        
        return result.getNumViev();
    }

    


    
    
}
