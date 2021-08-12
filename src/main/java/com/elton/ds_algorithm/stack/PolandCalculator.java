package com.elton.ds_algorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandCalculator {
  public static void main(String[] args) {

    String str = "1+((2+3)*4)-5";
    List<String> strings = toInfixList(str);
    System.out.println(strings);
    List<String> suffixList = toSuffixList(strings);
    System.out.println(suffixList);
    int calculate = calculate(suffixList);
    System.out.println(calculate);

    /*
    //    String str = "30 4 + 5 * 6 - ";
            String str= "4 5 * 8 - 60 + 8 2 / +";
        List<String> stringList = getStringList(str);
        System.out.println(stringList);
        int calculate = calculate(stringList);
        System.out.println(calculate);*/
  }

  public static List<String> toSuffixList(List<String> strings) {
    Stack<String> operatorStack = new Stack();
    List<String> resultList = new ArrayList<>();

    for (String string : strings) {
      if (string.matches("\\d")) {
        resultList.add(string);
      } else if (string.equals("(") || operatorStack.isEmpty()) {
        operatorStack.push(string);
      } else if (string.equals(")")) {
        while (!operatorStack.peek().equals("(")) {
          resultList.add(operatorStack.pop());
        }
        operatorStack.pop();
      } else {
        while (operatorStack.size() > 0 && priority(string) <= priority(operatorStack.peek())) {
          resultList.add(operatorStack.pop());
        }
        operatorStack.push(string);
      }
    }

    while (operatorStack.size() > 0) {
      resultList.add(operatorStack.pop());
    }

    return resultList;
  }

  public static int priority(String operator) {
    if (operator.equals("*") || operator.equals("/")) {
      return 2;
    } else if (operator.equals("+") || operator.equals("-")) {
      return 1;
    } else {
      return 0;
    }
  }

  public static List<String> toInfixList(String str) {
    List<String> list = new ArrayList<>();

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) < 48 || str.charAt(i) > 57) {
        list.add(String.valueOf(str.charAt(i)));
      } else {
        String tempStr = "";
        for (int j = i; j < str.length(); j++) {
          if (str.charAt(j) >= 48 && str.charAt(j) <= 57) {
            tempStr += str.charAt(j);
          }
          break;
        }
        list.add(tempStr);
      }
    }
    return list;
  }

  public static List<String> getStringList(String str) {
    String[] s = str.split(" ");
    List<String> strings = Arrays.asList(s);
    return strings;
  }

  public static int calculate(List<String> list) {
    Stack<String> stack = new Stack<>();
    for (String s : list) {
      if (s.matches("\\d+")) {
        stack.push(s);
      } else {
        int num1 = Integer.parseInt(stack.pop());
        int num2 = Integer.parseInt(stack.pop());
        int result = 0;
        switch (s) {
          case "+":
            result = num1 + num2;
            break;
          case "-":
            result = num2 - num1;
            break;
          case "*":
            result = num1 * num2;
            break;
          case "/":
            result = num2 / num1;
            break;
          default:
            throw new RuntimeException("operator error");
        }
        stack.push(String.valueOf(result));
      }
    }
    return Integer.parseInt(stack.pop());
  }
}
