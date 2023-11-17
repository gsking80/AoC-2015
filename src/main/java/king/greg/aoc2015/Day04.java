package king.greg.aoc2015;

import org.apache.commons.codec.digest.DigestUtils;

public class Day04 {

  public static int leadingZeros(final String key, final int zeroes){
    int i = 1;
    while(true){
      boolean found = true;
      for (int letter = 0; letter < zeroes; letter++){
        if (DigestUtils.md5Hex(key + i).charAt(letter) != '0') {
          found = false;
        }
      }
      if (found) {
        return i;
      }
      i++;
    }
  }

}
