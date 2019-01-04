public class Day11 {

  public static boolean validate(final String input) {
    boolean straight = false;
    boolean vagueCharacter = false;
    int pairs = 0;
    int incrementing = 0;
    boolean justFoundPair = false;
    Character previous = 0;
    for (int i = 0; i < input.length(); i++){
      final Character current = input.charAt(i);
      if(current == 'i' || current == 'l' || current == 'o'){
        vagueCharacter = true;
      }
      if (current == previous + 1) {
        incrementing ++;
        if (incrementing >= 3) {
          straight = true;
        }
      } else {
        incrementing = 1;
      }
      if (!justFoundPair && current == previous) {
        pairs++;
        justFoundPair = true;
      } else {
        justFoundPair = false;
      }
      previous = current;
    }
    return straight && !vagueCharacter && (pairs >= 2);
  }

  public static String increment(final String input) {
    char[] output = input.toCharArray();
    for (int i = input.length() - 1; i > -1; i--){
      Character test = input.charAt(i);
      test++;
      if (test > 'z') {
        output[i] = 'a';
      } else {
        output[i] = test;
        break;
      }
    }
    return new String(output);
  }

  public static String nextPassword(final String input) {
    String nextPassword = increment(input);
    while (!validate(nextPassword)) {
      nextPassword = increment(nextPassword);
    }
    return nextPassword;
  }

}
