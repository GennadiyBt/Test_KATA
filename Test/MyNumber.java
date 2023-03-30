package Test;

class MyNumber {
    String num_wiev;
    int value;
    boolean type;
    String [] arabian = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    String [] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public MyNumber(String num){
        this.num_wiev = num;
        for (int i = 0; i < 10; i++) {
            if (arabian[i].equals(num)){
                this.value = i+1;
                this.type = true;
                break;
            }
            else if (roman[i].equals(num)){
                this.value = i+1;
                this.type = false;
                break;
            }
        }
        if (value == 0){
            throw new RuntimeException("Введенные данные некорректны."); /*Этим исключением отсекаются все типы некорректного ввода:
            числа вне диапазона 1..10, данные, не являющиеся числами и т.д. */
        }
        
    }

    public MyNumber(int value, boolean type){
        this.type = type;
        this.value = value;
        if (type){
            this.num_wiev = Integer.toString(value);
        }
        else {
            if (value <=0){
                throw new RuntimeException("При использовании римских чисел результат не может быть меньше или равен 0");
            }
            this.num_wiev = parseRomanInArabian(value);
        }
    }

    String getNumViev(){return num_wiev;}

    boolean getType(){return type;}

    int getValue(){return value;}

    String parseRomanInArabian(int num){
        String result = "";
        if (num == 100) {result = "C"; return result;}
        if (90 <= num & num < 100){
            result += "XC";
            num = num - 90;
            result += smallRomanInArabian(num);
            return result;            
        }
        if (num >= 50){
            result += "L";
            num = num - 50;
            while (num > 10){
                result += "X";
                num = num-10;
            }
            result += smallRomanInArabian(num);
            return result;
        }
        if (40<= num & num < 50){
            result += "XL";
            num = num - 40;
            result += smallRomanInArabian(num);
            return result;
        }
        while (num > 10){
            result += "X";
            num = num-10;
        }
        result += smallRomanInArabian(num);
        return result;      
    }

    String smallRomanInArabian(int num){
        if (num == 0) return "";
        for (int i = 0; i < 10; i++) {
            if (i+1 == num) {return roman[i];}
        }
        return "Что-то пошло не так ((";
    }


}
