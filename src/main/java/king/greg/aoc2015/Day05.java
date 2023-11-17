package king.greg.aoc2015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day05 {

  int niceStrings;

  Day05(final FileReader fileReader) {
    this(fileReader, false);
  }

  Day05(final FileReader fileReader, final boolean newRules) {
    niceStrings = 0;
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while(true) {
        final String lineJustFetched = buf.readLine();
        if(null == lineJustFetched) {
          break;
        } else {
          if (newRules) {
            if (newNice(lineJustFetched)) {
              niceStrings++;
            }
          } else {
            if (nice(lineJustFetched)) {
              niceStrings++;
            }
          }
        }
      }

    } catch (IOException ioe) {

    }
  }

  public int getNiceStrings() {
    return niceStrings;
  }

  public static boolean nice(final String input) {
    int vowelCount = 0;
    boolean doubleLetter = false;
    boolean naughtyCharacters = false;

    Character previousCharacter = input.charAt(0);
    vowelCount += vowelTest(previousCharacter);
    for (int i = 1; i < input.length(); i++) {
      final Character currentCharacter = input.charAt(i);
      vowelCount += vowelTest(currentCharacter);
      if (!doubleLetter && (currentCharacter.equals(previousCharacter))){
        doubleLetter = true;
      }
      switch (currentCharacter) {
        case 'b':
          if (previousCharacter == 'a') {
            naughtyCharacters = true;
          }
          break;
        case 'd':
          if (previousCharacter == 'c') {
            naughtyCharacters = true;
          }
          break;
        case 'q':
          if (previousCharacter == 'p') {
            naughtyCharacters = true;
          }
          break;
        case 'y':
          if (previousCharacter == 'x') {
            naughtyCharacters = true;
          }
          break;
      }
      previousCharacter = currentCharacter;
    }

    return ((vowelCount >= 3) && doubleLetter && !naughtyCharacters);
  }

  public static boolean newNice(final String input) {
    boolean letterPair = false;
    boolean letterPosts = false;
    final Map<String, Integer> letterPairs = new HashMap<>();
    for(int i = 0; i < input.length() - 1; i++) {
      final String testPair = input.substring(i, i+2);
      if (null == letterPairs.get(testPair)) {
        letterPairs.put(testPair,i);
      } else if (letterPairs.get(testPair) < i -1){
        letterPair = true;
      }
      if ((i < input.length() - 2) && (input.charAt(i) == input.charAt(i+2))) {
        letterPosts = true;
      }
    }
    return (letterPair && letterPosts);
  }

  private static int vowelTest(final Character letter){
    switch (letter) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
        return 1;
      default:
        return 0;
    }
  }

}
