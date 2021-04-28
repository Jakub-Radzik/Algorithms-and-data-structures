package Zadanie4;

import Zadanie2.DynamicStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie4 {
    static DynamicStack<String> stack = new DynamicStack<>();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        String statement = readFromFile();
        boolean sign = true;
        statement = statement.replaceAll(" ","");

        for (int i=0; i<statement.length(); i++) {
            if (statement.charAt(i) == '(') {
                stack.push("(");
                sign = true;
                result.append(" ");
            } else if (statement.charAt(i) == ')') {
                result.append(" ").append(getFromStackUntilBracket());
                sign = false;
            } else if ((statement.charAt(i) == '+' ||
                    statement.charAt(i) == '-' ||
                    statement.charAt(i) == '*' ||
                    statement.charAt(i) == '/') && !sign) {
                result.append(" ").append(getFromStack(statement.substring(i, i + 1)));
                sign = true;
            } else {
                if (sign && statement.charAt(i) == '-') {
                    result.append(" ");
                }
                result.append(statement.charAt(i));
                sign = false;
            }
        }
        result.append(getAllFromStack());
        result = new StringBuilder(result.toString().replaceAll("  ", " "));
        System.out.println("ONP: " + result);
        System.out.println("Wartość: "+ calculate(result.toString()));
    }

    private static String getFromStackUntilBracket() {
        String result = "";
        String c = null;
        if (!stack.isEmpty()) {
            c = (String) stack.pop();
            while (!c.equals("(")){
                result = result + " " + c;
                if (stack.isEmpty()) break;
                c = (String) stack.pop();
            }
        }
        if (result.length() > 0) {
            result = " " + result;
        }
        return result;
    }

    private static String getFromStack(String operator) {
        StringBuilder result = new StringBuilder();
        String c = null;
        if (!stack.isEmpty()) {
            c = stack.pop();
            while (((operator.equals("+") || operator.equals("-")) && !c.equals("(")) ||
                    ((operator.equals("/") || operator.equals("*")) && (c.equals("/") || c.equals("*")))){
                result.append(" ").append(c);
                if (stack.isEmpty()) break;
                c = (String) stack.pop();
            }
            stack.push(c);
        }
        stack.push(operator);

        return result.toString();
    }

    private static String getAllFromStack() {
        StringBuilder result = new StringBuilder();
        String c = null;
        while (!stack.isEmpty()){
            c = (String) stack.pop();
            result.append(" ").append(c);
        }
        return result.toString();
    }

    private static double calculate(String result) {
        result = result.trim();
        DynamicStack<Double> values = new DynamicStack<>();
        String[] tokens = result.split(" +");
        double answer = 0.0;

        for (String token: tokens)
        {
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/"))
            {
                double value = Double.parseDouble(token);
                values.push(value);
            }
            else
            {
                double a = values.pop();
                double b = values.pop();
                switch (token) {
                    case "+" -> answer = a + b;
                    case "-" -> answer = b - a;
                    case "*" -> answer = a * b;
                    case "/" -> answer = b / a;
                }
                values.push(answer);
            }
        }
        return answer;

    }

    private static String readFromFile() {
        try {
            File myObj = new File("plik.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                return data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "";
    }

}
