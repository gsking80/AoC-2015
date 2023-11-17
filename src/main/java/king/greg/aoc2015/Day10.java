package king.greg.aoc2015;

public class Day10 {

  public static String lookAndSay(final String input) {
    final StringBuilder builder = new StringBuilder();
    int counter = 0;
    Character lastChar = null;
    for (int i = 0; i < input.length(); i++) {
      Character currentChar = input.charAt(i);
      if (currentChar.equals(lastChar)) {
        counter++;
      } else {
        addChars(counter, lastChar, builder);
        counter = 1;
        lastChar = currentChar;
      }

    }
    addChars(counter, lastChar, builder);
    return builder.toString();
  }

  public static String lookAndSay(final String input, final int times) {
    return times > 1 ? lookAndSay(lookAndSay(input),times - 1) : lookAndSay(input);
  }

  private static void addChars(final int count, final Character character, final StringBuilder builder) {
    if (count > 0) {
      builder.append(count + character.toString());
    }
  }

}
