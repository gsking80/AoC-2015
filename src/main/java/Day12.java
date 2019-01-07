public class Day12 {

  public static int sumNumbers(final String input) {
    int sum = 0;
    int currentNumber = 0;
    boolean negative = false;
    for (int i = 0; i < input.length(); i++) {
      Character current = input.charAt(i);
      if (current == '-') {
        negative = true;
      } else if (current >= '0' && current <= '9') {
        currentNumber *= 10;
        currentNumber += current - '0';
      } else {
        sum += negative ? currentNumber * -1 : currentNumber;
        negative = false;
        currentNumber = 0;
      }
    }
    return sum;
  }

  int index = 0;

  public int sumNonRedNumbers(final String input) {
    int sum = 0;
    int currentNumber = 0;
    boolean negative = false;
    boolean red = false;
      while (index < input.length()) {
        Character current = input.charAt(index);
        index++;
        if (current == '-') {
          negative = true;
        } else if (current >= '0' && current <= '9') {
          currentNumber *= 10;
          currentNumber += current - '0';
        } else if (current == 'r' && index + 1 < input.length() && input.substring(index,index+2).equals("ed")) {
          red = true;
        } else if (current == '{' || current == '[') {
          sum += sumNonRedNumbers(input);
        } else {
          sum += negative ? currentNumber * -1 : currentNumber;
          negative = false;
          currentNumber = 0;
          if (current == ']') {
            return sum;
          } else if (current == '}') {
            return red ? 0 : sum;
          }
        }
      }
    return red ? 0 : sum;
  }

}
