package com.elton.ds_algorithm.stack;

public class Calculator {
  public static void main(String[] args) {
    String expression = "70+4*5-1";

    CalculatorStack numberStack = new CalculatorStack(10);
    CalculatorStack operatorStack = new CalculatorStack(10);

    int num1 = 0;
    int num2 = 0;
    int operator = 0;
    int result = 0;
    char ch = ' ';
    String accumNumber = "";

    for (int i = 0; i < expression.length(); i++) {
      ch = expression.charAt(i);
      if (operatorStack.isOperator(ch)) {
        if (!operatorStack.isEmpty()) {
          if (operatorStack.priority(ch) <= operatorStack.priority((char) operatorStack.peek())) {
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operator = operatorStack.pop();
            result = operatorStack.calculate(num1, num2, (char) operator);
            numberStack.push(result);
          }
        }
        operatorStack.push(ch);
      } else {
        accumNumber += ch;
        if (i == expression.length() - 1) {
          numberStack.push(Integer.parseInt(accumNumber));
        } else {
          if (operatorStack.isOperator(expression.charAt(i + 1))) {
            numberStack.push(Integer.parseInt(accumNumber));
            accumNumber = "";
          }
        }
      }
    }

    while (true) {
      if (operatorStack.isEmpty()) {
        break;
      }
      num1 = numberStack.pop();
      num2 = numberStack.pop();
      operator = operatorStack.pop();
      result = operatorStack.calculate(num1, num2, (char) operator);
      numberStack.push(result);
    }
    System.out.println(numberStack.pop());
  }
}

class CalculatorStack extends ArrayStack {

  public CalculatorStack(int maxSize) {
    super(maxSize);
  }

  public int priority(char operator) {
    if (operator == '*' || operator == '/') {
      return 1;
    } else if (operator == '+' || operator == '-') {
      return 0;
    } else {
      return -1;
    }
  }

  public boolean isOperator(char operator) {
    return operator == '+' || operator == '-' || operator == '*' || operator == '/';
  }

  public int calculate(int num1, int num2, char operator) {
    int result = 0;
    switch (operator) {
      case '+':
        result = num1 + num2;
        break;
      case '-':
        result = num2 - num1;
        break;
      case '*':
        result = num1 * num2;
        break;
      case '/':
        result = num2 / num1;
        break;
    }
    return result;
  }
}
