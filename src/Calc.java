import java.util.NoSuchElementException;
import java.util.Scanner;

//Main class for task JM-team
public class Calc {

    //output result of task
    public static int result;

    //defined algorithm operation
    public static void operation(int num1, String op, int num2) throws NoSuchElementException
    {
        switch (op)
        {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new NoSuchElementException("wrong operation!!");
        }
    }

    public static void main(String[] args)
    {

        //try to read input data
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter by format: NUM1 op(+-*/) NUM2");

        String num1 = "", op = "", num2 = "";
        try {
            num1 = inp.next();
            op = inp.next();
            num2 = inp.next();
        }
        catch (NoSuchElementException e) {
            System.err.println("incorrect format!");
            System.out.println();
        }

        //using oop
        RomanNumber rn1 = new RomanNumber(num1);
        RomanNumber rn2 = new RomanNumber(num2);
        IntegerNumber in1 = new IntegerNumber(num1);
        IntegerNumber in2 = new IntegerNumber(num2);

        //arabic numbers or roman numbers
        if (in1.isInteger() && in2.isInteger()) {

            //task condition only 1-10 numbers to arabic numbers
            if ((1<=in1.intNumber && in1.intNumber<=10) && (1<=in2.intNumber && in2.intNumber<=10)) {
                operation (in1.intNumber, op, in2.intNumber);
                System.out.println(result);
            }
            else {
                System.err.println("incorrect format!");
                System.out.println();
            }
        }
        //task condition only 1-10 numbers to roman numbers
        else if ((1<=rn1.romanToInteger() && rn1.romanToInteger()<=10) &&
                (1<=rn2.romanToInteger() && rn2.romanToInteger()<=10)) {

            operation (rn1.romanToInteger(), op, rn2.romanToInteger());

            System.out.println(toRoman(result));
        }
        else {
            System.err.println("incorrect format!");
            System.out.println();
        }
    }

    //conversation from arabic numbers to roman numbers
    private static String toRoman(int number) {
        return String.valueOf(new char[number]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC");
    }
}
