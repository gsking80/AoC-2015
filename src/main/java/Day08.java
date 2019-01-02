import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day08 {

  int totalCode;
  int totalMemory;
  int totalEncoded;

  public Day08(final FileReader fileReader) {
    try {
      final BufferedReader buf = new BufferedReader(fileReader);

      while (true) {
        final String codeString = buf.readLine();
        if (null == codeString) {
          break;
        } else {
          // do a thing
          totalCode += codeString.length();
          final StringBuilder memStringBuilder = new StringBuilder();
          for (int i = 0; i < codeString.length(); i++) {
            switch (codeString.charAt(i)) {
              case '"':
                break;
              case '\\':
                i++;
                switch (codeString.charAt(i)) {
                  case 'x':
                    memStringBuilder.append((char) Integer.parseInt(codeString.substring(i + 1,i+3), 16));
                    i+=2;
                    break;
                  default:
                    memStringBuilder.append(codeString.charAt(i));
                    break;
                }
                break;
              default:
                memStringBuilder.append(codeString.charAt(i));
                break;
            }
          }
          final String memString = memStringBuilder.toString();
          totalMemory += memString.length();
          final StringBuilder encodedStringBuilder = new StringBuilder().append('"');
          for (int i = 0; i < codeString.length(); i++) {
            switch (codeString.charAt(i)) {
              case '"':
                encodedStringBuilder.append("\\\"");
                break;
              case '\\':
                encodedStringBuilder.append("\\\\");
                break;
              default:
                encodedStringBuilder.append(codeString.charAt(i));
                break;
            }
          }
          final String encodedString = encodedStringBuilder.append('"').toString();
          totalEncoded += encodedString.length();
          System.out.println(codeString + " --- " + memString + " --- " + encodedString);

        }
      }

    } catch (IOException ioe) {

    }
  }

  public int getDifference(){
    return totalCode - totalMemory;
  }

  public int getEncodedDifference() {
    return totalEncoded - totalCode;
  }

}
